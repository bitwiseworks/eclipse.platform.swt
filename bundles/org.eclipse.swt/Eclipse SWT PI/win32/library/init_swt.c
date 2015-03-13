/*
// init_swt.c -- Build Level Information and Odin32 based Library initialization and termination.
*/


#define  INCL_DOSMODULEMGR
#define  INCL_DOSMISC
#define  INCL_DOSPROCESS
#define  INCL_DOSSEMAPHORES
#include <os2wrap.h>
#include <time.h>
#include <win32type.h>
#include <odinlx.h>
#include <winconst.h>

#include <stdio.h>

#ifndef BUILD_MACHINE
#define BUILD_MACHINE "**UNKNOWN**"
#endif
static char    bldlevel[] = "@#Project swt-os2:0.5#@##1## 13 Mar 2015 00:00:00     "BUILD_MACHINE"::::3::@@Standard Widget Toolkit for OS/2 (alpha level)";

/* Prototypes */
BOOL WINAPI DllMain(HANDLE hInstDLL, DWORD dwReason, LPVOID lpvReserved);
BOOL WINAPI LibMain(HINSTANCE hinstDLL, DWORD fdwReason, LPVOID fImpLoad);
unsigned long _System _DLL_InitTerm(unsigned long hModule, unsigned long  ulFlag);

/* Used for testing, the real thing is called DllMain in os_custom.c */
BOOL WINAPI LibMain(HINSTANCE hinstDLL, DWORD fdwReason, LPVOID fImpLoad)
{
	BOOL brc = FALSE;
	switch (fdwReason) {
		case DLL_PROCESS_ATTACH:
			printf("swt.dll::LibMain Process Attach\n");
			//~ system("touch aaaaa-LibMain-Process-Attach");
		case DLL_THREAD_ATTACH:
			printf("swt.dll::LibMain Thread Attach\n");
			//~ system("touch aaaaa-LibMain-Thread-Attach");
			brc = TRUE;
            break;
		case DLL_PROCESS_DETACH:
			printf("swt.dll::LibMain Process Detach\n");
			//~ system("touch zzzzz-LibMain-Process-Detach");
		case DLL_THREAD_DETACH:
			printf("swt.dll::LibMain Thread Detach\n");
			//~ system("touch zzzzz-LibMain-Thread-Detach");
			brc = TRUE;
			break;
		default:
			printf("swt.dll::?????????????????? from LibMain\n");
			//~ system("touch ??????????????????-LibMain");
			brc = TRUE;
			break;
	}
	fflush(stdout);
	return brc;
}

/*
// DLL initialization called by OS/2.
// RegisterLxDll() causes the initialization to be forwarded to the registered
// function. Somehow the termination (case 1) does not get called here, but the
// termination in the registered function does get called.
// Is this a bug somewhere ?
*/
unsigned long _System _DLL_InitTerm(unsigned long hModule, unsigned long  ulFlag)
{
	APIRET rc = FALSE;

	switch (ulFlag) {
		case 0:
			 _CRT_init();
			 __ctordtorInit();
			printf("swt.dll::_DLL_InitTerm Attach\n");
			//~ system("touch ____DLL_Attach____");
			//~ rc = RegisterLxDll((HINSTANCE)hModule, LibMain, (PVOID)NULL, 0, 0, 0);
			rc = RegisterLxDll((HINSTANCE)hModule, DllMain, (PVOID)NULL, 0, 0, 0);
			break;
		case 1:
			printf("swt.dll::_DLL_InitTerm Detach\n");
			//~ system("touch ____DLL_Detach____");
			 rc = UnregisterLxDll((HINSTANCE)hModule);
			 __ctordtorTerm();
			 _CRT_term();
			break;
		default:
			printf("swt:dll::??????????????????\n");
			//~ system("touch ____DLL_WHAT____");
			break;
	}
	fflush(stdout);
	return rc;
}
