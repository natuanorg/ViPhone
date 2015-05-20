/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public enum SubscriptionDir
/*  4:   */ {
/*  5: 6 */   Incoming(0),  Outgoing(1),  Invalid(2);
/*  6:   */   
/*  7:   */   protected final int mValue;
/*  8:   */   
/*  9:   */   private SubscriptionDir(int value)
/* 10:   */   {
/* 11:11 */     this.mValue = value;
/* 12:   */   }
/* 13:   */   
/* 14:   */   protected static SubscriptionDir fromInt(int value)
/* 15:   */   {
/* 16:14 */     switch (value)
/* 17:   */     {
/* 18:   */     case 0: 
/* 19:15 */       return Incoming;
/* 20:   */     case 1: 
/* 21:16 */       return Outgoing;
/* 22:   */     }
/* 23:18 */     return Invalid;
/* 24:   */   }
/* 25:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.SubscriptionDir
 * JD-Core Version:    0.7.0.1
 */