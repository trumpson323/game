package org.Tiles;

import java.awt.image.BufferedImage;

import org.images.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stone, id);
		// TODO Auto-generated constructor stub
	}

	// Override
	public boolean isSolid() {
		return true;
	}
}
