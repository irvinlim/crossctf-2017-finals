package govtech.xctf;

import java.io.PrintStream;

public class NothingImportant {
    public NothingImportant() {
    }

    private static final java.util.Random s_random = new java.util.Random(System.currentTimeMillis());

    public static String md5(String paramString) {
        java.security.MessageDigest localMessageDigest = null;
        try {
            localMessageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (Exception localException) {
            localException.printStackTrace(System.out);
        }
        localMessageDigest.update(paramString.getBytes());
        byte[] arrayOfByte1 = localMessageDigest.digest();
        StringBuffer localStringBuffer = new StringBuffer();
        for (int k : arrayOfByte1) {
            localStringBuffer.append(String.format("%02x", new Object[]{Integer.valueOf(k & 0xFF)}));
        }
        return localStringBuffer.toString();
    }

    public static void main(String[] args) {
        march_on("flag1{7171a60f8cf4a789b7fa5906aa78f3e7}");
    }


    public static void march_on(String paramString) {
        String[] arrayOfString = new String[6];
        arrayOfString[0] = "If he is not expecting the unexpected, he will not find it.\nIt is not to be reached by search or trail.";
        arrayOfString[1] = "I am getting impatient.";
        arrayOfString[2] = "Try harder";
        arrayOfString[3] = "You can replace it";
        arrayOfString[4] = "Be patience";
        arrayOfString[5] = "Are you sure?";

        String str = "00000";
        int i = 0;
        long l1 = 0L;
        long l2 = 0L;

        for (int j = 0; j < 100000000; j++) {
            long l3 = (int) (s_random.nextFloat() * 1000.0F);
            if (j % 10 == 0) {
                System.out.println(arrayOfString[(j % arrayOfString.length)]);
            }
            l1 = System.currentTimeMillis();
//            try {
//                Thread.sleep(l3);
//            } catch (Exception localException) {
//                localException.printStackTrace(System.out);
//            }
            l2 = System.currentTimeMillis();
            long l4 = l2 - l1;
//            if (l4 < l3) {
//                System.out.println("No Cheating...");
//                System.exit(1);
//            } else if (l4 == l3) {
            paramString = md5(paramString + j);
            if ((paramString.startsWith(str)) && (i == 0)) {
                break;
            }
//            } else {
//                i = 1;
//            }
        }
//        if (i == 1) {
//            System.out.println("I am very impressed with your patience. But ... no...");

        if (paramString.startsWith(str)) {
            System.out.println("flag2{" + paramString + "}");
        }
    }
}
