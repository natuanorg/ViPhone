/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ class LinphoneCallImpl
/*   4:    */   implements LinphoneCall
/*   5:    */ {
/*   6:    */   protected final long nativePtr;
/*   7: 24 */   boolean ownPtr = false;
/*   8:    */   Object userData;
/*   9:    */   private LinphoneCallStats audioStats;
/*  10:    */   private LinphoneCallStats videoStats;
/*  11:    */   
/*  12:    */   private native void finalize(long paramLong);
/*  13:    */   
/*  14:    */   private native long getCallLog(long paramLong);
/*  15:    */   
/*  16:    */   private native boolean isIncoming(long paramLong);
/*  17:    */   
/*  18:    */   private native long getRemoteAddress(long paramLong);
/*  19:    */   
/*  20:    */   private native int getState(long paramLong);
/*  21:    */   
/*  22:    */   private native long getCurrentParamsCopy(long paramLong);
/*  23:    */   
/*  24:    */   private native long getRemoteParams(long paramLong);
/*  25:    */   
/*  26:    */   private native void enableCamera(long paramLong, boolean paramBoolean);
/*  27:    */   
/*  28:    */   private native boolean cameraEnabled(long paramLong);
/*  29:    */   
/*  30:    */   private native void enableEchoCancellation(long paramLong, boolean paramBoolean);
/*  31:    */   
/*  32:    */   private native boolean isEchoCancellationEnabled(long paramLong);
/*  33:    */   
/*  34:    */   private native void enableEchoLimiter(long paramLong, boolean paramBoolean);
/*  35:    */   
/*  36:    */   private native boolean isEchoLimiterEnabled(long paramLong);
/*  37:    */   
/*  38:    */   private native Object getReplacedCall(long paramLong);
/*  39:    */   
/*  40:    */   private native int getDuration(long paramLong);
/*  41:    */   
/*  42:    */   private native float getCurrentQuality(long paramLong);
/*  43:    */   
/*  44:    */   private native float getAverageQuality(long paramLong);
/*  45:    */   
/*  46:    */   private native boolean mediaInProgress(long paramLong);
/*  47:    */   
/*  48:    */   private LinphoneCallImpl(long aNativePtr)
/*  49:    */   {
/*  50: 52 */     this.nativePtr = aNativePtr;
/*  51:    */   }
/*  52:    */   
/*  53:    */   protected void finalize()
/*  54:    */     throws Throwable
/*  55:    */   {
/*  56: 55 */     finalize(this.nativePtr);
/*  57:    */   }
/*  58:    */   
/*  59:    */   public LinphoneCallLog getCallLog()
/*  60:    */   {
/*  61: 58 */     long lNativePtr = getCallLog(this.nativePtr);
/*  62: 59 */     if (lNativePtr != 0L) {
/*  63: 60 */       return new LinphoneCallLogImpl(lNativePtr);
/*  64:    */     }
/*  65: 62 */     return null;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setAudioStats(LinphoneCallStats stats)
/*  69:    */   {
/*  70: 66 */     this.audioStats = stats;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setVideoStats(LinphoneCallStats stats)
/*  74:    */   {
/*  75: 69 */     this.videoStats = stats;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public LinphoneCallStats getAudioStats()
/*  79:    */   {
/*  80: 72 */     if (this.audioStats != null) {
/*  81: 72 */       ((LinphoneCallStatsImpl)this.audioStats).updateRealTimeStats(this);
/*  82:    */     }
/*  83: 73 */     return this.audioStats;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public LinphoneCallStats getVideoStats()
/*  87:    */   {
/*  88: 76 */     if (this.videoStats != null) {
/*  89: 76 */       ((LinphoneCallStatsImpl)this.videoStats).updateRealTimeStats(this);
/*  90:    */     }
/*  91: 77 */     return this.videoStats;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public CallDirection getDirection()
/*  95:    */   {
/*  96: 80 */     return isIncoming(this.nativePtr) ? CallDirection.Incoming : CallDirection.Outgoing;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public LinphoneAddress getRemoteAddress()
/* 100:    */   {
/* 101: 83 */     long lNativePtr = getRemoteAddress(this.nativePtr);
/* 102: 84 */     if (lNativePtr != 0L) {
/* 103: 85 */       return new LinphoneAddressImpl(lNativePtr, LinphoneAddressImpl.WrapMode.FromConst);
/* 104:    */     }
/* 105: 87 */     return null;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public State getState()
/* 109:    */   {
/* 110: 91 */     return State.fromInt(getState(this.nativePtr));
/* 111:    */   }
/* 112:    */   
/* 113:    */   public LinphoneCallParams getCurrentParamsCopy()
/* 114:    */   {
/* 115: 94 */     return new LinphoneCallParamsImpl(getCurrentParamsCopy(this.nativePtr));
/* 116:    */   }
/* 117:    */   
/* 118:    */   public LinphoneCallParams getRemoteParams()
/* 119:    */   {
/* 120: 97 */     long remoteParamsPtr = getRemoteParams(this.nativePtr);
/* 121: 98 */     if (remoteParamsPtr == 0L) {
/* 122: 99 */       return null;
/* 123:    */     }
/* 124:101 */     return new LinphoneCallParamsImpl(remoteParamsPtr);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void enableCamera(boolean enabled)
/* 128:    */   {
/* 129:104 */     enableCamera(this.nativePtr, enabled);
/* 130:    */   }
/* 131:    */   
/* 132:    */   public boolean cameraEnabled()
/* 133:    */   {
/* 134:107 */     return cameraEnabled(this.nativePtr);
/* 135:    */   }
/* 136:    */   
/* 137:    */   public boolean equals(Object call)
/* 138:    */   {
/* 139:112 */     if (this == call) {
/* 140:112 */       return true;
/* 141:    */     }
/* 142:113 */     if (call == null) {
/* 143:113 */       return false;
/* 144:    */     }
/* 145:114 */     if (!(call instanceof LinphoneCallImpl)) {
/* 146:114 */       return false;
/* 147:    */     }
/* 148:115 */     return this.nativePtr == ((LinphoneCallImpl)call).nativePtr;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public int hashCode()
/* 152:    */   {
/* 153:120 */     int result = 17;
/* 154:121 */     result = 31 * result + (int)(this.nativePtr ^ this.nativePtr >>> 32);
/* 155:122 */     return result;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void enableEchoCancellation(boolean enable)
/* 159:    */   {
/* 160:125 */     enableEchoCancellation(this.nativePtr, enable);
/* 161:    */   }
/* 162:    */   
/* 163:    */   public boolean isEchoCancellationEnabled()
/* 164:    */   {
/* 165:129 */     return isEchoCancellationEnabled(this.nativePtr);
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void enableEchoLimiter(boolean enable)
/* 169:    */   {
/* 170:132 */     enableEchoLimiter(this.nativePtr, enable);
/* 171:    */   }
/* 172:    */   
/* 173:    */   public boolean isEchoLimiterEnabled()
/* 174:    */   {
/* 175:135 */     return isEchoLimiterEnabled(this.nativePtr);
/* 176:    */   }
/* 177:    */   
/* 178:    */   public LinphoneCall getReplacedCall()
/* 179:    */   {
/* 180:138 */     return (LinphoneCall)getReplacedCall(this.nativePtr);
/* 181:    */   }
/* 182:    */   
/* 183:    */   public int getDuration()
/* 184:    */   {
/* 185:142 */     return getDuration(this.nativePtr);
/* 186:    */   }
/* 187:    */   
/* 188:    */   public float getAverageQuality()
/* 189:    */   {
/* 190:145 */     return getAverageQuality(this.nativePtr);
/* 191:    */   }
/* 192:    */   
/* 193:    */   public float getCurrentQuality()
/* 194:    */   {
/* 195:148 */     return getCurrentQuality(this.nativePtr);
/* 196:    */   }
/* 197:    */   
/* 198:    */   private native String getAuthenticationToken(long paramLong);
/* 199:    */   
/* 200:    */   public String getAuthenticationToken()
/* 201:    */   {
/* 202:153 */     return getAuthenticationToken(this.nativePtr);
/* 203:    */   }
/* 204:    */   
/* 205:    */   private native boolean isAuthenticationTokenVerified(long paramLong);
/* 206:    */   
/* 207:    */   public boolean isAuthenticationTokenVerified()
/* 208:    */   {
/* 209:158 */     return isAuthenticationTokenVerified(this.nativePtr);
/* 210:    */   }
/* 211:    */   
/* 212:    */   private native void setAuthenticationTokenVerified(long paramLong, boolean paramBoolean);
/* 213:    */   
/* 214:    */   public void setAuthenticationTokenVerified(boolean verified)
/* 215:    */   {
/* 216:163 */     setAuthenticationTokenVerified(this.nativePtr, verified);
/* 217:    */   }
/* 218:    */   
/* 219:    */   public boolean isInConference()
/* 220:    */   {
/* 221:167 */     LinphoneCallParamsImpl params = new LinphoneCallParamsImpl(getCurrentParamsCopy(this.nativePtr));
/* 222:168 */     return params.localConferenceMode();
/* 223:    */   }
/* 224:    */   
/* 225:    */   public boolean mediaInProgress()
/* 226:    */   {
/* 227:171 */     return mediaInProgress(this.nativePtr);
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String toString()
/* 231:    */   {
/* 232:175 */     return "Call " + this.nativePtr;
/* 233:    */   }
/* 234:    */   
/* 235:    */   private native float getPlayVolume(long paramLong);
/* 236:    */   
/* 237:    */   public float getPlayVolume()
/* 238:    */   {
/* 239:180 */     return getPlayVolume(this.nativePtr);
/* 240:    */   }
/* 241:    */   
/* 242:    */   private native String getRemoteUserAgent(long paramLong);
/* 243:    */   
/* 244:    */   public String getRemoteUserAgent()
/* 245:    */   {
/* 246:185 */     return getRemoteUserAgent(this.nativePtr);
/* 247:    */   }
/* 248:    */   
/* 249:    */   private native String getRemoteContact(long paramLong);
/* 250:    */   
/* 251:    */   public String getRemoteContact()
/* 252:    */   {
/* 253:190 */     return getRemoteContact(this.nativePtr);
/* 254:    */   }
/* 255:    */   
/* 256:    */   private native void takeSnapshot(long paramLong, String paramString);
/* 257:    */   
/* 258:    */   public void takeSnapshot(String path)
/* 259:    */   {
/* 260:195 */     takeSnapshot(this.nativePtr, path);
/* 261:    */   }
/* 262:    */   
/* 263:    */   private native void zoomVideo(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
/* 264:    */   
/* 265:    */   public void zoomVideo(float factor, float cx, float cy)
/* 266:    */   {
/* 267:200 */     zoomVideo(this.nativePtr, factor, cx, cy);
/* 268:    */   }
/* 269:    */   
/* 270:    */   private native void startRecording(long paramLong);
/* 271:    */   
/* 272:    */   public void startRecording()
/* 273:    */   {
/* 274:206 */     startRecording(this.nativePtr);
/* 275:    */   }
/* 276:    */   
/* 277:    */   private native void stopRecording(long paramLong);
/* 278:    */   
/* 279:    */   public void stopRecording()
/* 280:    */   {
/* 281:211 */     stopRecording(this.nativePtr);
/* 282:    */   }
/* 283:    */   
/* 284:    */   private native int getTransferState(long paramLong);
/* 285:    */   
/* 286:    */   public State getTransferState()
/* 287:    */   {
/* 288:216 */     return State.fromInt(getTransferState(this.nativePtr));
/* 289:    */   }
/* 290:    */   
/* 291:    */   private native int sendInfoMessage(long paramLong1, long paramLong2);
/* 292:    */   
/* 293:    */   public void sendInfoMessage(LinphoneInfoMessage msg)
/* 294:    */   {
/* 295:221 */     sendInfoMessage(this.nativePtr, ((LinphoneInfoMessageImpl)msg).nativePtr);
/* 296:    */   }
/* 297:    */   
/* 298:    */   private native Object getTransfererCall(long paramLong);
/* 299:    */   
/* 300:    */   public LinphoneCall getTransfererCall()
/* 301:    */   {
/* 302:226 */     return (LinphoneCall)getTransfererCall(this.nativePtr);
/* 303:    */   }
/* 304:    */   
/* 305:    */   private native Object getTransferTargetCall(long paramLong);
/* 306:    */   
/* 307:    */   public LinphoneCall getTransferTargetCall()
/* 308:    */   {
/* 309:231 */     return (LinphoneCall)getTransferTargetCall(this.nativePtr);
/* 310:    */   }
/* 311:    */   
/* 312:    */   public Reason getReason()
/* 313:    */   {
/* 314:236 */     return null;
/* 315:    */   }
/* 316:    */   
/* 317:    */   private native long getErrorInfo(long paramLong);
/* 318:    */   
/* 319:    */   public ErrorInfo getErrorInfo()
/* 320:    */   {
/* 321:241 */     return new ErrorInfoImpl(getErrorInfo(this.nativePtr));
/* 322:    */   }
/* 323:    */   
/* 324:    */   public void setUserData(Object obj)
/* 325:    */   {
/* 326:245 */     this.userData = obj;
/* 327:    */   }
/* 328:    */   
/* 329:    */   public Object getUserData()
/* 330:    */   {
/* 331:249 */     return this.userData;
/* 332:    */   }
/* 333:    */   
/* 334:    */   private native long getPlayer(long paramLong);
/* 335:    */   
/* 336:    */   public LinphonePlayer getPlayer()
/* 337:    */   {
/* 338:255 */     return new LinphonePlayerImpl(getPlayer(this.nativePtr));
/* 339:    */   }
/* 340:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneCallImpl

 * JD-Core Version:    0.7.0.1

 */