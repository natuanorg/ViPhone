/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class LinphoneBufferImpl
/*  4:   */   implements LinphoneBuffer
/*  5:   */ {
/*  6:   */   private byte[] mData;
/*  7:   */   private int mSize;
/*  8:   */   
/*  9:   */   public LinphoneBufferImpl(byte[] data, int size)
/* 10:   */   {
/* 11: 9 */     this.mData = data;
/* 12:10 */     this.mSize = size;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public byte[] getContent()
/* 16:   */   {
/* 17:15 */     return this.mData;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setContent(byte[] data)
/* 21:   */   {
/* 22:20 */     this.mData = data;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int getSize()
/* 26:   */   {
/* 27:25 */     return this.mSize;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setSize(int size)
/* 31:   */   {
/* 32:30 */     this.mSize = size;
/* 33:   */   }
/* 34:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneBufferImpl
 * JD-Core Version:    0.7.0.1
 */