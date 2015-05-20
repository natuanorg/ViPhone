/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ import java.util.Vector;
/*   4:    */ 
/*   5:    */ public class Reason
/*   6:    */ {
/*   7:  6 */   private static Vector<Reason> values = new Vector();
/*   8: 10 */   public static Reason None = new Reason(0, "None");
/*   9: 14 */   public static Reason NoResponse = new Reason(1, "NoResponse");
/*  10: 18 */   public static Reason BadCredentials = new Reason(2, "BadCredentials");
/*  11: 22 */   public static Reason Declined = new Reason(3, "Declined");
/*  12: 26 */   public static Reason NotFound = new Reason(4, "NotFound");
/*  13: 30 */   public static Reason NotAnswered = new Reason(5, "NotAnswered");
/*  14: 34 */   public static Reason Busy = new Reason(6, "Busy");
/*  15: 38 */   public static Reason Media = new Reason(7, "Media");
/*  16: 42 */   public static Reason IOError = new Reason(8, "IOError");
/*  17: 46 */   public static Reason DoNotDisturb = new Reason(9, "DoNotDisturb");
/*  18: 50 */   public static Reason Unauthorized = new Reason(10, "Unauthorized");
/*  19: 54 */   public static Reason NotAcceptable = new Reason(11, "NotAcceptable");
/*  20: 58 */   public static Reason NoMatch = new Reason(12, "NoMatch");
/*  21: 62 */   public static Reason MovedPermanently = new Reason(13, "MovedPermanently");
/*  22: 66 */   public static Reason Gone = new Reason(14, "Gone");
/*  23: 70 */   public static Reason TemporarilyUnavailable = new Reason(15, "TemporarilyUnavailable");
/*  24: 74 */   public static Reason AddressIncomplete = new Reason(16, "AddressIncomplete");
/*  25: 78 */   public static Reason NotImplemented = new Reason(17, "NotImplemented");
/*  26: 82 */   public static Reason BadGateway = new Reason(18, "BadGateway");
/*  27: 86 */   public static Reason ServerTimeout = new Reason(19, "ServerTimeout");
/*  28: 90 */   public static Reason Unknown = new Reason(20, "Unknown");
/*  29:    */   protected final int mValue;
/*  30:    */   private final String mStringValue;
/*  31:    */   
/*  32:    */   private Reason(int value, String stringValue)
/*  33:    */   {
/*  34: 97 */     this.mValue = value;
/*  35: 98 */     values.addElement(this);
/*  36: 99 */     this.mStringValue = stringValue;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public static Reason fromInt(int value)
/*  40:    */   {
/*  41:102 */     for (int i = 0; i < values.size(); i++)
/*  42:    */     {
/*  43:103 */       Reason state = (Reason)values.elementAt(i);
/*  44:104 */       if (state.mValue == value) {
/*  45:104 */         return state;
/*  46:    */       }
/*  47:    */     }
/*  48:106 */     throw new RuntimeException("Reason not found [" + value + "]");
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String toString()
/*  52:    */   {
/*  53:110 */     return this.mStringValue;
/*  54:    */   }
/*  55:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.Reason
 * JD-Core Version:    0.7.0.1
 */