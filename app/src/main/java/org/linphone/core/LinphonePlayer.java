/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public abstract interface LinphonePlayer
/*  4:   */ {
/*  5:   */   public abstract int open(String paramString, Listener paramListener);
/*  6:   */   
/*  7:   */   public abstract int start();
/*  8:   */   
/*  9:   */   public abstract int pause();
/* 10:   */   
/* 11:   */   public abstract int seek(int paramInt);
/* 12:   */   
/* 13:   */   public abstract State getState();
/* 14:   */   
/* 15:   */   public abstract int getDuration();
/* 16:   */   
/* 17:   */   public abstract int getCurrentPosition();
/* 18:   */   
/* 19:   */   public abstract void close();
/* 20:   */   
/* 21:   */   public static abstract interface Listener
/* 22:   */   {
/* 23:   */     public abstract void endOfFile(LinphonePlayer paramLinphonePlayer);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public static enum State
/* 27:   */   {
/* 28:17 */     closed,  paused,  playing;
/* 29:   */     
/* 30:   */     private State() {}
/* 31:   */     
/* 32:   */     public static State fromValue(int value)
/* 33:   */     {
/* 34:22 */       if (value == 0) {
/* 35:23 */         return closed;
/* 36:   */       }
/* 37:24 */       if (value == 1) {
/* 38:25 */         return paused;
/* 39:   */       }
/* 40:26 */       if (value == 2) {
/* 41:27 */         return playing;
/* 42:   */       }
/* 43:29 */       return null;
/* 44:   */     }
/* 45:   */   }
/* 46:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphonePlayer
 * JD-Core Version:    0.7.0.1
 */