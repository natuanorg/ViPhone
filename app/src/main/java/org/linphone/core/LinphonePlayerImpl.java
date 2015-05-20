/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class LinphonePlayerImpl
/*  4:   */   implements LinphonePlayer
/*  5:   */ {
/*  6:11 */   private long nativePtr = 0L;
/*  7:   */   
/*  8:   */   LinphonePlayerImpl(long nativePtr)
/*  9:   */   {
/* 10:14 */     this.nativePtr = nativePtr;
/* 11:   */   }
/* 12:   */   
/* 13:   */   private native int open(long paramLong, String paramString, Listener paramListener);
/* 14:   */   
/* 15:   */   public synchronized int open(String filename, Listener listener)
/* 16:   */   {
/* 17:20 */     return open(this.nativePtr, filename, listener);
/* 18:   */   }
/* 19:   */   
/* 20:   */   private native int start(long paramLong);
/* 21:   */   
/* 22:   */   public synchronized int start()
/* 23:   */   {
/* 24:26 */     return start(this.nativePtr);
/* 25:   */   }
/* 26:   */   
/* 27:   */   private native int pause(long paramLong);
/* 28:   */   
/* 29:   */   public synchronized int pause()
/* 30:   */   {
/* 31:32 */     return pause(this.nativePtr);
/* 32:   */   }
/* 33:   */   
/* 34:   */   private native int seek(long paramLong, int paramInt);
/* 35:   */   
/* 36:   */   public synchronized int seek(int timeMs)
/* 37:   */   {
/* 38:38 */     return seek(this.nativePtr, timeMs);
/* 39:   */   }
/* 40:   */   
/* 41:   */   private native int getState(long paramLong);
/* 42:   */   
/* 43:   */   public synchronized State getState()
/* 44:   */   {
/* 45:44 */     return State.fromValue(getState(this.nativePtr));
/* 46:   */   }
/* 47:   */   
/* 48:   */   private native int getDuration(long paramLong);
/* 49:   */   
/* 50:   */   public synchronized int getDuration()
/* 51:   */   {
/* 52:50 */     return getDuration(this.nativePtr);
/* 53:   */   }
/* 54:   */   
/* 55:   */   private native int getCurrentPosition(long paramLong);
/* 56:   */   
/* 57:   */   public synchronized int getCurrentPosition()
/* 58:   */   {
/* 59:56 */     return getCurrentPosition(this.nativePtr);
/* 60:   */   }
/* 61:   */   
/* 62:   */   private native void close(long paramLong);
/* 63:   */   
/* 64:   */   public synchronized void close()
/* 65:   */   {
/* 66:62 */     close(this.nativePtr);
/* 67:   */   }
/* 68:   */   
/* 69:   */   private native void destroy(long paramLong);
/* 70:   */   
/* 71:   */   protected void finalize()
/* 72:   */   {
/* 73:68 */     destroy(this.nativePtr);
/* 74:   */   }
/* 75:   */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphonePlayerImpl

 * JD-Core Version:    0.7.0.1

 */