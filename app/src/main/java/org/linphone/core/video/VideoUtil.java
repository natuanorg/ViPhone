/*  1:   */ package org.linphone.core.video;
/*  2:   */ 
/*  3:   */

import android.hardware.Camera;

import org.linphone.core.VideoSize;

import java.util.ArrayList;
import java.util.List;

/*  4:   */
/*  5:   */
/*  6:   */
/*  7:   */ 
/*  8:   */ final class VideoUtil
/*  9:   */ {
/* 10:   */   public static List<VideoSize> createList(List<Camera.Size> supportedVideoSizes)
/* 11:   */   {
/* 12:36 */     List<VideoSize> converted = new ArrayList(supportedVideoSizes.size());
/* 13:37 */     for (Camera.Size s : supportedVideoSizes) {
/* 14:38 */       converted.add(new VideoSize(s.width, s.height));
/* 15:   */     }
/* 16:40 */     return converted;
/* 17:   */   }
/* 18:   */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.video.VideoUtil

 * JD-Core Version:    0.7.0.1

 */