/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public class LinphoneCallParamsImpl
/*   4:    */   implements LinphoneCallParams
/*   5:    */ {
/*   6:    */   protected final long nativePtr;
/*   7:    */   
/*   8:    */   public LinphoneCallParamsImpl(long nativePtr)
/*   9:    */   {
/*  10: 27 */     this.nativePtr = nativePtr;
/*  11:    */   }
/*  12:    */   
/*  13:    */   private native void enableVideo(long paramLong, boolean paramBoolean);
/*  14:    */   
/*  15:    */   private native boolean getVideoEnabled(long paramLong);
/*  16:    */   
/*  17:    */   private native void audioBandwidth(long paramLong, int paramInt);
/*  18:    */   
/*  19:    */   private native void setMediaEncryption(long paramLong, int paramInt);
/*  20:    */   
/*  21:    */   private native int getMediaEncryption(long paramLong);
/*  22:    */   
/*  23:    */   private native long getUsedAudioCodec(long paramLong);
/*  24:    */   
/*  25:    */   private native long getUsedVideoCodec(long paramLong);
/*  26:    */   
/*  27:    */   private native void destroy(long paramLong);
/*  28:    */   
/*  29:    */   private native void enableLowBandwidth(long paramLong, boolean paramBoolean);
/*  30:    */   
/*  31:    */   private native boolean isLowBandwidthEnabled(long paramLong);
/*  32:    */   
/*  33:    */   public boolean getVideoEnabled()
/*  34:    */   {
/*  35: 42 */     return getVideoEnabled(this.nativePtr);
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setVideoEnabled(boolean b)
/*  39:    */   {
/*  40: 46 */     enableVideo(this.nativePtr, b);
/*  41:    */   }
/*  42:    */   
/*  43:    */   protected void finalize()
/*  44:    */     throws Throwable
/*  45:    */   {
/*  46: 51 */     destroy(this.nativePtr);
/*  47: 52 */     super.finalize();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setAudioBandwidth(int value)
/*  51:    */   {
/*  52: 56 */     audioBandwidth(this.nativePtr, value);
/*  53:    */   }
/*  54:    */   
/*  55:    */   public LinphoneCore.MediaEncryption getMediaEncryption()
/*  56:    */   {
/*  57: 60 */     return LinphoneCore.MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setMediaEnctyption(LinphoneCore.MediaEncryption menc)
/*  61:    */   {
/*  62: 64 */     setMediaEncryption(this.nativePtr, menc.mValue);
/*  63:    */   }
/*  64:    */   
/*  65:    */   public PayloadType getUsedAudioCodec()
/*  66:    */   {
/*  67: 68 */     long ptr = getUsedAudioCodec(this.nativePtr);
/*  68: 69 */     if (ptr == 0L) {
/*  69: 69 */       return null;
/*  70:    */     }
/*  71: 70 */     return new PayloadTypeImpl(ptr);
/*  72:    */   }
/*  73:    */   
/*  74:    */   public PayloadType getUsedVideoCodec()
/*  75:    */   {
/*  76: 74 */     long ptr = getUsedVideoCodec(this.nativePtr);
/*  77: 75 */     if (ptr == 0L) {
/*  78: 75 */       return null;
/*  79:    */     }
/*  80: 76 */     return new PayloadTypeImpl(ptr);
/*  81:    */   }
/*  82:    */   
/*  83:    */   private native boolean localConferenceMode(long paramLong);
/*  84:    */   
/*  85:    */   public boolean localConferenceMode()
/*  86:    */   {
/*  87: 81 */     return localConferenceMode(this.nativePtr);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void enableLowBandwidth(boolean enable)
/*  91:    */   {
/*  92: 85 */     enableLowBandwidth(this.nativePtr, enable);
/*  93:    */   }
/*  94:    */   
/*  95:    */   public boolean isLowBandwidthEnabled()
/*  96:    */   {
/*  97: 89 */     return isLowBandwidthEnabled(this.nativePtr);
/*  98:    */   }
/*  99:    */   
/* 100:    */   private native void setRecordFile(long paramLong, String paramString);
/* 101:    */   
/* 102:    */   public void setRecordFile(String path)
/* 103:    */   {
/* 104: 95 */     setRecordFile(this.nativePtr, path);
/* 105:    */   }
/* 106:    */   
/* 107:    */   private native void addCustomHeader(long paramLong, String paramString1, String paramString2);
/* 108:    */   
/* 109:    */   public void addCustomHeader(String name, String value)
/* 110:    */   {
/* 111:101 */     addCustomHeader(this.nativePtr, name, value);
/* 112:    */   }
/* 113:    */   
/* 114:    */   private native String getCustomHeader(long paramLong, String paramString);
/* 115:    */   
/* 116:    */   public String getCustomHeader(String name)
/* 117:    */   {
/* 118:107 */     return getCustomHeader(this.nativePtr, name);
/* 119:    */   }
/* 120:    */   
/* 121:    */   private native void setPrivacy(long paramLong, int paramInt);
/* 122:    */   
/* 123:    */   public void setPrivacy(int privacy_mask)
/* 124:    */   {
/* 125:113 */     setPrivacy(this.nativePtr, privacy_mask);
/* 126:    */   }
/* 127:    */   
/* 128:    */   private native int getPrivacy(long paramLong);
/* 129:    */   
/* 130:    */   public int getPrivacy()
/* 131:    */   {
/* 132:119 */     return getPrivacy(this.nativePtr);
/* 133:    */   }
/* 134:    */   
/* 135:    */   private native void setSessionName(long paramLong, String paramString);
/* 136:    */   
/* 137:    */   public void setSessionName(String name)
/* 138:    */   {
/* 139:125 */     setSessionName(this.nativePtr, name);
/* 140:    */   }
/* 141:    */   
/* 142:    */   private native String getSessionName(long paramLong);
/* 143:    */   
/* 144:    */   public String getSessionName()
/* 145:    */   {
/* 146:131 */     return getSessionName(this.nativePtr);
/* 147:    */   }
/* 148:    */   
/* 149:    */   private native int[] getSentVideoSize(long paramLong);
/* 150:    */   
/* 151:    */   public VideoSize getSentVideoSize()
/* 152:    */   {
/* 153:137 */     int[] nativeSize = getSentVideoSize(this.nativePtr);
/* 154:138 */     VideoSize vSize = new VideoSize();
/* 155:139 */     vSize.width = nativeSize[0];
/* 156:140 */     vSize.height = nativeSize[1];
/* 157:141 */     return vSize;
/* 158:    */   }
/* 159:    */   
/* 160:    */   private native int[] getReceivedVideoSize(long paramLong);
/* 161:    */   
/* 162:    */   public VideoSize getReceivedVideoSize()
/* 163:    */   {
/* 164:147 */     int[] nativeSize = getReceivedVideoSize(this.nativePtr);
/* 165:148 */     VideoSize vSize = new VideoSize();
/* 166:149 */     vSize.width = nativeSize[0];
/* 167:150 */     vSize.height = nativeSize[1];
/* 168:151 */     return vSize;
/* 169:    */   }
/* 170:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCallParamsImpl
 * JD-Core Version:    0.7.0.1
 */