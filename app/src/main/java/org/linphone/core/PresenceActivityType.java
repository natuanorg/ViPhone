/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public enum PresenceActivityType
/*   4:    */ {
/*   5: 25 */   Offline(0),  Online(1),  Appointment(2),  Away(3),  Breakfast(4),  Busy(5),  Dinner(6),  Holiday(7),  InTransit(8),  LookingForWork(9),  Lunch(10),  Meal(11),  Meeting(12),  OnThePhone(13),  Other(14),  Performance(15),  PermanentAbsence(16),  Playing(17),  Presentation(18),  Shopping(19),  Sleeping(20),  Spectator(21),  Steering(22),  Travel(23),  TV(24),  Unknown(25),  Vacation(26),  Working(27),  Worship(28),  Invalid(29);
/*   6:    */   
/*   7:    */   protected final int mValue;
/*   8:    */   
/*   9:    */   private PresenceActivityType(int value)
/*  10:    */   {
/*  11: 96 */     this.mValue = value;
/*  12:    */   }
/*  13:    */   
/*  14:    */   public int toInt()
/*  15:    */   {
/*  16:100 */     return this.mValue;
/*  17:    */   }
/*  18:    */   
/*  19:    */   protected static PresenceActivityType fromInt(int value)
/*  20:    */   {
/*  21:104 */     switch (value)
/*  22:    */     {
/*  23:    */     case 0: 
/*  24:105 */       return Offline;
/*  25:    */     case 1: 
/*  26:106 */       return Online;
/*  27:    */     case 2: 
/*  28:107 */       return Appointment;
/*  29:    */     case 3: 
/*  30:108 */       return Away;
/*  31:    */     case 4: 
/*  32:109 */       return Breakfast;
/*  33:    */     case 5: 
/*  34:110 */       return Busy;
/*  35:    */     case 6: 
/*  36:111 */       return Dinner;
/*  37:    */     case 7: 
/*  38:112 */       return Holiday;
/*  39:    */     case 8: 
/*  40:113 */       return InTransit;
/*  41:    */     case 9: 
/*  42:114 */       return LookingForWork;
/*  43:    */     case 10: 
/*  44:115 */       return Lunch;
/*  45:    */     case 11: 
/*  46:116 */       return Meal;
/*  47:    */     case 12: 
/*  48:117 */       return Meeting;
/*  49:    */     case 13: 
/*  50:118 */       return OnThePhone;
/*  51:    */     case 14: 
/*  52:119 */       return Other;
/*  53:    */     case 15: 
/*  54:120 */       return Performance;
/*  55:    */     case 16: 
/*  56:121 */       return PermanentAbsence;
/*  57:    */     case 17: 
/*  58:122 */       return Playing;
/*  59:    */     case 18: 
/*  60:123 */       return Presentation;
/*  61:    */     case 19: 
/*  62:124 */       return Shopping;
/*  63:    */     case 20: 
/*  64:125 */       return Sleeping;
/*  65:    */     case 21: 
/*  66:126 */       return Spectator;
/*  67:    */     case 22: 
/*  68:127 */       return Steering;
/*  69:    */     case 23: 
/*  70:128 */       return Travel;
/*  71:    */     case 24: 
/*  72:129 */       return TV;
/*  73:    */     case 25: 
/*  74:130 */       return Unknown;
/*  75:    */     case 26: 
/*  76:131 */       return Vacation;
/*  77:    */     case 27: 
/*  78:132 */       return Working;
/*  79:    */     case 28: 
/*  80:133 */       return Worship;
/*  81:    */     }
/*  82:134 */     return Invalid;
/*  83:    */   }
/*  84:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceActivityType
 * JD-Core Version:    0.7.0.1
 */