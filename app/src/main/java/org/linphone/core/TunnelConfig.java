/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class TunnelConfig
/*  4:   */ {
/*  5: 4 */   private String host = null;
/*  6: 5 */   private int port = 443;
/*  7: 6 */   private int remoteUdpMirrorPort = 12345;
/*  8: 7 */   private int delay = 1000;
/*  9:   */   
/* 10:   */   public String getHost()
/* 11:   */   {
/* 12:10 */     return this.host;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public void setHost(String host)
/* 16:   */   {
/* 17:14 */     this.host = host;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public int getPort()
/* 21:   */   {
/* 22:18 */     return this.port;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setPort(int port)
/* 26:   */   {
/* 27:22 */     this.port = port;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public int getRemoteUdpMirrorPort()
/* 31:   */   {
/* 32:26 */     return this.remoteUdpMirrorPort;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setRemoteUdpMirrorPort(int remoteUdpMirrorPort)
/* 36:   */   {
/* 37:30 */     this.remoteUdpMirrorPort = remoteUdpMirrorPort;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public int getDelay()
/* 41:   */   {
/* 42:34 */     return this.delay;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setDelay(int delay)
/* 46:   */   {
/* 47:38 */     this.delay = delay;
/* 48:   */   }
/* 49:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.TunnelConfig
 * JD-Core Version:    0.7.0.1
 */