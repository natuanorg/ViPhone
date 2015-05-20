/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class ErrorInfoImpl
/*  4:   */   implements ErrorInfo
/*  5:   */ {
/*  6:   */   private Reason mReason;
/*  7:   */   private int mCode;
/*  8:   */   private String mPhrase;
/*  9:   */   private String mDetails;
/* 10:   */   
/* 11:   */   private native int getReason(long paramLong);
/* 12:   */   
/* 13:   */   private native int getProtocolCode(long paramLong);
/* 14:   */   
/* 15:   */   private native String getPhrase(long paramLong);
/* 16:   */   
/* 17:   */   private native String getDetails(long paramLong);
/* 18:   */   
/* 19:   */   public ErrorInfoImpl(long nativePtr)
/* 20:   */   {
/* 21:15 */     this.mReason = Reason.fromInt(getReason(nativePtr));
/* 22:16 */     this.mCode = getProtocolCode(nativePtr);
/* 23:17 */     this.mPhrase = getPhrase(nativePtr);
/* 24:18 */     this.mDetails = getDetails(nativePtr);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Reason getReason()
/* 28:   */   {
/* 29:23 */     return this.mReason;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public int getProtocolCode()
/* 33:   */   {
/* 34:28 */     return this.mCode;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getPhrase()
/* 38:   */   {
/* 39:33 */     return this.mPhrase;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getDetails()
/* 43:   */   {
/* 44:38 */     return this.mDetails;
/* 45:   */   }
/* 46:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.ErrorInfoImpl
 * JD-Core Version:    0.7.0.1
 */