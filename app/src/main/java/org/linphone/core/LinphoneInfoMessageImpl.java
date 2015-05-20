/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class LinphoneInfoMessageImpl
/*  4:   */   implements LinphoneInfoMessage
/*  5:   */ {
/*  6:   */   protected long nativePtr;
/*  7:   */   private LinphoneContent mContent;
/*  8:   */   
/*  9:   */   private native Object getContent(long paramLong);
/* 10:   */   
/* 11:   */   public LinphoneInfoMessageImpl(long ptr)
/* 12:   */   {
/* 13: 9 */     this.nativePtr = ptr;
/* 14:10 */     this.mContent = ((LinphoneContent)getContent(this.nativePtr));
/* 15:   */   }
/* 16:   */   
/* 17:   */   private native void setContent(long paramLong, String paramString1, String paramString2, String paramString3);
/* 18:   */   
/* 19:   */   public void setContent(LinphoneContent content)
/* 20:   */   {
/* 21:16 */     this.mContent = content;
/* 22:17 */     setContent(this.nativePtr, this.mContent.getType(), this.mContent.getSubtype(), this.mContent.getDataAsString());
/* 23:   */   }
/* 24:   */   
/* 25:   */   public LinphoneContent getContent()
/* 26:   */   {
/* 27:22 */     return this.mContent;
/* 28:   */   }
/* 29:   */   
/* 30:   */   private native void addHeader(long paramLong, String paramString1, String paramString2);
/* 31:   */   
/* 32:   */   public void addHeader(String name, String value)
/* 33:   */   {
/* 34:28 */     addHeader(this.nativePtr, name, value);
/* 35:   */   }
/* 36:   */   
/* 37:   */   private native String getHeader(long paramLong, String paramString);
/* 38:   */   
/* 39:   */   public String getHeader(String name)
/* 40:   */   {
/* 41:34 */     return getHeader(this.nativePtr, name);
/* 42:   */   }
/* 43:   */   
/* 44:   */   private native void delete(long paramLong);
/* 45:   */   
/* 46:   */   protected void finalize()
/* 47:   */   {
/* 48:39 */     delete(this.nativePtr);
/* 49:   */   }
/* 50:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneInfoMessageImpl
 * JD-Core Version:    0.7.0.1
 */