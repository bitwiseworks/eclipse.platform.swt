/*******************************************************************************
* Copyright (c) 2000, 2004 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Common Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/cpl-v10.html
* 
* Contributors:
*     IBM Corporation - initial API and implementation
*******************************************************************************/

#ifdef NATIVE_STATS
extern int Gdip_nativeFunctionCount;
extern int Gdip_nativeFunctionCallCount[];
extern char* Gdip_nativeFunctionNames[];
#define Gdip_NATIVE_ENTER(env, that, func) Gdip_nativeFunctionCallCount[func]++;
#define Gdip_NATIVE_EXIT(env, that, func) 
#else
#define Gdip_NATIVE_ENTER(env, that, func) 
#define Gdip_NATIVE_EXIT(env, that, func) 
#endif

typedef enum {
	Bitmap_1delete_FUNC,
	Bitmap_1new_FUNC,
	Color_1delete_FUNC,
	Color_1new_FUNC,
	FontFamily_1delete_FUNC,
	FontFamily_1new_FUNC,
	Font_1GetFamily_FUNC,
	Font_1GetSize_FUNC,
	Font_1GetStyle_FUNC,
	Font_1delete_FUNC,
	Font_1new_FUNC,
	GdiplusShutdown_FUNC,
	GdiplusStartup_FUNC,
	GraphicsPath_1AddArc_FUNC,
	GraphicsPath_1AddBezier_FUNC,
	GraphicsPath_1AddLine_FUNC,
	GraphicsPath_1AddPath_FUNC,
	GraphicsPath_1AddRectangle_FUNC,
	GraphicsPath_1AddString_FUNC,
	GraphicsPath_1CloseFigure_FUNC,
	GraphicsPath_1GetLastPoint_FUNC,
	GraphicsPath_1delete_FUNC,
	GraphicsPath_1new_FUNC,
	Graphics_1DrawArc_FUNC,
	Graphics_1DrawEllipse_FUNC,
	Graphics_1DrawImage__IIII_FUNC,
	Graphics_1DrawImage__IILorg_eclipse_swt_internal_gdip_Rect_2IIIIIIII_FUNC,
	Graphics_1DrawLine_FUNC,
	Graphics_1DrawLines_FUNC,
	Graphics_1DrawPath_FUNC,
	Graphics_1DrawPolygon_FUNC,
	Graphics_1DrawRectangle_FUNC,
	Graphics_1DrawString__I_3CIILorg_eclipse_swt_internal_gdip_PointF_2I_FUNC,
	Graphics_1DrawString__I_3CIILorg_eclipse_swt_internal_gdip_PointF_2II_FUNC,
	Graphics_1FillEllipse_FUNC,
	Graphics_1FillPath_FUNC,
	Graphics_1FillPie_FUNC,
	Graphics_1FillPolygon_FUNC,
	Graphics_1FillRectangle_FUNC,
	Graphics_1GetClipBounds__ILorg_eclipse_swt_internal_gdip_RectF_2_FUNC,
	Graphics_1GetClipBounds__ILorg_eclipse_swt_internal_gdip_Rect_2_FUNC,
	Graphics_1GetInterpolationMode_FUNC,
	Graphics_1GetTransform_FUNC,
	Graphics_1ResetClip_FUNC,
	Graphics_1SetClip__II_FUNC,
	Graphics_1SetClip__III_FUNC,
	Graphics_1SetClip__ILorg_eclipse_swt_internal_gdip_RectF_2_FUNC,
	Graphics_1SetInterpolationMode_FUNC,
	Graphics_1SetTransform_FUNC,
	Graphics_1delete_FUNC,
	Graphics_1new_FUNC,
	LinearGradientBrush_1delete_FUNC,
	LinearGradientBrush_1new_FUNC,
	Matrix_1GetElements_FUNC,
	Matrix_1Invert_FUNC,
	Matrix_1IsIdentity_FUNC,
	Matrix_1Multiply_FUNC,
	Matrix_1Rotate_FUNC,
	Matrix_1Scale_FUNC,
	Matrix_1SetElements_FUNC,
	Matrix_1Shear_FUNC,
	Matrix_1TransformPoints__ILorg_eclipse_swt_internal_gdip_PointF_2I_FUNC,
	Matrix_1TransformPoints__I_3FI_FUNC,
	Matrix_1Translate_FUNC,
	Matrix_1delete_FUNC,
	Matrix_1new_FUNC,
	Pen_1SetDashPattern_FUNC,
	Pen_1SetDashStyle_FUNC,
	Pen_1SetLineCap_FUNC,
	Pen_1SetLineJoin_FUNC,
	Pen_1delete_FUNC,
	Pen_1new_FUNC,
	Point_1delete_FUNC,
	Point_1new_FUNC,
	SolidBrush_1delete_FUNC,
	SolidBrush_1new_FUNC,
} Gdip_FUNCS;
