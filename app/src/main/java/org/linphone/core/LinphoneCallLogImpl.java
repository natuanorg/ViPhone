/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ class LinphoneCallLogImpl
/*  4:   */   implements LinphoneCallLog
/*  5:   */ {
/*  6:   */   protected final long nativePtr;
/*  7:   */   
/*  8:   */   private native long getFrom(long paramLong);
/*  9:   */   
/* 10:   */   private native long getTo(long paramLong);
/* 11:   */   
/* 12:   */   private native boolean isIncoming(long paramLong);
/* 13:   */   
/* 14:   */   private native int getStatus(long paramLong);
/* 15:   */   
/* 16:   */   private native String getStartDate(long paramLong);
/* 17:   */   
/* 18:   */   private native int getCallDuration(long paramLong);
/* 19:   */   
/* 20:   */   private native int getCallId(long paramLong);
/* 21:   */   
/* 22:   */   private native long getTimestamp(long paramLong);
/* 23:   */   
/* 24:   */   LinphoneCallLogImpl(long aNativePtr)
/* 25:   */   {
/* 26:36 */     this.nativePtr = aNativePtr;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public CallDirection getDirection()
/* 30:   */   {
/* 31:40 */     return isIncoming(this.nativePtr) ? CallDirection.Incoming : CallDirection.Outgoing;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public LinphoneAddress getFrom()
/* 35:   */   {
/* 36:44 */     return new LinphoneAddressImpl(getFrom(this.nativePtr), LinphoneAddressImpl.WrapMode.FromExisting);
/* 37:   */   }
/* 38:   */   
/* 39:   */   public LinphoneAddress getTo()
/* 40:   */   {
/* 41:48 */     return new LinphoneAddressImpl(getTo(this.nativePtr), LinphoneAddressImpl.WrapMode.FromExisting);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public LinphoneCallLog.CallStatus getStatus()
/* 45:   */   {
/* 46:51 */     return LinphoneCallLog.CallStatus.fromInt(getStatus(this.nativePtr));
/* 47:   */   }
/* 48:   */   
/* 49:   */   public long getNativePtr()
/* 50:   */   {
/* 51:55 */     return this.nativePtr;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getStartDate()
/* 55:   */   {
/* 56:59 */     return getStartDate(this.nativePtr);
/* 57:   */   }
/* 58:   */   
/* 59:   */   public int getCallDuration()
/* 60:   */   {
/* 61:63 */     return getCallDuration(this.nativePtr);
/* 62:   */   }
/* 63:   */   
/* 64:   */   public int getCallId()
/* 65:   */   {
/* 66:66 */     return getCallId(this.nativePtr);
/* 67:   */   }
/* 68:   */   
/* 69:   */   public long getTimestamp()
/* 70:   */   {
/* 71:70 */     return getTimestamp(this.nativePtr) * 1000L;
/* 72:   */   }
/* 73:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCallLogImpl
 * JD-Core Version:    0.7.0.1
 */