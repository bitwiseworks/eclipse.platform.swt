/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * Transparent Background example snippet: Set transparent background.
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
public class Snippet365 {
	static Image oldImage;
	static Image newImage;

	// Native
	static Group nativeGroup;
	static Button buttonCheckBox;
	static ToolBar bar;
	static Label label;
	static Link link;
	static Scale scale;
	static Button radio;
	static Button check;
	static Button push;
	static Group group;
	static Sash sash;

	// Custom
	static Group customGroup;
	static CLabel cLabel;
	static StyledText styledText;
	static CTabFolder cTab;
	static CTabFolder gradientCTab;

	// As Designed
	static Group defaultBackgroundGroup;
	static Text text;
	static Combo combo;
	static ProgressBar progressBar;
	static DateTime dateTime;
	static Slider slider;
	static List list;
	static CCombo ccombo;
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Transparent Background");
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.spacing = 20;
		layout.marginWidth = 10;
		layout.marginHeight = 10;
		shell.setLayout(layout);
		// Standard color background for Shell
		// shell.setBackground(display.getSystemColor(SWT.COLOR_CYAN));

		// Gradient background for Shell
		shell.addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Rectangle rect = shell.getClientArea();
				Image newImage = new Image(display, Math.max(1, rect.width), 1);
				GC gc = new GC(newImage);
				gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
				gc.fillGradientRectangle(rect.x, rect.y, rect.width, 1, false);
				gc.dispose();
				shell.setBackgroundImage(newImage);
				if (oldImage != null)
					oldImage.dispose();
				oldImage = newImage;
			}
		});

		// Transparent
		buttonCheckBox = new Button(shell, SWT.CHECK | SWT.None);
		buttonCheckBox.setText("SET TRANSPARENT");
		buttonCheckBox.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
		buttonCheckBox.setSelection(false);
		buttonCheckBox.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean transparent = ((Button) e.getSource()).getSelection();
				if (transparent) {
					// Native
					nativeGroup.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					bar.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					label.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					link.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					scale.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					radio.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					check.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					group.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					sash.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					slider.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					list.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));

					// Custom
					customGroup.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					cLabel.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					cTab.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_TRANSPARENT));
					gradientCTab.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_TRANSPARENT));

					// Default
					push.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					defaultBackgroundGroup.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					combo.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					progressBar.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					dateTime.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					ccombo.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					text.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
					styledText.setBackground(display.getSystemColor(SWT.COLOR_TRANSPARENT));
				} else {
					// Native
					nativeGroup.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
					bar.setBackground(null);
					label.setBackground(null);
					link.setBackground(null);
					scale.setBackground(null);
					RGB rgb = display.getSystemColor(SWT.COLOR_CYAN).getRGB();
					radio.setBackground(new Color(display, new RGBA(rgb.red, rgb.blue, rgb.green, 255)));
					check.setBackgroundImage(getBackgroundImage(display));
					group.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
					sash.setBackground(display.getSystemColor(SWT.COLOR_DARK_CYAN));
					slider.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
					list.setBackground(null);

					// Custom
					customGroup.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
					cLabel.setBackground((Color) null);
					styledText.setBackground((Color) null);
					cTab.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));

					gradientCTab.setBackground(
							new Color[] { display.getSystemColor(SWT.COLOR_RED),
									display.getSystemColor(SWT.COLOR_WHITE) }, new int[] { 90 }, true);

					// AsDesigned
					defaultBackgroundGroup.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
					push.setBackground(null);
					text.setBackground(null);
					combo.setBackground(null);
					ccombo.setBackground(null);
					dateTime.setBackground(null);
					progressBar.setBackground(null);

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Native
		nativeGroup = new Group(shell, SWT.NONE);
		nativeGroup.setText("NATIVE");
		layout = new RowLayout();
		layout.spacing = 20;
		nativeGroup.setLayout(layout);

		// Custom
		customGroup = new Group(shell, SWT.NONE);
		customGroup.setText("CUSTOM");
		layout = new RowLayout();
		layout.spacing = 20;
		customGroup.setLayout(layout);

		// AsDesigned
		defaultBackgroundGroup = new Group(shell, SWT.NONE);
		defaultBackgroundGroup.setText("Default Background");
		layout = new RowLayout();
		layout.spacing = 20;
		defaultBackgroundGroup.setLayout(layout);

		// Label
		label = new Label(nativeGroup, SWT.NONE);
		label.setText("Label");
		
		// Radio button
		radio = new Button(nativeGroup, SWT.RADIO);
		radio.setText("Radio Button");
		radio.setSelection(true);
		radio.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		
		// Checkbox button with image
		check = new Button(nativeGroup, SWT.CHECK);
		check.setText("CheckBox Image");
		check.setSelection(true);
		check.setBackgroundImage(getBackgroundImage(display));

		// Push Button
		push = new Button(defaultBackgroundGroup, SWT.PUSH | SWT.NO_BACKGROUND);
		push.setText("Push Button");
		
		// Toolbar
		bar = new ToolBar(nativeGroup, SWT.FLAT);
		bar.pack();
		ToolItem item = new ToolItem(bar, SWT.PUSH);
		item.setText("ToolBar_Item");

		// Scale
		scale = new Scale(nativeGroup, SWT.None);
		scale.setMaximum(100);
		scale.setSelection(20);

		// Link
		link = new Link(nativeGroup, SWT.NONE);
		link.setText("<A>Sample link</A>");

		// List
		list = new List(nativeGroup, SWT.BORDER);
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		// Group
		group = new Group(nativeGroup, SWT.NONE);
		group.setText("Group");

		// Sash
		sash = new Sash(nativeGroup, SWT.HORIZONTAL | SWT.BORDER);
		sash.setBackground(display.getSystemColor(SWT.COLOR_DARK_CYAN));
		sash.setLayoutData(new RowData(100, 100));
		sash.setToolTipText("Sash");

		// Text
		text = new Text(defaultBackgroundGroup, SWT.BORDER);
		text.setText("text");

		// Combo
		combo = new Combo(defaultBackgroundGroup, SWT.BORDER);
		combo.add("combo");
		combo.setText("combo");
		
		// ProgressBar
		progressBar = new ProgressBar(defaultBackgroundGroup, SWT.NONE);
		progressBar.setMaximum(100);
		progressBar.setSelection(80);
		
		// DateTime
		dateTime = new DateTime(defaultBackgroundGroup, SWT.NONE);
		
		// Slider
		slider = new Slider(nativeGroup, SWT.VERTICAL | SWT.BORDER);
		slider.setSelection(20);
		slider.setBackground(display.getSystemColor(SWT.COLOR_CYAN));

		// CCombo
		ccombo = new CCombo(defaultBackgroundGroup, SWT.BORDER);
		ccombo.add("ccombo");
		ccombo.setText("ccombo");

		// CLable
		cLabel = new CLabel(customGroup, SWT.NONE);
		cLabel.setText("CLabel");

		// Text
		styledText = new StyledText(customGroup, SWT.BORDER);
		styledText.setFont(new Font(display, "Tahoma", 18, SWT.BOLD | SWT.ITALIC));
		styledText.setForeground(display.getSystemColor(SWT.COLOR_DARK_BLUE));
		styledText.setText("Styled Text");
		styledText.append("\n");
		styledText.append("Example_string");
		styledText.append("\n");
		styledText.append("One_Two");
		styledText.append("\n");
		styledText.append("Two_Three");

		// CTabFolder
		cTab = new CTabFolder(customGroup, SWT.BORDER);
		CTabItem cTabItem = new CTabItem(cTab, SWT.CLOSE, 0);
		cTabItem.setText("Item1");
		cTabItem = new CTabItem(cTab, SWT.NONE, 1);
		cTabItem.setText("Item2");
		cTab.setSelection(0);

		// Gradient CTabFolder
		gradientCTab = new CTabFolder(customGroup, SWT.BORDER);
		gradientCTab.setBackground(
				new Color[] { display.getSystemColor(SWT.COLOR_WHITE), display.getSystemColor(SWT.COLOR_RED) },
				new int[] { 90 }, true);
		cTabItem = new CTabItem(gradientCTab, SWT.CLOSE, 0);
		cTabItem.setText("Item1");
		cTabItem = new CTabItem(gradientCTab, SWT.NONE, 1);
		cTabItem.setText("Item2");
		gradientCTab.setSelection(0);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static Image getBackgroundImage(final Display display) {
		if (newImage == null) {
			Rectangle rect = new Rectangle(0, 0, 115, 5);
			newImage = new Image(display, Math.max(1, rect.width), 1);
			GC gc = new GC(newImage);
			gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
			gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
			gc.fillGradientRectangle(rect.x, rect.y, rect.width, 1, false);
			gc.dispose();
		}
		return newImage;
	}

}