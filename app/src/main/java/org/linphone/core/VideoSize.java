/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public final class VideoSize
/*  4:   */ {
/*  5:   */   public static final int QCIF = 0;
/*  6:   */   public static final int CIF = 1;
/*  7:   */   public static final int HVGA = 2;
/*  8:   */   public static final int QVGA = 3;
/*  9:29 */   public static final VideoSize VIDEO_SIZE_QCIF = new VideoSize(176, 144);
/* 10:30 */   public static final VideoSize VIDEO_SIZE_CIF = new VideoSize(352, 288);
/* 11:31 */   public static final VideoSize VIDEO_SIZE_QVGA = new VideoSize(320, 240);
/* 12:32 */   public static final VideoSize VIDEO_SIZE_HVGA = new VideoSize(320, 480);
/* 13:33 */   public static final VideoSize VIDEO_SIZE_VGA = new VideoSize(640, 480);
/* 14:34 */   public static final VideoSize VIDEO_SIZE_720P = new VideoSize(1280, 720);
/* 15:35 */   public static final VideoSize VIDEO_SIZE_1020P = new VideoSize(1920, 1080);
/* 16:   */   public int width;
/* 17:   */   public int height;
/* 18:   */   
/* 19:   */   public VideoSize() {}
/* 20:   */   
/* 21:   */   public VideoSize(int width, int height)
/* 22:   */   {
/* 23:42 */     this.width = width;
/* 24:43 */     this.height = height;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Deprecated
/* 28:   */   public static final VideoSize createStandard(int code, boolean inverted)
/* 29:   */   {
/* 30:48 */     switch (code)
/* 31:   */     {
/* 32:   */     case 0: 
/* 33:50 */       return inverted ? new VideoSize(144, 176) : new VideoSize(176, 144);
/* 34:   */     case 1: 
/* 35:52 */       return inverted ? new VideoSize(288, 352) : new VideoSize(352, 288);
/* 36:   */     case 2: 
/* 37:54 */       return inverted ? new VideoSize(320, 480) : new VideoSize(480, 320);
/* 38:   */     case 3: 
/* 39:56 */       return inverted ? new VideoSize(240, 320) : new VideoSize(320, 240);
/* 40:   */     }
/* 41:58 */     return new VideoSize();
/* 42:   */   }
/* 43:   */   
/* 44:   */   public boolean isValid()
/* 45:   */   {
/* 46:63 */     return (this.width > 0) && (this.height > 0);
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int hashCode()
/* 50:   */   {
/* 51:68 */     int prime = 31;
/* 52:69 */     int result = 1;
/* 53:70 */     result = 31 * result + this.height;
/* 54:71 */     result = 31 * result + this.width;
/* 55:72 */     return result;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public boolean equals(Object obj)
/* 59:   */   {
/* 60:75 */     if (this == obj) {
/* 61:76 */       return true;
/* 62:   */     }
/* 63:77 */     if (obj == null) {
/* 64:78 */       return false;
/* 65:   */     }
/* 66:79 */     if (getClass() != obj.getClass()) {
/* 67:80 */       return false;
/* 68:   */     }
/* 69:81 */     VideoSize other = (VideoSize)obj;
/* 70:82 */     if (this.height != other.height) {
/* 71:83 */       return false;
/* 72:   */     }
/* 73:84 */     if (this.width != other.width) {
/* 74:85 */       return false;
/* 75:   */     }
/* 76:86 */     return true;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public String toDisplayableString()
/* 80:   */   {
/* 81:90 */     return this.width + "x" + this.height;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public String toString()
/* 85:   */   {
/* 86:93 */     return "width = " + this.width + " height = " + this.height;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public boolean isPortrait()
/* 90:   */   {
/* 91:96 */     return this.height >= this.width;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public VideoSize createInverted()
/* 95:   */   {
/* 96:99 */     return new VideoSize(this.height, this.width);
/* 97:   */   }
/* 98:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.VideoSize
 * JD-Core Version:    0.7.0.1
 */