package reseau.tests;

import reseau.Message;
import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class TestMessage {
        public static void main(String[] args) {
                testSize();
                testGetOctet();
                testAjouterShort();
                testAjouterInt();
                testAjouterOctet();
                testAjouterAdresse();
                testToString();
                testExtraireEntier();
                testExtraireChaine();
                testAugmenter();
                testSupprimer();
                testSupprimerBorne();
        }

        private static void testSize() {
                Message messageVide = new Message();
                assert (messageVide.size() == 0) : "Il y a un probleme pour la size d'un message construit sans rien";
                Message messageMessage = new Message(messageVide);
                assert (messageMessage.size() == 0)
                                : "Il y a un probleme pour la size d'un message construit a partir d'un message";
                Message messageShort = new Message((short) 10);
                assert (messageShort.size() == 1)
                                : "Il y a un probleme pour la size d'un message construit avec un short";
                Message messageInt = new Message(10);
                assert (messageInt.size() == 2) : "Il y a un probleme pour la size d'un message construit avec un int";
               /* Message messageString = new Message("192.168.1.1");
                assert (messageString.size() == 4)
                                : "Il y a un probleme pour la size d'un message construit avec un string";*/
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                assert (messageAdresse.size() == 4)
                                : "Il y a un probleme pour la size d'un message construit avec une adresse";
        }

        private static void testGetOctet() {
                Message messageShort = new Message((short) 10);
                assert (messageShort.getOctet(0).getValue() == 10)
                                : "Il y a un probleme pour le get octet d'un message construit avec un short";
                Message messageInt = new Message(10);
                assert (messageInt.getOctet(0).getValue() == 0)
                                : "Il y a un probleme pour le get octet d'un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                assert (messageString.getOctet(0).getValue() == 192)
                                : "Il y a un probleme pour le get octet d'un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                assert (messageAdresse.getOctet(0).getValue() == 192)
                                : "Il y a un probleme pour la size d'un message construit avec une adresse";
        }

        private static void testAjouterShort() {
                Message messageVide = new Message();
                messageVide.ajouter((short) 2);
                assert (messageVide.size() == 1)
                                : "Il y a un probleme lors de l'ajout d'un short dans un message construit sans rien";
                Message messageMessage = new Message(messageVide);
                messageMessage.ajouter((short) 2);
                assert (messageMessage.size() == 2)
                                : "Il y a un probleme lors de l'ajout d'un short dans un message construit a partir d'un message";
                Message messageShort = new Message((short) 10);
                messageShort.ajouter((short) 2);
                assert (messageShort.size() == 2)
                                : "Il y a un probleme pour lors de l'ajout d'un short dans un message construit avec un short";
                Message messageInt = new Message(10);
                messageInt.ajouter((short) 2);
                assert (messageInt.size() == 3)
                                : "Il y a un probleme pour lors de l'ajout d'un short dans un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                messageString.ajouter((short) 2);
                assert (messageString.size() == 5)
                                : "Il y a un probleme pour lors de l'ajout d'un short dans un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                messageAdresse.ajouter((short) 2);
                assert (messageAdresse.size() == 5)
                                : "Il y a un probleme pour lors de l'ajout d'un short dans un message construit avec une adresse";
        }

        private static void testAjouterInt() {
                Message messageVide = new Message();
                messageVide.ajouter((int) 2);
                assert (messageVide.size() == 2)
                                : "Il y a un probleme lors de l'ajout d'un int dans un message construit sans rien";
                Message messageMessage = new Message(messageVide);
                messageMessage.ajouter((int) 2);
                assert (messageMessage.size() == 4)
                                : "Il y a un probleme lors de l'ajout d'un int dans un message construit a partir d'un message";
                Message messageShort = new Message((short) 10);
                messageShort.ajouter((int) 2);
                assert (messageShort.size() == 3)
                                : "Il y a un probleme pour lors de l'ajout d'un int dans un message construit avec un short";
                Message messageInt = new Message(10);
                messageInt.ajouter((int) 2);
                assert (messageInt.size() == 4)
                                : "Il y a un probleme pour lors de l'ajout d'un int dans un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                messageString.ajouter((int) 2);
                assert (messageString.size() == 6)
                                : "Il y a un probleme pour lors de l'ajout d'un int dans un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                messageAdresse.ajouter((int) 2);
                assert (messageAdresse.size() == 6)
                                : "Il y a un probleme pour lors de l'ajout d'un int dans un message construit avec une adresse";
        }

        private static void testAjouterOctet() {
                Message messageVide = new Message();
                messageVide.ajouter(new Octet(10));
                assert (messageVide.size() == 1)
                                : "Il y a un probleme lors de l'ajout d'un octet dans un message construit sans rien";
                Message messageMessage = new Message(messageVide);
                messageMessage.ajouter(new Octet(10));
                assert (messageMessage.size() == 2)
                                : "Il y a un probleme lors de l'ajout d'un octet dans un message construit a partir d'un message";
                Message messageShort = new Message((short) 10);
                messageShort.ajouter(new Octet(10));
                assert (messageShort.size() == 2)
                                : "Il y a un probleme pour lors de l'ajout d'un octet dans un message construit avec un short";
                Message messageInt = new Message(10);
                messageInt.ajouter(new Octet(10));
                assert (messageInt.size() == 3)
                                : "Il y a un probleme pour lors de l'ajout d'un octet dans un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                messageString.ajouter(new Octet(10));
                assert (messageString.size() == 5)
                                : "Il y a un probleme pour lors de l'ajout d'un octet dans un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                messageAdresse.ajouter(new Octet(10));
                assert (messageAdresse.size() == 5)
                                : "Il y a un probleme pour lors de l'ajout d'un octet dans un message construit avec une adresse";
        }

        private static void testAjouterAdresse() {
                Message messageVide = new Message();
                messageVide.ajouter(new Adresse("10.10.10.10"));
                assert (messageVide.size() == 4)
                                : "Il y a un probleme lors de l'ajout d'une adresse dans un message construit sans rien";
                Message messageMessage = new Message(messageVide);
                messageMessage.ajouter(new Adresse("10.10.10.10"));
                assert (messageMessage.size() == 8)
                                : "Il y a un probleme lors de l'ajout d'une adresse dans un message construit a partir d'un message";
                Message messageShort = new Message((short) 10);
                messageShort.ajouter(new Adresse("10.10.10.10"));
                assert (messageShort.size() == 5)
                                : "Il y a un probleme pour lors de l'ajout d'une adresse dans un message construit avec un short";
                Message messageInt = new Message(10);
                messageInt.ajouter(new Adresse("10.10.10.10"));
                assert (messageInt.size() == 6)
                                : "Il y a un probleme pour lors de l'ajout d'une adresse dans un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                messageString.ajouter(new Adresse("10.10.10.10"));
                assert (messageString.size() == 8)
                                : "Il y a un probleme pour lors de l'ajout d'une adresse dans un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                messageAdresse.ajouter(new Adresse("10.10.10.10"));
                assert (messageAdresse.size() == 8)
                                : "Il y a un probleme pour lors de l'ajout d'une adresse dans un message construit avec une adresse";
        }

        private static void testToString() {
                Message messageVide = new Message();
                assert (messageVide.toString().equals(""))
                                : "Il y a un probleme pour le toString d'un message construit sans rien";
                Message messageMessage = new Message(messageVide);
                assert (messageMessage.toString().equals(""))
                                : "Il y a un probleme pour le toString d'un message construit a partir d'un message";
                Message messageShort = new Message((short) 10);
                assert (messageShort.toString().equals("10"))
                                : "Il y a un probleme pour le toString d'un message construit avec un short";
                Message messageInt = new Message(10);
                assert (messageInt.toString().equals("0.10"))
                                : "Il y a un probleme pour la size d'un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                assert (messageString.toString().equals("192.168.1.1"))
                                : "Il y a un probleme pour le toString d'un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                assert (messageAdresse.toString().equals("192.168.1.1"))
                                : "Il y a un probleme pour le toString d'un message construit avec une adresse";
        }

        private static void testExtraireEntier() {
                Message messageInt = new Message((int) 10);
                assert (messageInt.extraireEntier(0) == 10)
                                : "Il y a un probleme pour le extraire entier  d'un message construit avec un int";
                Message messageString = new Message("0.168.1.1");
                assert (messageString.extraireEntier(0) == 168)
                                : "Il y a un probleme pour le extraire entier d'un message construit avec un string";
                Adresse adr = new Adresse("0.168.1.1");
                Message messageAdresse = new Message(adr);
                assert (messageAdresse.extraireEntier(0) == 168)
                                : "Il y a un probleme pour le extraire entier  d'un message construit avec une adresse";
        }

        private static void testExtraireChaine() {
                //Je ne sais pas ce qui correspond à un caractère je ne sais donc pas tester cette fonction.
        }

        private static void testAugmenter() {
                //Je ne sais pas non plus comment comparer deux Message et donc comment tester augmenter.
        }

        private static void testSupprimer() {
                Message messageShort = new Message((short) 10);
                messageShort.supprimer(1);
                assert (messageShort.size() == 0)
                                : "Il y a un probleme pour la suppresion d'un message construit avec un short";
                Message messageInt = new Message(10);
                messageInt.supprimer(1);
                assert (messageInt.size() == 1) : "Il y a un probleme pour la suppresion d'un message construit avec un int";
                Message messageString = new Message("192.168.1.1");
                messageString.supprimer(1);
                assert (messageString.size() == 3)
                                : "Il y a un probleme pour la suppresion d'un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                messageAdresse.supprimer(1);
                assert (messageAdresse.size() == 3)
                                : "Il y a un probleme pour la suppresion d'un message construit avec une adresse";
        }

        private static void testSupprimerBorne() {
                Message messageString = new Message("192.168.1.1");
                messageString.supprimer(0,1);
                assert (messageString.size() == 2)
                                : "Il y a un probleme pour la suppresion d'un message construit avec un string";
                Adresse adr = new Adresse("192.168.1.1");
                Message messageAdresse = new Message(adr);
                messageAdresse.supprimer(0,1);
                assert (messageAdresse.size() == 2)
                                : "Il y a un probleme pour la suppresion d'un message construit avec une adresse";
        }
}
