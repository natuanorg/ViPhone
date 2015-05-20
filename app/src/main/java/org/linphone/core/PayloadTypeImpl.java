/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ class PayloadTypeImpl
/*  4:   */   implements PayloadType
/*  5:   */ {
/*  6:   */   public final long nativePtr;
/*  7:   */   
/*  8:   */   private native String toString(long paramLong);
/*  9:   */   
/* 10:   */   private native String getMime(long paramLong);
/* 11:   */   
/* 12:   */   private native int getRate(long paramLong);
/* 13:   */   
/* 14:   */   protected PayloadTypeImpl(long aNativePtr)
/* 15:   */   {
/* 16:31 */     this.nativePtr = aNativePtr;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public int getRate()
/* 20:   */   {
/* 21:35 */     return getRate(this.nativePtr);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getMime()
/* 25:   */   {
/* 26:39 */     return getMime(this.nativePtr);
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String toString()
/* 30:   */   {
/* 31:43 */     return toString(this.nativePtr);
/* 32:   */   }
/* 33:   */   
/* 34:   */   private native void setRecvFmtp(long paramLong, String paramString);
/* 35:   */   
/* 36:   */   public void setRecvFmtp(String fmtp)
/* 37:   */   {
/* 38:49 */     setRecvFmtp(this.nativePtr, fmtp);
/* 39:   */   }
/* 40:   */   
/* 41:   */   private native String getRecvFmtp(long paramLong);
/* 42:   */   
/* 43:   */   public String getRecvFmtp()
/* 44:   */   {
/* 45:54 */     return getRecvFmtp(this.nativePtr);
/* 46:   */   }
/* 47:   */   
/* 48:   */   private native void setSendFmtp(long paramLong, String paramString);
/* 49:   */   
/* 50:   */   public void setSendFmtp(String fmtp)
/* 51:   */   {
/* 52:60 */     setSendFmtp(this.nativePtr, fmtp);
/* 53:   */   }
/* 54:   */   
/* 55:   */   private native String getSendFmtp(long paramLong);
/* 56:   */   
/* 57:   */   public String getSendFmtp()
/* 58:   */   {
/* 59:65 */     return getSendFmtp(this.nativePtr);
/* 60:   */   }
/* 61:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PayloadTypeImpl
 * JD-Core Version:    0.7.0.1
 */