package com.insourcing.helper;

import java.awt.Color;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;

/**
 * Maps real values to a color.
 * 
 * @author Prakash
 * 
 */
public class TableHelper {

	Color minColor;
	Color maxColor;
	int alpha;

	public static Color getColorForValue(double value, int alpha, boolean logarithmic, double minValue, double maxValue,
			Color minColor, Color maxColor) {
		if (Double.isNaN(value)) {
			return Color.LIGHT_GRAY;
		}

		// map value to [0,1]
		if (minValue == maxValue) {
			value = 0.5;
		} else if (logarithmic) {
			value = (Math.log(value) - Math.log(minValue)) / (Math.log(maxValue) - Math.log(minValue));
		} else {
			value = (value - minValue) / (maxValue - minValue);
		}

		Color MIN_LEGEND_COLOR = minColor;
		Color MAX_LEGEND_COLOR = maxColor;
		float[] minCol = Color.RGBtoHSB(MIN_LEGEND_COLOR.getRed(), MIN_LEGEND_COLOR.getGreen(),
				MIN_LEGEND_COLOR.getBlue(), null);
		float[] maxCol = Color.RGBtoHSB(MAX_LEGEND_COLOR.getRed(), MAX_LEGEND_COLOR.getGreen(),
				MAX_LEGEND_COLOR.getBlue(), null);
		double hColorDiff = maxCol[0] - minCol[0];
		double sColorDiff = maxCol[1] - minCol[1];
		double bColorDiff = maxCol[2] - minCol[2];

		Color color = new Color(Color.HSBtoRGB((float) (minCol[0] + hColorDiff * value),
				(float) (minCol[1] + value * sColorDiff), (float) (minCol[2] + value * bColorDiff)));

		if (alpha < 255) {
			color = setColorAlpha(color, alpha);
		}
		return color;
	}

	public static Color setColorAlpha(Color color, int alpha) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
	}
	
	public static void drawInnerTable(float yPositionUpDown, float yStartN, float bottomMarginN,
			float tableWidth, float marginLR, PDDocument document, PDPage page, boolean drawTable, boolean drawText,
			float rowHeight, float cellHeight, String content, PDFont font, float fontSize, Color fontColor) throws IOException {
		BaseTable innerTable = new BaseTable(yPositionUpDown, yStartN, bottomMarginN, tableWidth, marginLR, document, page,
				drawTable, drawText);
		Row<PDPage> inRow;
		Cell<PDPage> inCell;
		inRow = innerTable.createRow(rowHeight);
		inCell = inRow.createCell(cellHeight, content); // increase 100 to make the table wide
		inCell.setFont(font);
		inCell.setTextColor(fontColor);
		inCell.setFontSize(fontSize);
		innerTable.draw();
	}

}