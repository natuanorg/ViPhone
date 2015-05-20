/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public enum ToneID
/*  4:   */ {
/*  5: 4 */   Undefined(0),  Busy(1),  CallWaiting(2),  CallOnHold(3),  CallLost(4);
/*  6:   */   
/*  7:   */   protected final int mValue;
/*  8:   */   
/*  9:   */   private ToneID(int value)
/* 10:   */   {
/* 11:11 */     this.mValue = value;
/* 12:   */   }
/* 13:   */   
/* 14:   */   protected static ToneID fromInt(int value)
/* 15:   */     throws LinphoneCoreException
/* 16:   */   {
/* 17:14 */     switch (value)
/* 18:   */     {
/* 19:   */     case 0: 
/* 20:15 */       return Undefined;
/* 21:   */     case 1: 
/* 22:16 */       return Busy;
/* 23:   */     case 2: 
/* 24:17 */       return CallWaiting;
/* 25:   */     case 3: 
/* 26:18 */       return CallOnHold;
/* 27:   */     case 4: 
/* 28:19 */       return CallLost;
/* 29:   */     }
/* 30:21 */     throw new LinphoneCoreException("Unhandled enum value " + value + " for LinphoneToneID");
/* 31:   */   }
/* 32:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.ToneID
 * JD-Core Version:    0.7.0.1
 */