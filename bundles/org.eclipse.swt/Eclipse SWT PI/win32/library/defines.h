/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/*
 * - Size Optimization -
 * You can specify here which structs and SWT JNI calls
 * you want to exclude. This can be useful to create
 * a smaller library, based on your particular requirements.
 * For example, if your application does not use the type ACCEL
 * you can add:
 * #define NO_ACCEL
 * If your application does not require the function Arc,
 * you can add:
 * #define NO_Arc
 * By default, all types and JNI calls relevant to a
 * platform are included.
 *
 */

///-------------------------------------------------------------------[swt-os2]
#ifdef __WIN32OS2__
//#define NO_ScriptApplyDigitSubstitution
#define NO_ScriptBreak
#define NO_ScriptCacheGetHeight
#define NO_ScriptCPtoX
#define NO_ScriptFreeCache
#define NO_ScriptGetCMap
#define NO_ScriptGetLogicalWidths
#define NO_ScriptGetFontProperties
//#define NO_ScriptGetProperties
//#define NO_ScriptItemize
#define NO_ScriptJustify
#define NO_ScriptLayout
#define NO_ScriptPlace
//#define NO_ScriptRecordDigitSubstitution
#define NO_ScriptShape
#define NO_ScriptStringAnalyse
#define NO_ScriptStringFree
#define NO_ScriptStringOut
#define NO_ScriptTextOut
#define NO_ScriptXtoCP
#endif
///----------------------------------------------------------------------------
