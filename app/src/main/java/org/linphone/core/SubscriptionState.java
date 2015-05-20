/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public enum SubscriptionState
/*  4:   */ {
/*  5: 7 */   None(0),  OutoingProgress(1),  IncomingReceived(2),  Pending(3),  Active(4),  Terminated(5),  Error(6),  Expiring(7);
/*  6:   */   
/*  7:   */   protected final int mValue;
/*  8:   */   
/*  9:   */   private SubscriptionState(int value)
/* 10:   */   {
/* 11:39 */     this.mValue = value;
/* 12:   */   }
/* 13:   */   
/* 14:   */   protected static SubscriptionState fromInt(int value)
/* 15:   */     throws LinphoneCoreException
/* 16:   */   {
/* 17:42 */     switch (value)
/* 18:   */     {
/* 19:   */     case 0: 
/* 20:43 */       return None;
/* 21:   */     case 1: 
/* 22:44 */       return OutoingProgress;
/* 23:   */     case 2: 
/* 24:45 */       return IncomingReceived;
/* 25:   */     case 3: 
/* 26:46 */       return Pending;
/* 27:   */     case 4: 
/* 28:47 */       return Active;
/* 29:   */     case 5: 
/* 30:48 */       return Terminated;
/* 31:   */     case 6: 
/* 32:49 */       return Error;
/* 33:   */     case 7: 
/* 34:50 */       return Expiring;
/* 35:   */     }
/* 36:52 */     throw new LinphoneCoreException("Unhandled enum value " + value + " for SubscriptionState");
/* 37:   */   }
/* 38:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.SubscriptionState
 * JD-Core Version:    0.7.0.1
 */