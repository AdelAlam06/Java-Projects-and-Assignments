import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabThreeTest 
{
    @Test public void testReverseVowels01() { assertEquals("", LabThree.reverseVowels("")); }
    @Test public void testReverseVowels02() { assertEquals("e", LabThree.reverseVowels("e")); }
    @Test public void testReverseVowels03() { assertEquals("X", LabThree.reverseVowels("X")); }
    @Test public void testReverseVowels04() { assertEquals("Au", LabThree.reverseVowels("Ua")); }
    @Test public void testReverseVowels05() { assertEquals("eI", LabThree.reverseVowels("iE")); }
    @Test public void testReverseVowels06() { assertEquals("cDfghklM", LabThree.reverseVowels("cDfghklM")); }
    @Test public void testReverseVowels07() { assertEquals("LOL", LabThree.reverseVowels("LOL")); }
    @Test public void testReverseVowels08() { assertEquals("Jova, Pythan, C", LabThree.reverseVowels("Java, Python, C")); }
    @Test public void testReverseVowels09() { assertEquals("Wuuleemoolaa", LabThree.reverseVowels("Waaloomeeluu")); }
    @Test public void testReverseVowels10() { assertEquals("ThIs As LaKa ElL sIrCiStIc", LabThree.reverseVowels("ThIs Is LiKe AlL sArCaStIc")); }
    @Test public void testReverseVowels11() { assertEquals("Ent, uat, boa, oka", LabThree.reverseVowels("Ant, oat, boa, uke")); }
    @Test public void testReverseVowels12() { assertEquals("Stix nix hix pix", LabThree.reverseVowels("Stix nix hix pix")); }
    @Test public void testReverseVowels13() { assertEquals("UoIeAxxxuOiEa", LabThree.reverseVowels("AeIoUxxxaEiOu")); }
    @Test public void testReverseVowels14() { assertEquals("Lettor Y as not i vewel", LabThree.reverseVowels("Letter Y is not a vowel")); }
    @Test public void testReverseVowels15() { assertEquals("lewercoselettersanlyhero", LabThree.reverseVowels("lowercaselettersonlyhere")); }
    @Test public void testReverseVowels16() { assertEquals("!@#$%^&*(){}:;'[]'", LabThree.reverseVowels("!@#$%^&*(){}:;'[]'")); }  
}

