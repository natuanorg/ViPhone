/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class LinphoneCoreException
/*  4:   */   extends Exception
/*  5:   */ {
/*  6:   */   public LinphoneCoreException() {}
/*  7:   */   
/*  8:   */   public LinphoneCoreException(String detailMessage)
/*  9:   */   {
/* 10:29 */     super(detailMessage);
/* 11:   */   }
/* 12:   */   
/* 13:   */   public LinphoneCoreException(Throwable e)
/* 14:   */   {
/* 15:33 */     super(e);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public LinphoneCoreException(String detailMessage, Throwable e)
/* 19:   */   {
/* 20:37 */     super(detailMessage, e);
/* 21:   */   }
/* 22:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCoreException
 * JD-Core Version:    0.7.0.1
 */