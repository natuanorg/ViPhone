/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class PresenceNoteImpl
/*  4:   */   implements PresenceNote
/*  5:   */ {
/*  6:   */   private long mNativePtr;
/*  7:   */   
/*  8:   */   protected PresenceNoteImpl(long nativePtr)
/*  9:   */   {
/* 10:26 */     this.mNativePtr = nativePtr;
/* 11:   */   }
/* 12:   */   
/* 13:   */   private native long newPresenceNoteImpl(String paramString1, String paramString2);
/* 14:   */   
/* 15:   */   protected PresenceNoteImpl(String content, String lang)
/* 16:   */   {
/* 17:31 */     this.mNativePtr = newPresenceNoteImpl(content, lang);
/* 18:   */   }
/* 19:   */   
/* 20:   */   private native void unref(long paramLong);
/* 21:   */   
/* 22:   */   protected void finalize()
/* 23:   */   {
/* 24:36 */     unref(this.mNativePtr);
/* 25:   */   }
/* 26:   */   
/* 27:   */   private native String getContent(long paramLong);
/* 28:   */   
/* 29:   */   public String getContent()
/* 30:   */   {
/* 31:42 */     return getContent(this.mNativePtr);
/* 32:   */   }
/* 33:   */   
/* 34:   */   private native int setContent(long paramLong, String paramString);
/* 35:   */   
/* 36:   */   public int setContent(String content)
/* 37:   */   {
/* 38:48 */     return setContent(this.mNativePtr, content);
/* 39:   */   }
/* 40:   */   
/* 41:   */   private native String getLang(long paramLong);
/* 42:   */   
/* 43:   */   public String getLang()
/* 44:   */   {
/* 45:54 */     return getLang(this.mNativePtr);
/* 46:   */   }
/* 47:   */   
/* 48:   */   private native int setLang(long paramLong, String paramString);
/* 49:   */   
/* 50:   */   public int setLang(String lang)
/* 51:   */   {
/* 52:60 */     return setLang(this.mNativePtr, lang);
/* 53:   */   }
/* 54:   */   
/* 55:   */   public long getNativePtr()
/* 56:   */   {
/* 57:64 */     return this.mNativePtr;
/* 58:   */   }
/* 59:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceNoteImpl
 * JD-Core Version:    0.7.0.1
 */