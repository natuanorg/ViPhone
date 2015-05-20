/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public enum PublishState
/*  4:   */ {
/*  5: 7 */   None(0),  Progress(1),  Ok(2),  Error(3),  Expiring(4),  Cleared(5);
/*  6:   */   
/*  7:   */   protected final int mValue;
/*  8:   */   
/*  9:   */   private PublishState(int value)
/* 10:   */   {
/* 11:32 */     this.mValue = value;
/* 12:   */   }
/* 13:   */   
/* 14:   */   protected static PublishState fromInt(int value)
/* 15:   */     throws LinphoneCoreException
/* 16:   */   {
/* 17:35 */     switch (value)
/* 18:   */     {
/* 19:   */     case 0: 
/* 20:36 */       return None;
/* 21:   */     case 1: 
/* 22:37 */       return Progress;
/* 23:   */     case 2: 
/* 24:38 */       return Ok;
/* 25:   */     case 3: 
/* 26:39 */       return Error;
/* 27:   */     case 4: 
/* 28:40 */       return Expiring;
/* 29:   */     case 5: 
/* 30:41 */       return Cleared;
/* 31:   */     }
/* 32:43 */     throw new LinphoneCoreException("Unhandled enum value " + value + " for PublishState");
/* 33:   */   }
/* 34:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PublishState
 * JD-Core Version:    0.7.0.1
 */