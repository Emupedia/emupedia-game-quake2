/*
Copyright (C) 2010 Copyright 2010 Google Inc.

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package com.googlecode.playnquake.core.tools;


import playn.core.Image;

import com.googlecode.gwtquake.shared.common.QuakeFiles;

public class WALConverter extends ImageConverter {

  @Override
  public Image convert(byte[] raw) {
	// TODO Auto-generated method stub
    return makePalletizedImage(LoadWAL(raw));
  }

  static image_t LoadWAL(byte[] raw)  {
    QuakeFiles.miptex_t mt = new QuakeFiles.miptex_t(raw);

    image_t image = new image_t();
    image.width = mt.width;
    image.height = mt.height;
    image.pix = new byte[mt.width * mt.height];
    System.arraycopy(raw, mt.offsets[0], image.pix, 0, image.pix.length);
    return image;
  }


}
