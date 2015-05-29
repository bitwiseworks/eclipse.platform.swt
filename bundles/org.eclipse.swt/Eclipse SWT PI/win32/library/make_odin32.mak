###############################################################################
# make_odin32.mak                                                             #
#                                                                             #
# Copyright (c) 2014 bww bitwiseworks GmbH                                    #
#                                                                             #
# This file is part of the SWT-OS2 project which is made available under the  #
# terms of the Eclipse Public License v1.0 which accompanies this             #
# distribution, and is available at http://www.eclipse.org/legal/epl-v10.html.#
#                                                                             #
###############################################################################

#
# Makefile for SWT libraries on OS/2
#


#
# Uncomment to spot functions without prototypes
#
#GCC_EXTRA_FLAGS=-Wall


#
# Default Target
# _____________________________________________________________________________
DEFAULT_TARGET: all
#DEFAULT_TARGET: compile-swtdll-sources
#DEFAULT_TARGET: swt.dll
#DEFAULT_TARGET: compile-swtawtdll-sources
#DEFAULT_TARGET: swt-awt.dll

# Include the SWT version
include make_common.mak


# ------------------------------------------------------------------- [swt.dll]
SWT_PREFIX:=swt
#WS_PREFIX:=win32
#WS_PREFIX:=odin32
SWT_VERSION:=$(maj_ver)$(min_ver)

# Name of the platform swt dll
#SWT_LIB:=$(SWT_PREFIX)-$(WS_PREFIX)-$(SWT_VERSION).dll
SWT_LIB:=$(SWT_PREFIX).dll
# Objects to build
SWT_OBJS =
SWT_OBJS += init_swt.obj
SWT_OBJS += os_custom.obj
SWT_OBJS += swt.obj
SWT_OBJS += callback.obj
SWT_OBJS += c.obj
SWT_OBJS += c_stats.obj
SWT_OBJS += os_stats.obj
SWT_OBJS += com_stats.obj
SWT_OBJS += os.obj
SWT_OBJS += os_structs.obj
SWT_OBJS += com_structs.obj
SWT_OBJS += com.obj
SWT_OBJS += com_custom.obj


# --------------------------------------------------------------- [swt-awt.dll]
AWT_PREFIX:=$(SWT_PREFIX)-awt
#AWT_LIB:=$(AWT_PREFIX)-$(WS_PREFIX)-$(SWT_VERSION).dll
AWT_LIB:=$(AWT_PREFIX).dll
AWT_LIBS:=-l$(JAVA_HOME)\lib\jawt.lib
AWT_OBJS:=init_swt_awt.obj
AWT_OBJS+=swt_awt.obj


# ---------------------------------------------------------------------- [Java]
# Java includes for JNI
JINC1:=$(JAVA_HOME)/include
JINC2:=$(JINC1)/os2


# -------------------------------------------------------------------- [Odin32]
# Odin32 includes for Win32
OINC1:=$(ODIN32_SDK)/include
OINC2:=$(OINC1)/incl_gcc
OINC3:=$(OINC1)/win

# Odin32 Libraries
ODIN32_LIBS:=
ODIN32_LIBS+=-lgdi32
ODIN32_LIBS+=-lcomdlg32
ODIN32_LIBS+=-lkernel32
ODIN32_LIBS+=-lcomctl32
ODIN32_LIBS+=-limm32os2
ODIN32_LIBS+=-luser32
ODIN32_LIBS+=-lole32
ODIN32_LIBS+=-loleaut32
#ODIN32_LIBS+=olecli32
#ODIN32_LIBS+=olepro32
ODIN32_LIBS+=-lshell32
ODIN32_LIBS+=-lwinspool
ODIN32_LIBS+=-lcrypt32
ODIN32_LIBS+=-lwininet
ODIN32_LIBS+=-lshlwapi
ODIN32_LIBS+=-lmsvfw32
#ODIN32_LIBS+=common
#ODIN32_LIBS+=unicode
#ODIN32_LIBS+=libwrap
#ODIN32_LIBS+=jpeglib
#ODIN32_LIBS+=usp10


# -------------------------------------------------------------------- [Linker]
# Suppress possible VAC3 stuff
LIB=
# Direct gcc to use this link method
export EMXOMFLD_TYPE=wlink
export EMXOMFLD_LINKER=wl.exe


# ------------------------------------------------------------------- [Defines]
DEFINES:=

# Indicate we're using Odin32 and jam-in the SWT version
DEFINES+=-D__WIN32OS2__ -DSWT_VERSION=$(SWT_VERSION)

#DEFINES+=-D_WIN32_WCE
DEFINES+=-D_WIN32

# Some constant normally in wine::port.h:114
DEFINES+=-DRTLD_LAZY=0x001

# Turn off unicode for now to avoid using incorrect structures
#DEFINES+=-DUNICODE

# Requires a new big header, 'shobjidl.h'; disable for now
DEFINES+=-DNO_SHDRAGIMAGE
# Stop os.c from barking about SHDRAGIMAGE (NO_SHDRAGIMAGE not enough)
DEFINES+=-DNO_MoveMemory__ILorg_eclipse_swt_internal_win32_SHDRAGIMAGE_2I
DEFINES+=-DNO_MoveMemory__Lorg_eclipse_swt_internal_win32_SHDRAGIMAGE_2II
DEFINES+=-DNO_SendMessageA__IIILorg_eclipse_swt_internal_win32_SHDRAGIMAGE_2
DEFINES+=-DNO_SendMessageW__IIILorg_eclipse_swt_internal_win32_SHDRAGIMAGE_2

# Needed for com_structs.c
# winnt.h:2343
DEFINES+=-DWINE_LARGE_INTEGER
# obj_oleaut.h:120
DEFINES+=-D_FORCENAMELESSUNION

# Needed for com.c
DEFINES+=-DNO_VtblCall__IILorg_eclipse_swt_internal_win32_SHDRAGIMAGE_2I
DEFINES+=-DNO_VtblCall__IILorg_eclipse_swt_internal_win32_SHDRAGIMAGE_2J

# Unresolved externals; revisit later
DEFINES+=-DNO_PathIsExe
DEFINES+=-DNO_GdiSetBatchLimit
#DEFINES+=-DNO_IIDFromString
#DEFINES+=-DNO_MsgWaitForMultipleObjectsEx
DEFINES+=-DNO_SHGetFolderPathA
DEFINES+=-DNO_SHGetFolderPathW
DEFINES+=-DNO_SHDoDragDrop

# Define the name of your build-machine here for bldlevel info
DEFINES+=-DBUILD_MACHINE=\"**UNKNOWN**\"


# ------------------------------------------------------------------- [Targets]
#
# Build all dlls
# _____________________________________________________________________________
all: swt.dll swt-awt.dll


#
# Build swt.dll
# _____________________________________________________________________________
swt.dll: compile-swtdll-sources
	@echo.
	@echo [$@]
	gcc -Zomf -Zdll -L$(ODIN32_SDK)/$(ODIN32_SDK_OUT)/os2.x86/$(ODIN32_SDK_BUILD)/stage/lib $(SWT_OBJS) $(ODIN32_LIBS) -o $@
	@bldlevel $@


#
# Build swt-awt.dll
# _____________________________________________________________________________
swt-awt.dll: compile-swtawtdll-sources
	@echo.
	@echo [$@]
	gcc -Zomf -Zdll -L$(ODIN32_SDK)/$(ODIN32_SDK_OUT)/os2.x86/$(ODIN32_SDK_BUILD)/stage/lib $(AWT_OBJS) $(ODIN32_LIBS) $(AWT_LIBS) -o $@
	@bldlevel $@


#
# Compile the sources for swt.dll using implicit rules
# _____________________________________________________________________________
compile-swtdll-sources: $(SWT_OBJS)


#
# Compile the sources for swt.dll using implicit rules
# _____________________________________________________________________________
compile-swtawtdll-sources: $(AWT_OBJS)


#
# Remove generated files
# _____________________________________________________________________________
clean:
	@echo.
	@echo [Cleaning up]
	@if exist *.o rm -v -f *.o
	@if exist *.obj rm -v -f *.obj
	@if exist *.dll rm -v -f *.dll
	@if exist *.lib rm -v -f *.lib
	@if exist *.lst rm -v -f *.lst
	@if exist *.map rm -v -f *.map
	@if exist *.wlk rm -v -f *.wlk
	@if exist *.err rm -v -f *.err
	@if exist *.log rm -v -f *.log
	@if exist *.wda rm -v -f *.wda
	@if exist *.exh rm -v -f *.exh
	@if exist *.exm rm -v -f *.exm
	@if exist *.wdump rm -v -f *.wdump


# --------------------------------------------------------------------- [Rules]
#
# Implicit Rules for C sources
# _____________________________________________________________________________
.c.obj:
	@echo.
	@echo [$@]
	gcc $(GCC_EXTRA_FLAGS) -Zomf -o $@ -c $(DEFINES) -I$(JINC1) -I$(JINC2) -I$(OINC1) -I$(OINC2) -I$(OINC3) $*.c


#
# Implicit Rules for C++ sources
# _____________________________________________________________________________
.cpp.obj:
	@echo.
	@echo [$@]
	g++ $(GCC_EXTRA_FLAGS) -Zomf -o $@ -c $(DEFINES) -I$(JINC1) -I$(JINC2) -I$(OINC1) -I$(OINC2) -I$(OINC3) $*.cpp
