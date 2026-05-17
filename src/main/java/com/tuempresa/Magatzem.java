package com.tuempresa;

class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    // El método principal ahora solo tiene una responsabilidad: iterar
    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            actualitzarArticleIndividual(articles[i]);
        }
    }

    // Trasladamos TODO el bloque interno del for original aquí dentro
    private void actualitzarArticleIndividual(Article article) {
        if (!article.nom.equals("Formatge Gidurat") && !article.nom.equals("Entrades per al Concert del Trobador")) {
            if (article.qualitat > 0) {
                if (!article.nom.equals("Martell de Thor (Llegendari)")) {
                    article.qualitat = article.qualitat - 1;
                }
            }
        } else {
            if (article.qualitat < 50) {
                article.qualitat = article.qualitat + 1;

                if (article.nom.equals("Entrades per al Concert del Trobador")) {
                    if (article.diesPerVendre < 11) {
                        if (article.qualitat < 50) {
                            article.qualitat = article.qualitat + 1;
                        }
                    }
                    if (article.diesPerVendre < 6) {
                        if (article.qualitat < 50) {
                            article.qualitat = article.qualitat + 1;
                        }
                    }
                }
            }
        }

        if (!article.nom.equals("Martell de Thor (Llegendari)")) {
            article.diesPerVendre = article.diesPerVendre - 1;
        }

        if (article.diesPerVendre < 0) {
            if (!article.nom.equals("Formatge Gidurat")) {
                if (!article.nom.equals("Entrades per al Concert del Trobador")) {
                    if (article.qualitat > 0) {
                        if (!article.nom.equals("Martell de Thor (Llegendari)")) {
                            article.qualitat = article.qualitat - 1;
                        }
                    }
                } else {
                    article.qualitat = 0;
                }
            } else {
                if (article.qualitat < 50) {
                    article.qualitat = article.qualitat + 1;
                }
            }
        }
    }
}