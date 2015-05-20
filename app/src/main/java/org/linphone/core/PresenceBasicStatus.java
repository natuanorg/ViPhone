/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public enum PresenceBasicStatus
/*  4:   */ {
/*  5:25 */   Open(0),  Closed(1),  Invalid(2);
/*  6:   */   
/*  7:   */   protected final int mValue;
/*  8:   */   
/*  9:   */   private PresenceBasicStatus(int value)
/* 10:   */   {
/* 11:33 */     this.mValue = value;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public int toInt()
/* 15:   */   {
/* 16:37 */     return this.mValue;
/* 17:   */   }
/* 18:   */   
/* 19:   */   protected static PresenceBasicStatus fromInt(int value)
/* 20:   */   {
/* 21:41 */     switch (value)
/* 22:   */     {
/* 23:   */     case 0: 
/* 24:42 */       return Open;
/* 25:   */     case 1: 
/* 26:43 */       return Closed;
/* 27:   */     }
/* 28:44 */     return Invalid;
/* 29:   */   }
/* 30:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceBasicStatus
 * JD-Core Version:    0.7.0.1
 */