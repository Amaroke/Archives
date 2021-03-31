package reseau.tests;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class TestAdresse {
    public static void main(String[] args) {
        testGetNbreOctets();
        testSize();
        testMasquer();
        testInverser();
        testSetOctets();
        testSetOctet();
        testToString();
    }

    private static void testSize() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        assert (adresseDeuxOctets.size() == 16)
                : "Il y a un probleme pour la size d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        assert (adresseQuatreOctets.size() == 32)
                : "Il y a un probleme pour la size d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        assert (adresseAdresse.size() == 32)
                : "Il y a un probleme pour la size d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        assert (adresseHuitBits.size() == 8)
                : "Il y a un probleme pour la size d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        assert (adresseSeizeBits.size() == 16)
                : "Il y a un probleme pour la size d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        assert (adresseSeizeBitsHuitAUn.size() == 16)
                : "Il y a un probleme pour la size d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        assert (adresseSeizeBitsDixAUn.size() == 16)
                : "Il y a un probleme pour la size d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        assert (adresseStrUn.size() == 32)
                : "Il y a un probleme pour la size d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        assert (adresseStrDeux.size() == 32)
                : "Il y a un probleme pour la size d'une adresse construite avec une chaine de 4 octets";
    }

    private static void testGetNbreOctets() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        assert (adresseDeuxOctets.getNbreOctets() == 2)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        assert (adresseQuatreOctets.getNbreOctets() == 4)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        assert (adresseAdresse.getNbreOctets() == 4)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        assert (adresseHuitBits.getNbreOctets() == 1)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        assert (adresseSeizeBits.getNbreOctets() == 2)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        assert (adresseSeizeBitsHuitAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        assert (adresseSeizeBitsDixAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        assert (adresseStrUn.getNbreOctets() == 4)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        assert (adresseStrDeux.getNbreOctets() == 4)
                : "Il y a un probleme pour le nombre d'octet d'une adresse construite avec une chaine de 4 octets";
    }

    private static void testMasquer() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        adresseDeuxOctets.masquer(new Adresse(tabDeuxOctets));
        assert (adresseDeuxOctets.getNbreOctets() == 2)
                : "Il y a un probleme pour le masque d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        adresseQuatreOctets.masquer(new Adresse("0.0.255.255"));
        assert (adresseQuatreOctets.getNbreOctets() == 4)
                : "Il y a un probleme pour le masque d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        adresseAdresse.masquer(new Adresse("0.0.255.255"));
        assert (adresseAdresse.getNbreOctets() == 4)
                : "Il y a un probleme pour le masque d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        adresseHuitBits.masquer(new Adresse(new Octet()));
        assert (adresseHuitBits.getNbreOctets() == 1)
                : "Il y a un probleme pour le masque d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        adresseSeizeBits.masquer(new Adresse(new Adresse(tabDeuxOctets)));
        assert (adresseSeizeBits.getNbreOctets() == 2)
                : "Il y a un probleme pour le masque d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        adresseSeizeBitsHuitAUn.masquer(new Adresse(tabDeuxOctets));
        assert (adresseSeizeBitsHuitAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le masque d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        adresseSeizeBitsDixAUn.masquer(new Adresse(tabDeuxOctets));
        assert (adresseSeizeBitsDixAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le masque d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        adresseStrUn.masquer(new Adresse("0.0.255.255"));
        assert (adresseStrUn.getNbreOctets() == 4)
                : "Il y a un probleme pour le masque d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        adresseStrDeux.masquer(new Adresse("0.0.255.255"));
        assert (adresseStrDeux.getNbreOctets() == 4)
                : "Il y a un probleme pour le masque d'une adresse construite avec une chaine de 4 octets";
    }

    private static void testInverser() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        adresseDeuxOctets.inverser();
        assert (adresseDeuxOctets.getNbreOctets() == 2)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        adresseQuatreOctets.inverser();
        assert (adresseQuatreOctets.getNbreOctets() == 4)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        adresseAdresse.inverser();
        assert (adresseAdresse.getNbreOctets() == 4)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        adresseHuitBits.inverser();
        assert (adresseHuitBits.getNbreOctets() == 1)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        adresseSeizeBits.inverser();
        assert (adresseSeizeBits.getNbreOctets() == 2)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        adresseSeizeBitsHuitAUn.inverser();
        assert (adresseSeizeBitsHuitAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        adresseSeizeBitsDixAUn.inverser();
        assert (adresseSeizeBitsDixAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        adresseStrUn.inverser();
        assert (adresseStrUn.getNbreOctets() == 4)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        adresseStrDeux.inverser();
        assert (adresseStrDeux.getNbreOctets() == 4)
                : "Il y a un probleme pour l'inversion d'une adresse construite avec une chaine de 4 octets";
    }

    private static void testSetOctets() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        adresseDeuxOctets.setOctets(tabDeuxOctets);
        assert (adresseDeuxOctets.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        adresseQuatreOctets.setOctets(tabDeuxOctets);
        assert (adresseQuatreOctets.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        adresseAdresse.setOctets(tabDeuxOctets);
        assert (adresseAdresse.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        adresseHuitBits.setOctets(new Octet());
        assert (adresseHuitBits.getNbreOctets() == 1)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        adresseSeizeBits.setOctets(tabDeuxOctets);
        assert (adresseSeizeBits.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        adresseSeizeBitsHuitAUn.setOctets(tabDeuxOctets);
        assert (adresseSeizeBitsHuitAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        adresseSeizeBitsDixAUn.setOctets(tabDeuxOctets);
        assert (adresseSeizeBitsDixAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        adresseStrUn.setOctets(tabDeuxOctets);
        assert (adresseStrUn.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        adresseStrDeux.setOctets(tabDeuxOctets);
        assert (adresseStrDeux.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'octets d'une adresse construite avec une chaine de 4 octets";
    }

    private static void testSetOctet() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        adresseDeuxOctets.setOctet(new Octet(), 0);
        assert (adresseDeuxOctets.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        adresseQuatreOctets.setOctet(new Octet(), 0);
        assert (adresseQuatreOctets.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        adresseAdresse.setOctet(new Octet(), 0);
        assert (adresseAdresse.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        adresseHuitBits.setOctet(new Octet(), 0);
        assert (adresseHuitBits.getNbreOctets() == 1)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        adresseSeizeBits.setOctet(new Octet(), 0);
        assert (adresseSeizeBits.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        adresseSeizeBitsHuitAUn.setOctet(new Octet(), 0);
        assert (adresseSeizeBitsHuitAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        adresseSeizeBitsDixAUn.setOctet(new Octet(), 0);
        assert (adresseSeizeBitsDixAUn.getNbreOctets() == 2)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        adresseStrUn.setOctet(new Octet(), 0);
        assert (adresseStrUn.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        adresseStrDeux.setOctet(new Octet(), 0);
        assert (adresseStrDeux.getNbreOctets() == 4)
                : "Il y a un probleme pour le set d'un octet d'une adresse construite avec une chaine de 4 octets";
    }

    private static void testToString() {
        Octet[] tabDeuxOctets = { new Octet(), new Octet() };
        Octet[] tabQuatreOctets = { new Octet(), new Octet(), new Octet(), new Octet() };
        Adresse adresseDeuxOctets = new Adresse(tabDeuxOctets);
        assert (adresseDeuxOctets.toString().equals("0.0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec deux octets";
        Adresse adresseQuatreOctets = new Adresse(tabQuatreOctets);
        assert (adresseQuatreOctets.toString().equals("0.0.0.0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec quatre octets";
        Adresse adresseAdresse = new Adresse(adresseQuatreOctets);
        assert (adresseAdresse.toString().equals("0.0.0.0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec une adresse";
        Adresse adresseHuitBits = new Adresse(8);
        assert (adresseHuitBits.toString().equals("0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec huit bits";
        Adresse adresseSeizeBits = new Adresse(16);
        assert (adresseSeizeBits.toString().equals("0.0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec seize bits";
        Adresse adresseSeizeBitsHuitAUn = new Adresse(16, 8);
        assert (adresseSeizeBitsHuitAUn.toString().equals("255.0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec seize bits et huit à un";
        Adresse adresseSeizeBitsDixAUn = new Adresse(16, 10);
        assert (adresseSeizeBitsDixAUn.toString().equals("255.192"))
                : "Il y a un probleme pour le toString d'une adresse construite avec seize bits et dix à un";
        Adresse adresseStrUn = new Adresse("0.0.0.0");
        assert (adresseStrUn.toString().equals("0.0.0.0"))
                : "Il y a un probleme pour le toString d'une adresse construite avec une chaine de 4 octets nuls";
        Adresse adresseStrDeux = new Adresse("192.168.1.1");
        assert (adresseStrDeux.toString().equals("192.168.1.1"))
                : "Il y a un probleme pour le toString d'une adresse construite avec une chaine de 4 octets";
    }
}
