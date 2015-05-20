/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */ public abstract interface LinphoneCallLog
/*  6:   */ {
/*  7:   */   public abstract LinphoneAddress getFrom();
/*  8:   */   
/*  9:   */   public abstract LinphoneAddress getTo();
/* 10:   */   
/* 11:   */   public abstract CallDirection getDirection();
/* 12:   */   
/* 13:   */   public abstract CallStatus getStatus();
/* 14:   */   
/* 15:   */   public abstract String getStartDate();
/* 16:   */   
/* 17:   */   public abstract long getTimestamp();
/* 18:   */   
/* 19:   */   public abstract int getCallDuration();
/* 20:   */   
/* 21:   */   public abstract int getCallId();
/* 22:   */   
/* 23:   */   public static class CallStatus
/* 24:   */   {
/* 25:39 */     private static Vector<CallStatus> values = new Vector();
/* 26:   */     private final int mValue;
/* 27:   */     private final String mStringValue;
/* 28:45 */     public static final CallStatus Success = new CallStatus(0, "Sucess");
/* 29:49 */     public static final CallStatus Aborted = new CallStatus(1, "Aborted");
/* 30:53 */     public static final CallStatus Missed = new CallStatus(2, "Missed");
/* 31:57 */     public static final CallStatus Declined = new CallStatus(3, "Declined");
/* 32:   */     
/* 33:   */     private CallStatus(int value, String stringValue)
/* 34:   */     {
/* 35:61 */       this.mValue = value;
/* 36:62 */       values.addElement(this);
/* 37:63 */       this.mStringValue = stringValue;
/* 38:   */     }
/* 39:   */     
/* 40:   */     public static CallStatus fromInt(int value)
/* 41:   */     {
/* 42:67 */       for (int i = 0; i < values.size(); i++)
/* 43:   */       {
/* 44:68 */         CallStatus state = (CallStatus)values.elementAt(i);
/* 45:69 */         if (state.mValue == value) {
/* 46:69 */           return state;
/* 47:   */         }
/* 48:   */       }
/* 49:71 */       throw new RuntimeException("CallStatus not found [" + value + "]");
/* 50:   */     }
/* 51:   */     
/* 52:   */     public String toString()
/* 53:   */     {
/* 54:74 */       return this.mStringValue;
/* 55:   */     }
/* 56:   */     
/* 57:   */     public int toInt()
/* 58:   */     {
/* 59:77 */       return this.mValue;
/* 60:   */     }
/* 61:   */   }
/* 62:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCallLog
 * JD-Core Version:    0.7.0.1
 */