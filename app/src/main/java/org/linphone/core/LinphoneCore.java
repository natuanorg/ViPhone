/*    1:     */ package org.linphone.core;
/*    2:     */ 
/*    3:     */ import org.linphone.mediastream.video.AndroidVideoWindowImpl;

import java.util.Vector;

/*    4:     */
/*    5:     */ 
/*    6:     */ public abstract interface LinphoneCore
/*    7:     */ {
/*    8:     */   public abstract void setContext(Object paramObject);
/*    9:     */   
/*   10:     */   public abstract void clearProxyConfigs();
/*   11:     */   
/*   12:     */   public abstract void addProxyConfig(LinphoneProxyConfig paramLinphoneProxyConfig)
/*   13:     */     throws LinphoneCoreException;
/*   14:     */   
/*   15:     */   public abstract void removeProxyConfig(LinphoneProxyConfig paramLinphoneProxyConfig);
/*   16:     */   
/*   17:     */   public abstract void setDefaultProxyConfig(LinphoneProxyConfig paramLinphoneProxyConfig);
/*   18:     */   
/*   19:     */   public abstract LinphoneProxyConfig getDefaultProxyConfig();
/*   20:     */   
/*   21:     */   public abstract LinphoneAuthInfo[] getAuthInfosList();
/*   22:     */   
/*   23:     */   public abstract LinphoneAuthInfo findAuthInfo(String paramString1, String paramString2, String paramString3);
/*   24:     */   
/*   25:     */   public abstract void removeAuthInfo(LinphoneAuthInfo paramLinphoneAuthInfo);
/*   26:     */   
/*   27:     */   public abstract void clearAuthInfos();
/*   28:     */   
/*   29:     */   public abstract void addAuthInfo(LinphoneAuthInfo paramLinphoneAuthInfo);
/*   30:     */   
/*   31:     */   public abstract LinphoneAddress interpretUrl(String paramString)
/*   32:     */     throws LinphoneCoreException;
/*   33:     */   
/*   34:     */   public abstract LinphoneCall invite(String paramString)
/*   35:     */     throws LinphoneCoreException;
/*   36:     */   
/*   37:     */   public abstract LinphoneCall invite(LinphoneAddress paramLinphoneAddress)
/*   38:     */     throws LinphoneCoreException;
/*   39:     */   
/*   40:     */   public abstract void terminateCall(LinphoneCall paramLinphoneCall);
/*   41:     */   
/*   42:     */   public abstract void declineCall(LinphoneCall paramLinphoneCall, Reason paramReason);
/*   43:     */   
/*   44:     */   public abstract LinphoneCall getCurrentCall();
/*   45:     */   
/*   46:     */   public abstract LinphoneAddress getRemoteAddress();
/*   47:     */   
/*   48:     */   public abstract boolean isIncall();
/*   49:     */   
/*   50:     */   public abstract boolean isInComingInvitePending();
/*   51:     */   
/*   52:     */   public abstract void iterate();
/*   53:     */   
/*   54:     */   public abstract void acceptCall(LinphoneCall paramLinphoneCall)
/*   55:     */     throws LinphoneCoreException;
/*   56:     */   
/*   57:     */   public abstract void acceptCallWithParams(LinphoneCall paramLinphoneCall, LinphoneCallParams paramLinphoneCallParams)
/*   58:     */     throws LinphoneCoreException;
/*   59:     */   
/*   60:     */   public abstract void acceptCallUpdate(LinphoneCall paramLinphoneCall, LinphoneCallParams paramLinphoneCallParams)
/*   61:     */     throws LinphoneCoreException;
/*   62:     */   
/*   63:     */   public abstract void deferCallUpdate(LinphoneCall paramLinphoneCall)
/*   64:     */     throws LinphoneCoreException;
/*   65:     */   
/*   66:     */   public abstract LinphoneCallLog[] getCallLogs();
/*   67:     */   
/*   68:     */   public abstract void setNetworkReachable(boolean paramBoolean);
/*   69:     */   
/*   70:     */   public abstract boolean isNetworkReachable();
/*   71:     */   
/*   72:     */   public abstract void destroy();
/*   73:     */   
/*   74:     */   public abstract void setPlaybackGain(float paramFloat);
/*   75:     */   
/*   76:     */   public abstract float getPlaybackGain();
/*   77:     */   
/*   78:     */   public abstract void setPlayLevel(int paramInt);
/*   79:     */   
/*   80:     */   public abstract int getPlayLevel();
/*   81:     */   
/*   82:     */   public abstract void muteMic(boolean paramBoolean);
/*   83:     */   
/*   84:     */   public abstract boolean isMicMuted();
/*   85:     */   
/*   86:     */   public abstract void sendDtmf(char paramChar);
/*   87:     */   
/*   88:     */   public abstract void playDtmf(char paramChar, int paramInt);
/*   89:     */   
/*   90:     */   public abstract void stopDtmf();
/*   91:     */   
/*   92:     */   public abstract void clearCallLogs();
/*   93:     */   
/*   94:     */   public abstract PayloadType findPayloadType(String paramString, int paramInt1, int paramInt2);
/*   95:     */   
/*   96:     */   public abstract PayloadType findPayloadType(String paramString, int paramInt);
/*   97:     */   
/*   98:     */   public abstract PayloadType findPayloadType(String paramString);
/*   99:     */   
/*  100:     */   public abstract void enablePayloadType(PayloadType paramPayloadType, boolean paramBoolean)
/*  101:     */     throws LinphoneCoreException;
/*  102:     */   
/*  103:     */   public abstract boolean isPayloadTypeEnabled(PayloadType paramPayloadType);
/*  104:     */   
/*  105:     */   public abstract boolean payloadTypeIsVbr(PayloadType paramPayloadType);
/*  106:     */   
/*  107:     */   public abstract void setPayloadTypeBitrate(PayloadType paramPayloadType, int paramInt);
/*  108:     */   
/*  109:     */   public abstract int getPayloadTypeBitrate(PayloadType paramPayloadType);
/*  110:     */   
/*  111:     */   public abstract void setPayloadTypeNumber(PayloadType paramPayloadType, int paramInt);
/*  112:     */   
/*  113:     */   public abstract int getPayloadTypeNumber(PayloadType paramPayloadType);
/*  114:     */   
/*  115:     */   public abstract void enableAdaptiveRateControl(boolean paramBoolean);
/*  116:     */   
/*  117:     */   public abstract boolean isAdaptiveRateControlEnabled();
/*  118:     */   
/*  119:     */   public abstract void setAdaptiveRateAlgorithm(AdaptiveRateAlgorithm paramAdaptiveRateAlgorithm);
/*  120:     */   
/*  121:     */   public abstract AdaptiveRateAlgorithm getAdaptiveRateAlgorithm();
/*  122:     */   
/*  123:     */   public abstract void enableEchoCancellation(boolean paramBoolean);
/*  124:     */   
/*  125:     */   public abstract boolean isEchoCancellationEnabled();
/*  126:     */   
/*  127:     */   public abstract boolean isEchoLimiterEnabled();
/*  128:     */   
/*  129:     */   public abstract void setSignalingTransportPorts(Transports paramTransports);
/*  130:     */   
/*  131:     */   public abstract Transports getSignalingTransportPorts();
/*  132:     */   
/*  133:     */   public abstract void setSipDscp(int paramInt);
/*  134:     */   
/*  135:     */   public abstract int getSipDscp();
/*  136:     */   
/*  137:     */   public abstract void enableSpeaker(boolean paramBoolean);
/*  138:     */   
/*  139:     */   public abstract boolean isSpeakerEnabled();
/*  140:     */   
/*  141:     */   public abstract void addFriend(LinphoneFriend paramLinphoneFriend)
/*  142:     */     throws LinphoneCoreException;
/*  143:     */   
/*  144:     */   public abstract LinphoneFriend[] getFriendList();
/*  145:     */   
/*  146:     */
/*  149:     */   public abstract void setPresenceInfo(int paramInt, String paramString, OnlineStatus paramOnlineStatus);
/*  150:     */
/*  154:     */   public abstract OnlineStatus getPresenceInfo();
/*  155:     */   
/*  156:     */   public abstract void setPresenceModel(PresenceModel paramPresenceModel);
/*  157:     */   
/*  158:     */   public abstract PresenceModel getPresenceModel();
/*  159:     */   
/*  160:     */   public abstract LinphoneChatRoom getOrCreateChatRoom(String paramString);
/*  161:     */   
/*  162:     */   public abstract void setVideoWindow(Object paramObject);
/*  163:     */   
/*  164:     */   public abstract void setPreviewWindow(Object paramObject);
/*  165:     */   
/*  166:     */   public abstract void setDeviceRotation(int paramInt);
/*  167:     */   
/*  168:     */   public abstract void setVideoDevice(int paramInt);
/*  169:     */   
/*  170:     */   public abstract int getVideoDevice();
/*  171:     */   
/*  172:     */   public abstract boolean isVideoSupported();
/*  173:     */   
/*  174:     */   public abstract void enableVideo(boolean paramBoolean1, boolean paramBoolean2);
/*  175:     */   
/*  176:     */   public abstract boolean isVideoEnabled();
/*  177:     */   
/*  178:     */   public abstract void setStunServer(String paramString);
/*  179:     */   
/*  180:     */   public abstract String getStunServer();
/*  181:     */   
/*  182:     */   public abstract void setFirewallPolicy(FirewallPolicy paramFirewallPolicy);
/*  183:     */   
/*  184:     */   public abstract FirewallPolicy getFirewallPolicy();
/*  185:     */   
/*  186:     */   public abstract LinphoneCall inviteAddressWithParams(LinphoneAddress paramLinphoneAddress, LinphoneCallParams paramLinphoneCallParams)
/*  187:     */     throws LinphoneCoreException;
/*  188:     */   
/*  189:     */   public abstract int updateCall(LinphoneCall paramLinphoneCall, LinphoneCallParams paramLinphoneCallParams);
/*  190:     */   
/*  191:     */   public abstract LinphoneCallParams createDefaultCallParameters();
/*  192:     */   
/*  193:     */   public abstract void setRing(String paramString);
/*  194:     */   
/*  195:     */   public abstract String getRing();
/*  196:     */   
/*  197:     */   public abstract void setRootCA(String paramString);
/*  198:     */   
/*  199:     */   public abstract void setRingback(String paramString);
/*  200:     */   
/*  201:     */   public abstract void setUploadBandwidth(int paramInt);
/*  202:     */   
/*  203:     */   public abstract void setDownloadBandwidth(int paramInt);
/*  204:     */   
/*  205:     */   public abstract void setDownloadPtime(int paramInt);
/*  206:     */   
/*  207:     */   public abstract void setUploadPtime(int paramInt);
/*  208:     */   
/*  209:     */   public abstract void setPreferredVideoSize(VideoSize paramVideoSize);
/*  210:     */   
/*  211:     */   public abstract void setPreferredVideoSizeByName(String paramString);
/*  212:     */   
/*  213:     */   public abstract VideoSize getPreferredVideoSize();
/*  214:     */   
/*  215:     */   public abstract void setPreferredFramerate(float paramFloat);
/*  216:     */   
/*  217:     */   public abstract float getPreferredFramerate();
/*  218:     */   
/*  219:     */   public abstract PayloadType[] getAudioCodecs();
/*  220:     */   
/*  221:     */   public abstract void setAudioCodecs(PayloadType[] paramArrayOfPayloadType);
/*  222:     */   
/*  223:     */   public abstract PayloadType[] getVideoCodecs();
/*  224:     */   
/*  225:     */   public abstract void setVideoCodecs(PayloadType[] paramArrayOfPayloadType);
/*  226:     */   
/*  227:     */   public abstract void enableKeepAlive(boolean paramBoolean);
/*  228:     */   
/*  229:     */   public abstract boolean isKeepAliveEnabled();
/*  230:     */   
/*  231:     */   public abstract void startEchoCalibration(LinphoneCoreListener paramLinphoneCoreListener)
/*  232:     */     throws LinphoneCoreException;
/*  233:     */   
/*  234:     */   public abstract boolean needsEchoCalibration();
/*  235:     */   
/*  236:     */   public abstract boolean needsEchoCanceler();
/*  237:     */   
/*  238:     */   public abstract void enableIpv6(boolean paramBoolean);
/*  239:     */   
/*  240:     */   public abstract boolean isIpv6Enabled();
/*  241:     */   
/*  242:     */
/*  245:     */   public abstract void adjustSoftwareVolume(int paramInt);
/*  246:     */   
/*  247:     */   public abstract boolean pauseCall(LinphoneCall paramLinphoneCall);
/*  248:     */   
/*  249:     */   public abstract boolean resumeCall(LinphoneCall paramLinphoneCall);
/*  250:     */   
/*  251:     */   public abstract boolean pauseAllCalls();
/*  252:     */   
/*  253:     */   public abstract void setZrtpSecretsCache(String paramString);
/*  254:     */   
/*  255:     */   public abstract void enableEchoLimiter(boolean paramBoolean);
/*  256:     */   
/*  257:     */   public abstract boolean isInConference();
/*  258:     */   
/*  259:     */   public abstract boolean enterConference();
/*  260:     */   
/*  261:     */   public abstract void leaveConference();
/*  262:     */   
/*  263:     */   public abstract void addToConference(LinphoneCall paramLinphoneCall);
/*  264:     */   
/*  265:     */   public abstract void removeFromConference(LinphoneCall paramLinphoneCall);
/*  266:     */   
/*  267:     */   public abstract void addAllToConference();
/*  268:     */   
/*  269:     */   public abstract void terminateConference();
/*  270:     */   
/*  271:     */   public abstract int getConferenceSize();
/*  272:     */   
/*  273:     */   public abstract void startConferenceRecording(String paramString);
/*  274:     */   
/*  275:     */   public abstract void stopConferenceRecording();
/*  276:     */   
/*  277:     */   public abstract void terminateAllCalls();
/*  278:     */   
/*  279:     */   public abstract LinphoneCall[] getCalls();
/*  280:     */   
/*  281:     */   public abstract int getCallsNb();
/*  282:     */   
/*  283:     */   public abstract void transferCall(LinphoneCall paramLinphoneCall, String paramString);
/*  284:     */   
/*  285:     */   public abstract void transferCallToAnother(LinphoneCall paramLinphoneCall1, LinphoneCall paramLinphoneCall2);
/*  286:     */   
/*  287:     */   public abstract LinphoneCall startReferedCall(LinphoneCall paramLinphoneCall, LinphoneCallParams paramLinphoneCallParams);
/*  288:     */   
/*  289:     */   public abstract LinphoneCall findCallFromUri(String paramString);
/*  290:     */   
/*  291:     */   public abstract int getMaxCalls();
/*  292:     */   
/*  293:     */   public abstract void setMaxCalls(int paramInt);
/*  294:     */   
/*  295:     */
/*  298:     */   public abstract boolean isMyself(String paramString);
/*  299:     */   
/*  300:     */   public abstract boolean soundResourcesLocked();
/*  301:     */   
/*  302:     */   public abstract boolean mediaEncryptionSupported(MediaEncryption paramMediaEncryption);
/*  303:     */   
/*  304:     */   public abstract void setMediaEncryption(MediaEncryption paramMediaEncryption);
/*  305:     */   
/*  306:     */   public abstract MediaEncryption getMediaEncryption();
/*  307:     */   
/*  308:     */   public abstract void setMediaEncryptionMandatory(boolean paramBoolean);
/*  309:     */   
/*  310:     */   public abstract boolean isMediaEncryptionMandatory();
/*  311:     */   
/*  312:     */   public abstract void setPlayFile(String paramString);
/*  313:     */   
/*  314:     */
/*  317:     */   public abstract void tunnelEnable(boolean paramBoolean);
/*  318:     */   
/*  319:     */   public abstract void tunnelSetMode(TunnelMode paramTunnelMode);
/*  320:     */   
/*  321:     */   public abstract TunnelMode tunnelGetMode();
/*  322:     */   
/*  323:     */   public abstract void tunnelEnableSip(boolean paramBoolean);
/*  324:     */   
/*  325:     */   public abstract boolean tunnelSipEnabled();
/*  326:     */   
/*  327:     */
/*  330:     */   public abstract void tunnelAutoDetect();
/*  331:     */   
/*  332:     */   public abstract void tunnelCleanServers();
/*  333:     */   
/*  334:     */   public abstract void tunnelSetHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3);
/*  335:     */   
/*  336:     */   public abstract void tunnelAddServerAndMirror(String paramString, int paramInt1, int paramInt2, int paramInt3);
/*  337:     */   
/*  338:     */   public abstract void tunnelAddServer(TunnelConfig paramTunnelConfig);
/*  339:     */   
/*  340:     */   public abstract TunnelConfig[] tunnelGetServers();
/*  341:     */   
/*  342:     */   public abstract boolean isTunnelAvailable();
/*  343:     */   
/*  344:     */   public abstract LinphoneProxyConfig[] getProxyConfigList();
/*  345:     */   
/*  346:     */   public abstract void setVideoPolicy(boolean paramBoolean1, boolean paramBoolean2);
/*  347:     */   
/*  348:     */   public abstract boolean getVideoAutoInitiatePolicy();
/*  349:     */   
/*  350:     */   public abstract boolean getVideoAutoAcceptPolicy();
/*  351:     */   
/*  352:     */   public abstract void setStaticPicture(String paramString);
/*  353:     */   
/*  354:     */   public abstract void setUserAgent(String paramString1, String paramString2);
/*  355:     */   
/*  356:     */   public abstract void setCpuCount(int paramInt);
/*  357:     */   
/*  358:     */   public abstract void removeCallLog(LinphoneCallLog paramLinphoneCallLog);
/*  359:     */   
/*  360:     */   public abstract int getMissedCallsCount();
/*  361:     */   
/*  362:     */   public abstract void resetMissedCallsCount();
/*  363:     */   
/*  364:     */   public abstract void refreshRegisters();
/*  365:     */   
/*  366:     */   public abstract String getVersion();
/*  367:     */   
/*  368:     */   public abstract void removeFriend(LinphoneFriend paramLinphoneFriend);
/*  369:     */   
/*  370:     */   public abstract LinphoneFriend findFriendByAddress(String paramString);
/*  371:     */   
/*  372:     */   public abstract void setAudioPort(int paramInt);
/*  373:     */   
/*  374:     */   public abstract void setAudioPortRange(int paramInt1, int paramInt2);
/*  375:     */   
/*  376:     */   public abstract void setAudioDscp(int paramInt);
/*  377:     */   
/*  378:     */   public abstract int getAudioDscp();
/*  379:     */   
/*  380:     */   public abstract void setVideoPort(int paramInt);
/*  381:     */   
/*  382:     */   public abstract void setVideoPortRange(int paramInt1, int paramInt2);
/*  383:     */   
/*  384:     */   public abstract void setVideoDscp(int paramInt);
/*  385:     */   
/*  386:     */   public abstract int getVideoDscp();
/*  387:     */   
/*  388:     */   public abstract void setIncomingTimeout(int paramInt);
/*  389:     */   
/*  390:     */   public abstract void setInCallTimeout(int paramInt);
/*  391:     */   
/*  392:     */   public abstract void setMicrophoneGain(float paramFloat);
/*  393:     */   
/*  394:     */   public abstract void setPrimaryContact(String paramString);
/*  395:     */   
/*  396:     */   public abstract String getPrimaryContact();
/*  397:     */   
/*  398:     */   public abstract void setPrimaryContact(String paramString1, String paramString2);
/*  399:     */   
/*  400:     */   public abstract String getPrimaryContactUsername();
/*  401:     */   
/*  402:     */   public abstract String getPrimaryContactDisplayName();
/*  403:     */   
/*  404:     */   public abstract void setUseSipInfoForDtmfs(boolean paramBoolean);
/*  405:     */   
/*  406:     */   public abstract boolean getUseSipInfoForDtmfs();
/*  407:     */   
/*  408:     */   public abstract void setUseRfc2833ForDtmfs(boolean paramBoolean);
/*  409:     */   
/*  410:     */   public abstract boolean getUseRfc2833ForDtmfs();
/*  411:     */   
/*  412:     */   public abstract LpConfig getConfig();
/*  413:     */   
/*  414:     */   public abstract boolean upnpAvailable();
/*  415:     */   
/*  416:     */   public abstract UpnpState getUpnpState();
/*  417:     */   
/*  418:     */   public abstract String getUpnpExternalIpaddress();
/*  419:     */   
/*  420:     */   public abstract LinphoneInfoMessage createInfoMessage();
/*  421:     */   
/*  422:     */   public abstract LinphoneEvent subscribe(LinphoneAddress paramLinphoneAddress, String paramString, int paramInt, LinphoneContent paramLinphoneContent);
/*  423:     */   
/*  424:     */   public abstract LinphoneEvent createSubscribe(LinphoneAddress paramLinphoneAddress, String paramString, int paramInt);
/*  425:     */   
/*  426:     */   public abstract LinphoneEvent createPublish(LinphoneAddress paramLinphoneAddress, String paramString, int paramInt);
/*  427:     */   
/*  428:     */   public abstract LinphoneEvent publish(LinphoneAddress paramLinphoneAddress, String paramString, int paramInt, LinphoneContent paramLinphoneContent);
/*  429:     */   
/*  430:     */   public abstract void setChatDatabasePath(String paramString);
/*  431:     */   
/*  432:     */   public abstract LinphoneChatRoom[] getChatRooms();
/*  433:     */   
/*  434:     */   public abstract String[] getSupportedVideoSizes();
/*  435:     */   
/*  436:     */   public abstract int migrateToMultiTransport();
/*  437:     */   
/*  438:     */   public abstract boolean acceptEarlyMedia(LinphoneCall paramLinphoneCall);
/*  439:     */   
/*  440:     */   public abstract boolean acceptEarlyMediaWithParams(LinphoneCall paramLinphoneCall, LinphoneCallParams paramLinphoneCallParams);
/*  441:     */   
/*  442:     */   public abstract LinphoneProxyConfig createProxyConfig();
/*  443:     */   
/*  444:     */   public abstract LinphoneProxyConfig createProxyConfig(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
/*  445:     */     throws LinphoneCoreException;
/*  446:     */   
/*  447:     */   public abstract void setCallErrorTone(Reason paramReason, String paramString);
/*  448:     */   
/*  449:     */   public abstract void setTone(ToneID paramToneID, String paramString);
/*  450:     */   
/*  451:     */   public abstract void setMtu(int paramInt);
/*  452:     */   
/*  453:     */   public abstract int getMtu();
/*  454:     */   
/*  455:     */   public abstract void enableSdp200Ack(boolean paramBoolean);
/*  456:     */   
/*  457:     */   public abstract boolean isSdp200AckEnabled();
/*  458:     */   
/*  459:     */   public abstract void disableChat(Reason paramReason);
/*  460:     */   
/*  461:     */   public abstract void enableChat();
/*  462:     */   
/*  463:     */   public abstract boolean chatEnabled();
/*  464:     */   
/*  465:     */   public abstract void stopRinging();
/*  466:     */   
/*  467:     */   public abstract void setAudioJittcomp(int paramInt);
/*  468:     */   
/*  469:     */   public abstract void setVideoJittcomp(int paramInt);
/*  470:     */   
/*  471:     */   public abstract void setFileTransferServer(String paramString);
/*  472:     */   
/*  473:     */   public abstract String getFileTransferServer();
/*  474:     */   
/*  475:     */   public abstract LinphonePlayer createLocalPlayer(AndroidVideoWindowImpl paramAndroidVideoWindowImpl);
/*  476:     */   
/*  477:     */   public abstract void addListener(LinphoneCoreListener paramLinphoneCoreListener);
/*  478:     */   
/*  479:     */   public abstract void removeListener(LinphoneCoreListener paramLinphoneCoreListener);
/*  480:     */   
/*  481:     */   public abstract void setRemoteRingbackTone(String paramString);
/*  482:     */   
/*  483:     */   public abstract String getRemoteRingbackTone();
/*  484:     */   
/*  485:     */   public abstract void uploadLogCollection();
/*  486:     */   
/*  487:     */   public abstract void resetLogCollection();
/*  488:     */   
/*  489:     */   public abstract void setAudioMulticastAddr(String paramString)
/*  490:     */     throws LinphoneCoreException;
/*  491:     */   
/*  492:     */   public abstract void setVideoMulticastAddr(String paramString)
/*  493:     */     throws LinphoneCoreException;
/*  494:     */   
/*  495:     */   public abstract String getAudioMulticastAddr();
/*  496:     */   
/*  497:     */   public abstract String getVideoMulticastAddr();
/*  498:     */   
/*  499:     */   public abstract void setAudioMulticastTtl(int paramInt)
/*  500:     */     throws LinphoneCoreException;
/*  501:     */   
/*  502:     */   public abstract void setVideoMulticastTtl(int paramInt)
/*  503:     */     throws LinphoneCoreException;
/*  504:     */   
/*  505:     */   public abstract int getAudioMulticastTtl();
/*  506:     */   
/*  507:     */   public abstract int getVideoMulticastTtl();
/*  508:     */   
/*  509:     */   public abstract void enableAudioMulticast(boolean paramBoolean);
/*  510:     */   
/*  511:     */   public abstract boolean audioMulticastEnabled();
/*  512:     */   
/*  513:     */   public abstract void enableVideoMulticast(boolean paramBoolean);
/*  514:     */   
/*  515:     */   public abstract boolean videoMulticastEnabled();
/*  516:     */   
/*  517:     */   public abstract void enableDnsSrv(boolean paramBoolean);
/*  518:     */   
/*  519:     */   public abstract boolean dnsSrvEnabled();
/*  520:     */   
/*  521:     */   public static class GlobalState
/*  522:     */   {
/*  523:  40 */     private static Vector<GlobalState> values = new Vector();
/*  524:  44 */     public static GlobalState GlobalOff = new GlobalState(0, "GlobalOff");
/*  525:  48 */     public static GlobalState GlobalStartup = new GlobalState(1, "GlobalStartup");
/*  526:  52 */     public static GlobalState GlobalOn = new GlobalState(2, "GlobalOn");
/*  527:  56 */     public static GlobalState GlobalShutdown = new GlobalState(3, "GlobalShutdown");
/*  528:  60 */     public static GlobalState GlobalConfiguring = new GlobalState(4, "GlobalConfiguring");
/*  529:     */     private final int mValue;
/*  530:     */     private final String mStringValue;
/*  531:     */     
/*  532:     */     private GlobalState(int value, String stringValue)
/*  533:     */     {
/*  534:  67 */       this.mValue = value;
/*  535:  68 */       values.addElement(this);
/*  536:  69 */       this.mStringValue = stringValue;
/*  537:     */     }
/*  538:     */     
/*  539:     */     public static GlobalState fromInt(int value)
/*  540:     */     {
/*  541:  73 */       for (int i = 0; i < values.size(); i++)
/*  542:     */       {
/*  543:  74 */         GlobalState state = (GlobalState)values.elementAt(i);
/*  544:  75 */         if (state.mValue == value) {
/*  545:  75 */           return state;
/*  546:     */         }
/*  547:     */       }
/*  548:  77 */       throw new RuntimeException("state not found [" + value + "]");
/*  549:     */     }
/*  550:     */     
/*  551:     */     public String toString()
/*  552:     */     {
/*  553:  80 */       return this.mStringValue;
/*  554:     */     }
/*  555:     */   }
/*  556:     */   
/*  557:     */   public static class RemoteProvisioningState
/*  558:     */   {
/*  559:  88 */     private static Vector<RemoteProvisioningState> values = new Vector();
/*  560:  92 */     public static RemoteProvisioningState ConfiguringSuccessful = new RemoteProvisioningState(0, "ConfiguringSuccessful");
/*  561:  96 */     public static RemoteProvisioningState ConfiguringFailed = new RemoteProvisioningState(1, "ConfiguringFailed");
/*  562: 100 */     public static RemoteProvisioningState ConfiguringSkipped = new RemoteProvisioningState(2, "ConfiguringSkipped");
/*  563:     */     private final int mValue;
/*  564:     */     private final String mStringValue;
/*  565:     */     
/*  566:     */     private RemoteProvisioningState(int value, String stringValue)
/*  567:     */     {
/*  568: 107 */       this.mValue = value;
/*  569: 108 */       values.addElement(this);
/*  570: 109 */       this.mStringValue = stringValue;
/*  571:     */     }
/*  572:     */     
/*  573:     */     public static RemoteProvisioningState fromInt(int value)
/*  574:     */     {
/*  575: 113 */       for (int i = 0; i < values.size(); i++)
/*  576:     */       {
/*  577: 114 */         RemoteProvisioningState state = (RemoteProvisioningState)values.elementAt(i);
/*  578: 115 */         if (state.mValue == value) {
/*  579: 115 */           return state;
/*  580:     */         }
/*  581:     */       }
/*  582: 117 */       throw new RuntimeException("state not found [" + value + "]");
/*  583:     */     }
/*  584:     */     
/*  585:     */     public String toString()
/*  586:     */     {
/*  587: 120 */       return this.mStringValue;
/*  588:     */     }
/*  589:     */   }
/*  590:     */   
/*  591:     */   public static class RegistrationState
/*  592:     */   {
/*  593: 129 */     private static Vector<RegistrationState> values = new Vector();
/*  594: 133 */     public static RegistrationState RegistrationNone = new RegistrationState(0, "RegistrationNone");
/*  595: 137 */     public static RegistrationState RegistrationProgress = new RegistrationState(1, "RegistrationProgress");
/*  596: 141 */     public static RegistrationState RegistrationOk = new RegistrationState(2, "RegistrationOk");
/*  597: 145 */     public static RegistrationState RegistrationCleared = new RegistrationState(3, "RegistrationCleared");
/*  598: 149 */     public static RegistrationState RegistrationFailed = new RegistrationState(4, "RegistrationFailed");
/*  599:     */     private final int mValue;
/*  600:     */     private final String mStringValue;
/*  601:     */     
/*  602:     */     private RegistrationState(int value, String stringValue)
/*  603:     */     {
/*  604: 155 */       this.mValue = value;
/*  605: 156 */       values.addElement(this);
/*  606: 157 */       this.mStringValue = stringValue;
/*  607:     */     }
/*  608:     */     
/*  609:     */     public static RegistrationState fromInt(int value)
/*  610:     */     {
/*  611: 161 */       for (int i = 0; i < values.size(); i++)
/*  612:     */       {
/*  613: 162 */         RegistrationState state = (RegistrationState)values.elementAt(i);
/*  614: 163 */         if (state.mValue == value) {
/*  615: 163 */           return state;
/*  616:     */         }
/*  617:     */       }
/*  618: 165 */       throw new RuntimeException("state not found [" + value + "]");
/*  619:     */     }
/*  620:     */     
/*  621:     */     public String toString()
/*  622:     */     {
/*  623: 168 */       return this.mStringValue;
/*  624:     */     }
/*  625:     */   }
/*  626:     */   
/*  627:     */   public static class FirewallPolicy
/*  628:     */   {
/*  629: 177 */     private static Vector<FirewallPolicy> values = new Vector();
/*  630: 181 */     public static FirewallPolicy NoFirewall = new FirewallPolicy(0, "NoFirewall");
/*  631: 185 */     public static FirewallPolicy UseNatAddress = new FirewallPolicy(1, "UseNatAddress");
/*  632: 189 */     public static FirewallPolicy UseStun = new FirewallPolicy(2, "UseStun");
/*  633: 193 */     public static FirewallPolicy UseIce = new FirewallPolicy(3, "UseIce");
/*  634: 197 */     public static FirewallPolicy UseUpnp = new FirewallPolicy(4, "UseUpnp");
/*  635:     */     private final int mValue;
/*  636:     */     private final String mStringValue;
/*  637:     */     
/*  638:     */     private FirewallPolicy(int value, String stringValue)
/*  639:     */     {
/*  640: 204 */       this.mValue = value;
/*  641: 205 */       values.addElement(this);
/*  642: 206 */       this.mStringValue = stringValue;
/*  643:     */     }
/*  644:     */     
/*  645:     */     public static FirewallPolicy fromInt(int value)
/*  646:     */     {
/*  647: 210 */       for (int i = 0; i < values.size(); i++)
/*  648:     */       {
/*  649: 211 */         FirewallPolicy state = (FirewallPolicy)values.elementAt(i);
/*  650: 212 */         if (state.mValue == value) {
/*  651: 212 */           return state;
/*  652:     */         }
/*  653:     */       }
/*  654: 214 */       throw new RuntimeException("state not found [" + value + "]");
/*  655:     */     }
/*  656:     */     
/*  657:     */     public String toString()
/*  658:     */     {
/*  659: 217 */       return this.mStringValue;
/*  660:     */     }
/*  661:     */     
/*  662:     */     public int value()
/*  663:     */     {
/*  664: 220 */       return this.mValue;
/*  665:     */     }
/*  666:     */   }
/*  667:     */   
/*  668:     */   public static class Transports
/*  669:     */   {
/*  670:     */     public int udp;
/*  671:     */     public int tcp;
/*  672:     */     public int tls;
/*  673:     */     
/*  674:     */     public Transports() {}
/*  675:     */     
/*  676:     */     public Transports(Transports t)
/*  677:     */     {
/*  678: 245 */       this.udp = t.udp;
/*  679: 246 */       this.tcp = t.tcp;
/*  680: 247 */       this.tls = t.tls;
/*  681:     */     }
/*  682:     */     
/*  683:     */     public String toString()
/*  684:     */     {
/*  685: 250 */       return "udp[" + this.udp + "] tcp[" + this.tcp + "] tls[" + this.tls + "]";
/*  686:     */     }
/*  687:     */   }
/*  688:     */   
/*  689:     */   public static final class MediaEncryption
/*  690:     */   {
/*  691: 259 */     private static Vector<MediaEncryption> values = new Vector();
/*  692: 263 */     public static final MediaEncryption None = new MediaEncryption(0, "None");
/*  693: 267 */     public static final MediaEncryption SRTP = new MediaEncryption(1, "SRTP");
/*  694: 271 */     public static final MediaEncryption ZRTP = new MediaEncryption(2, "ZRTP");
/*  695: 275 */     public static final MediaEncryption DTLS = new MediaEncryption(3, "DTLS");
/*  696:     */     protected final int mValue;
/*  697:     */     private final String mStringValue;
/*  698:     */     
/*  699:     */     private MediaEncryption(int value, String stringValue)
/*  700:     */     {
/*  701: 281 */       this.mValue = value;
/*  702: 282 */       values.addElement(this);
/*  703: 283 */       this.mStringValue = stringValue;
/*  704:     */     }
/*  705:     */     
/*  706:     */     public static MediaEncryption fromInt(int value)
/*  707:     */     {
/*  708: 287 */       for (int i = 0; i < values.size(); i++)
/*  709:     */       {
/*  710: 288 */         MediaEncryption menc = (MediaEncryption)values.elementAt(i);
/*  711: 289 */         if (menc.mValue == value) {
/*  712: 289 */           return menc;
/*  713:     */         }
/*  714:     */       }
/*  715: 291 */       throw new RuntimeException("MediaEncryption not found [" + value + "]");
/*  716:     */     }
/*  717:     */     
/*  718:     */     public String toString()
/*  719:     */     {
/*  720: 294 */       return this.mStringValue;
/*  721:     */     }
/*  722:     */   }
/*  723:     */   
/*  724:     */   public static final class AdaptiveRateAlgorithm
/*  725:     */   {
/*  726: 299 */     private static Vector<AdaptiveRateAlgorithm> values = new Vector();
/*  727: 303 */     public static final AdaptiveRateAlgorithm Simple = new AdaptiveRateAlgorithm(0, "Simple");
/*  728: 307 */     public static final AdaptiveRateAlgorithm Stateful = new AdaptiveRateAlgorithm(1, "Stateful");
/*  729:     */     protected final int mValue;
/*  730:     */     private final String mStringValue;
/*  731:     */     
/*  732:     */     private AdaptiveRateAlgorithm(int value, String stringValue)
/*  733:     */     {
/*  734: 313 */       this.mValue = value;
/*  735: 314 */       values.addElement(this);
/*  736: 315 */       this.mStringValue = stringValue;
/*  737:     */     }
/*  738:     */     
/*  739:     */     public static AdaptiveRateAlgorithm fromString(String value)
/*  740:     */     {
/*  741: 319 */       for (int i = 0; i < values.size(); i++)
/*  742:     */       {
/*  743: 320 */         AdaptiveRateAlgorithm alg = (AdaptiveRateAlgorithm)values.elementAt(i);
/*  744: 321 */         if (alg.mStringValue.equalsIgnoreCase(value)) {
/*  745: 321 */           return alg;
/*  746:     */         }
/*  747:     */       }
/*  748: 323 */       throw new RuntimeException("AdaptiveRateAlgorithm not found [" + value + "]");
/*  749:     */     }
/*  750:     */     
/*  751:     */     public String toString()
/*  752:     */     {
/*  753: 326 */       return this.mStringValue;
/*  754:     */     }
/*  755:     */   }
/*  756:     */   
/*  757:     */   public static class EcCalibratorStatus
/*  758:     */   {
/*  759: 334 */     private static Vector<EcCalibratorStatus> values = new Vector();
/*  760:     */     public static final int IN_PROGRESS_STATUS = 0;
/*  761:     */     public static final int DONE_STATUS = 1;
/*  762:     */     public static final int FAILED_STATUS = 2;
/*  763:     */     public static final int DONE_NO_ECHO_STATUS = 3;
/*  764: 344 */     public static EcCalibratorStatus InProgress = new EcCalibratorStatus(0, "InProgress");
/*  765: 348 */     public static EcCalibratorStatus Done = new EcCalibratorStatus(1, "Done");
/*  766: 352 */     public static EcCalibratorStatus Failed = new EcCalibratorStatus(2, "Failed");
/*  767: 356 */     public static EcCalibratorStatus DoneNoEcho = new EcCalibratorStatus(3, "DoneNoEcho");
/*  768:     */     private final int mValue;
/*  769:     */     private final String mStringValue;
/*  770:     */     
/*  771:     */     private EcCalibratorStatus(int value, String stringValue)
/*  772:     */     {
/*  773: 363 */       this.mValue = value;
/*  774: 364 */       values.addElement(this);
/*  775: 365 */       this.mStringValue = stringValue;
/*  776:     */     }
/*  777:     */     
/*  778:     */     public static EcCalibratorStatus fromInt(int value)
/*  779:     */     {
/*  780: 369 */       for (int i = 0; i < values.size(); i++)
/*  781:     */       {
/*  782: 370 */         EcCalibratorStatus status = (EcCalibratorStatus)values.elementAt(i);
/*  783: 371 */         if (status.mValue == value) {
/*  784: 371 */           return status;
/*  785:     */         }
/*  786:     */       }
/*  787: 373 */       throw new RuntimeException("status not found [" + value + "]");
/*  788:     */     }
/*  789:     */     
/*  790:     */     public String toString()
/*  791:     */     {
/*  792: 376 */       return this.mStringValue;
/*  793:     */     }
/*  794:     */     
/*  795:     */     public int value()
/*  796:     */     {
/*  797: 379 */       return this.mValue;
/*  798:     */     }
/*  799:     */   }
/*  800:     */   
/*  801:     */   public static class UpnpState
/*  802:     */   {
/*  803: 384 */     private static Vector<UpnpState> values = new Vector();
/*  804: 388 */     public static UpnpState Idle = new UpnpState(0, "Idle");
/*  805: 392 */     public static UpnpState Pending = new UpnpState(1, "Pending");
/*  806: 396 */     public static UpnpState Adding = new UpnpState(2, "Adding");
/*  807: 400 */     public static UpnpState Removing = new UpnpState(3, "Removing");
/*  808: 404 */     public static UpnpState NotAvailable = new UpnpState(4, "Not available");
/*  809: 408 */     public static UpnpState Ok = new UpnpState(5, "Ok");
/*  810: 412 */     public static UpnpState Ko = new UpnpState(6, "Ko");
/*  811: 416 */     public static UpnpState Blacklisted = new UpnpState(7, "Blacklisted");
/*  812:     */     protected final int mValue;
/*  813:     */     private final String mStringValue;
/*  814:     */     
/*  815:     */     private UpnpState(int value, String stringValue)
/*  816:     */     {
/*  817: 422 */       this.mValue = value;
/*  818: 423 */       values.addElement(this);
/*  819: 424 */       this.mStringValue = stringValue;
/*  820:     */     }
/*  821:     */     
/*  822:     */     public static UpnpState fromInt(int value)
/*  823:     */     {
/*  824: 427 */       for (int i = 0; i < values.size(); i++)
/*  825:     */       {
/*  826: 428 */         UpnpState mstate = (UpnpState)values.elementAt(i);
/*  827: 429 */         if (mstate.mValue == value) {
/*  828: 429 */           return mstate;
/*  829:     */         }
/*  830:     */       }
/*  831: 431 */       throw new RuntimeException("UpnpState not found [" + value + "]");
/*  832:     */     }
/*  833:     */     
/*  834:     */     public String toString()
/*  835:     */     {
/*  836: 434 */       return this.mStringValue;
/*  837:     */     }
/*  838:     */   }
/*  839:     */   
/*  840:     */   public static class LogCollectionUploadState
/*  841:     */   {
/*  842: 442 */     private static Vector<LogCollectionUploadState> values = new Vector();
/*  843: 446 */     public static LogCollectionUploadState LogCollectionUploadStateInProgress = new LogCollectionUploadState(0, "LinphoneCoreLogCollectionUploadStateInProgress");
/*  844: 450 */     public static LogCollectionUploadState LogCollectionUploadStateDelivered = new LogCollectionUploadState(1, "LinphoneCoreLogCollectionUploadStateDelivered");
/*  845: 454 */     public static LogCollectionUploadState LogCollectionUploadStateNotDelivered = new LogCollectionUploadState(2, "LinphoneCoreLogCollectionUploadStateNotDelivered");
/*  846:     */     private final int mValue;
/*  847:     */     private final String mStringValue;
/*  848:     */     
/*  849:     */     private LogCollectionUploadState(int value, String stringValue)
/*  850:     */     {
/*  851: 460 */       this.mValue = value;
/*  852: 461 */       values.addElement(this);
/*  853: 462 */       this.mStringValue = stringValue;
/*  854:     */     }
/*  855:     */     
/*  856:     */     public static LogCollectionUploadState fromInt(int value)
/*  857:     */     {
/*  858: 466 */       for (int i = 0; i < values.size(); i++)
/*  859:     */       {
/*  860: 467 */         LogCollectionUploadState state = (LogCollectionUploadState)values.elementAt(i);
/*  861: 468 */         if (state.mValue == value) {
/*  862: 468 */           return state;
/*  863:     */         }
/*  864:     */       }
/*  865: 470 */       throw new RuntimeException("state not found [" + value + "]");
/*  866:     */     }
/*  867:     */     
/*  868:     */     public String toString()
/*  869:     */     {
/*  870: 473 */       return this.mStringValue;
/*  871:     */     }
/*  872:     */   }
/*  873:     */   
/*  874:     */   public static enum TunnelMode
/*  875:     */   {
/*  876:1394 */     disable(0),  enable(1),  auto(2);
/*  877:     */     
/*  878:     */     private final int value;
/*  879:     */     
/*  880:     */     private TunnelMode(int value)
/*  881:     */     {
/*  882:1400 */       this.value = value;
/*  883:     */     }
/*  884:     */     
/*  885:     */     public static int enumToInt(TunnelMode enum_mode)
/*  886:     */     {
/*  887:1403 */       return enum_mode.value;
/*  888:     */     }
/*  889:     */     
/*  890:     */     public static TunnelMode intToEnum(int value)
/*  891:     */     {
/*  892:1406 */       switch (value)
/*  893:     */       {
/*  894:     */       case 0: 
/*  895:1407 */         return disable;
/*  896:     */       case 1: 
/*  897:1408 */         return enable;
/*  898:     */       case 2: 
/*  899:1409 */         return auto;
/*  900:     */       }
/*  901:1410 */       return disable;
/*  902:     */     }
/*  903:     */   }
/*  904:     */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneCore

 * JD-Core Version:    0.7.0.1

 */