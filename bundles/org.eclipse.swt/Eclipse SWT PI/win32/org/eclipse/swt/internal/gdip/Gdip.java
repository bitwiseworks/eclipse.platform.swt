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
package org.eclipse.swt.internal.gdip;

import org.eclipse.swt.internal.*;

public class Gdip extends Platform {
	static {
		Library.loadLibrary ("swt-gdip"); //$NON-NLS-1$
	}
	
	/** GdiPlus constants */
	public static final int CombineModeReplace = 0;
	public static final int CombineModeIntersect = 1;
	public static final int CombineModeUnion = 2;
	public static final int CombineModeXor = 3;
	public static final int CombineModeExclude = 4;
	public static final int CombineModeComplement = 5;
	public static final int FillModeAlternate = 0;
	public static final int FillModeWinding = 0;
	public static final int DashCapFlat = 0;
	public static final int DashCapRound = 2;
    public static final int DashCapTriangle = 3;
    public static final int DashStyleSolid = 0;
    public static final int DashStyleDash = 1;
    public static final int DashStyleDot = 2;
    public static final int DashStyleDashDot = 3;
    public static final int DashStyleDashDotDot = 4;
    public static final int DashStyleCustom = 5;
    public static final int LineJoinMiter = 0;
    public static final int LineJoinBevel = 1;
    public static final int LineJoinRound = 2;
    public static final int LineCapFlat = 0;
    public static final int LineCapSquare = 1;
    public static final int LineCapRound = 2;
    public static final int MatrixOrderPrepend = 0;
    public static final int MatrixOrderAppend = 1;
    public static final int UnitPixel = 2;


/** GdiPlus natives */
public static final native int GdiplusStartup(int[] token, GdiplusStartupInput input, int output);
public static final native void GdiplusShutdown(int[] token);
public static final native int Bitmap_new(int hbm, int hpal);
public static final native void Bitmap_delete(int bitmap);
public static final native int Graphics_new(int hdc);
public static final native void Graphics_delete(int graphics);
public static final native int Graphics_DrawArc(int graphics, int pen, int x, int y, int width, int height, float startAngle, float sweepAngle);
public static final native int Graphics_DrawEllipse(int graphics, int pen, int x, int y, int width, int height);
public static final native int Graphics_DrawImage(int graphics, int image, int x, int y);
public static final native int Graphics_DrawImage(int graphics, int image, Rect destRect, int srcx, int srcy, int srcwidth, int srcheight, int srcUnit, int imageAttributes, int callback, int callbackData);
public static final native int Graphics_DrawLine(int graphics, int pen, int x1, int y1, int x2, int y2);
public static final native int Graphics_DrawLines(int graphics, int pen, int[] points, int count);
public static final native int Graphics_DrawPath(int graphics, int pen, int path);
public static final native int Graphics_DrawPolygon(int graphics, int pen, int[] points, int count);
public static final native int Graphics_DrawRectangle(int graphics, int pen, int x, int y, int width, int height);
public static final native int Graphics_DrawString(int graphics, char[] string, int length, int font, PointF origin, int brush);
public static final native int Graphics_DrawString(int graphics, char[] string, int length, int font, PointF origin, int format, int brush);
public static final native int Graphics_FillEllipse(int graphics, int brush, int x, int y, int width, int height);
public static final native int Graphics_FillPath(int graphics, int brush, int path);
public static final native int Graphics_FillPie(int graphics, int brush, int x, int y, int width, int height, float startAngle, float sweepAngle);
public static final native int Graphics_FillPolygon(int graphics, int brush, int[] points, int count, int fillMode);
public static final native int Graphics_FillRectangle(int graphics, int brush, int x, int y, int width, int height);
public static final native int Graphics_GetClipBounds(int graphics, RectF rect);
public static final native int Graphics_GetClipBounds(int graphics, Rect rect);
public static final native int Graphics_GetInterpolationMode(int graphics);
public static final native int Graphics_GetTransform(int graphics, int matrix);
public static final native int Graphics_ResetClip(int graphics);
public static final native int Graphics_SetClip(int graphics, int hrgn, int combineMode);
public static final native int Graphics_SetClip(int graphics, int path);
public static final native int Graphics_SetClip(int graphics, RectF rect);
public static final native int Graphics_SetTransform(int graphics, int matrix);
public static final native int Graphics_SetInterpolationMode(int graphics, int mode);
public static final native int Color_new(int argb);
public static final native void Color_delete(int color);
public static final native int Font_new(int hdc, int hfont);
public static final native void Font_delete(int font);
public static final native int Font_GetFamily(int font, int family);
public static final native float Font_GetSize(int font);
public static final native int Font_GetStyle(int font);
public static final native int FontFamily_new();
public static final native void FontFamily_delete(int family);
public static final native int LinearGradientBrush_new(PointF point1, PointF point2, int color1, int color2);
public static final native void LinearGradientBrush_delete(int brush);
public static final native int SolidBrush_new(int color);
public static final native void SolidBrush_delete(int pen);
public static final native int Pen_new(int color, float width);
public static final native void Pen_delete(int pen);
public static final native int Pen_SetDashPattern(int pen, float[] dashArray, int count);
public static final native int Pen_SetDashStyle(int pen, int dashStyle);
public static final native int Pen_SetLineCap(int pen, int startCap, int endCap, int dashCap);
public static final native int Pen_SetLineJoin(int pen, int lineJoin);
public static final native int Point_new(int x, int y);
public static final native void Point_delete(int point);
public static final native int GraphicsPath_new(int brushMode);
public static final native void GraphicsPath_delete(int path);
public static final native int GraphicsPath_AddArc(int path, float x, float y, float width, float height, float startAngle, float sweepAngle);
public static final native int GraphicsPath_AddBezier(int path, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4);
public static final native int GraphicsPath_AddLine(int path, float x1, float y1, float x2, float y2);
public static final native int GraphicsPath_AddPath(int path, int addingPath, boolean connect);
public static final native int GraphicsPath_AddRectangle(int path, RectF rect);
public static final native int GraphicsPath_AddString(int path, char[] string, int length, int family, int style, float emSize, PointF origin, int format);
public static final native int GraphicsPath_CloseFigure(int path);
public static final native int GraphicsPath_GetLastPoint(int path, PointF lastPoint);
public static final native int Matrix_new(float m11, float m12, float m21, float m22, float dx, float dy);
public static final native void Matrix_delete(int matrix);
public static final native int Matrix_GetElements(int matrix, float[] m);
public static final native int Matrix_Invert(int matrix);
public static final native boolean Matrix_IsIdentity(int metrix);
public static final native int Matrix_Multiply(int matrix, int matrix1, int order);
public static final native int Matrix_Rotate(int matrix, float angle, int order);
public static final native int Matrix_Scale(int matrix, float scaleX, float scaleY, int order);
public static final native int Matrix_Shear(int matrix, float shearX, float shearY, int order);
public static final native int Matrix_TransformPoints(int matrix, PointF pts, int count);
public static final native int Matrix_TransformPoints(int matrix, float[] pts, int count);
public static final native int Matrix_Translate(int matrix, float offsetX, float offsetY, int order);
public static final native int Matrix_SetElements(int matrix, float m11, float m12, float m21, float m22, float dx, float dy);

}
