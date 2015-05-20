/*    1:     */ package org.linphone.core;
/*    2:     */ 
/*    3:     */ import android.content.Context;
/*    4:     */ import android.media.AudioManager;
/*    5:     */ import android.net.wifi.WifiManager;
/*    6:     */ import android.net.wifi.WifiManager.MulticastLock;
/*    7:     */ import android.net.wifi.WifiManager.WifiLock;
/*    8:     */ import java.io.File;
/*    9:     */ import java.io.IOException;
/*   10:     */ import org.linphone.mediastream.Log;
/*   11:     */ import org.linphone.mediastream.Version;
/*   12:     */ import org.linphone.mediastream.video.AndroidVideoWindowImpl;
/*   13:     */ import org.linphone.mediastream.video.capture.hwconf.Hacks;
/*   14:     */ 
/*   15:     */ class LinphoneCoreImpl
/*   16:     */   implements LinphoneCore
/*   17:     */ {
/*   18:     */   private final LinphoneCoreListener mListener;
/*   19:  42 */   protected long nativePtr = 0L;
/*   20:  43 */   private Context mContext = null;
/*   21:  44 */   private AudioManager mAudioManager = null;
/*   22:  45 */   private boolean mSpeakerEnabled = false;
/*   23:     */   
/*   24:     */   private native long newLinphoneCore(LinphoneCoreListener paramLinphoneCoreListener, String paramString1, String paramString2, Object paramObject);
/*   25:     */   
/*   26:     */   private native void iterate(long paramLong);
/*   27:     */   
/*   28:     */   private native LinphoneProxyConfig getDefaultProxyConfig(long paramLong);
/*   29:     */   
/*   30:     */   private native void setDefaultProxyConfig(long paramLong1, long paramLong2);
/*   31:     */   
/*   32:     */   private native int addProxyConfig(LinphoneProxyConfig paramLinphoneProxyConfig, long paramLong1, long paramLong2);
/*   33:     */   
/*   34:     */   private native void removeProxyConfig(long paramLong1, long paramLong2);
/*   35:     */   
/*   36:     */   private native void clearAuthInfos(long paramLong);
/*   37:     */   
/*   38:     */   private native void clearProxyConfigs(long paramLong);
/*   39:     */   
/*   40:     */   private native void addAuthInfo(long paramLong1, long paramLong2);
/*   41:     */   
/*   42:     */   private native void removeAuthInfo(long paramLong1, long paramLong2);
/*   43:     */   
/*   44:     */   private native Object invite(long paramLong, String paramString);
/*   45:     */   
/*   46:     */   private native void terminateCall(long paramLong1, long paramLong2);
/*   47:     */   
/*   48:     */   private native long getRemoteAddress(long paramLong);
/*   49:     */   
/*   50:     */   private native boolean isInCall(long paramLong);
/*   51:     */   
/*   52:     */   private native boolean isInComingInvitePending(long paramLong);
/*   53:     */   
/*   54:     */   private native void acceptCall(long paramLong1, long paramLong2);
/*   55:     */   
/*   56:     */   private native long getCallLog(long paramLong, int paramInt);
/*   57:     */   
/*   58:     */   private native int getNumberOfCallLogs(long paramLong);
/*   59:     */   
/*   60:     */   private native void delete(long paramLong);
/*   61:     */   
/*   62:     */   private native void setNetworkStateReachable(long paramLong, boolean paramBoolean);
/*   63:     */   
/*   64:     */   private native boolean isNetworkStateReachable(long paramLong);
/*   65:     */   
/*   66:     */   private native void setPlaybackGain(long paramLong, float paramFloat);
/*   67:     */   
/*   68:     */   private native float getPlaybackGain(long paramLong);
/*   69:     */   
/*   70:     */   private native void muteMic(long paramLong, boolean paramBoolean);
/*   71:     */   
/*   72:     */   private native long interpretUrl(long paramLong, String paramString);
/*   73:     */   
/*   74:     */   private native Object inviteAddress(long paramLong1, long paramLong2);
/*   75:     */   
/*   76:     */   private native Object inviteAddressWithParams(long paramLong1, long paramLong2, long paramLong3);
/*   77:     */   
/*   78:     */   private native void sendDtmf(long paramLong, char paramChar);
/*   79:     */   
/*   80:     */   private native void clearCallLogs(long paramLong);
/*   81:     */   
/*   82:     */   private native boolean isMicMuted(long paramLong);
/*   83:     */   
/*   84:     */   private native long findPayloadType(long paramLong, String paramString, int paramInt1, int paramInt2);
/*   85:     */   
/*   86:     */   private native int enablePayloadType(long paramLong1, long paramLong2, boolean paramBoolean);
/*   87:     */   
/*   88:     */   private native boolean isPayloadTypeEnabled(long paramLong1, long paramLong2);
/*   89:     */   
/*   90:     */   private native boolean payloadTypeIsVbr(long paramLong1, long paramLong2);
/*   91:     */   
/*   92:     */   private native void enableAdaptiveRateControl(long paramLong, boolean paramBoolean);
/*   93:     */   
/*   94:     */   private native boolean isAdaptiveRateControlEnabled(long paramLong);
/*   95:     */   
/*   96:     */   private native String getAdaptiveRateAlgorithm(long paramLong);
/*   97:     */   
/*   98:     */   private native void setAdaptiveRateAlgorithm(long paramLong, String paramString);
/*   99:     */   
/*  100:     */   private native void enableEchoCancellation(long paramLong, boolean paramBoolean);
/*  101:     */   
/*  102:     */   private native boolean isEchoCancellationEnabled(long paramLong);
/*  103:     */   
/*  104:     */   private native Object getCurrentCall(long paramLong);
/*  105:     */   
/*  106:     */   private native void playDtmf(long paramLong, char paramChar, int paramInt);
/*  107:     */   
/*  108:     */   private native void stopDtmf(long paramLong);
/*  109:     */   
/*  110:     */   private native void setVideoWindowId(long paramLong, Object paramObject);
/*  111:     */   
/*  112:     */   private native void setPreviewWindowId(long paramLong, Object paramObject);
/*  113:     */   
/*  114:     */   private native void setDeviceRotation(long paramLong, int paramInt);
/*  115:     */   
/*  116:     */   private native void addFriend(long paramLong1, long paramLong2);
/*  117:     */   
/*  118:     */   private native LinphoneFriend[] getFriendList(long paramLong);
/*  119:     */   
/*  120:     */   private native void setPresenceInfo(long paramLong, int paramInt1, String paramString, int paramInt2);
/*  121:     */   
/*  122:     */   private native int getPresenceInfo(long paramLong);
/*  123:     */   
/*  124:     */   private native void setPresenceModel(long paramLong1, long paramLong2);
/*  125:     */   
/*  126:     */   private native Object getPresenceModel(long paramLong);
/*  127:     */   
/*  128:     */   private native long getOrCreateChatRoom(long paramLong, String paramString);
/*  129:     */   
/*  130:     */   private native void enableVideo(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
/*  131:     */   
/*  132:     */   private native boolean isVideoEnabled(long paramLong);
/*  133:     */   
/*  134:     */   private native boolean isVideoSupported(long paramLong);
/*  135:     */   
/*  136:     */   private native void setFirewallPolicy(long paramLong, int paramInt);
/*  137:     */   
/*  138:     */   private native int getFirewallPolicy(long paramLong);
/*  139:     */   
/*  140:     */   private native void setStunServer(long paramLong, String paramString);
/*  141:     */   
/*  142:     */   private native String getStunServer(long paramLong);
/*  143:     */   
/*  144:     */   private native long createDefaultCallParams(long paramLong);
/*  145:     */   
/*  146:     */   private native int updateCall(long paramLong1, long paramLong2, long paramLong3);
/*  147:     */   
/*  148:     */   private native void setUploadBandwidth(long paramLong, int paramInt);
/*  149:     */   
/*  150:     */   private native void setDownloadBandwidth(long paramLong, int paramInt);
/*  151:     */   
/*  152:     */   private native void setPreferredVideoSize(long paramLong, int paramInt1, int paramInt2);
/*  153:     */   
/*  154:     */   private native void setPreferredVideoSizeByName(long paramLong, String paramString);
/*  155:     */   
/*  156:     */   private native int[] getPreferredVideoSize(long paramLong);
/*  157:     */   
/*  158:     */   private native void setRing(long paramLong, String paramString);
/*  159:     */   
/*  160:     */   private native String getRing(long paramLong);
/*  161:     */   
/*  162:     */   private native void setRootCA(long paramLong, String paramString);
/*  163:     */   
/*  164:     */   private native void setRingback(long paramLong, String paramString);
/*  165:     */   
/*  166:     */   private native long[] listVideoPayloadTypes(long paramLong);
/*  167:     */   
/*  168:     */   private native void setVideoCodecs(long paramLong, long[] paramArrayOfLong);
/*  169:     */   
/*  170:     */   private native LinphoneProxyConfig[] getProxyConfigList(long paramLong);
/*  171:     */   
/*  172:     */   private native long[] getAuthInfosList(long paramLong);
/*  173:     */   
/*  174:     */   private native long findAuthInfos(long paramLong, String paramString1, String paramString2, String paramString3);
/*  175:     */   
/*  176:     */   private native long[] listAudioPayloadTypes(long paramLong);
/*  177:     */   
/*  178:     */   private native void setAudioCodecs(long paramLong, long[] paramArrayOfLong);
/*  179:     */   
/*  180:     */   private native void enableKeepAlive(long paramLong, boolean paramBoolean);
/*  181:     */   
/*  182:     */   private native boolean isKeepAliveEnabled(long paramLong);
/*  183:     */   
/*  184:     */   private native int startEchoCalibration(long paramLong, Object paramObject);
/*  185:     */   
/*  186:     */   private native int getSignalingTransportPort(long paramLong, int paramInt);
/*  187:     */   
/*  188:     */   private native void setSignalingTransportPorts(long paramLong, int paramInt1, int paramInt2, int paramInt3);
/*  189:     */   
/*  190:     */   private native void enableIpv6(long paramLong, boolean paramBoolean);
/*  191:     */   
/*  192:     */   private native boolean isIpv6Enabled(long paramLong);
/*  193:     */   
/*  194:     */   private native int pauseCall(long paramLong1, long paramLong2);
/*  195:     */   
/*  196:     */   private native int pauseAllCalls(long paramLong);
/*  197:     */   
/*  198:     */   private native int resumeCall(long paramLong1, long paramLong2);
/*  199:     */   
/*  200:     */   private native void setUploadPtime(long paramLong, int paramInt);
/*  201:     */   
/*  202:     */   private native void setDownloadPtime(long paramLong, int paramInt);
/*  203:     */   
/*  204:     */   private native void setZrtpSecretsCache(long paramLong, String paramString);
/*  205:     */   
/*  206:     */   private native void enableEchoLimiter(long paramLong, boolean paramBoolean);
/*  207:     */   
/*  208:     */   private native int setVideoDevice(long paramLong, int paramInt);
/*  209:     */   
/*  210:     */   private native int getVideoDevice(long paramLong);
/*  211:     */   
/*  212:     */   private native int getMediaEncryption(long paramLong);
/*  213:     */   
/*  214:     */   private native void setMediaEncryption(long paramLong, int paramInt);
/*  215:     */   
/*  216:     */   private native boolean isMediaEncryptionMandatory(long paramLong);
/*  217:     */   
/*  218:     */   private native void setMediaEncryptionMandatory(long paramLong, boolean paramBoolean);
/*  219:     */   
/*  220:     */   private native void removeCallLog(long paramLong1, long paramLong2);
/*  221:     */   
/*  222:     */   private native int getMissedCallsCount(long paramLong);
/*  223:     */   
/*  224:     */   private native void resetMissedCallsCount(long paramLong);
/*  225:     */   
/*  226:     */   private native String getVersion(long paramLong);
/*  227:     */   
/*  228:     */   private native void setAudioPort(long paramLong, int paramInt);
/*  229:     */   
/*  230:     */   private native void setVideoPort(long paramLong, int paramInt);
/*  231:     */   
/*  232:     */   private native void setAudioPortRange(long paramLong, int paramInt1, int paramInt2);
/*  233:     */   
/*  234:     */   private native void setVideoPortRange(long paramLong, int paramInt1, int paramInt2);
/*  235:     */   
/*  236:     */   private native void setIncomingTimeout(long paramLong, int paramInt);
/*  237:     */   
/*  238:     */   private native void setInCallTimeout(long paramLong, int paramInt);
/*  239:     */   
/*  240:     */   private native void setPrimaryContact2(long paramLong, String paramString);
/*  241:     */   
/*  242:     */   private native String getPrimaryContact(long paramLong);
/*  243:     */   
/*  244:     */   private native void setPrimaryContact(long paramLong, String paramString1, String paramString2);
/*  245:     */   
/*  246:     */   private native String getPrimaryContactUsername(long paramLong);
/*  247:     */   
/*  248:     */   private native String getPrimaryContactDisplayName(long paramLong);
/*  249:     */   
/*  250:     */   private native void setChatDatabasePath(long paramLong, String paramString);
/*  251:     */   
/*  252:     */   private native long[] getChatRooms(long paramLong);
/*  253:     */   
/*  254:     */   private native int migrateToMultiTransport(long paramLong);
/*  255:     */   
/*  256:     */   private native void setCallErrorTone(long paramLong, int paramInt, String paramString);
/*  257:     */   
/*  258:     */   private native void enableSdp200Ack(long paramLong, boolean paramBoolean);
/*  259:     */   
/*  260:     */   private native boolean isSdp200AckEnabled(long paramLong);
/*  261:     */   
/*  262:     */   private native void stopRinging(long paramLong);
/*  263:     */   
/*  264:     */   private static native void setAndroidPowerManager(Object paramObject);
/*  265:     */   
/*  266:     */   private native void setAndroidWifiLock(long paramLong, Object paramObject);
/*  267:     */   
/*  268:     */   private native void setAndroidMulticastLock(long paramLong, Object paramObject);
/*  269:     */   
/*  270:     */   LinphoneCoreImpl(LinphoneCoreListener listener, File userConfig, File factoryConfig, Object userdata)
/*  271:     */     throws IOException
/*  272:     */   {
/*  273: 173 */     this.mListener = listener;
/*  274: 174 */     String user = userConfig == null ? null : userConfig.getCanonicalPath();
/*  275: 175 */     String factory = factoryConfig == null ? null : factoryConfig.getCanonicalPath();
/*  276: 176 */     this.nativePtr = newLinphoneCore(listener, user, factory, userdata);
/*  277:     */   }
/*  278:     */   
/*  279:     */   LinphoneCoreImpl(LinphoneCoreListener listener)
/*  280:     */     throws IOException
/*  281:     */   {
/*  282: 179 */     this.mListener = listener;
/*  283: 180 */     this.nativePtr = newLinphoneCore(listener, null, null, null);
/*  284:     */   }
/*  285:     */   
/*  286:     */   protected void finalize()
/*  287:     */     throws Throwable
/*  288:     */   {
/*  289: 184 */     if (this.nativePtr != 0L) {
/*  290: 184 */       destroy();
/*  291:     */     }
/*  292:     */   }
/*  293:     */   
/*  294:     */   private boolean contextInitialized()
/*  295:     */   {
/*  296: 188 */     if (this.mContext == null)
/*  297:     */     {
/*  298: 189 */       Log.e(new Object[] { "Context of LinphoneCore has not been initialized, call setContext() after creating LinphoneCore." });
/*  299: 190 */       return false;
/*  300:     */     }
/*  301: 192 */     return true;
/*  302:     */   }
/*  303:     */   
/*  304:     */   public void setContext(Object context)
/*  305:     */   {
/*  306: 195 */     this.mContext = ((Context)context);
/*  307: 196 */     this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
/*  308: 197 */     setAndroidPowerManager(this.mContext.getSystemService("power"));
/*  309: 198 */     if (Version.sdkAboveOrEqual(12))
/*  310:     */     {
/*  311: 199 */       WifiManager wifiManager = (WifiManager)this.mContext.getSystemService("wifi");
/*  312: 200 */       WifiLock lock = wifiManager.createWifiLock(3, "linphonecore [" + this.nativePtr + "] wifi-lock");
/*  313: 201 */       lock.setReferenceCounted(true);
/*  314: 202 */       setAndroidWifiLock(this.nativePtr, lock);
/*  315:     */     }
/*  316: 204 */     if (Version.sdkAboveOrEqual(14))
/*  317:     */     {
/*  318: 205 */       WifiManager wifiManager = (WifiManager)this.mContext.getSystemService("wifi");
/*  319: 206 */       MulticastLock lock = wifiManager.createMulticastLock("linphonecore [" + this.nativePtr + "] multicast-lock");
/*  320: 207 */       lock.setReferenceCounted(true);
/*  321: 208 */       setAndroidMulticastLock(this.nativePtr, lock);
/*  322:     */     }
/*  323:     */   }
/*  324:     */   
/*  325:     */   public synchronized void addAuthInfo(LinphoneAuthInfo info)
/*  326:     */   {
/*  327: 213 */     isValid();
/*  328: 214 */     addAuthInfo(this.nativePtr, ((LinphoneAuthInfoImpl)info).nativePtr);
/*  329:     */   }
/*  330:     */   
/*  331:     */   public synchronized void removeAuthInfo(LinphoneAuthInfo info)
/*  332:     */   {
/*  333: 218 */     isValid();
/*  334: 219 */     removeAuthInfo(this.nativePtr, ((LinphoneAuthInfoImpl)info).nativePtr);
/*  335:     */   }
/*  336:     */   
/*  337:     */   public synchronized LinphoneProxyConfig getDefaultProxyConfig()
/*  338:     */   {
/*  339: 223 */     isValid();
/*  340: 224 */     return getDefaultProxyConfig(this.nativePtr);
/*  341:     */   }
/*  342:     */   
/*  343:     */   public synchronized LinphoneCall invite(String uri)
/*  344:     */   {
/*  345: 228 */     isValid();
/*  346: 229 */     return (LinphoneCall)invite(this.nativePtr, uri);
/*  347:     */   }
/*  348:     */   
/*  349:     */   public synchronized void iterate()
/*  350:     */   {
/*  351: 233 */     isValid();
/*  352: 234 */     iterate(this.nativePtr);
/*  353:     */   }
/*  354:     */   
/*  355:     */   public synchronized void setDefaultProxyConfig(LinphoneProxyConfig proxyCfg)
/*  356:     */   {
/*  357: 238 */     isValid();
/*  358: 239 */     long proxyPtr = proxyCfg != null ? ((LinphoneProxyConfigImpl)proxyCfg).nativePtr : 0L;
/*  359: 240 */     setDefaultProxyConfig(this.nativePtr, proxyPtr);
/*  360:     */   }
/*  361:     */   
/*  362:     */   public synchronized void addProxyConfig(LinphoneProxyConfig proxyCfg)
/*  363:     */     throws LinphoneCoreException
/*  364:     */   {
/*  365: 243 */     isValid();
/*  366: 244 */     if (addProxyConfig(proxyCfg, this.nativePtr, ((LinphoneProxyConfigImpl)proxyCfg).nativePtr) != 0) {
/*  367: 245 */       throw new LinphoneCoreException("bad proxy config");
/*  368:     */     }
/*  369: 247 */     ((LinphoneProxyConfigImpl)proxyCfg).mCore = this;
/*  370:     */   }
/*  371:     */   
/*  372:     */   public synchronized void removeProxyConfig(LinphoneProxyConfig proxyCfg)
/*  373:     */   {
/*  374: 250 */     isValid();
/*  375: 251 */     removeProxyConfig(this.nativePtr, ((LinphoneProxyConfigImpl)proxyCfg).nativePtr);
/*  376:     */   }
/*  377:     */   
/*  378:     */   public synchronized void clearAuthInfos()
/*  379:     */   {
/*  380: 254 */     isValid();
/*  381: 255 */     clearAuthInfos(this.nativePtr);
/*  382:     */   }
/*  383:     */   
/*  384:     */   public synchronized void clearProxyConfigs()
/*  385:     */   {
/*  386: 258 */     isValid();
/*  387: 259 */     clearProxyConfigs(this.nativePtr);
/*  388:     */   }
/*  389:     */   
/*  390:     */   public synchronized void terminateCall(LinphoneCall aCall)
/*  391:     */   {
/*  392: 262 */     isValid();
/*  393: 263 */     if (aCall != null) {
/*  394: 263 */       terminateCall(this.nativePtr, ((LinphoneCallImpl)aCall).nativePtr);
/*  395:     */     }
/*  396:     */   }
/*  397:     */   
/*  398:     */   public synchronized LinphoneAddress getRemoteAddress()
/*  399:     */   {
/*  400: 266 */     isValid();
/*  401: 267 */     long ptr = getRemoteAddress(this.nativePtr);
/*  402: 268 */     if (ptr == 0L) {
/*  403: 269 */       return null;
/*  404:     */     }
/*  405: 271 */     return new LinphoneAddressImpl(ptr, LinphoneAddressImpl.WrapMode.FromConst);
/*  406:     */   }
/*  407:     */   
/*  408:     */   public synchronized boolean isIncall()
/*  409:     */   {
/*  410: 275 */     isValid();
/*  411: 276 */     return isInCall(this.nativePtr);
/*  412:     */   }
/*  413:     */   
/*  414:     */   public synchronized boolean isInComingInvitePending()
/*  415:     */   {
/*  416: 279 */     isValid();
/*  417: 280 */     return isInComingInvitePending(this.nativePtr);
/*  418:     */   }
/*  419:     */   
/*  420:     */   public synchronized void acceptCall(LinphoneCall aCall)
/*  421:     */   {
/*  422: 283 */     isValid();
/*  423: 284 */     acceptCall(this.nativePtr, ((LinphoneCallImpl)aCall).nativePtr);
/*  424:     */   }
/*  425:     */   
/*  426:     */   public synchronized LinphoneCallLog[] getCallLogs()
/*  427:     */   {
/*  428: 287 */     isValid();
/*  429: 288 */     LinphoneCallLog[] logs = new LinphoneCallLog[getNumberOfCallLogs(this.nativePtr)];
/*  430: 289 */     for (int i = 0; i < getNumberOfCallLogs(this.nativePtr); i++) {
/*  431: 290 */       logs[i] = new LinphoneCallLogImpl(getCallLog(this.nativePtr, i));
/*  432:     */     }
/*  433: 292 */     return logs;
/*  434:     */   }
/*  435:     */   
/*  436:     */   public synchronized void destroy()
/*  437:     */   {
/*  438: 295 */     setAndroidPowerManager(null);
/*  439: 296 */     delete(this.nativePtr);
/*  440: 297 */     this.nativePtr = 0L;
/*  441:     */   }
/*  442:     */   
/*  443:     */   private void isValid()
/*  444:     */   {
/*  445: 301 */     if (this.nativePtr == 0L) {
/*  446: 302 */       throw new RuntimeException("object already destroyed");
/*  447:     */     }
/*  448:     */   }
/*  449:     */   
/*  450:     */   public synchronized void setNetworkReachable(boolean isReachable)
/*  451:     */   {
/*  452: 306 */     setNetworkStateReachable(this.nativePtr, isReachable);
/*  453:     */   }
/*  454:     */   
/*  455:     */   public synchronized void setPlaybackGain(float gain)
/*  456:     */   {
/*  457: 309 */     setPlaybackGain(this.nativePtr, gain);
/*  458:     */   }
/*  459:     */   
/*  460:     */   public synchronized float getPlaybackGain()
/*  461:     */   {
/*  462: 313 */     return getPlaybackGain(this.nativePtr);
/*  463:     */   }
/*  464:     */   
/*  465:     */   public synchronized void muteMic(boolean isMuted)
/*  466:     */   {
/*  467: 316 */     muteMic(this.nativePtr, isMuted);
/*  468:     */   }
/*  469:     */   
/*  470:     */   public synchronized LinphoneAddress interpretUrl(String destination)
/*  471:     */     throws LinphoneCoreException
/*  472:     */   {
/*  473: 320 */     long lAddress = interpretUrl(this.nativePtr, destination);
/*  474: 321 */     if (lAddress != 0L) {
/*  475: 322 */       return new LinphoneAddressImpl(lAddress, LinphoneAddressImpl.WrapMode.FromNew);
/*  476:     */     }
/*  477: 324 */     throw new LinphoneCoreException("Cannot interpret [" + destination + "]");
/*  478:     */   }
/*  479:     */   
/*  480:     */   public synchronized LinphoneCall invite(LinphoneAddress to)
/*  481:     */     throws LinphoneCoreException
/*  482:     */   {
/*  483: 328 */     LinphoneCall call = (LinphoneCall)inviteAddress(this.nativePtr, ((LinphoneAddressImpl)to).nativePtr);
/*  484: 329 */     if (call != null) {
/*  485: 330 */       return call;
/*  486:     */     }
/*  487: 332 */     throw new LinphoneCoreException("Unable to invite address " + to.asString());
/*  488:     */   }
/*  489:     */   
/*  490:     */   public synchronized void sendDtmf(char number)
/*  491:     */   {
/*  492: 337 */     sendDtmf(this.nativePtr, number);
/*  493:     */   }
/*  494:     */   
/*  495:     */   public synchronized void clearCallLogs()
/*  496:     */   {
/*  497: 340 */     clearCallLogs(this.nativePtr);
/*  498:     */   }
/*  499:     */   
/*  500:     */   public synchronized boolean isMicMuted()
/*  501:     */   {
/*  502: 343 */     return isMicMuted(this.nativePtr);
/*  503:     */   }
/*  504:     */   
/*  505:     */   public synchronized PayloadType findPayloadType(String mime, int clockRate, int channels)
/*  506:     */   {
/*  507: 346 */     isValid();
/*  508: 347 */     long playLoadType = findPayloadType(this.nativePtr, mime, clockRate, channels);
/*  509: 348 */     if (playLoadType == 0L) {
/*  510: 349 */       return null;
/*  511:     */     }
/*  512: 351 */     return new PayloadTypeImpl(playLoadType);
/*  513:     */   }
/*  514:     */   
/*  515:     */   public synchronized void enablePayloadType(PayloadType pt, boolean enable)
/*  516:     */     throws LinphoneCoreException
/*  517:     */   {
/*  518: 356 */     isValid();
/*  519: 357 */     if (enablePayloadType(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr, enable) != 0) {
/*  520: 358 */       throw new LinphoneCoreException("cannot enable payload type [" + pt + "]");
/*  521:     */     }
/*  522:     */   }
/*  523:     */   
/*  524:     */   public synchronized boolean isPayloadTypeEnabled(PayloadType pt)
/*  525:     */   {
/*  526: 363 */     isValid();
/*  527: 364 */     return isPayloadTypeEnabled(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr);
/*  528:     */   }
/*  529:     */   
/*  530:     */   public synchronized boolean payloadTypeIsVbr(PayloadType pt)
/*  531:     */   {
/*  532: 368 */     isValid();
/*  533: 369 */     return payloadTypeIsVbr(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr);
/*  534:     */   }
/*  535:     */   
/*  536:     */   public synchronized void enableEchoCancellation(boolean enable)
/*  537:     */   {
/*  538: 373 */     isValid();
/*  539: 374 */     enableEchoCancellation(this.nativePtr, enable);
/*  540:     */   }
/*  541:     */   
/*  542:     */   public synchronized boolean isEchoCancellationEnabled()
/*  543:     */   {
/*  544: 377 */     isValid();
/*  545: 378 */     return isEchoCancellationEnabled(this.nativePtr);
/*  546:     */   }
/*  547:     */   
/*  548:     */   public synchronized LinphoneCall getCurrentCall()
/*  549:     */   {
/*  550: 383 */     isValid();
/*  551: 384 */     return (LinphoneCall)getCurrentCall(this.nativePtr);
/*  552:     */   }
/*  553:     */   
/*  554:     */   public int getPlayLevel()
/*  555:     */   {
/*  556: 389 */     return 0;
/*  557:     */   }
/*  558:     */   
/*  559:     */   public void setPlayLevel(int level) {}
/*  560:     */   
/*  561:     */   private void applyAudioHacks()
/*  562:     */   {
/*  563: 397 */     if (Hacks.needGalaxySAudioHack()) {
/*  564: 399 */       setMicrophoneGain(-9.0F);
/*  565:     */     }
/*  566:     */   }
/*  567:     */   
/*  568:     */   private void setAudioModeIncallForGalaxyS()
/*  569:     */   {
/*  570: 403 */     if (!contextInitialized()) {
/*  571: 403 */       return;
/*  572:     */     }
/*  573: 404 */     this.mAudioManager.setMode(2);
/*  574:     */   }
/*  575:     */   
/*  576:     */   public void routeAudioToSpeakerHelper(boolean speakerOn)
/*  577:     */   {
/*  578: 407 */     if (!contextInitialized()) {
/*  579: 407 */       return;
/*  580:     */     }
/*  581: 408 */     if (Hacks.needGalaxySAudioHack()) {
/*  582: 409 */       setAudioModeIncallForGalaxyS();
/*  583:     */     }
/*  584: 410 */     this.mAudioManager.setSpeakerphoneOn(speakerOn);
/*  585:     */   }
/*  586:     */   
/*  587:     */   private native void forceSpeakerState(long paramLong, boolean paramBoolean);
/*  588:     */   
/*  589:     */   public void enableSpeaker(boolean value)
/*  590:     */   {
/*  591: 414 */     LinphoneCall call = getCurrentCall();
/*  592: 415 */     this.mSpeakerEnabled = value;
/*  593: 416 */     applyAudioHacks();
/*  594: 417 */     if ((call != null) && (call.getState() == LinphoneCall.State.StreamsRunning) && (Hacks.needGalaxySAudioHack()))
/*  595:     */     {
/*  596: 418 */       Log.d(new Object[] { "Hack to have speaker=", Boolean.valueOf(value), " while on call" });
/*  597: 419 */       forceSpeakerState(this.nativePtr, value);
/*  598:     */     }
/*  599:     */     else
/*  600:     */     {
/*  601: 421 */       routeAudioToSpeakerHelper(value);
/*  602:     */     }
/*  603:     */   }
/*  604:     */   
/*  605:     */   public boolean isSpeakerEnabled()
/*  606:     */   {
/*  607: 425 */     return this.mSpeakerEnabled;
/*  608:     */   }
/*  609:     */   
/*  610:     */   public synchronized void playDtmf(char number, int duration)
/*  611:     */   {
/*  612: 428 */     playDtmf(this.nativePtr, number, duration);
/*  613:     */   }
/*  614:     */   
/*  615:     */   public synchronized void stopDtmf()
/*  616:     */   {
/*  617: 432 */     stopDtmf(this.nativePtr);
/*  618:     */   }
/*  619:     */   
/*  620:     */   public synchronized void addFriend(LinphoneFriend lf)
/*  621:     */     throws LinphoneCoreException
/*  622:     */   {
/*  623: 436 */     addFriend(this.nativePtr, ((LinphoneFriendImpl)lf).nativePtr);
/*  624:     */   }
/*  625:     */   
/*  626:     */   public synchronized LinphoneFriend[] getFriendList()
/*  627:     */   {
/*  628: 440 */     return getFriendList(this.nativePtr);
/*  629:     */   }
/*  630:     */   
/*  631:     */   public synchronized void setPresenceInfo(int minutes_away, String alternative_contact, OnlineStatus status)
/*  632:     */   {
/*  633: 445 */     setPresenceInfo(this.nativePtr, minutes_away, alternative_contact, status.mValue);
/*  634:     */   }
/*  635:     */   
/*  636:     */   public synchronized OnlineStatus getPresenceInfo()
/*  637:     */   {
/*  638: 450 */     return OnlineStatus.fromInt(getPresenceInfo(this.nativePtr));
/*  639:     */   }
/*  640:     */   
/*  641:     */   public synchronized void setPresenceModel(PresenceModel presence)
/*  642:     */   {
/*  643: 453 */     setPresenceModel(this.nativePtr, ((PresenceModelImpl)presence).getNativePtr());
/*  644:     */   }
/*  645:     */   
/*  646:     */   public synchronized PresenceModel getPresenceModel()
/*  647:     */   {
/*  648: 456 */     return (PresenceModel)getPresenceModel(this.nativePtr);
/*  649:     */   }
/*  650:     */   
/*  651:     */   public synchronized LinphoneChatRoom getOrCreateChatRoom(String to)
/*  652:     */   {
/*  653: 459 */     return new LinphoneChatRoomImpl(getOrCreateChatRoom(this.nativePtr, to));
/*  654:     */   }
/*  655:     */   
/*  656:     */   public synchronized void setPreviewWindow(Object w)
/*  657:     */   {
/*  658: 462 */     setPreviewWindowId(this.nativePtr, w);
/*  659:     */   }
/*  660:     */   
/*  661:     */   public synchronized void setVideoWindow(Object w)
/*  662:     */   {
/*  663: 465 */     setVideoWindowId(this.nativePtr, w);
/*  664:     */   }
/*  665:     */   
/*  666:     */   public synchronized void setDeviceRotation(int rotation)
/*  667:     */   {
/*  668: 468 */     setDeviceRotation(this.nativePtr, rotation);
/*  669:     */   }
/*  670:     */   
/*  671:     */   public synchronized void enableVideo(boolean vcap_enabled, boolean display_enabled)
/*  672:     */   {
/*  673: 472 */     enableVideo(this.nativePtr, vcap_enabled, display_enabled);
/*  674:     */   }
/*  675:     */   
/*  676:     */   public synchronized boolean isVideoEnabled()
/*  677:     */   {
/*  678: 475 */     return isVideoEnabled(this.nativePtr);
/*  679:     */   }
/*  680:     */   
/*  681:     */   public synchronized boolean isVideoSupported()
/*  682:     */   {
/*  683: 478 */     return isVideoSupported(this.nativePtr);
/*  684:     */   }
/*  685:     */   
/*  686:     */   public synchronized FirewallPolicy getFirewallPolicy()
/*  687:     */   {
/*  688: 481 */     return FirewallPolicy.fromInt(getFirewallPolicy(this.nativePtr));
/*  689:     */   }
/*  690:     */   
/*  691:     */   public synchronized String getStunServer()
/*  692:     */   {
/*  693: 484 */     return getStunServer(this.nativePtr);
/*  694:     */   }
/*  695:     */   
/*  696:     */   public synchronized void setFirewallPolicy(FirewallPolicy pol)
/*  697:     */   {
/*  698: 487 */     setFirewallPolicy(this.nativePtr, pol.value());
/*  699:     */   }
/*  700:     */   
/*  701:     */   public synchronized void setStunServer(String stunServer)
/*  702:     */   {
/*  703: 490 */     setStunServer(this.nativePtr, stunServer);
/*  704:     */   }
/*  705:     */   
/*  706:     */   public synchronized LinphoneCallParams createDefaultCallParameters()
/*  707:     */   {
/*  708: 494 */     return new LinphoneCallParamsImpl(createDefaultCallParams(this.nativePtr));
/*  709:     */   }
/*  710:     */   
/*  711:     */   public synchronized LinphoneCall inviteAddressWithParams(LinphoneAddress to, LinphoneCallParams params)
/*  712:     */     throws LinphoneCoreException
/*  713:     */   {
/*  714: 498 */     long ptrDestination = ((LinphoneAddressImpl)to).nativePtr;
/*  715: 499 */     long ptrParams = ((LinphoneCallParamsImpl)params).nativePtr;
/*  716:     */     
/*  717: 501 */     LinphoneCall call = (LinphoneCall)inviteAddressWithParams(this.nativePtr, ptrDestination, ptrParams);
/*  718: 502 */     if (call != null) {
/*  719: 503 */       return call;
/*  720:     */     }
/*  721: 505 */     throw new LinphoneCoreException("Unable to invite with params " + to.asString());
/*  722:     */   }
/*  723:     */   
/*  724:     */   public synchronized int updateCall(LinphoneCall call, LinphoneCallParams params)
/*  725:     */   {
/*  726: 510 */     long ptrCall = ((LinphoneCallImpl)call).nativePtr;
/*  727: 511 */     long ptrParams = params != null ? ((LinphoneCallParamsImpl)params).nativePtr : 0L;
/*  728:     */     
/*  729: 513 */     return updateCall(this.nativePtr, ptrCall, ptrParams);
/*  730:     */   }
/*  731:     */   
/*  732:     */   public synchronized void setUploadBandwidth(int bw)
/*  733:     */   {
/*  734: 516 */     setUploadBandwidth(this.nativePtr, bw);
/*  735:     */   }
/*  736:     */   
/*  737:     */   public synchronized void setDownloadBandwidth(int bw)
/*  738:     */   {
/*  739: 520 */     setDownloadBandwidth(this.nativePtr, bw);
/*  740:     */   }
/*  741:     */   
/*  742:     */   public synchronized void setPreferredVideoSize(VideoSize vSize)
/*  743:     */   {
/*  744: 524 */     setPreferredVideoSize(this.nativePtr, vSize.width, vSize.height);
/*  745:     */   }
/*  746:     */   
/*  747:     */   public synchronized void setPreferredVideoSizeByName(String name)
/*  748:     */   {
/*  749: 528 */     setPreferredVideoSizeByName(this.nativePtr, name);
/*  750:     */   }
/*  751:     */   
/*  752:     */   public synchronized VideoSize getPreferredVideoSize()
/*  753:     */   {
/*  754: 532 */     int[] nativeSize = getPreferredVideoSize(this.nativePtr);
/*  755:     */     
/*  756: 534 */     VideoSize vSize = new VideoSize();
/*  757: 535 */     vSize.width = nativeSize[0];
/*  758: 536 */     vSize.height = nativeSize[1];
/*  759: 537 */     return vSize;
/*  760:     */   }
/*  761:     */   
/*  762:     */   public synchronized void setRing(String path)
/*  763:     */   {
/*  764: 540 */     setRing(this.nativePtr, path);
/*  765:     */   }
/*  766:     */   
/*  767:     */   public synchronized String getRing()
/*  768:     */   {
/*  769: 543 */     return getRing(this.nativePtr);
/*  770:     */   }
/*  771:     */   
/*  772:     */   public synchronized void setRootCA(String path)
/*  773:     */   {
/*  774: 547 */     setRootCA(this.nativePtr, path);
/*  775:     */   }
/*  776:     */   
/*  777:     */   public synchronized void setRingback(String path)
/*  778:     */   {
/*  779: 551 */     setRingback(this.nativePtr, path);
/*  780:     */   }
/*  781:     */   
/*  782:     */   public synchronized LinphoneProxyConfig[] getProxyConfigList()
/*  783:     */   {
/*  784: 555 */     return getProxyConfigList(this.nativePtr);
/*  785:     */   }
/*  786:     */   
/*  787:     */   public synchronized PayloadType[] getVideoCodecs()
/*  788:     */   {
/*  789: 559 */     long[] typesPtr = listVideoPayloadTypes(this.nativePtr);
/*  790: 560 */     if (typesPtr == null) {
/*  791: 560 */       return null;
/*  792:     */     }
/*  793: 562 */     PayloadType[] codecs = new PayloadType[typesPtr.length];
/*  794: 564 */     for (int i = 0; i < codecs.length; i++) {
/*  795: 565 */       codecs[i] = new PayloadTypeImpl(typesPtr[i]);
/*  796:     */     }
/*  797: 568 */     return codecs;
/*  798:     */   }
/*  799:     */   
/*  800:     */   public synchronized void setVideoCodecs(PayloadType[] codecs)
/*  801:     */   {
/*  802: 571 */     long[] typesPtr = new long[codecs.length];
/*  803: 572 */     for (int i = 0; i < codecs.length; i++) {
/*  804: 573 */       typesPtr[i] = ((PayloadTypeImpl)codecs[i]).nativePtr;
/*  805:     */     }
/*  806: 575 */     setVideoCodecs(this.nativePtr, typesPtr);
/*  807:     */   }
/*  808:     */   
/*  809:     */   public synchronized PayloadType[] getAudioCodecs()
/*  810:     */   {
/*  811: 578 */     long[] typesPtr = listAudioPayloadTypes(this.nativePtr);
/*  812: 579 */     if (typesPtr == null) {
/*  813: 579 */       return null;
/*  814:     */     }
/*  815: 581 */     PayloadType[] codecs = new PayloadType[typesPtr.length];
/*  816: 583 */     for (int i = 0; i < codecs.length; i++) {
/*  817: 584 */       codecs[i] = new PayloadTypeImpl(typesPtr[i]);
/*  818:     */     }
/*  819: 587 */     return codecs;
/*  820:     */   }
/*  821:     */   
/*  822:     */   public synchronized void setAudioCodecs(PayloadType[] codecs)
/*  823:     */   {
/*  824: 590 */     long[] typesPtr = new long[codecs.length];
/*  825: 591 */     for (int i = 0; i < codecs.length; i++) {
/*  826: 592 */       typesPtr[i] = ((PayloadTypeImpl)codecs[i]).nativePtr;
/*  827:     */     }
/*  828: 594 */     setAudioCodecs(this.nativePtr, typesPtr);
/*  829:     */   }
/*  830:     */   
/*  831:     */   public synchronized boolean isNetworkReachable()
/*  832:     */   {
/*  833: 597 */     return isNetworkStateReachable(this.nativePtr);
/*  834:     */   }
/*  835:     */   
/*  836:     */   public synchronized void enableKeepAlive(boolean enable)
/*  837:     */   {
/*  838: 601 */     enableKeepAlive(this.nativePtr, enable);
/*  839:     */   }
/*  840:     */   
/*  841:     */   public synchronized boolean isKeepAliveEnabled()
/*  842:     */   {
/*  843: 605 */     return isKeepAliveEnabled(this.nativePtr);
/*  844:     */   }
/*  845:     */   
/*  846:     */   public synchronized void startEchoCalibration(LinphoneCoreListener listener)
/*  847:     */     throws LinphoneCoreException
/*  848:     */   {
/*  849: 608 */     startEchoCalibration(this.nativePtr, listener);
/*  850:     */   }
/*  851:     */   
/*  852:     */   public synchronized Transports getSignalingTransportPorts()
/*  853:     */   {
/*  854: 612 */     Transports transports = new Transports();
/*  855: 613 */     transports.udp = getSignalingTransportPort(this.nativePtr, 0);
/*  856: 614 */     transports.tcp = getSignalingTransportPort(this.nativePtr, 1);
/*  857: 615 */     transports.tls = getSignalingTransportPort(this.nativePtr, 3);
/*  858:     */     
/*  859:     */ 
/*  860: 618 */     return transports;
/*  861:     */   }
/*  862:     */   
/*  863:     */   public synchronized void setSignalingTransportPorts(Transports transports)
/*  864:     */   {
/*  865: 621 */     setSignalingTransportPorts(this.nativePtr, transports.udp, transports.tcp, transports.tls);
/*  866:     */   }
/*  867:     */   
/*  868:     */   public synchronized void enableIpv6(boolean enable)
/*  869:     */   {
/*  870: 625 */     enableIpv6(this.nativePtr, enable);
/*  871:     */   }
/*  872:     */   
/*  873:     */   public synchronized boolean isIpv6Enabled()
/*  874:     */   {
/*  875: 628 */     return isIpv6Enabled(this.nativePtr);
/*  876:     */   }
/*  877:     */   
/*  878:     */   public synchronized void adjustSoftwareVolume(int i) {}
/*  879:     */   
/*  880:     */   public synchronized boolean pauseCall(LinphoneCall call)
/*  881:     */   {
/*  882: 635 */     return 0 == pauseCall(this.nativePtr, ((LinphoneCallImpl)call).nativePtr);
/*  883:     */   }
/*  884:     */   
/*  885:     */   public synchronized boolean resumeCall(LinphoneCall call)
/*  886:     */   {
/*  887: 638 */     return 0 == resumeCall(this.nativePtr, ((LinphoneCallImpl)call).nativePtr);
/*  888:     */   }
/*  889:     */   
/*  890:     */   public synchronized boolean pauseAllCalls()
/*  891:     */   {
/*  892: 641 */     return 0 == pauseAllCalls(this.nativePtr);
/*  893:     */   }
/*  894:     */   
/*  895:     */   public synchronized void setDownloadPtime(int ptime)
/*  896:     */   {
/*  897: 644 */     setDownloadPtime(this.nativePtr, ptime);
/*  898:     */   }
/*  899:     */   
/*  900:     */   public synchronized void setUploadPtime(int ptime)
/*  901:     */   {
/*  902: 648 */     setUploadPtime(this.nativePtr, ptime);
/*  903:     */   }
/*  904:     */   
/*  905:     */   public synchronized void setZrtpSecretsCache(String file)
/*  906:     */   {
/*  907: 652 */     setZrtpSecretsCache(this.nativePtr, file);
/*  908:     */   }
/*  909:     */   
/*  910:     */   public synchronized void enableEchoLimiter(boolean val)
/*  911:     */   {
/*  912: 655 */     enableEchoLimiter(this.nativePtr, val);
/*  913:     */   }
/*  914:     */   
/*  915:     */   public synchronized void setVideoDevice(int id)
/*  916:     */   {
/*  917: 658 */     Log.i(new Object[] { "Setting camera id :", Integer.valueOf(id) });
/*  918: 659 */     if (setVideoDevice(this.nativePtr, id) != 0) {
/*  919: 660 */       Log.e(new Object[] { "Failed to set video device to id:", Integer.valueOf(id) });
/*  920:     */     }
/*  921:     */   }
/*  922:     */   
/*  923:     */   public synchronized int getVideoDevice()
/*  924:     */   {
/*  925: 664 */     return getVideoDevice(this.nativePtr);
/*  926:     */   }
/*  927:     */   
/*  928:     */   private native void leaveConference(long paramLong);
/*  929:     */   
/*  930:     */   public synchronized void leaveConference()
/*  931:     */   {
/*  932: 670 */     leaveConference(this.nativePtr);
/*  933:     */   }
/*  934:     */   
/*  935:     */   private native boolean enterConference(long paramLong);
/*  936:     */   
/*  937:     */   public synchronized boolean enterConference()
/*  938:     */   {
/*  939: 675 */     return enterConference(this.nativePtr);
/*  940:     */   }
/*  941:     */   
/*  942:     */   private native boolean isInConference(long paramLong);
/*  943:     */   
/*  944:     */   public synchronized boolean isInConference()
/*  945:     */   {
/*  946: 680 */     return isInConference(this.nativePtr);
/*  947:     */   }
/*  948:     */   
/*  949:     */   private native void terminateConference(long paramLong);
/*  950:     */   
/*  951:     */   public synchronized void terminateConference()
/*  952:     */   {
/*  953: 685 */     terminateConference(this.nativePtr);
/*  954:     */   }
/*  955:     */   
/*  956:     */   private native int getConferenceSize(long paramLong);
/*  957:     */   
/*  958:     */   public synchronized int getConferenceSize()
/*  959:     */   {
/*  960: 689 */     return getConferenceSize(this.nativePtr);
/*  961:     */   }
/*  962:     */   
/*  963:     */   private native int getCallsNb(long paramLong);
/*  964:     */   
/*  965:     */   public synchronized int getCallsNb()
/*  966:     */   {
/*  967: 693 */     return getCallsNb(this.nativePtr);
/*  968:     */   }
/*  969:     */   
/*  970:     */   private native void terminateAllCalls(long paramLong);
/*  971:     */   
/*  972:     */   public synchronized void terminateAllCalls()
/*  973:     */   {
/*  974: 697 */     terminateAllCalls(this.nativePtr);
/*  975:     */   }
/*  976:     */   
/*  977:     */   private native Object getCall(long paramLong, int paramInt);
/*  978:     */   
/*  979:     */   public synchronized LinphoneCall[] getCalls()
/*  980:     */   {
/*  981: 701 */     int size = getCallsNb(this.nativePtr);
/*  982: 702 */     LinphoneCall[] calls = new LinphoneCall[size];
/*  983: 703 */     for (int i = 0; i < size; i++) {
/*  984: 704 */       calls[i] = ((LinphoneCall)getCall(this.nativePtr, i));
/*  985:     */     }
/*  986: 706 */     return calls;
/*  987:     */   }
/*  988:     */   
/*  989:     */   private native void addAllToConference(long paramLong);
/*  990:     */   
/*  991:     */   public synchronized void addAllToConference()
/*  992:     */   {
/*  993: 710 */     addAllToConference(this.nativePtr);
/*  994:     */   }
/*  995:     */   
/*  996:     */   private native void addToConference(long paramLong1, long paramLong2);
/*  997:     */   
/*  998:     */   public synchronized void addToConference(LinphoneCall call)
/*  999:     */   {
/* 1000: 715 */     addToConference(this.nativePtr, getCallPtr(call));
/* 1001:     */   }
/* 1002:     */   
/* 1003:     */   private native void removeFromConference(long paramLong1, long paramLong2);
/* 1004:     */   
/* 1005:     */   public synchronized void removeFromConference(LinphoneCall call)
/* 1006:     */   {
/* 1007: 720 */     removeFromConference(this.nativePtr, getCallPtr(call));
/* 1008:     */   }
/* 1009:     */   
/* 1010:     */   private long getCallPtr(LinphoneCall call)
/* 1011:     */   {
/* 1012: 724 */     return ((LinphoneCallImpl)call).nativePtr;
/* 1013:     */   }
/* 1014:     */   
/* 1015:     */   private long getCallParamsPtr(LinphoneCallParams callParams)
/* 1016:     */   {
/* 1017: 728 */     return ((LinphoneCallParamsImpl)callParams).nativePtr;
/* 1018:     */   }
/* 1019:     */   
/* 1020:     */   private native int transferCall(long paramLong1, long paramLong2, String paramString);
/* 1021:     */   
/* 1022:     */   public synchronized void transferCall(LinphoneCall call, String referTo)
/* 1023:     */   {
/* 1024: 733 */     transferCall(this.nativePtr, getCallPtr(call), referTo);
/* 1025:     */   }
/* 1026:     */   
/* 1027:     */   private native int transferCallToAnother(long paramLong1, long paramLong2, long paramLong3);
/* 1028:     */   
/* 1029:     */   public synchronized void transferCallToAnother(LinphoneCall call, LinphoneCall dest)
/* 1030:     */   {
/* 1031: 738 */     transferCallToAnother(this.nativePtr, getCallPtr(call), getCallPtr(dest));
/* 1032:     */   }
/* 1033:     */   
/* 1034:     */   private native Object findCallFromUri(long paramLong, String paramString);
/* 1035:     */   
/* 1036:     */   public synchronized LinphoneCall findCallFromUri(String uri)
/* 1037:     */   {
/* 1038: 744 */     return (LinphoneCall)findCallFromUri(this.nativePtr, uri);
/* 1039:     */   }
/* 1040:     */   
/* 1041:     */   public synchronized MediaEncryption getMediaEncryption()
/* 1042:     */   {
/* 1043: 748 */     return MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
/* 1044:     */   }
/* 1045:     */   
/* 1046:     */   public synchronized boolean isMediaEncryptionMandatory()
/* 1047:     */   {
/* 1048: 751 */     return isMediaEncryptionMandatory(this.nativePtr);
/* 1049:     */   }
/* 1050:     */   
/* 1051:     */   public synchronized void setMediaEncryption(MediaEncryption menc)
/* 1052:     */   {
/* 1053: 754 */     setMediaEncryption(this.nativePtr, menc.mValue);
/* 1054:     */   }
/* 1055:     */   
/* 1056:     */   public synchronized void setMediaEncryptionMandatory(boolean yesno)
/* 1057:     */   {
/* 1058: 757 */     setMediaEncryptionMandatory(this.nativePtr, yesno);
/* 1059:     */   }
/* 1060:     */   
/* 1061:     */   private native int getMaxCalls(long paramLong);
/* 1062:     */   
/* 1063:     */   public synchronized int getMaxCalls()
/* 1064:     */   {
/* 1065: 762 */     return getMaxCalls(this.nativePtr);
/* 1066:     */   }
/* 1067:     */   
/* 1068:     */   public boolean isMyself(String uri)
/* 1069:     */   {
/* 1070: 766 */     LinphoneProxyConfig lpc = getDefaultProxyConfig();
/* 1071: 767 */     if (lpc == null) {
/* 1072: 767 */       return false;
/* 1073:     */     }
/* 1074: 768 */     return uri.equals(lpc.getIdentity());
/* 1075:     */   }
/* 1076:     */   
/* 1077:     */   private native boolean soundResourcesLocked(long paramLong);
/* 1078:     */   
/* 1079:     */   public synchronized boolean soundResourcesLocked()
/* 1080:     */   {
/* 1081: 773 */     return soundResourcesLocked(this.nativePtr);
/* 1082:     */   }
/* 1083:     */   
/* 1084:     */   private native void setMaxCalls(long paramLong, int paramInt);
/* 1085:     */   
/* 1086:     */   public synchronized void setMaxCalls(int max)
/* 1087:     */   {
/* 1088: 779 */     setMaxCalls(this.nativePtr, max);
/* 1089:     */   }
/* 1090:     */   
/* 1091:     */   private native boolean isEchoLimiterEnabled(long paramLong);
/* 1092:     */   
/* 1093:     */   public synchronized boolean isEchoLimiterEnabled()
/* 1094:     */   {
/* 1095: 784 */     return isEchoLimiterEnabled(this.nativePtr);
/* 1096:     */   }
/* 1097:     */   
/* 1098:     */   private native boolean mediaEncryptionSupported(long paramLong, int paramInt);
/* 1099:     */   
/* 1100:     */   public synchronized boolean mediaEncryptionSupported(MediaEncryption menc)
/* 1101:     */   {
/* 1102: 789 */     return mediaEncryptionSupported(this.nativePtr, menc.mValue);
/* 1103:     */   }
/* 1104:     */   
/* 1105:     */   private native void setPlayFile(long paramLong, String paramString);
/* 1106:     */   
/* 1107:     */   public synchronized void setPlayFile(String path)
/* 1108:     */   {
/* 1109: 796 */     setPlayFile(this.nativePtr, path);
/* 1110:     */   }
/* 1111:     */   
/* 1112:     */   private native void tunnelAddServerAndMirror(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3);
/* 1113:     */   
/* 1114:     */   public synchronized void tunnelAddServerAndMirror(String host, int port, int mirror, int ms)
/* 1115:     */   {
/* 1116: 803 */     tunnelAddServerAndMirror(this.nativePtr, host, port, mirror, ms);
/* 1117:     */   }
/* 1118:     */   
/* 1119:     */   private native void tunnelAddServer(long paramLong, TunnelConfig paramTunnelConfig);
/* 1120:     */   
/* 1121:     */   public synchronized void tunnelAddServer(TunnelConfig config)
/* 1122:     */   {
/* 1123: 809 */     tunnelAddServer(this.nativePtr, config);
/* 1124:     */   }
/* 1125:     */   
/* 1126:     */   private final native TunnelConfig[] tunnelGetServers(long paramLong);
/* 1127:     */   
/* 1128:     */   public final synchronized TunnelConfig[] tunnelGetServers()
/* 1129:     */   {
/* 1130: 815 */     return tunnelGetServers(this.nativePtr);
/* 1131:     */   }
/* 1132:     */   
/* 1133:     */   private native void tunnelAutoDetect(long paramLong);
/* 1134:     */   
/* 1135:     */   public synchronized void tunnelAutoDetect()
/* 1136:     */   {
/* 1137: 821 */     tunnelAutoDetect(this.nativePtr);
/* 1138:     */   }
/* 1139:     */   
/* 1140:     */   private native void tunnelCleanServers(long paramLong);
/* 1141:     */   
/* 1142:     */   public synchronized void tunnelCleanServers()
/* 1143:     */   {
/* 1144: 827 */     tunnelCleanServers(this.nativePtr);
/* 1145:     */   }
/* 1146:     */   
/* 1147:     */   private native void tunnelEnable(long paramLong, boolean paramBoolean);
/* 1148:     */   
/* 1149:     */   public synchronized void tunnelEnable(boolean enable)
/* 1150:     */   {
/* 1151: 833 */     tunnelEnable(this.nativePtr, enable);
/* 1152:     */   }
/* 1153:     */   
/* 1154:     */   private native void tunnelSetMode(long paramLong, int paramInt);
/* 1155:     */   
/* 1156:     */   public synchronized void tunnelSetMode(TunnelMode mode)
/* 1157:     */   {
/* 1158: 839 */     tunnelSetMode(this.nativePtr, TunnelMode.enumToInt(mode));
/* 1159:     */   }
/* 1160:     */   
/* 1161:     */   private native int tunnelGetMode(long paramLong);
/* 1162:     */   
/* 1163:     */   public synchronized TunnelMode tunnelGetMode()
/* 1164:     */   {
/* 1165: 845 */     return TunnelMode.intToEnum(tunnelGetMode(this.nativePtr));
/* 1166:     */   }
/* 1167:     */   
/* 1168:     */   private native void tunnelEnableSip(long paramLong, boolean paramBoolean);
/* 1169:     */   
/* 1170:     */   public void tunnelEnableSip(boolean enable)
/* 1171:     */   {
/* 1172: 851 */     tunnelEnableSip(this.nativePtr, enable);
/* 1173:     */   }
/* 1174:     */   
/* 1175:     */   private native boolean tunnelSipEnabled(long paramLong);
/* 1176:     */   
/* 1177:     */   public boolean tunnelSipEnabled()
/* 1178:     */   {
/* 1179: 857 */     return tunnelSipEnabled(this.nativePtr);
/* 1180:     */   }
/* 1181:     */   
/* 1182:     */   public native boolean isTunnelAvailable();
/* 1183:     */   
/* 1184:     */   private native void acceptCallWithParams(long paramLong1, long paramLong2, long paramLong3);
/* 1185:     */   
/* 1186:     */   public synchronized void acceptCallWithParams(LinphoneCall aCall, LinphoneCallParams params)
/* 1187:     */     throws LinphoneCoreException
/* 1188:     */   {
/* 1189: 868 */     acceptCallWithParams(this.nativePtr, getCallPtr(aCall), getCallParamsPtr(params));
/* 1190:     */   }
/* 1191:     */   
/* 1192:     */   private native void acceptCallUpdate(long paramLong1, long paramLong2, long paramLong3);
/* 1193:     */   
/* 1194:     */   public synchronized void acceptCallUpdate(LinphoneCall aCall, LinphoneCallParams params)
/* 1195:     */     throws LinphoneCoreException
/* 1196:     */   {
/* 1197: 875 */     acceptCallUpdate(this.nativePtr, getCallPtr(aCall), getCallParamsPtr(params));
/* 1198:     */   }
/* 1199:     */   
/* 1200:     */   private native void deferCallUpdate(long paramLong1, long paramLong2);
/* 1201:     */   
/* 1202:     */   public synchronized void deferCallUpdate(LinphoneCall aCall)
/* 1203:     */     throws LinphoneCoreException
/* 1204:     */   {
/* 1205: 882 */     deferCallUpdate(this.nativePtr, getCallPtr(aCall));
/* 1206:     */   }
/* 1207:     */   
/* 1208:     */   private native void setVideoPolicy(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
/* 1209:     */   
/* 1210:     */   public synchronized void setVideoPolicy(boolean autoInitiate, boolean autoAccept)
/* 1211:     */   {
/* 1212: 888 */     setVideoPolicy(this.nativePtr, autoInitiate, autoAccept);
/* 1213:     */   }
/* 1214:     */   
/* 1215:     */   private native boolean getVideoAutoInitiatePolicy(long paramLong);
/* 1216:     */   
/* 1217:     */   public synchronized boolean getVideoAutoInitiatePolicy()
/* 1218:     */   {
/* 1219: 892 */     return getVideoAutoInitiatePolicy(this.nativePtr);
/* 1220:     */   }
/* 1221:     */   
/* 1222:     */   private native boolean getVideoAutoAcceptPolicy(long paramLong);
/* 1223:     */   
/* 1224:     */   public synchronized boolean getVideoAutoAcceptPolicy()
/* 1225:     */   {
/* 1226: 896 */     return getVideoAutoAcceptPolicy(this.nativePtr);
/* 1227:     */   }
/* 1228:     */   
/* 1229:     */   private native void setStaticPicture(long paramLong, String paramString);
/* 1230:     */   
/* 1231:     */   public synchronized void setStaticPicture(String path)
/* 1232:     */   {
/* 1233: 901 */     setStaticPicture(this.nativePtr, path);
/* 1234:     */   }
/* 1235:     */   
/* 1236:     */   private native void setUserAgent(long paramLong, String paramString1, String paramString2);
/* 1237:     */   
/* 1238:     */   public synchronized void setUserAgent(String name, String version)
/* 1239:     */   {
/* 1240: 906 */     setUserAgent(this.nativePtr, name, version);
/* 1241:     */   }
/* 1242:     */   
/* 1243:     */   private native void setCpuCountNative(int paramInt);
/* 1244:     */   
/* 1245:     */   public synchronized void setCpuCount(int count)
/* 1246:     */   {
/* 1247: 912 */     setCpuCountNative(count);
/* 1248:     */   }
/* 1249:     */   
/* 1250:     */   public synchronized int getMissedCallsCount()
/* 1251:     */   {
/* 1252: 916 */     return getMissedCallsCount(this.nativePtr);
/* 1253:     */   }
/* 1254:     */   
/* 1255:     */   public synchronized void removeCallLog(LinphoneCallLog log)
/* 1256:     */   {
/* 1257: 920 */     removeCallLog(this.nativePtr, ((LinphoneCallLogImpl)log).getNativePtr());
/* 1258:     */   }
/* 1259:     */   
/* 1260:     */   public synchronized void resetMissedCallsCount()
/* 1261:     */   {
/* 1262: 924 */     resetMissedCallsCount(this.nativePtr);
/* 1263:     */   }
/* 1264:     */   
/* 1265:     */   private native void tunnelSetHttpProxy(long paramLong, String paramString1, int paramInt, String paramString2, String paramString3);
/* 1266:     */   
/* 1267:     */   public synchronized void tunnelSetHttpProxy(String proxy_host, int port, String username, String password)
/* 1268:     */   {
/* 1269: 932 */     tunnelSetHttpProxy(this.nativePtr, proxy_host, port, username, password);
/* 1270:     */   }
/* 1271:     */   
/* 1272:     */   private native void refreshRegisters(long paramLong);
/* 1273:     */   
/* 1274:     */   public synchronized void refreshRegisters()
/* 1275:     */   {
/* 1276: 937 */     refreshRegisters(this.nativePtr);
/* 1277:     */   }
/* 1278:     */   
/* 1279:     */   public String getVersion()
/* 1280:     */   {
/* 1281: 942 */     return getVersion(this.nativePtr);
/* 1282:     */   }
/* 1283:     */   
/* 1284: 947 */   static int FIND_PAYLOAD_IGNORE_RATE = -1;
/* 1285: 951 */   static int FIND_PAYLOAD_IGNORE_CHANNELS = -1;
/* 1286:     */   
/* 1287:     */   public synchronized PayloadType findPayloadType(String mime, int clockRate)
/* 1288:     */   {
/* 1289: 954 */     return findPayloadType(mime, clockRate, FIND_PAYLOAD_IGNORE_CHANNELS);
/* 1290:     */   }
/* 1291:     */   
/* 1292:     */   private native void removeFriend(long paramLong1, long paramLong2);
/* 1293:     */   
/* 1294:     */   public synchronized void removeFriend(LinphoneFriend lf)
/* 1295:     */   {
/* 1296: 960 */     removeFriend(this.nativePtr, lf.getNativePtr());
/* 1297:     */   }
/* 1298:     */   
/* 1299:     */   private native LinphoneFriend getFriendByAddress(long paramLong, String paramString);
/* 1300:     */   
/* 1301:     */   public synchronized LinphoneFriend findFriendByAddress(String sipUri)
/* 1302:     */   {
/* 1303: 966 */     return getFriendByAddress(this.nativePtr, sipUri);
/* 1304:     */   }
/* 1305:     */   
/* 1306:     */   public synchronized void setAudioPort(int port)
/* 1307:     */   {
/* 1308: 970 */     setAudioPort(this.nativePtr, port);
/* 1309:     */   }
/* 1310:     */   
/* 1311:     */   public synchronized void setVideoPort(int port)
/* 1312:     */   {
/* 1313: 974 */     setVideoPort(this.nativePtr, port);
/* 1314:     */   }
/* 1315:     */   
/* 1316:     */   public synchronized void setAudioPortRange(int minPort, int maxPort)
/* 1317:     */   {
/* 1318: 978 */     setAudioPortRange(this.nativePtr, minPort, maxPort);
/* 1319:     */   }
/* 1320:     */   
/* 1321:     */   public synchronized void setVideoPortRange(int minPort, int maxPort)
/* 1322:     */   {
/* 1323: 982 */     setVideoPortRange(this.nativePtr, minPort, maxPort);
/* 1324:     */   }
/* 1325:     */   
/* 1326:     */   public synchronized void setIncomingTimeout(int timeout)
/* 1327:     */   {
/* 1328: 986 */     setIncomingTimeout(this.nativePtr, timeout);
/* 1329:     */   }
/* 1330:     */   
/* 1331:     */   public synchronized void setInCallTimeout(int timeout)
/* 1332:     */   {
/* 1333: 991 */     setInCallTimeout(this.nativePtr, timeout);
/* 1334:     */   }
/* 1335:     */   
/* 1336:     */   private native void setMicrophoneGain(long paramLong, float paramFloat);
/* 1337:     */   
/* 1338:     */   public synchronized void setMicrophoneGain(float gain)
/* 1339:     */   {
/* 1340: 996 */     setMicrophoneGain(this.nativePtr, gain);
/* 1341:     */   }
/* 1342:     */   
/* 1343:     */   public synchronized void setPrimaryContact(String address)
/* 1344:     */   {
/* 1345:1000 */     setPrimaryContact2(this.nativePtr, address);
/* 1346:     */   }
/* 1347:     */   
/* 1348:     */   public synchronized String getPrimaryContact()
/* 1349:     */   {
/* 1350:1004 */     return getPrimaryContact(this.nativePtr);
/* 1351:     */   }
/* 1352:     */   
/* 1353:     */   public synchronized void setPrimaryContact(String displayName, String username)
/* 1354:     */   {
/* 1355:1008 */     setPrimaryContact(this.nativePtr, displayName, username);
/* 1356:     */   }
/* 1357:     */   
/* 1358:     */   public synchronized String getPrimaryContactUsername()
/* 1359:     */   {
/* 1360:1012 */     return getPrimaryContactUsername(this.nativePtr);
/* 1361:     */   }
/* 1362:     */   
/* 1363:     */   public synchronized String getPrimaryContactDisplayName()
/* 1364:     */   {
/* 1365:1016 */     return getPrimaryContactDisplayName(this.nativePtr);
/* 1366:     */   }
/* 1367:     */   
/* 1368:     */   private native void setUseSipInfoForDtmfs(long paramLong, boolean paramBoolean);
/* 1369:     */   
/* 1370:     */   public synchronized void setUseSipInfoForDtmfs(boolean use)
/* 1371:     */   {
/* 1372:1021 */     setUseSipInfoForDtmfs(this.nativePtr, use);
/* 1373:     */   }
/* 1374:     */   
/* 1375:     */   private native boolean getUseSipInfoForDtmfs(long paramLong);
/* 1376:     */   
/* 1377:     */   public synchronized boolean getUseSipInfoForDtmfs()
/* 1378:     */   {
/* 1379:1026 */     return getUseSipInfoForDtmfs(this.nativePtr);
/* 1380:     */   }
/* 1381:     */   
/* 1382:     */   private native void setUseRfc2833ForDtmfs(long paramLong, boolean paramBoolean);
/* 1383:     */   
/* 1384:     */   public synchronized void setUseRfc2833ForDtmfs(boolean use)
/* 1385:     */   {
/* 1386:1031 */     setUseRfc2833ForDtmfs(this.nativePtr, use);
/* 1387:     */   }
/* 1388:     */   
/* 1389:     */   private native boolean getUseRfc2833ForDtmfs(long paramLong);
/* 1390:     */   
/* 1391:     */   public synchronized boolean getUseRfc2833ForDtmfs()
/* 1392:     */   {
/* 1393:1036 */     return getUseRfc2833ForDtmfs(this.nativePtr);
/* 1394:     */   }
/* 1395:     */   
/* 1396:     */   private native long getConfig(long paramLong);
/* 1397:     */   
/* 1398:     */   public synchronized LpConfig getConfig()
/* 1399:     */   {
/* 1400:1041 */     long configPtr = getConfig(this.nativePtr);
/* 1401:1042 */     return new LpConfigImpl(configPtr);
/* 1402:     */   }
/* 1403:     */   
/* 1404:     */   private native boolean needsEchoCalibration(long paramLong);
/* 1405:     */   
/* 1406:     */   public synchronized boolean needsEchoCalibration()
/* 1407:     */   {
/* 1408:1047 */     return needsEchoCalibration(this.nativePtr);
/* 1409:     */   }
/* 1410:     */   
/* 1411:     */   private native boolean needsEchoCanceler(long paramLong);
/* 1412:     */   
/* 1413:     */   public synchronized boolean needsEchoCanceler()
/* 1414:     */   {
/* 1415:1052 */     return needsEchoCanceler(this.nativePtr);
/* 1416:     */   }
/* 1417:     */   
/* 1418:     */   private native void declineCall(long paramLong1, long paramLong2, int paramInt);
/* 1419:     */   
/* 1420:     */   public synchronized void declineCall(LinphoneCall aCall, Reason reason)
/* 1421:     */   {
/* 1422:1057 */     declineCall(this.nativePtr, ((LinphoneCallImpl)aCall).nativePtr, reason.mValue);
/* 1423:     */   }
/* 1424:     */   
/* 1425:     */   private native boolean upnpAvailable(long paramLong);
/* 1426:     */   
/* 1427:     */   public synchronized boolean upnpAvailable()
/* 1428:     */   {
/* 1429:1062 */     return upnpAvailable(this.nativePtr);
/* 1430:     */   }
/* 1431:     */   
/* 1432:     */   private native int getUpnpState(long paramLong);
/* 1433:     */   
/* 1434:     */   public synchronized UpnpState getUpnpState()
/* 1435:     */   {
/* 1436:1067 */     return UpnpState.fromInt(getUpnpState(this.nativePtr));
/* 1437:     */   }
/* 1438:     */   
/* 1439:     */   private native String getUpnpExternalIpaddress(long paramLong);
/* 1440:     */   
/* 1441:     */   public synchronized String getUpnpExternalIpaddress()
/* 1442:     */   {
/* 1443:1072 */     return getUpnpExternalIpaddress(this.nativePtr);
/* 1444:     */   }
/* 1445:     */   
/* 1446:     */   private native int startConferenceRecording(long paramLong, String paramString);
/* 1447:     */   
/* 1448:     */   public synchronized void startConferenceRecording(String path)
/* 1449:     */   {
/* 1450:1077 */     startConferenceRecording(this.nativePtr, path);
/* 1451:     */   }
/* 1452:     */   
/* 1453:     */   private native int stopConferenceRecording(long paramLong);
/* 1454:     */   
/* 1455:     */   public synchronized void stopConferenceRecording()
/* 1456:     */   {
/* 1457:1083 */     stopConferenceRecording(this.nativePtr);
/* 1458:     */   }
/* 1459:     */   
/* 1460:     */   public synchronized PayloadType findPayloadType(String mime)
/* 1461:     */   {
/* 1462:1087 */     return findPayloadType(mime, FIND_PAYLOAD_IGNORE_RATE);
/* 1463:     */   }
/* 1464:     */   
/* 1465:     */   private native void setSipDscp(long paramLong, int paramInt);
/* 1466:     */   
/* 1467:     */   public synchronized void setSipDscp(int dscp)
/* 1468:     */   {
/* 1469:1093 */     setSipDscp(this.nativePtr, dscp);
/* 1470:     */   }
/* 1471:     */   
/* 1472:     */   private native int getSipDscp(long paramLong);
/* 1473:     */   
/* 1474:     */   public synchronized int getSipDscp()
/* 1475:     */   {
/* 1476:1099 */     return getSipDscp(this.nativePtr);
/* 1477:     */   }
/* 1478:     */   
/* 1479:     */   private native void setAudioDscp(long paramLong, int paramInt);
/* 1480:     */   
/* 1481:     */   public synchronized void setAudioDscp(int dscp)
/* 1482:     */   {
/* 1483:1104 */     setAudioDscp(this.nativePtr, dscp);
/* 1484:     */   }
/* 1485:     */   
/* 1486:     */   private native int getAudioDscp(long paramLong);
/* 1487:     */   
/* 1488:     */   public synchronized int getAudioDscp()
/* 1489:     */   {
/* 1490:1110 */     return getAudioDscp(this.nativePtr);
/* 1491:     */   }
/* 1492:     */   
/* 1493:     */   private native void setVideoDscp(long paramLong, int paramInt);
/* 1494:     */   
/* 1495:     */   public synchronized void setVideoDscp(int dscp)
/* 1496:     */   {
/* 1497:1116 */     setVideoDscp(this.nativePtr, dscp);
/* 1498:     */   }
/* 1499:     */   
/* 1500:     */   private native int getVideoDscp(long paramLong);
/* 1501:     */   
/* 1502:     */   public synchronized int getVideoDscp()
/* 1503:     */   {
/* 1504:1122 */     return getVideoDscp(this.nativePtr);
/* 1505:     */   }
/* 1506:     */   
/* 1507:     */   private native long createInfoMessage(long paramLong);
/* 1508:     */   
/* 1509:     */   public synchronized LinphoneInfoMessage createInfoMessage()
/* 1510:     */   {
/* 1511:1128 */     return new LinphoneInfoMessageImpl(createInfoMessage(this.nativePtr));
/* 1512:     */   }
/* 1513:     */   
/* 1514:     */   private native Object subscribe(long paramLong1, long paramLong2, String paramString1, int paramInt, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4);
/* 1515:     */   
/* 1516:     */   public synchronized LinphoneEvent subscribe(LinphoneAddress resource, String eventname, int expires, LinphoneContent content)
/* 1517:     */   {
/* 1518:1135 */     return (LinphoneEvent)subscribe(this.nativePtr, ((LinphoneAddressImpl)resource).nativePtr, eventname, expires, content != null ? content.getType() : null, content != null ? content.getSubtype() : null, content != null ? content.getData() : null, content != null ? content.getEncoding() : null);
/* 1519:     */   }
/* 1520:     */   
/* 1521:     */   private native Object publish(long paramLong1, long paramLong2, String paramString1, int paramInt, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4);
/* 1522:     */   
/* 1523:     */   public synchronized LinphoneEvent publish(LinphoneAddress resource, String eventname, int expires, LinphoneContent content)
/* 1524:     */   {
/* 1525:1143 */     return (LinphoneEvent)publish(this.nativePtr, ((LinphoneAddressImpl)resource).nativePtr, eventname, expires, content != null ? content.getType() : null, content != null ? content.getSubtype() : null, content != null ? content.getData() : null, content != null ? content.getEncoding() : null);
/* 1526:     */   }
/* 1527:     */   
/* 1528:     */   private native Object createSubscribe(long paramLong1, long paramLong2, String paramString, int paramInt);
/* 1529:     */   
/* 1530:     */   public synchronized LinphoneEvent createSubscribe(LinphoneAddress resource, String event, int expires)
/* 1531:     */   {
/* 1532:1152 */     return (LinphoneEvent)createSubscribe(this.nativePtr, ((LinphoneAddressImpl)resource).nativePtr, event, expires);
/* 1533:     */   }
/* 1534:     */   
/* 1535:     */   private native Object createPublish(long paramLong1, long paramLong2, String paramString, int paramInt);
/* 1536:     */   
/* 1537:     */   public synchronized LinphoneEvent createPublish(LinphoneAddress resource, String event, int expires)
/* 1538:     */   {
/* 1539:1158 */     return (LinphoneEvent)createPublish(this.nativePtr, ((LinphoneAddressImpl)resource).nativePtr, event, expires);
/* 1540:     */   }
/* 1541:     */   
/* 1542:     */   public synchronized void setChatDatabasePath(String path)
/* 1543:     */   {
/* 1544:1162 */     setChatDatabasePath(this.nativePtr, path);
/* 1545:     */   }
/* 1546:     */   
/* 1547:     */   public synchronized LinphoneChatRoom[] getChatRooms()
/* 1548:     */   {
/* 1549:1166 */     long[] typesPtr = getChatRooms(this.nativePtr);
/* 1550:1167 */     if (typesPtr == null) {
/* 1551:1167 */       return null;
/* 1552:     */     }
/* 1553:1169 */     LinphoneChatRoom[] proxies = new LinphoneChatRoom[typesPtr.length];
/* 1554:1171 */     for (int i = 0; i < proxies.length; i++) {
/* 1555:1172 */       proxies[i] = new LinphoneChatRoomImpl(typesPtr[i]);
/* 1556:     */     }
/* 1557:1175 */     return proxies;
/* 1558:     */   }
/* 1559:     */   
/* 1560:     */   public synchronized LinphoneAuthInfo[] getAuthInfosList()
/* 1561:     */   {
/* 1562:1178 */     long[] typesPtr = getAuthInfosList(this.nativePtr);
/* 1563:1179 */     if (typesPtr == null) {
/* 1564:1179 */       return null;
/* 1565:     */     }
/* 1566:1181 */     LinphoneAuthInfo[] authInfos = new LinphoneAuthInfo[typesPtr.length];
/* 1567:1183 */     for (int i = 0; i < authInfos.length; i++) {
/* 1568:1184 */       authInfos[i] = new LinphoneAuthInfoImpl(typesPtr[i]);
/* 1569:     */     }
/* 1570:1187 */     return authInfos;
/* 1571:     */   }
/* 1572:     */   
/* 1573:     */   public synchronized LinphoneAuthInfo findAuthInfo(String username, String realm, String domain)
/* 1574:     */   {
/* 1575:1191 */     long ptr = findAuthInfos(this.nativePtr, username, realm, domain);
/* 1576:1192 */     if (ptr == 0L) {
/* 1577:1193 */       return null;
/* 1578:     */     }
/* 1579:1195 */     return new LinphoneAuthInfoImpl(ptr);
/* 1580:     */   }
/* 1581:     */   
/* 1582:     */   private native LinphoneCall startReferedCall(long paramLong1, long paramLong2, long paramLong3);
/* 1583:     */   
/* 1584:     */   public synchronized LinphoneCall startReferedCall(LinphoneCall call, LinphoneCallParams params)
/* 1585:     */   {
/* 1586:1201 */     long ptrParams = ((LinphoneCallParamsImpl)params).nativePtr;
/* 1587:1202 */     return startReferedCall(this.nativePtr, getCallPtr(call), ptrParams);
/* 1588:     */   }
/* 1589:     */   
/* 1590:     */   private native String[] listSupportedVideoResolutions(long paramLong);
/* 1591:     */   
/* 1592:     */   public synchronized String[] getSupportedVideoSizes()
/* 1593:     */   {
/* 1594:1208 */     return listSupportedVideoResolutions(this.nativePtr);
/* 1595:     */   }
/* 1596:     */   
/* 1597:     */   public synchronized int migrateToMultiTransport()
/* 1598:     */   {
/* 1599:1213 */     return migrateToMultiTransport(this.nativePtr);
/* 1600:     */   }
/* 1601:     */   
/* 1602:     */   private native boolean acceptEarlyMedia(long paramLong1, long paramLong2);
/* 1603:     */   
/* 1604:     */   public synchronized boolean acceptEarlyMedia(LinphoneCall call)
/* 1605:     */   {
/* 1606:1219 */     return acceptEarlyMedia(this.nativePtr, getCallPtr(call));
/* 1607:     */   }
/* 1608:     */   
/* 1609:     */   private native boolean acceptEarlyMediaWithParams(long paramLong1, long paramLong2, long paramLong3);
/* 1610:     */   
/* 1611:     */   public synchronized boolean acceptEarlyMediaWithParams(LinphoneCall call, LinphoneCallParams params)
/* 1612:     */   {
/* 1613:1226 */     long ptrParams = params != null ? ((LinphoneCallParamsImpl)params).nativePtr : 0L;
/* 1614:1227 */     return acceptEarlyMediaWithParams(this.nativePtr, getCallPtr(call), ptrParams);
/* 1615:     */   }
/* 1616:     */   
/* 1617:     */   public synchronized LinphoneProxyConfig createProxyConfig()
/* 1618:     */   {
/* 1619:1231 */     return new LinphoneProxyConfigImpl(this);
/* 1620:     */   }
/* 1621:     */   
/* 1622:     */   public synchronized LinphoneProxyConfig createProxyConfig(String identity, String proxy, String route, boolean enableRegister)
/* 1623:     */     throws LinphoneCoreException
/* 1624:     */   {
/* 1625:1235 */     isValid();
/* 1626:     */     try
/* 1627:     */     {
/* 1628:1237 */       return new LinphoneProxyConfigImpl(this, identity, proxy, route, enableRegister);
/* 1629:     */     }
/* 1630:     */     catch (LinphoneCoreException e) {}
/* 1631:1239 */     return null;
/* 1632:     */   }
/* 1633:     */   
/* 1634:     */   public synchronized void setCallErrorTone(Reason reason, String path)
/* 1635:     */   {
/* 1636:1244 */     setCallErrorTone(this.nativePtr, reason.mValue, path);
/* 1637:     */   }
/* 1638:     */   
/* 1639:     */   private native void setMtu(long paramLong, int paramInt);
/* 1640:     */   
/* 1641:     */   public synchronized void setMtu(int mtu)
/* 1642:     */   {
/* 1643:1249 */     setMtu(this.nativePtr, mtu);
/* 1644:     */   }
/* 1645:     */   
/* 1646:     */   private native int getMtu(long paramLong);
/* 1647:     */   
/* 1648:     */   public synchronized int getMtu()
/* 1649:     */   {
/* 1650:1254 */     return getMtu(this.nativePtr);
/* 1651:     */   }
/* 1652:     */   
/* 1653:     */   public synchronized void enableSdp200Ack(boolean enable)
/* 1654:     */   {
/* 1655:1258 */     enableSdp200Ack(this.nativePtr, enable);
/* 1656:     */   }
/* 1657:     */   
/* 1658:     */   public synchronized boolean isSdp200AckEnabled()
/* 1659:     */   {
/* 1660:1262 */     return isSdp200AckEnabled(this.nativePtr);
/* 1661:     */   }
/* 1662:     */   
/* 1663:     */   private native void setTone(long paramLong, int paramInt, String paramString);
/* 1664:     */   
/* 1665:     */   public synchronized void setTone(ToneID id, String wavfile)
/* 1666:     */   {
/* 1667:1267 */     setTone(this.nativePtr, id.mValue, wavfile);
/* 1668:     */   }
/* 1669:     */   
/* 1670:     */   private native void disableChat(long paramLong, int paramInt);
/* 1671:     */   
/* 1672:     */   public synchronized void disableChat(Reason denycode)
/* 1673:     */   {
/* 1674:1272 */     disableChat(this.nativePtr, denycode.mValue);
/* 1675:     */   }
/* 1676:     */   
/* 1677:     */   private native void enableChat(long paramLong);
/* 1678:     */   
/* 1679:     */   public synchronized void enableChat()
/* 1680:     */   {
/* 1681:1277 */     enableChat(this.nativePtr);
/* 1682:     */   }
/* 1683:     */   
/* 1684:     */   private native boolean chatEnabled(long paramLong);
/* 1685:     */   
/* 1686:     */   public synchronized boolean chatEnabled()
/* 1687:     */   {
/* 1688:1282 */     return chatEnabled(this.nativePtr);
/* 1689:     */   }
/* 1690:     */   
/* 1691:     */   public synchronized void stopRinging()
/* 1692:     */   {
/* 1693:1287 */     stopRinging(this.nativePtr);
/* 1694:     */   }
/* 1695:     */   
/* 1696:     */   private native void setPayloadTypeBitrate(long paramLong1, long paramLong2, int paramInt);
/* 1697:     */   
/* 1698:     */   public synchronized void setPayloadTypeBitrate(PayloadType pt, int bitrate)
/* 1699:     */   {
/* 1700:1292 */     setPayloadTypeBitrate(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr, bitrate);
/* 1701:     */   }
/* 1702:     */   
/* 1703:     */   private native int getPayloadTypeBitrate(long paramLong1, long paramLong2);
/* 1704:     */   
/* 1705:     */   public synchronized int getPayloadTypeBitrate(PayloadType pt)
/* 1706:     */   {
/* 1707:1297 */     return getPayloadTypeBitrate(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr);
/* 1708:     */   }
/* 1709:     */   
/* 1710:     */   private native void setPayloadTypeNumber(long paramLong1, long paramLong2, int paramInt);
/* 1711:     */   
/* 1712:     */   public synchronized void setPayloadTypeNumber(PayloadType pt, int number)
/* 1713:     */   {
/* 1714:1303 */     setPayloadTypeNumber(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr, number);
/* 1715:     */   }
/* 1716:     */   
/* 1717:     */   private native int getPayloadTypeNumber(long paramLong1, long paramLong2);
/* 1718:     */   
/* 1719:     */   public synchronized int getPayloadTypeNumber(PayloadType pt)
/* 1720:     */   {
/* 1721:1308 */     return getPayloadTypeNumber(this.nativePtr, ((PayloadTypeImpl)pt).nativePtr);
/* 1722:     */   }
/* 1723:     */   
/* 1724:     */   public synchronized void enableAdaptiveRateControl(boolean enable)
/* 1725:     */   {
/* 1726:1313 */     enableAdaptiveRateControl(this.nativePtr, enable);
/* 1727:     */   }
/* 1728:     */   
/* 1729:     */   public synchronized boolean isAdaptiveRateControlEnabled()
/* 1730:     */   {
/* 1731:1318 */     return isAdaptiveRateControlEnabled(this.nativePtr);
/* 1732:     */   }
/* 1733:     */   
/* 1734:     */   public synchronized AdaptiveRateAlgorithm getAdaptiveRateAlgorithm()
/* 1735:     */   {
/* 1736:1321 */     return AdaptiveRateAlgorithm.fromString(getAdaptiveRateAlgorithm(this.nativePtr));
/* 1737:     */   }
/* 1738:     */   
/* 1739:     */   public synchronized void setAdaptiveRateAlgorithm(AdaptiveRateAlgorithm alg)
/* 1740:     */   {
/* 1741:1324 */     setAdaptiveRateAlgorithm(this.nativePtr, alg.toString());
/* 1742:     */   }
/* 1743:     */   
/* 1744:     */   private native void setAudioJittcomp(long paramLong, int paramInt);
/* 1745:     */   
/* 1746:     */   public synchronized void setAudioJittcomp(int value)
/* 1747:     */   {
/* 1748:1331 */     setAudioJittcomp(this.nativePtr, value);
/* 1749:     */   }
/* 1750:     */   
/* 1751:     */   private native void setVideoJittcomp(long paramLong, int paramInt);
/* 1752:     */   
/* 1753:     */   public synchronized void setVideoJittcomp(int value)
/* 1754:     */   {
/* 1755:1336 */     setVideoJittcomp(this.nativePtr, value);
/* 1756:     */   }
/* 1757:     */   
/* 1758:     */   private native void setFileTransferServer(long paramLong, String paramString);
/* 1759:     */   
/* 1760:     */   public synchronized void setFileTransferServer(String serverUrl)
/* 1761:     */   {
/* 1762:1342 */     setFileTransferServer(this.nativePtr, serverUrl);
/* 1763:     */   }
/* 1764:     */   
/* 1765:     */   private native String getFileTransferServer(long paramLong);
/* 1766:     */   
/* 1767:     */   public synchronized String getFileTransferServer()
/* 1768:     */   {
/* 1769:1348 */     return getFileTransferServer(this.nativePtr);
/* 1770:     */   }
/* 1771:     */   
/* 1772:     */   private native long createLocalPlayer(long paramLong, AndroidVideoWindowImpl paramAndroidVideoWindowImpl);
/* 1773:     */   
/* 1774:     */   public synchronized LinphonePlayer createLocalPlayer(AndroidVideoWindowImpl window)
/* 1775:     */   {
/* 1776:1354 */     long playerPtr = createLocalPlayer(this.nativePtr, window);
/* 1777:1355 */     if (playerPtr != 0L) {
/* 1778:1356 */       return new LinphonePlayerImpl(playerPtr);
/* 1779:     */     }
/* 1780:1358 */     return null;
/* 1781:     */   }
/* 1782:     */   
/* 1783:     */   private native void addListener(long paramLong, LinphoneCoreListener paramLinphoneCoreListener);
/* 1784:     */   
/* 1785:     */   public void addListener(LinphoneCoreListener listener)
/* 1786:     */   {
/* 1787:1365 */     addListener(this.nativePtr, listener);
/* 1788:     */   }
/* 1789:     */   
/* 1790:     */   private native void removeListener(long paramLong, LinphoneCoreListener paramLinphoneCoreListener);
/* 1791:     */   
/* 1792:     */   public void removeListener(LinphoneCoreListener listener)
/* 1793:     */   {
/* 1794:1371 */     removeListener(this.nativePtr, listener);
/* 1795:     */   }
/* 1796:     */   
/* 1797:     */   private native void setRemoteRingbackTone(long paramLong, String paramString);
/* 1798:     */   
/* 1799:     */   public void setRemoteRingbackTone(String file)
/* 1800:     */   {
/* 1801:1376 */     setRemoteRingbackTone(this.nativePtr, file);
/* 1802:     */   }
/* 1803:     */   
/* 1804:     */   private native String getRemoteRingbackTone(long paramLong);
/* 1805:     */   
/* 1806:     */   public String getRemoteRingbackTone()
/* 1807:     */   {
/* 1808:1381 */     return getRemoteRingbackTone(this.nativePtr);
/* 1809:     */   }
/* 1810:     */   
/* 1811:     */   private native void uploadLogCollection(long paramLong);
/* 1812:     */   
/* 1813:     */   public void uploadLogCollection()
/* 1814:     */   {
/* 1815:1387 */     uploadLogCollection(this.nativePtr);
/* 1816:     */   }
/* 1817:     */   
/* 1818:     */   public native void resetLogCollection();
/* 1819:     */   
/* 1820:     */   private native void setPreferredFramerate(long paramLong, float paramFloat);
/* 1821:     */   
/* 1822:     */   public void setPreferredFramerate(float fps)
/* 1823:     */   {
/* 1824:1396 */     setPreferredFramerate(this.nativePtr, fps);
/* 1825:     */   }
/* 1826:     */   
/* 1827:     */   private native float getPreferredFramerate(long paramLong);
/* 1828:     */   
/* 1829:     */   public float getPreferredFramerate()
/* 1830:     */   {
/* 1831:1401 */     return getPreferredFramerate(this.nativePtr);
/* 1832:     */   }
/* 1833:     */   
/* 1834:     */   private native int setAudioMulticastAddr(long paramLong, String paramString);
/* 1835:     */   
/* 1836:     */   public void setAudioMulticastAddr(String ip)
/* 1837:     */     throws LinphoneCoreException
/* 1838:     */   {
/* 1839:1408 */     if (setAudioMulticastAddr(this.nativePtr, ip) != 0) {
/* 1840:1409 */       throw new LinphoneCoreException("bad ip address [" + ip + "]");
/* 1841:     */     }
/* 1842:     */   }
/* 1843:     */   
/* 1844:     */   private native int setVideoMulticastAddr(long paramLong, String paramString);
/* 1845:     */   
/* 1846:     */   public void setVideoMulticastAddr(String ip)
/* 1847:     */     throws LinphoneCoreException
/* 1848:     */   {
/* 1849:1414 */     if (setVideoMulticastAddr(this.nativePtr, ip) != 0) {
/* 1850:1415 */       throw new LinphoneCoreException("bad ip address [" + ip + "]");
/* 1851:     */     }
/* 1852:     */   }
/* 1853:     */   
/* 1854:     */   private native String getAudioMulticastAddr(long paramLong);
/* 1855:     */   
/* 1856:     */   public String getAudioMulticastAddr()
/* 1857:     */   {
/* 1858:1420 */     return getAudioMulticastAddr(this.nativePtr);
/* 1859:     */   }
/* 1860:     */   
/* 1861:     */   private native String getVideoMulticastAddr(long paramLong);
/* 1862:     */   
/* 1863:     */   public String getVideoMulticastAddr()
/* 1864:     */   {
/* 1865:1425 */     return getVideoMulticastAddr(this.nativePtr);
/* 1866:     */   }
/* 1867:     */   
/* 1868:     */   private native int setAudioMulticastTtl(long paramLong, int paramInt);
/* 1869:     */   
/* 1870:     */   public void setAudioMulticastTtl(int ttl)
/* 1871:     */     throws LinphoneCoreException
/* 1872:     */   {
/* 1873:1430 */     if (setAudioMulticastTtl(this.nativePtr, ttl) != 0) {
/* 1874:1431 */       throw new LinphoneCoreException("bad ttl value [" + ttl + "]");
/* 1875:     */     }
/* 1876:     */   }
/* 1877:     */   
/* 1878:     */   private native int setVideoMulticastTtl(long paramLong, int paramInt);
/* 1879:     */   
/* 1880:     */   public void setVideoMulticastTtl(int ttl)
/* 1881:     */     throws LinphoneCoreException
/* 1882:     */   {
/* 1883:1437 */     if (setVideoMulticastTtl(this.nativePtr, ttl) != 0) {
/* 1884:1438 */       throw new LinphoneCoreException("bad ttl value [" + ttl + "]");
/* 1885:     */     }
/* 1886:     */   }
/* 1887:     */   
/* 1888:     */   private native int getAudioMulticastTtl(long paramLong);
/* 1889:     */   
/* 1890:     */   public int getAudioMulticastTtl()
/* 1891:     */   {
/* 1892:1443 */     return getAudioMulticastTtl(this.nativePtr);
/* 1893:     */   }
/* 1894:     */   
/* 1895:     */   private native int getVideoMulticastTtl(long paramLong);
/* 1896:     */   
/* 1897:     */   public int getVideoMulticastTtl()
/* 1898:     */   {
/* 1899:1448 */     return getVideoMulticastTtl(this.nativePtr);
/* 1900:     */   }
/* 1901:     */   
/* 1902:     */   private native void enableAudioMulticast(long paramLong, boolean paramBoolean);
/* 1903:     */   
/* 1904:     */   public void enableAudioMulticast(boolean yesno)
/* 1905:     */   {
/* 1906:1453 */     enableAudioMulticast(this.nativePtr, yesno);
/* 1907:     */   }
/* 1908:     */   
/* 1909:     */   private native boolean audioMulticastEnabled(long paramLong);
/* 1910:     */   
/* 1911:     */   public boolean audioMulticastEnabled()
/* 1912:     */   {
/* 1913:1458 */     return audioMulticastEnabled(this.nativePtr);
/* 1914:     */   }
/* 1915:     */   
/* 1916:     */   private native void enableVideoMulticast(long paramLong, boolean paramBoolean);
/* 1917:     */   
/* 1918:     */   public void enableVideoMulticast(boolean yesno)
/* 1919:     */   {
/* 1920:1464 */     enableVideoMulticast(this.nativePtr, yesno);
/* 1921:     */   }
/* 1922:     */   
/* 1923:     */   private native boolean videoMulticastEnabled(long paramLong);
/* 1924:     */   
/* 1925:     */   public boolean videoMulticastEnabled()
/* 1926:     */   {
/* 1927:1469 */     return videoMulticastEnabled(this.nativePtr);
/* 1928:     */   }
/* 1929:     */   
/* 1930:     */   private native void enableDnsSrv(long paramLong, boolean paramBoolean);
/* 1931:     */   
/* 1932:     */   public void enableDnsSrv(boolean yesno)
/* 1933:     */   {
/* 1934:1475 */     enableDnsSrv(this.nativePtr, yesno);
/* 1935:     */   }
/* 1936:     */   
/* 1937:     */   private native boolean dnsSrvEnabled(long paramLong);
/* 1938:     */   
/* 1939:     */   public boolean dnsSrvEnabled()
/* 1940:     */   {
/* 1941:1480 */     return dnsSrvEnabled(this.nativePtr);
/* 1942:     */   }
/* 1943:     */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneCoreImpl

 * JD-Core Version:    0.7.0.1

 */