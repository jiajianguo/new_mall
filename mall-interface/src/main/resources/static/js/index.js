"use strict";
$(function () {
    window.SAIL_ENV.language = {
        en: {
            btn_add_to_cart: "Add To Cart",
            btn_sold_out: "SOLD OUT",
            btn_unavailable: "Unavailable",
            btn_buy: "BUY",
            btn_complete_order: "Complete order",
            add_selected_to_cart: "ADD SELECTED TO CART",
            sale_discount: "limited offer",
            max_inventory: "Maximum quantity available reached.",
            cart_express: "Calculate Shipping",
            cart_express_hide: "Hide shipping calculator",
            menu: "Menu",
            refresh_recommend: "Don't like these?",
            save: "Save",
            reviews: "reviews",
            order_show: "Show order summary",
            order_hide: "Hide order summary",
            valid_email: "Enter a valid email",
            erro_email: "Wrong email format",
            subscribe: "Thanks for subscribing",
            max_255: "maximum is 255 characters",
            max_40: "maximum is 40 characters",
            free: "Free",
            calculated: "Calculated at next step",
            phone_place: "Phone (Optional)",
            other_address: "Apartment, suite, etc.",
            new_address: "New address",
            paypal: "Authorized by PayPal",
            no_logistics: "We don't currently ship to this country / region. Enter a new shipping address and try again.",
            select_province: "Select a state / province",
            select_country: "Select a  Country / Region",
            tax_number: "Enter a valid VAT NO.",
            google_map: "Please enter 4-200 characters to Automatically retrieve addresses.",
            google_map_suggestions: "Suggestions",
            btn_helpful: "helpful",
            feedback: "Thank you for your feedback.",
            required: "This field is required",
            max_upload: "Upload up to five times a day!",
            image_erro: "The image must be under 10MB",
            helpful: "One person found this helpful",
            people: "people",
            report_confirm: "Are you sure you want to report this review as inappropriate?",
            has_reported: "This review has been reported",
            report: "Report as Inappropriate",
            filpclock: "Your cart is expiring soon.",
            groups: "Please, select at least one variant.",
            groups_total_price: "Total price",
            discount: "Discount",
            placeholder_discount: "Discount code",
            tips_coupon_error_1: "This code did not match any active gift card or discount. Was it entered correctly?",
            tips_coupon_error_2: "discount code isn’t valid for the items in your cart",
            cod_tips: "In response to the request of Saudi Arabian customs, you are required to provide the consignee's ID number for customs declaration.",
            personal_id: "ID card",
            personal_id_num: "ID number",
            validation: {
                email: ["Enter a valid email", "Enter a valid email", "Please inpute between 2-200 characters only."],
                first_name: ["Enter a first name", "Enter a first name ", "Please inpute between 2-100 characters only."],
                last_name: ["Enter a last name", "Enter a last name ", "Please inpute between 2-50 characters only."],
                address: ["Enter an address", "Enter an address ", "Please inpute between 2-200 characters only."],
                other_address: ["Enter an apartment, suite, etc.", "Enter an apartment, suite, etc. ", "Please inpute between 2-200 characters only."],
                tax_number: ["Value Added Tax NO. must have 11 or 14 characters.", "Value Added Tax NO. must have 13-14 characters."],
                phone: ["Enter a valid phone number", "Enter a valid phone number", "Please inpute between 2-50 characters only."],
                zip_code: ["Enter a ZIP / postal code", "Enter a valid ZIP / postal code"],
                city: ["Enter a city", "Enter a city", "Please inpute between 2-100 characters only."],
                pay_card_number: ["Enter a card number", "Enter a first name", "Please inpute between 2-100 characters only."],
                pay_card_mmyy: ["Enter a card mmyy", "Enter a first name", "Please inpute between 2-100 characters only."],
                pay_card_cvv: ["Enter a card number", "Enter a first name", "Please inpute between 2-100 characters only."],
                cod_id: ["Please fill in the consignee's ID number, so that you can receive the parcel smoothly!", "Please fill in the consignee's ID number, so that you can receive the parcel smoothly!", "The format of the ID number that you input is wrong. Please fill in it accurately!"]
            },
            insurance_alert: "We advise you to take out freight insurance. If you do not take out freight insurance, we will not pay for the loss or damage",
            insurance_alert_ok: "ok",
            scroll_more: "Scroll for more items",
            state: "Province/State",
            qty: "Qty",
            at: "at",
            remove: "Remove",
            did_not_buy: "Didn't buy",
            expand_all_settings: "Expand all settings",
            collapse_all_settings: "Collapse all settings",
            no_shipping: "There are no shipping methods available for your cart or address",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">One person</span> found this helpful' : '<span class="J-helpfulNum">' + e + " people</span> found this helpful"
            },
            cart_express_num: function (e, t) {
                return "We found " + e + " shipping rates available for  " + t
            },
            cart_express_free: function (e) {
                return "Buy " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> more and get free shipping."
            },
            filpclock_forma_time: function (e) {
                return 'Your order is reserved for <span class="J-CountDown count-down-time">' + e + "</span> minutes!"
            },
            limitoffer: function (e) {
                return "Discount for the first " + e + " items"
            },
            tips_coupon_error_3: function (e) {
                return "Your cart does not meet the requirements for the <strong> " + e + " </strong> discount code"
            },
            inventory_limit: function (e, t, a) {
                return "You can only add " + e + " " + t + " -  " + a.replace(/·/g, " / ") + " to the cart."
            },
            sellable_inventory: function (e) {
                return e + " pieces available"
            },
            select_sku_attribute: function (e) {
                return "Please Select " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">Already have an account? <a href="/login?redirect_uri=' + e + '">log in</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">This code did not match any active gift card or discount. Was it entered correctly?</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips">Your cart does not meet the requirements for the <strong>' + t + "</strong> discount code</p>"
                }
                return a
            },
            product_lastSale: "recently purchased"
        }, de: {
            btn_add_to_cart: "IN DEN EINKAUFSWAGEN",
            btn_sold_out: "AUSVERKAUFT",
            btn_unavailable: "Unverfügbar",
            btn_buy: "KAUFEN",
            btn_complete_order: "Bestellung abschließen",
            add_selected_to_cart: "IN DEN EINKAUFSWAGEN",
            sale_discount: "limitiertes Angebot",
            max_inventory: "Maximale verfügbare Menge erreichen.",
            cart_express: "Versandkosten berechnen ",
            cart_express_hide: "Versandrechner ausblenden",
            menu: "Menü",
            refresh_recommend: "Wollen diese nicht?",
            save: "Speichern",
            reviews: "Rezensionen",
            order_show: "Bestellungsübersicht anzeigen",
            order_hide: "Bestellungsübersicht ausblenden",
            valid_email: "Eine gültige E-Mail-Adresse eingeben",
            erro_email: "Falsche E-Mail-Form",
            subscribe: "Danke fürs Abonnieren",
            max_255: "Maximal 255 Zeichen",
            max_40: "Maximal 40 Zeichen",
            free: "Kostenlos",
            calculated: "Im nächsten Schritt berechnen",
            phone_place: "Telefon (optional)",
            other_address: "Wohnung, Suite usw.",
            new_address: "Neue Adresse",
            paypal: "Autorisiert von PayPal",
            no_logistics: "Wir versenden derzeit nicht in dieses Land/diese Region. Geben Sie eine neue Lieferadresse ein und versuchen Sie es erneut.",
            select_province: "Ein Bundesland / eine Provinz auswählen",
            select_country: "Ein Land / eine Region auswählen",
            tax_number: "Eine gültige Umsatzsteuer-Identifikationsnummer eingeben.",
            google_map: "4-200 Zeichen zum automatischen Adressen Abrufen eingeben.",
            google_map_suggestions: "Vorschläge",
            btn_helpful: "helfend",
            feedback: "Danke für Ihre Rückmeldungen",
            required: "erforderliche Felder",
            max_upload: "Maximal fünf Mal am Tag hochladen!",
            image_erro: "Das Bild muss unter 10MB sein",
            helpful: "ein Person findet es hilfreich",
            people: "Personen",
            report_confirm: "Sind Sie sicher, diese Rezension als unangemessen melden zu wollen?",
            has_reported: "Diese Bewertung wurde gemeldet",
            report: "unangemessen melden",
            filpclock: "Ihr Einkaufswagen läuft bald ab",
            groups: "Mindestens eine Variante auswählen.",
            groups_total_price: "Gesamtpreis",
            placeholder_discount: "Rabattcode",
            discount: "Rabatt",
            tips_coupon_error_1: "Dieser Code stimmte mit keiner aktiven Geschenkkarte und keinem Rabatt überein. Sind sie richtig eingegeben?",
            tips_coupon_error_2: "Der Rabattcode gilt nicht für die Artikel in Ihrem Einkaufswagen",
            cod_tips: "Aufgrund der Anforderungen des saudi-arabischen Zolls müssen Sie bei dieser Bestellung die Personalausweis-Nummer des Empfängers für die Zollanmeldung angeben.",
            personal_id: "Personalausweis",
            personal_id_num: "Personalausweis-Nummer",
            validation: {
                email: ["Eine gültige E-Mail-Adresse eingeben", "Eine gültige E-Mail-Adresse eingeben", "Nur zwischen 2 und 200 Zeichen eingeben sollen"],
                first_name: ["Einen Vornamen eingeben", "Einen Vornamen eingeben", "Nur zwischen 2 und 100 Zeichen eingeben sollen."],
                last_name: ["Einen Nachnamen eingeben", "Einen Nachnamen eingeben", "Nur zwischen 2 und 50 Zeichen eingeben sollen."],
                address: ["Eine Adresse eingeben", "Eine Adresse eingeben", "Nur zwischen 2 und 200 Zeichen eingeben sollen."],
                other_address: ["Eine Wohnung, Suite usw eingeben.", "Eine Wohnung, Suite usw eingeben.", "Nur zwischen 2 und 200 Zeichen eingeben sollen."],
                tax_number: ["Mehrwertsteuer NR. muss 11 oder 14 Zeichen haben.", "Mehrwertsteuer NR. muss 13-14 Zeichen haben."],
                phone: ["Eine gültige Telefonnummer eigebenn", "Eine gültige Telefonnummer eigebenn", "Nur zwischen 2 und 50 Zeichen eingeben sollen."],
                zip_code: ["Eine Postleitzahl eingeben", "Eine Postleitzahl eingeben"],
                city: ["Eine Stadt eingeben", "Eine Stadt eingeben", "Nur zwischen 2 und 100 Zeichen eingeben sollen."],
                pay_card_number: ["Eine Kartennummer eingeben", "Eine Kartennummer eingeben", "Nur zwischen 2 und 100 Zeichen eingeben sollen."],
                pay_card_mmyy: ["Eine Karte mmyy eingeben", "Eine Karte mmyy eingeben", "Nur zwischen 2 und 100 Zeichen eingeben sollen."],
                pay_card_cvv: ["Eine Karte cvv eingeben", "Eine Karte cvv eingeben", "Nur zwischen 2 und 100 Zeichen eingeben sollen."],
                cod_id: ["Bitte geben Sie die Personalausweis-Nummer des Empfängers ein, damit Sie das Paket reibungslos erhalten können!", "Bitte geben Sie die Personalausweis-Nummer des Empfängers ein, damit Sie das Paket reibungslos erhalten können!", "Es liegt ein Fehler im Format der von Ihnen eingegebenen Personalausweis-Nummer vor. Bitte geben Sie diese korrekt ein!"]
            },
            insurance_alert: "Wir empfehlen Ihnen, eine Versandsversicherung abzuschließen. Wenn Sie keine Versandsversicherung abschließen, werden wir den Verlust oder die Beschädigung nicht bezahlen",
            insurance_alert_ok: "Okay",
            scroll_more: "Scrollen für mehrere Artikel",
            state: "Provinz/Staat",
            qty: "Qty",
            at: "für",
            remove: "Entfernen",
            did_not_buy: "Nicht gekauft",
            expand_all_settings: "Alle Einstellungen erweitern",
            collapse_all_settings: "Alle Einstellungen  zurückziehen",
            no_shipping: "Aucune méthode d'expédition n'est disponible pour votre panier ou votre adresse",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">ein Person</span> findet es hilfreich' : '<span class="J-helpfulNum">' + e + " Personen</span> finden es hilfreich"
            },
            cart_express_num: function (e, t) {
                return "Wir haben " + e + " Versandkosten für " + t + " gefunden"
            },
            cart_express_free: function (e) {
                return "Kaufen Sie für " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> und bekommen Sie einen kostenlosen Versand ."
            },
            filpclock_forma_time: function (e) {
                return 'Ihre Bestellung ist für <span class="J-CountDown count-down-time">' + e + "</span> Minuten reserviert!"
            },
            limitoffer: function (e) {
                return "Rabatt für die ersten " + e + " Artikel"
            },
            tips_coupon_error_3: function (e) {
                return "Ihr Einkaufswagen erfüllt nicht die Anforderungen für den Rabattcode <strong>" + e + "</strong>"
            },
            inventory_limit: function (e, t, a) {
                return "Nur " + e + " " + t + " -  " + a.replace(/·/g, " / ") + "  können in den Einkaufwagen gelegen werden."
            },
            sellable_inventory: function (e) {
                return e + " Verfügbare Stücke"
            },
            select_sku_attribute: function (e) {
                return "Bitte auswählen " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">Haben Sie bereits ein Konto? <a href="/login?redirect_uri=' + e + '">Anmeldung</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">Dieser Code stimmte mit keiner aktiven Geschenkkarte und keinem Rabatt überein. Sind sie richtig eingegeben?</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips">Ihr Einkaufswagen erfüllt nicht die Anforderungen für den Rabattcode <strong>' + t + "</strong></p>"
                }
                return a
            },
            product_lastSale: "vor kurzem gekauft"
        }, fr: {
            btn_add_to_cart: "AJOUTER AU PANIER",
            btn_sold_out: "Épuisé",
            btn_unavailable: "Non disponible",
            btn_buy: "ACHETER",
            btn_complete_order: "Finir la commande",
            add_selected_to_cart: "AJOUTER CHOISI AU PANIER",
            sale_discount: "offre limitée",
            max_inventory: "Quantité maximale disponible atteinte",
            cart_express: "Calculer le tarif d'expédition",
            cart_express_hide: "Masquer la calculatrice d'expédition",
            menu: "Menu",
            refresh_recommend: "Vous n'aimez pas ça?",
            save: "Sauvegarder",
            reviews: "Commentaires",
            order_show: "Afficher le récapitulatif de la commande",
            order_hide: "Masquer le récapitulatif  de la commande",
            valid_email: "Saisir un e-mail valide",
            erro_email: "Format d'e-mail incorrect",
            subscribe: "Merci pour votre souscription",
            max_255: "255 caractères maximum",
            max_40: "40 caractères maximum",
            free: "Gratuit",
            calculated: "Calculé à l'étape suivante",
            phone_place: "Téléphone (Optionnel)",
            other_address: "Appartement, suite, etc.",
            new_address: "Nouvelle adresse",
            paypal: "Autorisé par PayPal",
            no_logistics: "Nous ne livrons pas actuellement dans ce pays / région. Saisissez une nouvelle adresse d'expédition et réessayez.",
            select_province: "Choisir un état / une province",
            select_country: "Choisir un pays / une région",
            tax_number: "Saisir un numéro de TVA valide.",
            google_map: "Saisir 4-200 caractères pour récupérer automatiquement les adresses.",
            google_map_suggestions: "Suggestions",
            btn_helpful: "Utile",
            feedback: "Merci pour votre feed-back.",
            required: "Ce champ est requis",
            max_upload: "Télécharger jusqu'à cinq fois par jour!",
            image_erro: "Cette image doit être inférieure à 10MB",
            helpful: "Une personne a trouvé cela utile.",
            people: "personnes",
            report_confirm: "Sûr de signaler cet avis comme inapproprié?",
            has_reported: "Cet avis a été signalé",
            report: "Signaler comme inapproprié",
            filpclock: "Votre panier expire bientôt",
            groups: "Choisir au moins une variante.",
            groups_total_price: "Prix​total",
            placeholder_discount: "Code de discount",
            discount: "Discount",
            tips_coupon_error_1: "Ce code ne correspond à aucune carte-cadeau ni discount. Correctement saisi?",
            tips_coupon_error_2: "le code de discount est invalide pour les articles de votre panier",
            cod_tips: "En raison des exigences des douanes saoudiennes, vous devez fournir le numéro de la carte d'identité du destinataire de cette commande afin de faciliter la déclaration en douane.",
            personal_id: "Carte d'identité",
            personal_id_num: "Numéro de la carte d'identité",
            validation: {
                email: ["Saisir un e-mail valide", "Saisir un e-mail valide", "Saisir 2-200 caractères uniquement"],
                first_name: ["Saisir un prénom", "Saisir un prénom", "Saisir 2-100 caractères uniquement."],
                last_name: ["Saisir un prénom", "Saisir un prénom ", "Saisir 2-50 caractères uniquement"],
                address: ["Saisir une adresse", "Saisir une adresse", "Saisir 2-200 caractères uniquement"],
                other_address: ["Saisir un appartement, une suite, etc.", "Saisir un appartement, une suite, etc.", "Saisir 2-200 caractères uniquement"],
                tax_number: ["Le numéro de TVA doit comporter 11 ou 14 caractères.", "Le numéro de TVA doit comporter 13-14 caractères."],
                phone: ["Saisir un numéro de téléphone valide", "Saisir un numéro de téléphone valide", "Saisir 2-50 caractères uniquement"],
                zip_code: ["Saisir un code postal / ZIP", "Saisir un code postal / ZIP"],
                city: ["Saisir une ville", "Saisir une ville", "Saisir 2-100 caractères uniquement."],
                pay_card_number: ["Saisir un numéro de carte", "Saisir un numéro de carte", "Saisir 2-100 caractères uniquement."],
                pay_card_mmyy: ["Saisir une carte mmyy", "Saisir une carte mmyy", "Saisir 2-100 caractères uniquement."],
                pay_card_cvv: ["Saisir une carte cvv", "Saisir une carte cvv", "Saisir 2-100 caractères uniquement."],
                cod_id: ["Veuillez saisir le numéro de la carte d'identité du destinataire afin que vous puissiez recevoir le colis en douceur!", "Veuillez saisir le numéro de la carte d'identité du destinataire afin que vous puissiez recevoir le colis en douceur!", "Le format du numéro de la carte d'identité que vous avez saisi est incorrect. Veuillez saisir exactement!"]
            },
            insurance_alert: "Nous vous conseillons de souscrire une assurance d'envoi. Sans assurance d'envoi, nous ne prendrons pas en charge la perte ou les dommages",
            insurance_alert_ok: "Ok",
            scroll_more: "Faire défiler pour voir plus d'articles.",
            state: "Province / État",
            qty: "Qté",
            at: "à",
            remove: "Supprimer",
            did_not_buy: "Sans avoir acheté",
            expand_all_settings: "Dérouler tous les paramètres",
            collapse_all_settings: "Plier tous",
            no_shipping: "Aucune méthode d'expédition n'est disponible pour votre panier ou votre adresse",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">Une personne</span> a trouvé cela utile.' : '<span class="J-helpfulNum">' + e + " personnes</span> ont trouvé cela utile."
            },
            cart_express_num: function (e, t) {
                return "Nous avons trouvé " + e + " frais de livraison disponibles pour " + t
            },
            cart_express_free: function (e) {
                return "Acheter " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> plus pour l'expédition gratuite."
            },
            filpclock_forma_time: function (e) {
                return 'Votre commande est réservée pour <span class="J-CountDown count-down-time">' + e + "</span> minutes!"
            },
            limitoffer: function (e) {
                return "Discount pour les premiers " + e + " articles"
            },
            tips_coupon_error_3: function (e) {
                return "Votre panier ne répond pas aux exigences du code de discount <strong>" + e + "</strong>"
            },
            inventory_limit: function (e, t, a) {
                return "Vous pouvez seulement ajouter " + e + " " + t + " -  " + a.replace(/·/g, " / ") + "  au panier."
            },
            sellable_inventory: function (e) {
                return e + " pièces disponibles"
            },
            select_sku_attribute: function (e) {
                return "Choisir " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">Avez-vous déjà un compte? <a href="/login?redirect_uri=' + e + "\">S'identifier</a></div>"
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">Ce code ne correspond à aucune carte-cadeau ni discount. Correctement saisi?</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips">Votre panier ne répond pas aux exigences du code de discount <strong>' + t + "</strong></p>"
                }
                return a
            },
            product_lastSale: "a récemment acheté"
        }, it: {
            btn_add_to_cart: "Aggiugi al carrello",
            btn_sold_out: "ESAURITO",
            btn_unavailable: "Non disponibile",
            btn_buy: "ACQUISTA",
            btn_complete_order: "Ordine completo",
            add_selected_to_cart: "AGGIUNGI SELEZIONATO AL CARRELLO",
            sale_discount: "offerta limitata",
            max_inventory: "Raggiunta la quantità massima disponibile.",
            cart_express: "Calcola la Spedizione",
            cart_express_hide: "Nascondi la calcolatrice di spedizione",
            menu: "Menù",
            refresh_recommend: "Non ti piacciono questi?",
            save: "salva",
            reviews: "Recensioni",
            order_show: "Mostra riassunto dell'ordine",
            order_hide: "Nascondi riassunto dell'ordine",
            valid_email: "Inserisci un'e-mail valida",
            erro_email: "Formato e-mail errato",
            subscribe: "Grazie per l’iscrizione",
            max_255: "il massimo è di 255 caratteri",
            max_40: "il massimo è di 40 caratteri",
            free: "Gratis",
            calculated: "Calcolato al passo successivo",
            phone_place: "Telefono (Opzionale)",
            other_address: "Appartamento, camera, ecc.",
            new_address: "Nuovo indirizzo",
            paypal: "Autorizzato da PayPal",
            no_logistics: "Attualmente non effettuiamo spedizioni in questo paese/regione. Inserisci un nuovo indirizzo di spedizione e riprova.",
            select_province: "Seleziona uno stato / provincia",
            select_country: "Seleziona un Paese / Regione",
            tax_number: "Inserire un numero di partita IVA valido.",
            google_map: "Inserisci 4-200 caratteri per richiamare automaticamente gli indirizzi.",
            google_map_suggestions: "Suggerimenti",
            btn_helpful: "Utile",
            feedback: "Grazie per il tuo feedback",
            required: "Questo campo è obbligatorio",
            max_upload: "Carica fino a cinque volte al giorno!",
            image_erro: "L'immagine deve essere inferiore a 10MB ",
            helpful: "Una persona ha trovato utile questo",
            people: "persone",
            report_confirm: "Sei sicuro di voler segnalare questa recensione come inappropriata?",
            has_reported: "Questa recensione è stata riportata",
            report: "Segnala come Inappropriata",
            filpclock: "Your cart is expiring soon.",
            groups: "Il tuo carrello scade presto.",
            groups_total_price: "Prezzo totale",
            discount: "Sconto",
            placeholder_discount: "Codice sconto",
            tips_coupon_error_1: "Questo codice non corrisponde a nessuna carta regalo o sconto attivo. È stato inserito correttamente?",
            tips_coupon_error_2: "il codice sconto non è valido per gli articoli nel carrello",
            cod_tips: "Secondo i requisiti della dogana dell'Arabia Saudita, questo ordine richiede di fornire il numero della carta d'identità del destinatario per comodità di dichiarazione al momento dell'ingresso.",
            personal_id: "carta d'identità",
            personal_id_num: "numero della carta d'identità",
            validation: {
                email: ["Inserisci un'e-mail valida", "Inserisci un'e-mail valida", "Si prega di inserire solo tra 2-200 caratteri"],
                first_name: ["Inserisci un nome", "Inserisci un nome", "Si prega di inserire solo tra 2-100 caratteri."],
                last_name: ["Inserisci un cognome", "Inserisci un cognome", "Si prega di inserire solo tra 2-50 caratteri"],
                address: ["Inserisci un indirizzo", "Inserisci un indirizzo", "Si prega di inserire solo tra 2-200 caratteri."],
                other_address: ["Inserisci un appartamento, una camera, ecc.", "Inserisci un appartamento, una camera, ecc.", "Si prega di inserire solo tra 2-200 caratteri."],
                tax_number: ["Il codice fiscale sul valore aggiunto deve avere 11 o 14 caratteri.", "Il codice fiscale sul valore aggiunto deve avere 13-14 caratteri."],
                phone: ["Inserisci un numero di telefono valido", "Inserisci un numero di telefono valido", "Si prega di inserire solo tra 2-50 caratteri."],
                zip_code: ["Inserisci un CAP / codice postale.", "Inserisci un CAP / codice postale."],
                city: ["Inserisci una città", "Inserisci una città", "Si prega di inserire solo tra 2-100 caratteri."],
                pay_card_number: ["Inserisci un numero di carta", "Inserisci un numero di carta", "Si prega di inserire solo tra 2-100 caratteri."],
                pay_card_mmyy: ["Inserisci un mmyy di carta", "Inserisci un mmyy di carta", "Si prega di inserire solo tra 2-100 caratteri."],
                pay_card_cvv: ["Inserisci un cvv di carta", "Inserisci un cvv di carta", "Si prega di inserire solo tra 2-100 caratteri."],
                cod_id: ["Si prega di inserire corettamente il numero della carta d'identità del destinatario in modo da poter ricevere il pacco senza problemi!", "Si prega di inserire corettamente il numero della carta d'identità del destinatario in modo da poter ricevere il pacco senza problemi!", "Il formato del numero della carta d'identità che hai inserito è sbagliato, compila correttamente!"]
            },
            insurance_alert: "Ti consigliamo di stipulare un'assicurazione per il trasporto merci. Se non si stipula un'assicurazione per il trasporto, non pagheremo la perdita o il danno",
            insurance_alert_ok: "ok",
            scroll_more: "Scorrere per altri articoli",
            state: "Provincia/Stato",
            qty: "Q.tà",
            at: "di",
            remove: "Rimuovi",
            did_not_buy: "Non acquistato",
            expand_all_settings: "Espandi tutte le impostazioni",
            collapse_all_settings: "Chiudi tutte le impostazioni",
            no_shipping: "Non ci sono metodi di spedizione disponibili per il tuo carrello o indirizzo",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">Una persona</span> ha trovato utile questo' : '<span class="J-helpfulNum">' + e + " people</span> persone lo hanno trovato utile"
            },
            cart_express_num: function (e, t) {
                return "Abbiamo trovato " + e + " tariffe di spedizione disponibili per " + t
            },
            cart_express_free: function (e) {
                return "Acquista " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> di più per ottenere la spedizione gratuita."
            },
            filpclock_forma_time: function (e) {
                return 'Il tuo ordine è riservato per <span class="J-CountDown count-down-time">' + e + "</span> minuti!"
            },
            limitoffer: function (e) {
                return "Sconto per i primi " + e + " articoli"
            },
            tips_coupon_error_3: function (e) {
                return "Il tuo carrello non soddisfa i requisiti per <strong> " + e + " </strong> codice sconto"
            },
            inventory_limit: function (e, t, a) {
                return "Puoi solo aggiungere " + e + " " + t + " -  " + a.replace(/·/g, " / ") + " al carrello."
            },
            sellable_inventory: function (e) {
                return e + " pezzi disponibili"
            },
            select_sku_attribute: function (e) {
                return "Si Prega di Selezionare " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">Hai già un account? <a href="/login?redirect_uri=' + e + '">Accedi</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">Questo codice non corrisponde a nessuna carta regalo o sconto attivo. È stato inserito correttamente?</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips"> Il tuo carrello non soddisfa i requisiti per il codice di sconto <strong>' + t + "</strong>.</p>"
                }
                return a
            },
            product_lastSale: "ha recentemente acquistato"
        }, es: {
            btn_add_to_cart: "Añadir al carrito",
            btn_sold_out: "AGOTADO",
            btn_unavailable: "Indisponible",
            btn_buy: "COMPRAR",
            btn_complete_order: "Pedido completa",
            add_selected_to_cart: "AÑADIR SELECCIONADO AL CARRITO",
            sale_discount: "Oferta limitada",
            max_inventory: "Cantidad máxima disponible alcanzada.",
            cart_express: "Calcular costo de envío",
            cart_express_hide: "Ocultar calculadora de envío",
            menu: "Menú",
            refresh_recommend: "¿No le gustan estos?",
            save: "salvar",
            reviews: "Comentarios",
            order_show: "Mostrar resumen de pedido",
            order_hide: "Ocultar resumen de pedido",
            valid_email: "Introduzca un E-mail válido",
            erro_email: "Forma incorrecta de E-mail",
            subscribe: "Gracias por suscribirse",
            max_255: "El máximo es de 255 caracteres",
            max_40: "El máximo es de 40 caracteres",
            free: "Gratis",
            calculated: "Calculado en el siguiente paso",
            phone_place: "Teléfono (opcional)",
            other_address: "Apartamento, suite, etc.",
            new_address: "Nueva dirección",
            paypal: "Autorizado por PayPal",
            no_logistics: "Actualmente no enviamos a este país/región. Ingrese una nueva dirección de envío e intente nuevamente.",
            select_province: "Seleccione una provincia/estado",
            select_country: "Seleccione un estado/provincia",
            tax_number: "Ingrese un número de IVA válido.",
            google_map: "Ingrese 4-200 caracteres para recuperar direcciones automáticamente.",
            google_map_suggestions: "Sugerencias",
            btn_helpful: "Útil",
            feedback: "Gracias por sus comentarios.",
            required: "Este campo es requerido",
            max_upload: "¡Carga hasta cinco veces al día!",
            image_erro: "La imagen debe ser inferior a 10MB",
            helpful: "Una persona encontró esto útil",
            people: "Personas",
            report_confirm: "¿Está seguro de que desea denunciar esta revisión como inapropiada?",
            has_reported: "Esta revisión ha sido reportada",
            report: "Informar como inapropiado",
            filpclock: "Su carrito caduca pronto.",
            groups: "Por favor, seleccione al menos una variante.",
            groups_total_price: "Precio total",
            discount: "Descuento",
            placeholder_discount: "Código de descuento",
            tips_coupon_error_1: "Este código no coincide con ninguna tarjeta de regalo activa o descuento. ¿Se ingresó correctamente?",
            tips_coupon_error_2: "El código de descuento no es válido para los artículos en su carrito",
            cod_tips: "Debido a los requisitos de la aduana de Arabia Saudita, esta orden requiere que proporcione el número de identificación del destinatario para facilitar la declaración de aduana.",
            personal_id: "Tarjeta de identificación",
            personal_id_num: "Número de identificación",
            validation: {
                email: ["Introduzca un E-mail válido", "Introduzca un E-mail válido", "Ingrese solo entre 2 y 200 caracteres"],
                first_name: ["Ingrese un primer nombre", "Ingrese un primer nombre", "Ingrese solo entre 2 y 100 caracteres."],
                last_name: ["Ingrese un apellido", "Ingrese un apellido", "Ingrese solo entre 2 y 50 caracteres"],
                address: ["Ingrese una dirección", "Ingrese una dirección", "Ingrese solo entre 2 y 200 caracteres."],
                other_address: ["Ingrese a un departamento, suite, etc.", "Ingrese a un departamento, suite, etc.", "Ingrese solo entre 2 y 200 caracteres."],
                tax_number: ["El Impuesto al Valor Agregado NO debe tener 11 o 14 caracteres.", "El Impuesto al valor agregado NO. debe tener 13-14 caracteres."],
                phone: ["Ingrese un número de teléfono válido", "Ingrese un número de teléfono válido", "Ingrese solo entre 2 y 50 caracteres."],
                zip_code: ["Ingrese un código postal", "Ingrese un código postal"],
                city: ["Ingrese una ciudad", "Ingrese una ciudad", "Ingrese solo entre 2 y 100 caracteres."],
                pay_card_number: ["Ingrese un número de tarjeta", "Ingrese un número de tarjeta", "Ingrese solo entre 2 y 100 caracteres."],
                pay_card_mmyy: ["Ingrese una tarjeta mmyy", "Ingrese una tarjeta mmyy", "Ingrese solo entre 2 y 100 caracteres."],
                pay_card_cvv: ["Ingrese una tarjeta cvv", "Ingrese una tarjeta cvv", "Ingrese solo entre 2 y 100 caracteres."],
                cod_id: ["Complete el número de identificación del destinatario para que pueda recibir el paquete sin problemas.", "Complete el número de identificación del destinatario para que pueda recibir el paquete sin problemas.", "El formato del número de identificación que ingresó es incorrecto, ¡complételo con precisión!"]
            },
            insurance_alert: "Le aconsejamos contratar un seguro de transporte. Si no contrata un seguro de transporte, no pagaremos la pérdida o el daño.",
            insurance_alert_ok: "Ok",
            scroll_more: "Desplácese para más artículo",
            state: "Provincia/Estado",
            qty: "Cant",
            at: "en",
            remove: "Eliminar",
            did_not_buy: "No compra",
            expand_all_settings: "Expandir más configuraciones",
            collapse_all_settings: "Desplegar todas configuraciones",
            no_shipping: "Aucune méthode d'expédition n'est disponible pour votre panier ou votre adresse",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">Una persona</span> encontró esto útil' : '<span class="J-helpfulNum">' + e + " personas</span> encontró esto útil"
            },
            cart_express_num: function (e, t) {
                return "Encontramos tarifas de envío de " + e + " disponibles por " + t
            },
            cart_express_free: function (e) {
                return "Compre más de " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> y obtenga envío gratis."
            },
            filpclock_forma_time: function (e) {
                return '¡Su pedido está reservado por <span class="J-CountDown count-down-time">' + e + "</span> minutos!"
            },
            limitoffer: function (e) {
                return "Descuento para los primeros " + e + " artículos"
            },
            tips_coupon_error_3: function (e) {
                return "Su carrito no cumple con los requisitos para el <strong> " + e + " </strong> código de descuento"
            },
            inventory_limit: function (e, t, a) {
                return "Solo puede agregar " + e + " " + t + " -  " + a.replace(/·/g, " / ") + "  al carrito."
            },
            sellable_inventory: function (e) {
                return e + " piezas disponibles"
            },
            select_sku_attribute: function (e) {
                return "Por favor seleccione " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">¿Ya tiene una cuenta? <a href="/login?redirect_uri=' + e + '">Iniciar sesión</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">Este código no coincide con ninguna tarjeta de regalo activa o descuento. ¿Se ingresó correctamente?</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips">Su carrito no cumple con los requisitos para el código de descuento <strong>' + t + "</strong></p>"
                }
                return a
            },
            product_lastSale: "comprado recientemente"
        }, pt: {
            btn_add_to_cart: "Adicionar ao carrinho",
            btn_sold_out: "ESGOTADO",
            btn_unavailable: "Indisponível",
            btn_buy: "COMPRAR",
            btn_complete_order: "Concluir pedido",
            add_selected_to_cart: "ADICIONAR O SELECIONADO AO CARRINHO",
            sale_discount: "limited offer",
            max_inventory: "Quantidade máxima disponível atingida.",
            cart_express: "Calcular Frete",
            cart_express_hide: "Ocultar calculadora de frete",
            menu: "Menu",
            refresh_recommend: "Não gosta disso?",
            save: "Salvar",
            reviews: "Comentários",
            order_show: "Mostrar resumo de pedidos",
            order_hide: "Ocultar resumo de pedidos",
            valid_email: "Entre com um e-mail válido",
            erro_email: "Formato de email errado",
            subscribe: "Obrigado pela assinatura",
            max_255: "máximo de 255 caracteres",
            max_40: "máximo de 40 caracteres",
            free: "Grátis",
            calculated: "Calculado na próxima etapa",
            phone_place: "Telefone (opcional)",
            other_address: "Apartamento, suíte, etc.",
            new_address: "Novo endereço",
            paypal: "Autorizado pelo PayPal",
            no_logistics: "Não enviamos para este país/região. Digite um novo endereço de entrega e tente novamente.",
            select_province: "Selecione um estado/província",
            select_country: "Selecione um País/Região",
            tax_number: "Insira um número IVA válido.",
            google_map: "Digite de 4 a 200 caracteres para recuperar endereços automaticamente.",
            google_map_suggestions: "Sugestões",
            btn_helpful: "Útil ",
            feedback: "Obrigado pelo seu comentário.",
            required: "Este campo é obrigatório",
            max_upload: "Carregue até cinco vezes por dia!",
            image_erro: "A imagem deve ser menos de 10MB",
            helpful: "Uma pessoa achou isso útil",
            people: "pessoa",
            report_confirm: "Tem certeza de denunciar este comentário como impróprio?",
            has_reported: "Este comentário foi relatado",
            report: "Denunciar como impróprio",
            filpclock: "Seu carrinho expirará em breve",
            groups: "Selecione pelo menos uma variante.",
            groups_total_price: "Total price",
            discount: "Desconto",
            placeholder_discount: "Código de desconto",
            tips_coupon_error_1: "Este código não corresponde a nenhum vale-presente ou desconto efetivo. Foi inserido corretamente?",
            tips_coupon_error_2: "o código de desconto não é válido para os itens do seu carrinho",
            cod_tips: "Em resposta aos requisitos da alfândega da Arábia Saudita, esta encomenda exige o número do Bilhete de Identidade do destinatário para a declaração alfandegária.",
            personal_id: "Bilhete de Identidade",
            personal_id_num: "Número do Bilhete de Identidade",
            validation: {
                email: ["Entre com um e-mail válido", "Entre com um e-mail válido", "Digite entre 2 e 200 caracteres"],
                first_name: ["Digite o nome", "Digite o nome", "Digite entre 2 e 100 caracteres"],
                last_name: ["Digite o sobrenome", "Digite o sobrenome", "Digite entre 2 e 50 caracteres."],
                address: ["Digite o endereço", "Digite o endereço", "Digite entre 2 e 200 caracteres"],
                other_address: ["Digite um apartamento, suíte etc.", "Digite um apartamento, suíte etc.", "Digite entre 2 e 200 caracteres"],
                tax_number: ["O número do IVA deve ser de 11 ou 14 caracteres.", "O número do IVA deve ser de 13 a 14 caracteres."],
                phone: ["Digite um telefone válido", "Digite um telefone válido", "Digite entre 2 e 50 caracteres."],
                zip_code: ["Digite um CEP/código postal", "Digite um CEP/código postal"],
                city: ["Digite uma cidade", "Digite uma cidade", "Digite entre 2 e 100 caracteres"],
                pay_card_number: ["Digite o número do cartão", "Digite o número do cartão", "Digite entre 2 e 100 caracteres"],
                pay_card_mmyy: ["Insira um cartão mmyy", "Insira um cartão mmyy", "Digite entre 2 e 100 caracteres"],
                pay_card_cvv: ["Insira um cartão cvv", "Insira um cartão cvv", "Digite entre 2 e 100 caracteres"],
                cod_id: ["Preencha o número do Bilhete de Identidade do destinatário para que possa receber o pacote sem problemas!", "Preencha o número do Bilhete de Identidade do destinatário para que possa receber o pacote sem problemas!", "O formato do número do Bilhete de Identidade inserido é errado, preencha-o corretamente!"]
            },
            insurance_alert: "É melhor subscrever um seguro de transporte. Se não tem seguro de transporte, será compensada perda ou dano não . ",
            insurance_alert_ok: "Ok",
            scroll_more: "Deslizar para mais items",
            state: "Província/Estado",
            qty: "Qtde",
            at: "de",
            remove: "Remover",
            did_not_buy: "Não comprou",
            expand_all_settings: "Mostrar mais configurações",
            collapse_all_settings: "Esconder todas as configurações",
            no_shipping: "Nenhum método de frete está disponível para seu carrinho ou endereço",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">Uma pessoa</span> achou isso útil' : '<span class="J-helpfulNum">' + e + " pessoa</span> achou isso útil"
            },
            cart_express_num: function (e, t) {
                return "Encontramos taxas de envio " + e + " disponíveis para " + t
            },
            cart_express_free: function (e) {
                return "Comprar mais " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> para ganhar frete grátis."
            },
            filpclock_forma_time: function (e) {
                return 'Seu pedido será reservado por <span class="J-CountDown count-down-time">' + e + "</span> minutos!"
            },
            limitoffer: function (e) {
                return "Desconto para os primeiros itens de " + e
            },
            tips_coupon_error_3: function (e) {
                return "Seu carrinho não atende aos requisitos do código de desconto <strong> " + e + " </strong>"
            },
            inventory_limit: function (e, t, a) {
                return "Só pode adicionar " + e + " " + t + " -  " + a.replace(/·/g, " / ") + "  ao carrinho."
            },
            sellable_inventory: function (e) {
                return e + " peças disponíveis"
            },
            select_sku_attribute: function (e) {
                return "Favor selecionar " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">Já tem uma conta? <a href="/login?redirect_uri=' + e + '">Acessar</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">Este código não corresponde a nenhum vale-presente ou desconto efetivo. Foi inserido corretamente?</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips">Seu carrinho não atende aos requisitos do código de desconto de <strong>' + t + "</strong></p>"
                }
                return a
            },
            product_lastSale: "comprou recentemente"
        }, ar: {
            btn_add_to_cart: "أضف إلى سلة التسوق",
            btn_sold_out: "بيعت كلها            ",
            btn_unavailable: "غير متوفره",
            btn_buy: "شراء",
            btn_complete_order: "اكمل الطلب",
            add_selected_to_cart: "أضف إلى سلة التسوق",
            sale_discount: "عروض محدودة",
            max_inventory: "تم الوصول إلى الكمية القصوى المتاحة.",
            cart_express: "احسب الشحن",
            cart_express_hide: "إخفاء حاسبة الشحن",
            menu: "قائمة",
            refresh_recommend: "لا تحب هذه؟",
            save: "خصم",
            reviews: "تعليق",
            order_show: "إظهار ملخص الطلب",
            order_hide: "إخفاء ملخص الطلب",
            valid_email: "أدخل بريد إلكتروني متاح",
            erro_email: "تنسيق بريد إلكتروني غير صحيح",
            subscribe: "شكرا على الإشتراك",
            max_255: "الحد الأقصى هو 255 حرفًا",
            max_40: "الحد الأقصى هو 40 حرفًا",
            free: "مجانا",
            calculated: "تحسب الشحن في الخطوة التالية",
            phone_place: "رقم الموبايل (اختياري)",
            other_address: "شقة ، جناح وإلخ",
            new_address: "العنوان الجديد",
            paypal: "حساب PayPal تلقائيًا",
            no_logistics: "نحن لا نشحن حاليًا إلى هذا البلد / المنطقة . أدخل عنوان شحن جديد وحاول مرة أخرى .",
            select_province: "اختيار ولاية / مقاطعة",
            select_country: "اختيار البلد / المنطقة",
            tax_number: "أدخل رقم ضريبة القيمة المضافة ساري المفعول.",
            google_map: "يُرجى إدخال 4-200 حرفًا لاسترداد العناوين تلقائيًا.",
            google_map_suggestions: "اقتراحات",
            btn_helpful: "مفيد",
            feedback: "شكرا لك على ملاحظاتك .",
            required: "هذه الخانة مطلوبه",
            max_upload: "قم بتحميل ما يصل إلى خمس مرات في اليوم!",
            image_erro: "يجب أن تكون الصورة أقل من 10 ميجابايت",
            helpful: "شخص واحد وجد هذا مفيدا",
            people: "اشخاص",
            report_confirm: "هل تريد الإبلاغ عن هذا التعليق باعتباره غير ملائم؟",
            has_reported: "تم الإبلاغ عن هذا التعليق",
            report: "الإبلاغ عن عدم ملاءمة",
            filpclock: "سلة التسوق لك تنتهي صلاحيتها قريبا",
            groups: "يرجى تحديد مواصفات واحدة على الأقل",
            groups_total_price: "السعر الكلي",
            discount: "خصم",
            placeholder_discount: "كود خصم",
            tips_coupon_error_1: "لم يتطابق هذا الكود مع أي بطاقة هدايا أو خصم نشط . هل تم إدخالها بشكل صحيح؟",
            tips_coupon_error_2: "كود الخصم غير صالح للعناصر الموجودة في سلة التسوق لك",
            cod_tips: "يتطلب هذا الطلب منك تقديم رقم بطاقة هوية المرسل إليه من أجل تلبية متطلبات الجمارك في المملكة العربية السعودية ، وتسهيل البيان الجمركي .",
            personal_id: "بطاقة الهوية",
            personal_id_num: "رقم بطاقة الهوية",
            validation: {
                email: ["أدخل بريد إلكتروني متاح", "أدخل بريد إلكتروني متاح", "يرجى إدخال 2-200 حرفًا"],
                first_name: ["أدخل الاسم", "أدخل الاسم ", "يرجى إدخال 2-100 حرفًا"],
                last_name: ["أدخل اللقب", "أدخل اللقب", "يرجى إدخال 2-50 حرفًا"],
                address: ["أدخل العنوان", "أدخل العنوان ", "يرجى إدخال 2-200 حرفًا"],
                other_address: ["أدخل شقة ، جناح وإلخ", "أدخل شقة ، جناح وإلخ ", "يرجى إدخال 2-200 حرفًا"],
                tax_number: ["يجب ألا تحتوي ضريبة القيمة المضافة على 11 أو 14 حرفًا.", "ضريبة القيمة المضافة يجب أن يكون لديك 13-14 حرفًا."],
                phone: ["أدخل رقم هاتف صالح", "أدخل رقم هاتف صالح", "يرجى إدخال 2-50 حرفًا"],
                zip_code: ["أدخل الرمز البريدي", "أدخل الرمز البريدي"],
                city: ["أدخل مدينة", "أدخل مدينة", "يرجى إدخال 2-100 حرفًا"],
                pay_card_number: ["أدخل رقم البطاقة", "أدخل رقم البطاقة", "يرجى إدخال 2-100 حرفًا"],
                pay_card_mmyy: ["أدخل تاريخ انتهاء صلاحية البطاقة mmyy", "أدخل تاريخ انتهاء صلاحية البطاقة mmyy", "يرجى إدخال 2-100 حرفًا"],
                pay_card_cvv: ["Enter a card number", "Enter a first name", "يرجى إدخال 2-100 حرفًا"],
                cod_id: ["يرجى ملء رقم بطاقة هوية المرسل إليه ، لكى تستلم الطرد بسلاسة!", "يرجى ملء رقم بطاقة هوية المرسل إليه ، لكى تستلم الطرد بسلاسة!", "شكل رقم بطاقة الهوية الذي أدخلته خاطئ ، يرجى إدخاله بدقة!"]
            },
            insurance_alert: "ننصحك بشراء تأمين الشحن . إذا لم تشتر على تأمين الشحن ، فلن ندفع مقابل الخسارة أو الضرر",
            insurance_alert_ok: "تأكيد",
            scroll_more: "قم بالتمرير لمزيد من العناصر",
            state: "المقاطعة / الولاية",
            qty: "كمية",
            at: "at",
            remove: "Remove",
            did_not_buy: "لا شراء",
            expand_all_settings: "توسيع المزيد من الإعدادات",
            collapse_all_settings: "تصغير جميع الإعدادات",
            no_shipping: "طريقة الشحن غير متاحة لعربة التسوق أو العنوان لك",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">One person</span> found this helpful' : '<span class="J-helpfulNum">' + e + " people</span> found this helpful"
            },
            cart_express_num: function (e, t) {
                return "وجدنا أن " + t + " يحتوي على " + e + " رسوم الشحن"
            },
            cart_express_free: function (e) {
                return "التمتع بالشحن المجاني على المشتريات التي تزيد عن  <span>" + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span> "
            },
            filpclock_forma_time: function (e) {
                return 'تم حجز طلبك لمدة  <span class="J-CountDown count-down-time">' + e + "</span> دقيقة!"
            },
            limitoffer: function (e) {
                return " خصومات على المنتجات " + e + " السابقة"
            },
            tips_coupon_error_3: function (e) {
                return "سلة التسوق الخاصة بك لا تستوفي متطلبات كود الخصم  <strong> " + e + " </strong> "
            },
            inventory_limit: function (e, t, a) {
                return "يمكنك فقط إضافة " + e + " " + t + " -  " + a.replace(/·/g, " / ") + " إلى سلة التسوق  "
            },
            sellable_inventory: function (e) {
                return " في المخزن " + e + " "
            },
            select_sku_attribute: function (e) {
                return "اختر من فضلك " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">هل لديك حساب؟ <a href="/login?redirect_uri=' + e + '">تسجيل الدخول</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">لم يتطابق هذا الكود مع أي بطاقة هدايا أو خصم نشط . هل تم إدخالها بشكل صحيح؟</p>';
                        break;
                    case"2":
                        a = '<p class="erro-tips">سلة التسوق الخاصة بك لا تستوفي متطلبات كود الخصم <strong>' + t + "</strong> </p>";
                        break;
                    case"3":
                        a = '<p class="erro-tips">سلة التسوق الخاصة بك لا تستوفي متطلبات كود الخصم <strong>' + t + "</strong></p>"
                }
                return a
            },
            product_lastSale: "تم شراء مؤخرًا"
        }, ja: {
            btn_add_to_cart: "カートに追加する",
            btn_sold_out: "売り切れ",
            btn_unavailable: "お取り扱いできません",
            btn_buy: "購買",
            btn_complete_order: "注文完了",
            add_selected_to_cart: "カートに追加する",
            sale_discount: "限定の割引",
            max_inventory: "最大數量に達しました。",
            cart_express: "運賃計算",
            cart_express_hide: "運賃計算機を隠す",
            menu: "メニュー",
            refresh_recommend: "これらが好きではないですか？",
            save: "割引",
            reviews: "コメント",
            order_show: "注文の概要を表示する",
            order_hide: "注文の概要を隠す",
            valid_email: "有効なメールを入力してください",
            erro_email: "間違ったメールボックスのフォーマット",
            subscribe: "購読してありがとうございます",
            max_255: "最大255文字まで入力してください。",
            max_40: "最大40文字まで入力してください。",
            free: "無料",
            calculated: "次の計算",
            phone_place: "攜帯番号(オプション)",
            other_address: "アパート、スイートルームなど",
            new_address: "新しいアドレス",
            paypal: "PayPal授権",
            no_logistics: "今この國/地區に運送しません。新たな配送先を入力してください。",
            select_province: "洲/省を選択",
            select_country: "國/地區を選択",
            tax_number: "有効な増値稅號を入力します。",
            google_map: "アドレスを自動検索するために4-200文字を入力してください。",
            google_map_suggestions: "アドバイス",
            btn_helpful: "役に立つ",
            feedback: "ご意見をありがとうございます。",
            required: "これは記入欄です",
            max_upload: "毎日最大5回アップロードします。",
            image_erro: "畫像のサイズは10 MBより大きくできません。",
            helpful: "これが役に立つと思う人がいます。",
            people: "人",
            report_confirm: "このコメントを不正な內容として告発しますか？",
            has_reported: "このコメントは告発されました",
            report: "告発が不當です",
            filpclock: "あなたのショッピングカートはもうすぐ期限が切れます。",
            groups: "少なくとも一つの規格を選んでください。",
            groups_total_price: "総価格",
            discount: "割引",
            placeholder_discount: "割引コード",
            tips_coupon_error_1: "このコードはギフトカードや割引には効果的ではありません。入力は正しいですか？",
            tips_coupon_error_2: "割引コードはカートの中の商品には適用されません。",
            cod_tips: "通関申告の手続きを処理するために、サウジアラビア稅関の要求により、この注文は受取人の身分証番號を提供する必要がある。",
            personal_id: "身分証",
            personal_id_num: "身分証番號",
            validation: {
                email: ["有効なメールを入力してください", "有効なメールを入力してください", "2-200文字を入力してください"],
                first_name: ["名を入力してください", "名を入力してください", "2-100文字を入力してください"],
                last_name: ["氏を入力してください", "氏を入力してください", "2-50文字を入力してください"],
                address: ["アドレスを入力してください", "アドレスを入力してください ", "2-200文字を入力してください"],
                other_address: ["アパート、スイートルームなどを入力してください", "アパート、スイートルームなどを入力してください ", "2-200文字を入力してください"],
                tax_number: ["増値稅號は11または14の字元を含む必要があります。", "増値稅號は13-14の字元を含む必要があります。"],
                phone: ["有効な攜帯番号を入力してください", "有効な攜帯番号を入力してください", "2-50文字を入力してください"],
                zip_code: ["郵便番号を入力してください", "郵便番号を入力してください"],
                city: ["都市を入力してください", "都市を入力してください", "2-100文字を入力してください"],
                pay_card_number: ["カード番号を入力してください", "カード番号を入力してください", "2-100文字を入力してください"],
                pay_card_mmyy: ["カードの有効期限mmyyを入力してください", "カードの有効期限mmyyを入力してください", "2-100文字を入力してください"],
                pay_card_cvv: ["カードの有効期限cvvを入力してください", "カードの有効期限cvvを入力してください", "2-100文字を入力してください"],
                cod_id: ["荷物を順調に受け取るために、受取人の身分証番號をご記入してください。", "荷物を順調に受け取るために、受取人の身分証番號をご記入してください。", "入力された身分証番號のフォーマットが間違ったので、正確にご記入してください。"]
            },
            insurance_alert: "貨物保険を買うことをお勧めします。貨物保険を買わないと、損害や損害を賠償しません。",
            insurance_alert_ok: "確認",
            scroll_more: "スクロールしてもっと多くの商品を見る",
            state: "省/ステート",
            qty: "數量",
            at: ":",
            remove: "削除",
            did_not_buy: "購買しない",
            expand_all_settings: "もっと詳細設定を展開する",
            collapse_all_settings: "すべてをたたむ",
            no_shipping: "あなたのショッピングカートや住所での配送方法がありません。",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum"></span> これが役に立つと思う人がいます。' : '<span class="J-helpfulNum">' + e + "</span>人はこれが役に立つと思う。"
            },
            cart_express_num: function (e, t) {
                return t + "に" + e + "運賃を見つけました"
            },
            cart_express_free: function (e) {
                return SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span>以上を買うと送料無料です。"
            },
            filpclock_forma_time: function (e) {
                return 'ご注文は<span class="J-CountDown count-down-time">' + e + "</span>分を保留します。"
            },
            limitoffer: function (e) {
                return "前" + e + "個商品の割引"
            },
            tips_coupon_error_3: function (e) {
                return "あなたのショッピングカートは<strong> " + e + " </strong>割引コードの要求に合わないです。"
            },
            inventory_limit: function (e, t, a) {
                return e + " " + t + " -  " + a.replace(/·/g, " / ") + "をショッピングカートに追加するしかありません。"
            },
            sellable_inventory: function (e) {
                return e + " 利用可能"
            },
            select_sku_attribute: function (e) {
                return e + "を選択してください"
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">すでにアカウントを持っていますか？ <a href="/login?redirect_uri=' + e + '">ログイン</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">このコードはギフトカードや割引には効果的ではありません。入力は正しいですか？</p>';
                        break;
                    case"2":
                    case"3":
                        a = "あなたのショッピングカートは" + t + "割引コードの要求に合わないです。"
                }
                return a
            },
            product_lastSale: "は最近買いました"
        }, "zh-tw": {
            btn_add_to_cart: "加入購物車",
            btn_sold_out: "售罄",
            btn_unavailable: "無法供貨",
            btn_buy: "購買",
            btn_complete_order: "完成訂單",
            add_selected_to_cart: "加入購物車",
            sale_discount: "限量優惠",
            max_inventory: "已達到最大數量。",
            cart_express: "計算運費",
            cart_express_hide: "隱藏運費計算器",
            menu: "菜單",
            refresh_recommend: "不喜歡這些？",
            save: "優惠",
            reviews: "評論",
            order_show: "顯示訂單摘要",
            order_hide: "隱藏訂單摘要",
            valid_email: "輸入有效的電子郵件",
            erro_email: "錯誤的郵箱格式",
            subscribe: "感謝訂閱",
            max_255: "最多輸入255個字",
            max_40: "最多輸入40個字",
            free: "免費",
            calculated: "下一步計算運費",
            phone_place: "手機號（選填）",
            other_address: "公寓，套房等",
            new_address: "新地址",
            paypal: "PayPal授權",
            no_logistics: "我們目前不運送到這個國家/地區。請重新輸入新的送貨地址。",
            select_province: "選擇洲/省份",
            select_country: "選擇國家/地區",
            tax_number: "輸入有效的增值稅號。",
            google_map: "請輸入4-200個字以自動檢索地址。",
            google_map_suggestions: "建議",
            btn_helpful: "有幫助的",
            feedback: "感謝您的回饋意見。",
            required: "這是必填欄",
            max_upload: "每天最多上傳五次！",
            image_erro: "圖片大小不能高於10MB",
            helpful: "有一個人覺得這個有用",
            people: "人",
            report_confirm: "您確定要舉報此評論為不當內容嗎？",
            has_reported: "該評論已舉報",
            report: "舉報不當",
            filpclock: "您的購物車即將到期",
            groups: "請至少選擇一種規格。",
            groups_total_price: "總價",
            discount: "折扣",
            placeholder_discount: "折扣碼",
            tips_coupon_error_1: "該代碼與任何有效的禮品卡或折扣都不匹配。輸入正確嗎？",
            tips_coupon_error_2: "折扣代碼不適用於您購物車中的商品",
            cod_tips: "因應沙烏地阿拉伯海關的要求，本筆訂單需要您提供收貨人身份證號碼，以便於進行入關申報。",
            personal_id: "身份證",
            personal_id_num: "身份證號碼",
            validation: {
                email: ["輸入有效的電子郵件", "輸入有效的電子郵件", "請輸入2-200個字元"],
                first_name: ["請輸入名", "請輸入名", "請輸入2-100個字元"],
                last_name: ["請輸入姓", "請輸入姓 ", "請輸入2-50個字元"],
                address: ["請輸入地址", "請輸入地址 ", "請輸入2-200個字元"],
                other_address: ["請輸入公寓，套房等。", "請輸入公寓，套房等。 ", "請輸入2-200個字元"],
                tax_number: ["增值稅號必須包含11或14個字元。", "增值稅號必須包含13-14個字元。"],
                phone: ["請輸入有效的電話號碼", "請輸入有效的電話號碼", "請輸入2-50個字元"],
                zip_code: ["請輸入郵遞區號", "請輸入郵遞區號"],
                city: ["請輸入城市", "請輸入城市", "請輸入2-100個字元"],
                pay_card_number: ["請輸入卡號", "請輸入卡號", "請輸入2-100個字元"],
                pay_card_mmyy: ["請輸入卡有效期mmyy", "請輸入卡有效期mmyy", "請輸入2-100個字元"],
                pay_card_cvv: ["請輸入CVV碼", "請輸入CVV碼", "請輸入2-100個字元"],
                cod_id: ["請填寫收貨人身份證號，以便於您順利收到包裹！", "請填寫收貨人身份證號，以便於您順利收到包裹！", "您輸入的身份證號格式錯誤，請準確填寫！"]
            },
            insurance_alert: "我們建議您購買貨運保險。 如果您不購買貨運保險，我們將不賠償損失或損壞",
            insurance_alert_ok: "確認",
            scroll_more: "滾動查看更多商品",
            state: "省份/洲",
            qty: "數量",
            at: ":",
            remove: "刪除",
            did_not_buy: "沒有購買",
            expand_all_settings: "展開更多設置",
            collapse_all_settings: "折疊全部",
            no_shipping: "沒有可用於您的購物車或地址的發貨方式",
            helpful_num: function (e) {
                return 1 == e ? '<span class="J-helpfulNum">有一個人</span> 覺得這個有用' : '<span class="J-helpfulNum">' + e + "</span> 人覺得這個有用"
            },
            cart_express_num: function (e, t) {
                return "我們發現" + t + "有" + e + "個運費"
            },
            cart_express_free: function (e) {
                return "購買 " + SAIL_ENV.config.currencyEntity.symbol + " " + (e / _this.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</span>以上可享免費送貨"
            },
            filpclock_forma_time: function (e) {
                return '您的訂單將保留<span class="J-CountDown count-down-time">' + e + "</span>分鐘！"
            },
            limitoffer: function (e) {
                return "前" + e + "個商品的折扣"
            },
            tips_coupon_error_3: function (e) {
                return "您的購物車不符合<strong> " + e + " </strong>折扣代碼的要求"
            },
            inventory_limit: function (e, t, a) {
                return "您只能將" + e + " " + t + " -  " + a.replace(/·/g, " / ") + " 添加到購物車"
            },
            sellable_inventory: function (e) {
                return e + " 可用"
            },
            select_sku_attribute: function (e) {
                return "請選擇 " + e
            },
            log_in: function (e) {
                return '<div class="fr J-UserLogOut">已經擁有帳號？ <a href="/login?redirect_uri=' + e + '">登錄</a></div>'
            },
            coupon_tips: function (e, t) {
                var a = "";
                switch (e += "") {
                    case"1":
                        a = '<p class="erro-tips">該代碼與任何有效的禮品卡或折扣都不匹配。輸入正確嗎？</p>';
                        break;
                    case"2":
                    case"3":
                        a = '<p class="erro-tips">您的購物車不符合<strong>' + t + "</strong>折扣代碼的要求</p>"
                }
                return a
            },
            product_lastSale: "最近購買"
        }, lang: $(".J-language").val() || "en"
    }
}), $(function () {
    window.SAIL_ENV.Comment = {
        pages: {size: 8, total: 0, current: 1},
        config: {comment_time: !1, country: !0, helpful: !0, avatar: !0},
        createdDate: "",
        commentList: [],
        starRating: 5,
        lastTime: new Date((new Date).toLocaleDateString()).getTime(),
        init: function () {
            var t, a = this;
            "PAGE_PRODUCT_DETAIL" != $(".JH-page-location").val() && !$("body").hasClass("template5-body") || (t = !0, $(window, ".J-Popup").scroll(function () {
                var e = parseInt($(document).scrollTop() + $(window).height()) || parseInt($("html, body").scrollTop() + $(window).height());
                1 == $(".J-isShowComment").val() && 0 < $(".reviews").length && t && e > $(".reviews").offset().top && (a.getProductReview(), t = !1)
            })), a.event(), a.showBigImg()
        },
        event: function () {
            var i = this;
            $(document).on("click", ".J-PagesItem", function () {
                i.pages.current = parseInt($(this).data("index")), i.pages.current && i.getProductReview()
            }), $(document).on("click", ".J-PagesPrev", function () {
                --i.pages.current, i.pages.current && i.getProductReview()
            }), $(document).on("click", ".J-PagesLast", function () {
                i.pages.current += 1, i.pages.current && i.getProductReview()
            }), $(document).on("click", ".J-ImgDel", function () {
                $(this).parent("div").remove()
            }), $(document).on("change", ".J-UploadImg", function () {
                var e = $(this).get(0).files,
                    t = parseInt($(".J-MessageImgList").find(".message-img-item").length) + e.length;
                if (e.length && t <= 5) for (var a = 0; a < e.length; a++) $http.upload(e[a], function (e) {
                    var t;
                    0 == e.code && (t = '<div class="message-img-item">\n                               <span class="J-ImgDel message-img-del"></span>\n                               <div><img class="J-MessageImg" src="' + e.data[0].file_preview + '" data-id="' + e.data[0].file_id + '"/></div>\n                             </div>', $(".J-MessageImgList").append(t))
                }); else 5 < t && $plug.message.error(SAIL_ENV.language[SAIL_ENV.language.lang].max_upload)
            }), $(".score").val(i.starRating), $(document).on("mouseenter", ".starRating span", function () {
                $(this).prevAll().find(".icon-star_full").addClass("cur"), $(this).find(".icon-star_full").addClass("cur"), $(this).nextAll().find(".icon-star_full").removeClass("cur")
            }), $(document).on("mouseleave", ".starRating", function () {
                $(this).find(".icon-star_full").removeClass("cur"), 5 == i.starRating ? $(".starRating span").find(".icon-star_full").addClass("cur") : $(".starRating span").eq(i.starRating).prevAll().find(".icon-star_full").addClass("cur")
            }), $(document).on("click", ".starRating span", function () {
                var e = $(this).index() + 1;
                $(this).prevAll().find(".icon-star_full").addClass("cur"), $(this).find(".icon-star_full").addClass("cur"), i.starRating = e, $(".score").val(i.starRating)
            }), $(document).on("click", ".J-BtnReview", function () {
                $(".write-review-box").slideToggle(500).toggleClass("jh-btn-review--show")
            }), $(document).on("click", ".J-closeReview", function () {
                $(".J-reviewOk").hide()
            }), $(document).on("click", ".J-submitReview", function () {
                $(this).attr("disabled", "disabled").addClass("jh-btn-loading"), i.submitReply()
            }), $(".J-review").blur(function () {
                $(this).hasClass("email") ? new RegExp(SAIL_ENV.config.EmailReg).test($(this).val()) ? ($(this).removeClass("review-error"), $(this).next(".tips").text("")) : ($(this).addClass("review-error"), $(this).next(".tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].valid_email)) : "" == $(this).val() ? ($(this).addClass("review-error"), $(this).next(".tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].required)) : ($(this).removeClass("review-error"), $(this).next(".tips").text(""))
            }), $(document).on("click", ".J-helpful", function () {
                var e, t = [], a = parseInt($(this).siblings(".helpful-num").data("num")) + 1;
                $(this).hide().siblings(".helpful-tips").show(), window.localStorage.getItem("hasHelpfulId") && (e = JSON.parse(window.localStorage.getItem("hasHelpfulId")).date, i.lastTime == e ? t = JSON.parse(window.localStorage.getItem("hasHelpfulId")).ids : window.localStorage.removeItem("hasHelpfulId")), t.indexOf($(this).data("id")) <= -1 && ($(this).data("id") && t.push($(this).data("id")), 1 == a ? $(this).siblings(".helpful-num").append("<span>" + SAIL_ENV.language[SAIL_ENV.language.lang].helpful + "</span>") : $(this).siblings(".helpful-num").find("span").text(a + " " + SAIL_ENV.language[SAIL_ENV.language.lang].people), $http.post("/buyer/comment/add-helpful", JSON.stringify({comment_id: $(this).data("id")}), function (e) {
                    0 == e.code && window.localStorage.setItem("hasHelpfulId", JSON.stringify({
                        date: i.lastTime,
                        ids: t
                    }))
                }))
            })
        },
        submitReply: function () {
            var t = this, a = new Date, e = [], i = [];
            $(".J-MessageImgList").find("img").map(function () {
                e.push($(this).data("id")), i.push({file_preview: $(this).attr("src")})
            });
            var n = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"], o = {
                product_id: $(".product-id").val() || $(".J-ProductInfo").find(".title").data("id"),
                observer: $(".observer").val(),
                email: $(".email").val(),
                comment: $(".comment").val(),
                score: $(".score").val() || 5,
                image_id: e.join(),
                product_name: $(".JH-product-title").val() || $(".J-ProductInfo").find(".title").data("handler"),
                image_url: $(".J-MessageImg").attr("src"),
                country: $(".J-getCurrentState").val(),
                observer_icon: 40
            };
            t.commentList = [], t.commentList.push(JSON.parse(JSON.stringify(o))), t.commentList.forEach(function (e) {
                e.images = i, e.country = $(".J-getCurrentState").val(), e.country_flag = $(".J-getCurrentState").data("flag"), e.created_at = n[a.getMonth()] + " " + a.getDate() + "," + a.getFullYear(), e.observer_icon = "https://static.xshoppy.shop/customer/icon/40.jpg", e.helpful = 0
            }), $(".J-review").each(function () {
                $(this).hasClass("email") ? new RegExp(SAIL_ENV.config.EmailReg).test(o.email) ? ($(this).removeClass("review-error"), $(this).next(".tips").text("")) : ($(this).addClass("review-error"), $(this).next(".tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].valid_email)) : "" == $(this).val() ? ($(this).addClass("review-error"), $(this).next(".tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].required)) : ($(this).removeClass("review-error"), $(this).next(".tips").text(""))
            }), 0 == $(".review-error").length ? $http.post("/buyer/comment/add", JSON.stringify(o), function (e) {
                $(".J-submitReview").removeClass("jh-btn-loading").removeAttr("disabled"), 0 == e.code && ($(".J-reviewOk").show(), $(".write-review-box").hide(), $(".starRating").find(".icon-star_full").addClass("cur"), $(".J-review").val(""), $(".score").val("5"), $(".J-MessageImgList").remove(), t.makeCommentHtml(t.commentList, "addComment"), t.showBigImg())
            }) : $(".J-submitReview").removeClass("jh-btn-loading").removeAttr("disabled")
        },
        getProductReview: function () {
            var t = this, e = {
                page: t.pages.current,
                product_id: $(".product-id").val() || $(".J-ProductInfo").find(".title").data("id")
            };
            $http.post("/buyer/comment/one", JSON.stringify(e), function (e) {
                0 == e.code && (t.pages.total = parseInt(e.data.total), t.config.comment_time = e.data.deploy.config.style.comment_time, t.config.country = e.data.deploy.config.style.country, t.config.helpful = void 0 === e.data.deploy.config.style.helpful || e.data.deploy.config.style.helpful, t.config.avatar = void 0 === e.data.deploy.config.style.avatar || e.data.deploy.config.style.avatar, t.commentList = e.data.list, t.makeCommentHtml(t.commentList), t.showBigImg(), e.data.list && 0 < e.data.list.length && $plug.Pages(e.data.pageSize, t.pages.current, t.pages.total), 0 == e.data.list.length && $(".J-Pages").empty(), e.data.total <= e.data.pageSize ? $(".J-LoadMore").hide() : $(".J-LoadMore").show())
            })
        },
        showBigImg: function () {
            $(".J-bigImg").click(function () {
                var e, t = $(this), a = 0, i = t.parent(".reviews-picture").children(".J-bigImg"), n = i.length, o = "";
                $(".layer-img").find("img").attr("src", t.find("img").attr("src")), $(".product-big-img").addClass("product-big-img--show"), $(".J-Mask").addClass("white"), SAIL_ENV.config.mask_layer("show"), e = t.index(), a = e, 1 == n ? $(".J-bigImgPrev,.J-bigImgNext").hide() : $(".J-bigImgPrev,.J-bigImgNext").show(), $(".J-bigImgPrev").click(function () {
                    0 == a ? a = n - 1 : --a, o = i.eq(a).children("img").attr("src"), $(".layer-img").children().attr("src", o)
                }), $(".J-bigImgNext").click(function () {
                    a == n - 1 ? a = 0 : a += 1, o = i.eq(a).children("img").attr("src"), $(".layer-img").children().attr("src", o)
                })
            }), $(".J-bigImgClose,.layer-img").click(function () {
                $(".product-big-img").removeClass("product-big-img--show"), $(".layer-img").find("img").attr("src", ""), $(".J-Mask").removeClass("white"), SAIL_ENV.config.mask_layer("hide")
            }), $(".J-report").click(function () {
                $(this).hasClass("reported") || confirm(SAIL_ENV.language[SAIL_ENV.language.lang].report_confirm) && ($(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].has_reported), $(this).addClass("reported"))
            })
        },
        makeCommentHtml: function (e, t) {
            var u = this, h = "", g = "";
            e.map(function (e) {
                var t = e.images && 1 < e.images.length ? '<div class="picture-num">' + e.images.length + "</div>" : "",
                    a = '<div class="reviews-picture">' + e.images.map(function (e) {
                        return '<div class="J-bigImg"><img src="' + e.file_preview + '"></div>'
                    }).join("") + "\n                </div>",
                    i = '<div class="star">\n                                <div class="score">\n                                    <span class="iconfont ' + (0 < e.score ? "icon-star_full" : "icon-wujiaoxing") + '"></span>\n                                    <span class="iconfont ' + (1 < e.score ? "icon-star_full" : "icon-wujiaoxing") + '"></span>\n                                    <span class="iconfont ' + (2 < e.score ? "icon-star_full" : "icon-wujiaoxing") + '"></span>\n                                    <span class="iconfont ' + (3 < e.score ? "icon-star_full" : "icon-wujiaoxing") + '"></span>\n                                    <span class="iconfont ' + (4 < e.score ? "icon-star_full" : "icon-wujiaoxing") + '"></span>\n                                </div>\n                            </div>',
                    n = u.config.comment_time ? '<span class="reviews-date">' + e.created_at + "</span>" : "",
                    o = u.config.country ? '<span class="reviews-country"><img src="' + e.country_flag + '">' + e.country + "</span>" : "",
                    r = '<div>\n                                <span class="reviews-name sl-subhead-title">' + e.observer + "</span>\n                                <p>\n                                    " + o + "\n                                    " + (u.config.country && u.config.comment_time ? '<span class="spot">·</span>' : "") + "\n                                    " + n + "\n                                </p>\n                            </div>",
                    s = 0 < e.helpful ? "" + SAIL_ENV.language[SAIL_ENV.language.lang].helpful_num(e.helpful) : "",
                    d = u.config.helpful ? '<div class="helpful-num" data-num="' + e.helpful + '" style="' + (e.images && e.images.length < 1 || "" == e.comment ? "margin-top: 0;" : "") + '">' + s + '</div><span class="helpful J-helpful" data-id="' + e.id + '">' + SAIL_ENV.language[SAIL_ENV.language.lang].btn_helpful + '</span><span class="helpful-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].feedback + "</span>" : "",
                    c = '<span class="report J-report ' + (u.config.helpful ? "border-left" : "") + '">' + SAIL_ENV.language[SAIL_ENV.language.lang].report + "</span>",
                    l = u.config.avatar ? '<div class="reviews-avatar"><img src="' + e.observer_icon + '"></div>' : "",
                    p = "" == e.comment ? "" : ' <p class="reviews-detail">' + e.comment + "</p>";
                h += '<li>\n                                <div class="reviews-info">\n                                ' + l + "\n                                " + r + "\n                                </div>\n                                " + i + "\n                                " + p + "\n                                " + a + "\n                                " + d + "\n                                " + c + "\n                            </li>", g += '<li>\n                                    <div class="reviews-info">\n                                    ' + t + "\n                                    " + a + "\n                                    " + l + '\n                                    <div class="reviews-wrap">\n                                        ' + r + "\n                                        " + i + "\n                                        " + p + "\n                                        " + d + "\n                                        " + c + "\n                                    </div>\n                                    </div>\n                                </li>"
            }), u.config.avatar ? $(".reviews-list").removeClass("unavatar") : $(".reviews-list").addClass("unavatar"), "addComment" == t ? 0 < $(".J-reviewList li").length ? 0 < $(".list-style-waterfall").length ? $(".J-reviewList li").first().before(g) : $(".J-reviewList li").first().before(h) : 0 < $(".list-style-waterfall").length ? $(".J-reviewList").append(g) : $(".J-reviewList").append(h) : $(".list-style-waterfall").length ? $(".J-reviewList").empty().append(g) : $(".J-reviewList").empty().append(h)
        }
    }, SAIL_ENV.Comment.init()
}), $(function () {
    window.SAIL_ENV.flipClock = {
        timer: null, init: function () {
            0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() && (SAIL_ENV.config.holidayStyle = $(".J-holidayStyle").val(), 0 < $(".flipclock").length && this.flipClock("details")), 0 < $(".J-OrderCountDown").length && this.flipClock("order")
        }, event: function () {
        }, flipClock: function (e) {
            var t, a, i, o, r, s = "", d = this, c = 0, l = 0;
            $http.post("", JSON.stringify({handler: $(".JH-product-handler").val() || $(".J-ProductInfo").find(".title").data("handler")}), function (n) {
                0 == n.code && n.data && (0 < n.data.total_time ? ($(".flipclock").addClass("flipclock--show"), $(".flipclock").addClass(SAIL_ENV.config.holidayStyle)) : $(".flipclock").removeClass("flipclock--show"), "details" == e && n.data.total_time && (t = window.localStorage.getItem("goods_flip_clock_stamp") ? parseInt((new Date).getTime() / 1e3) - window.localStorage.getItem("goods_flip_clock_stamp") : 0, c = parseInt(n.data.total_time - t), r = window.localStorage.getItem("goods_flip_last_time") ? window.localStorage.getItem("goods_flip_last_time") : window.localStorage.setItem("goods_flip_last_time", n.data.total_time), c < 0 && 1 == n.data.is_repeat && (c = n.data.total_time, window.localStorage.setItem("goods_flip_clock_stamp", parseInt((new Date).getTime() / 1e3))), c < -86400 && 0 == n.data.is_repeat && (c = n.data.total_time, window.localStorage.setItem("goods_flip_clock_stamp", parseInt((new Date).getTime() / 1e3))), r != n.data.total_time && c <= 0 && (c = n.data.total_time, window.localStorage.setItem("goods_flip_last_time", n.data.total_time)), r != n.data.total_time && window.localStorage.setItem("goods_flip_last_time", n.data.total_time), s = "<h3>" + n.data.display_text + '</h3><div class="timer"></div>', c <= 0 && $(".flipclock").removeClass("flipclock--show"), 0 < c && ($(".flipclock").html(s), l = 10 * c, window.localStorage.getItem("goods_flip_clock_stamp") || window.localStorage.setItem("goods_flip_clock_stamp", parseInt((new Date).getTime() / 1e3)), clearInterval(d.timer), d.timer = setInterval(function () {
                    var e, t, a, i;
                    l = --l < 0 ? 0 : l, e = parseInt(l / 10 / 60 / 60) < 10 ? "0" + parseInt(l / 10 / 60 / 60) : parseInt(l / 10 / 60 / 60), t = parseInt(l / 10 / 60) % 60 < 10 ? "0" + parseInt(l / 10 / 60) % 60 : parseInt(l / 10 / 60) % 60, a = parseInt(l / 10) % 60 < 10 ? "0" + parseInt(l / 10) % 60 : parseInt(l / 10) % 60, i = parseInt(l % 10), $(".flipclock").find(".timer").html(e + ":" + t + ":" + a + "." + i), 0 == l && (1 == n.data.is_repeat ? (window.localStorage.setItem("goods_flip_clock_stamp", parseInt((new Date).getTime() / 1e3)), l = 10 * n.data.total_time) : (clearInterval(d.timer), $(".J-Product").find(".flipclock").removeClass("flipclock--show"), window.screen.availWidth < 768 && $(".J-Product").css("padding-top", "12px")))
                }, 100))), window.screen.availWidth < 768 && $(".J-Product").css("padding-top", $(".flipclock").hasClass("flipclock--show") ? "52px" : "12px"), "order" == e && n.data.ext_total_time && (i = parseInt((new Date).getTime() / 1e3), o = window.localStorage.getItem("flip_clock_stamp") ? i - window.localStorage.getItem("flip_clock_stamp") : 0, c = n.data.ext_total_time - o, a = d.formaTime(c), s = '<div class="order-count-down J-CountDownTime">\n                                    <span class="iconfont icon-naozhong-"></span>\n                                    ' + SAIL_ENV.language[SAIL_ENV.language.lang].filpclock_forma_time(a) + "\n                                </div>", $(".J-OrderCountDown").html(s), window.localStorage.getItem("flip_clock_stamp") || window.localStorage.setItem("flip_clock_stamp", i), clearInterval(d.timer), d.timer = setInterval(function () {
                    --c <= 0 && (clearInterval(d.timer), window.localStorage.removeItem("flip_clock_stamp"), $(".J-CountDownTime").text(SAIL_ENV.language[SAIL_ENV.language.lang].filpclock)), $(".J-CountDown").text(d.formaTime(c))
                }, 1e3)))
            })
        }, formaTime: function (e, t) {
            return 0 <= e && this.timer && t && (clearInterval(this.timer), window.localStorage.setItem("flip_clock_stamp", parseInt((new Date).getTime() / 1e3)), e = t), (e < 60 ? "00" : 10 <= e / 60 ? parseInt(e / 60) : "0" + parseInt(e / 60)) + " : " + (10 <= e % 60 ? e % 60 : "0" + parseInt(e % 60))
        }
    }, SAIL_ENV.flipClock.init()
}), $(function () {
    window.SAIL_ENV.ProductGroups = {
        init: function () {
            $(".J-ProductGroupsImg").length && $(".product-groups-info").find(".J-ProductGroupsImg").each(function () {
                $(this).addClass("active")
            }), this.event()
        }, event: function () {
            var r = this;
            $(document).on("change", ".product-groups-type", function () {
                var e = $(this).parent("li").index(), t = $(this).find("option:selected").data("price"),
                    a = $(this).find("option:selected").data("orig-price"),
                    i = $(this).find("option:selected").data("compare-at-price"),
                    n = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).find("option:selected").data("orig-price") : parseFloat(t * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2),
                    o = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).find("option:selected").data("orig-compare-at-price") : parseFloat(i * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2);
                $(this).parent("li").find(".price").find(".pay-price").text(SAIL_ENV.config.currencyEntity.symbol + n).attr("data-price", t), $(this).parent("li").find(".price").find(".pay-price").attr("data-seller-price", a), 0 == i || parseFloat(i) <= parseFloat(t) ? $(this).parent("li").find(".price").find(".orig-price").text(" ") : $(this).parent("li").find(".price").find(".orig-price").text(SAIL_ENV.config.currencyEntity.symbol + o).attr("data-price", i), $(".product-groups-info").find(".product-groups-img").eq(e).find("img").attr("src", $(this).find("option:selected").data("image-url")), r.totalPrice()
            }), $(document).on("click", ".J-ProductGroups", function () {
                var e = $(this).parent("li").index(), t = "";
                $(this).parent("li").hasClass("checked") ? (t = "hide", $(this).parent("li").removeClass("checked"), $(this).removeClass("jh-checkbox-active"), $(".product-groups-info").find(".J-ProductGroupsImg").eq(e).removeClass("active")) : (t = "show", $(this).parent("li").addClass("checked"), $(this).addClass("jh-checkbox-active"), $(".product-groups-info").find(".J-ProductGroupsImg").eq(e).addClass("active")), r.eachEle(t, e), r.totalPrice()
            })
        }, totalPrice: function () {
            var e = 0, t = 0, a = 0, i = 0;
            $(".product-groups-info").find(".checked").each(function () {
                e += parseFloat($(this).find(".product-groups-type").find("option:selected").data("orig-price")), t += parseFloat(0 == $(this).find(".product-groups-type").find("option:selected").data("orig-compare-at-price") || $(this).find(".product-groups-type").find("option:selected").data("orig-compare-at-price") < $(this).find(".product-groups-type").find("option:selected").data("orig-price") ? $(this).find(".product-groups-type").find("option:selected").data("orig-price") : $(this).find(".product-groups-type").find("option:selected").data("orig-compare-at-price")), a += parseFloat($(this).find(".product-groups-type").find("option:selected").data("price")), i += parseFloat(0 == $(this).find(".product-groups-type").find("option:selected").data("compare-at-price") || $(this).find(".product-groups-type").find("option:selected").data("compare-at-price") < $(this).find(".product-groups-type").find("option:selected").data("price") ? $(this).find(".product-groups-type").find("option:selected").data("price") : $(this).find(".product-groups-type").find("option:selected").data("compare-at-price"))
            }), SAIL_ENV.config.headcode != SAIL_ENV.config.currencyEntity.currency_code ? ($(".product-groups-total").find(".pay-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + parseFloat(a * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)).attr("data-price", a), 0 == t || t <= e ? $(".product-groups-total").find(".orig-price").text(" ") : $(".product-groups-total").find(".orig-price").text(SAIL_ENV.config.currencyEntity.symbol + parseFloat(i * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)).attr("data-price", i)) : ($(".product-groups-total").find(".pay-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + parseFloat(e).toFixed(2)), 0 == t || t <= e ? $(".product-groups-total").find(".orig-price").text(" ") : $(".product-groups-total").find(".orig-price").text(SAIL_ENV.config.currencyEntity.symbol + parseFloat(t).toFixed(2)))
        }, eachEle: function () {
            var e = $(".product-groups-info").find(".J-ProductGroupsImg.active").length;
            if (e <= 0) return $(".product-groups-tips").show(), !1;
            $(".product-groups-tips").hide(), $(".product-groups-info").find(".J-ProductGroupsImg.active").each(function () {
                $(this).find(".product-groups-link").show()
            }), $(".product-groups-info").find(".J-ProductGroupsImg.active").eq(e - 1).find(".product-groups-link").hide()
        }
    }, SAIL_ENV.ProductGroups.init()
}), $(function () {
    window.SAIL_ENV.ProductRecommend = {
        init: function () {
            $(".J-isOpenRecommend").length && 1 == $(".J-isOpenRecommend").val() && this.getProductRecommend(), this.event()
        }, event: function () {
            var e = this;
            $(document).on("click", ".J-refreshRecommend", function () {
                e.getProductRecommend("refresh")
            })
        }, getProductRecommend: function (e) {
            var y = "de" == $(".J-language").val() ? "font12" : "", t = {
                product_id: $(".product-id").val() || $(".J-ProductInfo").find(".title").data("id"),
                refresh: "refresh" == e
            };
            $http.post("", JSON.stringify(t), function (r) {
                var s, e, d, c, l, p, u, h = "", g = 0, m = 0, _ = "", f = "";
                0 == r.code && (r.data.products.map(function (i) {
                    var a, n, o = "", e = {widths: "", original: ""};
                    i.hasOwnProperty("image") && (a = [], n = [], Object.keys(i.image).forEach(function (e, t) {
                        "origin_image" !== e && "" !== i.image[e] && (a.push(parseInt(e)), n.push(i.image[e])), "origin_image" == e && n.push(i.image[e])
                    }), e.widths = JSON.stringify(a), e.original = n.join(",")), i.attribute.map(function (e) {
                        return o += e.specName + "·"
                    }), 0 < o.length && (o = o.substr(0, o.length - 1)), m = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? (g = i.price, i.compare_at_price) : (g = (i.jsPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), (i.jsCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)), s = i.limitoffer_open ? '<div class="sale-discount"><span>' + SAIL_ENV.language[SAIL_ENV.language.lang].sale_discount + "</span></div>" : "", u = i.is_show_comment && ' <div class="star"><div class="score">' + i.star + "</div></div>", d = 1 == r.data.config.is_show_discount_tag ? '<div class="sale-tag">' + ($(".template6-body").length ? i.discountTag.replace("-", SAIL_ENV.language[SAIL_ENV.language.lang].save) : i.discountTag) + "</div>" : "", c = 1 == r.data.config.is_show_product_name ? ' <div class="title"><a href="' + i.target_url + '" target="_self" title="' + i.title + '">' + i.title + "</a></div>" : 2 == r.data.config.is_show_product_name ? ' <div class="title ellipsis"><a href="' + i.target_url + '" target="_self" title="' + i.title + '">' + i.title + "</a></div>" : "";
                    var t = 1 < i.sku_list.length ? '<div class="attribute"><select class="J-recommendAttribute">' : '<div class="attribute select-hide"><select class="J-recommendAttribute">';
                    1 == r.data.config.is_show_btn_add_to_cart && (f = t + i.sku_list.map(function (e, t) {
                        var a = "";
                        return i.track_sku_id == e.id ? (a += '<option data-id="' + e.id + '" data-inventory-quantity="' + e.inventory_quantity + '" data-desc="' + o + '" data-title="' + e.title + '" \n                                                        data-image-url="' + e.image_url + '" data-price="' + e.jsPrice + '" data-orig-price="' + e.price + '" data-compare-at-price="' + e.jsCompareAtPrice + '" \n                                                        data-orig-compare-at-price="' + e.compare_at_price + '"  data-limitoffer-open="' + e.data_limitoffer_open + '" selected>' + e.title + "</option>", _ = 1 == r.data.config.is_show_btn_add_to_cart ? i.sku_list[t].inventory_quantity <= 0 ? '<button class="jh-btn sl-subhead-title jh-disabled sl-secondary-btn J-BuyRecommendCart ' + y + '" disabled="disabled" data-sku-id="' + i.sku_list[t].id + '">' + SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out + "</button>" : '<button class="jh-btn sl-subhead-title sl-secondary-btn J-BuyRecommendCart ' + y + '" data-sku-id="' + i.sku_list[t].id + '">' + SAIL_ENV.language[SAIL_ENV.language.lang].btn_add_to_cart + "</button>" : "") : a += '<option data-id="' + e.id + '" data-inventory-quantity="' + e.inventory_quantity + '" data-desc="' + o + '" data-title="' + e.title + '" \n                                        data-image-url="' + e.image_url + '" data-price="' + e.jsPrice + '" data-orig-price="' + e.price + '" data-compare-at-price="' + e.jsCompareAtPrice + '" \n                                        data-orig-compare-at-price="' + e.compare_at_price + '"  data-limitoffer-open="' + e.data_limitoffer_open + '">' + e.title + "</option>", a
                    }).join("") + "</select></div>"), l = '<span class="pay-price"  data-price="' + i.jsPrice + '" data-seller-price="' + i.price + '">' + (SAIL_ENV.config.currencyEntity.symbol + g) + "</span>", p = parseFloat(i.compare_at_price) <= parseFloat(i.price) || parseFloat(i.compare_at_price) <= 0 ? '<span class="orig-price" data-price="' + i.jsCompareAtPrice + '"></span>' : '<span class="orig-price" data-price="' + i.jsCompareAtPrice + '">' + SAIL_ENV.config.currencyEntity.symbol + m + "</span>", $(".template6-body").length ? h += ' <li class="swiper-slide" data-product-id="' + i.id + '">\n                                                    <div class="grid-picture">\n                                                        ' + s + '\n                                                        <a href="' + i.target_url + '" target="_self">\n                                                            <img class="J-LazyLoad" src="' + SAIL_ENV.STATIC_HOST + '/buyer/public/img/default.png" data-widths="' + e.widths + '" data-original="' + e.original + '"  alt="' + i.title + '">\n                                                        </a>\n                                                        ' + d + "\n                                                        " + _ + '\n                                                    </div>\n                                                    <p class="price">' + l + p + " </p>\n                                                    " + c + f + "\n                                                    " + u + "\n                                                </li>" : $(".template5-body").length ? h += ' <li class="swiper-slide" data-product-id="' + i.id + '">\n                                                    <div class="grid-picture">\n                                                        ' + s + '\n                                                        <a href="' + i.target_url + '" target="_self">\n                                                            <img src=' + i.default_image_url + '  alt="' + i.title + '"> \n                                                        </a>\n                                                        ' + d + "\n                                                    </div>\n                                                    " + c + f + ' \n                                                    <p class="price">' + l + p + " </p>\n                                                    " + (u + _) + "\n                                                </li>" : h += ' <li class="swiper-slide" data-product-id="' + i.id + '">\n                                                    <div class="grid-picture">\n                                                        ' + s + '\n                                                        <a href="' + i.target_url + '" target="_self">\n                                                        <img class="J-LazyLoad" src="' + SAIL_ENV.STATIC_HOST + '/buyer/public/img/default.png" data-widths="' + e.widths + '" data-original="' + e.original + '"  alt="' + i.title + '">\n                                                        </a>\n                                                        ' + d + "\n                                                    </div>\n                                                    " + c + f + ' \n                                                    <p class="price">' + l + p + " </p>\n                                                    " + (u + _) + "\n                                                </li>"
                }), e = "<span>" + r.data.config.title + "</span><em class='J-refreshRecommend'>" + SAIL_ENV.language[SAIL_ENV.language.lang].refresh_recommend + "</em>", $(".model-recommend").length && $(".model-recommend").find(".J-title").empty().append(e), $(".model-recommend").length && $(".model-recommend").find(".J-productList").empty().append(h), $(".template5-body").length && $(".model-recommend").length && $(".J-productList").find(".grid-picture").css("height", $(".J-productList").find("li").width()), 4 < r.data.config.recommend_num && new Swiper(".model-recommend-container .swiper-container", {
                    slidesPerView: 2,
                    slidesPerGroup: 2,
                    spaceBetween: 0,
                    breakpointsInverse: !0,
                    breakpoints: {768: {allowTouchMove: !1, slidesPerView: 4, spaceBetween: 20, slidesPerGroup: 4}},
                    navigation: {
                        nextEl: ".model-recommend .swiper-button-next",
                        prevEl: ".model-recommend .swiper-button-prev"
                    }
                }), lazyLoad("J-LazyLoad"))
            }), this.changeRecommendPrice()
        }, changeRecommendPrice: function () {
            $(document).on("change", ".J-recommendAttribute", function () {
                var e = 0, t = 0;
                SAIL_ENV.Product.imgSrc = $(this).find("option:selected").data("image-url"), 0 < $(this).find("option:selected").data("inventory-quantity") ? ($(this).parent().siblings(".J-BuyRecommendCart").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_add_to_cart), $(this).parent().siblings(".J-BuyRecommendCart").removeClass("jh-disabled").removeAttr("disabled")) : ($(this).parent().siblings(".J-BuyRecommendCart").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out), $(this).parent().siblings(".J-BuyRecommendCart").addClass("jh-disabled").attr("disabled", "disabled")), t = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? (e = $(this).find("option:selected").data("orig-price"), $(this).find("option:selected").data("orig-compare-at-price")) : (e = ($(this).find("option:selected").data("price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), ($(this).find("option:selected").data("compare-at-price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)), $(this).parents().siblings(".grid-picture").find("img").attr("src", SAIL_ENV.Product.imgSrc), $(this).parents().siblings(".price").find(".pay-price").attr("data-seller-price", $(this).find("option:selected").data("orig-price")), $(this).parents().siblings(".price").find(".pay-price").text(SAIL_ENV.config.currencyEntity.symbol + e).attr("data-price", e), $(this).parents().siblings(".price").find(".pay-price").attr("data-seller-price", $(this).find("option:selected").data("orig-price")), parseFloat(t) <= parseFloat(e) || 0 == t ? $(this).parents().siblings(".price").find(".orig-price").text("") : $(this).parents().siblings(".price").find(".orig-price").text(SAIL_ENV.config.currencyEntity.symbol + t)
            })
        }
    }, SAIL_ENV.ProductRecommend.init()
}), $(".J-IsSubscribe").length && $(".J-Offers").click(function () {
    $(this).hasClass("jh-checkbox-active") ? $(this).removeClass("jh-checkbox-active") : $(this).addClass("jh-checkbox-active")
}), $(".J-CreateAccount").click(function () {
    $(this).attr("disabled", "disabled").addClass("jh-btn-loading");
    var a = {
        email: "",
        first_name: "",
        last_name: "",
        password: "",
        referer: $(".J-LoginReferer").val() || "",
        is_subscribe: $(this).siblings().find(".J-Offers").hasClass("jh-checkbox-active") ? "1" : "0"
    };
    $(this).siblings().find(".J-AccountVal").each(function () {
        var e = $(this).data("type"), t = $(this).val();
        a[e] = t
    }), new RegExp(SAIL_ENV.config.EmailReg).test(a.email) ? $http.post("/buyer/user/register", JSON.stringify(a), function (e) {
        0 == e.code ? ($(".J-CreateAccount").removeAttr("disabled").removeClass("jh-btn-loading"), $(".tips-account.tips-succeed").html(e.data.msg).show(), setTimeout(function () {
            window.location.href = e.data.url || "/index"
        }, 5e3)) : ($(".J-CreateAccount").removeAttr("disabled").removeClass("jh-btn-loading"), $(".tips-account.tips-error").html(e.msg).show())
    }) : ($(".tips-account.tips-error").text(SAIL_ENV.language[SAIL_ENV.language.lang].erro_email).show(), $(".J-CreateAccount").removeAttr("disabled").removeClass("jh-btn-loading"))
}), $(".J-SignIn").click(function () {
    $(this).attr("disabled", "disabled").addClass("jh-btn-loading");
    var a = {email: "", password: "", referer: $(".J-LoginReferer").val() || ""};
    $(this).siblings().find(".J-AccountVal").each(function () {
        var e = $(this).data("type"), t = $(this).val();
        a[e] = t
    }), new RegExp(SAIL_ENV.config.EmailReg).test(a.email) ? $http.post("/buyer/user/login", JSON.stringify(a), function (e) {
        $(".J-SignIn").removeAttr("disabled").removeClass("jh-btn-loading"), 0 == e.code ? window.location.href = e.data.url || "/index" : $(".tips-account.tips-error").html(e.msg).show()
    }) : ($(".tips-account.tips-error").text(SAIL_ENV.language[SAIL_ENV.language.lang].erro_email).show(), $(".J-SignIn").removeAttr("disabled").removeClass("jh-btn-loading"))
}), $(".J-emailSubmit").click(function () {
    $(this).attr("disabled", "disabled").addClass("jh-btn-loading");
    var e = {email: $(this).siblings().find(".J-AccountVal").val()};
    new RegExp(SAIL_ENV.config.EmailReg).test(e.email) ? $http.post("/buyer/user/reset-password-mail", JSON.stringify(e), function (e) {
        $(".J-emailSubmit").removeAttr("disabled").removeClass("jh-btn-loading"), 0 == e.code ? ($(".login-customer").show().siblings().hide(), $(".tips-account.tips-succeed").html(e.data.msg).show()) : $(".tips-account.tips-error").html(e.msg).show()
    }) : ($(".tips-account.tips-error").text(SAIL_ENV.language[SAIL_ENV.language.lang].erro_email).show(), $(".J-emailSubmit").removeAttr("disabled").removeClass("jh-btn-loading"))
}), $(".J-resetPassword").click(function () {
    $(this).attr("disabled", "disabled").addClass("jh-btn-loading");
    var a = {
        key: $(".J-resetEmailVal").data("key"),
        code: $(".J-resetEmailVal").data("code"),
        password: "",
        confirm_password: ""
    };
    $(this).siblings().find(".J-AccountVal").each(function () {
        var e = $(this).data("type"), t = $(this).val();
        a[e] = t
    }), $http.post("/buyer/user/reset-password", JSON.stringify(a), function (e) {
        $(".J-resetPassword").removeAttr("disabled").removeClass("jh-btn-loading"), 0 == e.code ? window.location.href = "/login" : $(".tips-account.tips-error").html(e.msg).show()
    })
}), $(".J-logout").click(function () {
    $http.post("/buyer/user/logout", "", function (e) {
        0 == e.code && (window.location.href = "/index")
    })
}), $(".J-AccountVal").on("keyup click", function () {
    "" == $(this).val() ? $(this).parent(".account-input").removeClass("account-input--show") : $(this).parent(".account-input").addClass("account-input--show")
}), $(".J-AccountAddress").bind("input propertychange", function () {
    "" == $(this).val() ? $(this).parent().removeClass("address-input--show") : $(this).parent().addClass("address-input--show")
}), $(".J-AccountAddress").each(function () {
    $(".J-AddressCountry,.J-AddressProvince").parent().addClass("address-input--show"), "" == $(this).val() ? $(this).parent().removeClass("address-input--show") : $(this).parent().addClass("address-input--show")
}), $(".J-AccountVal:input[name=email],.J-AccountVal:input[name=name]").bind("input propertychange", function () {
    255 < $(this).val().length ? ($(".tips-account.tips-error").html("<p>" + SAIL_ENV.language[SAIL_ENV.language.lang].max_255 + "</p>").show(500), $(this).parent(".account-input").addClass("border-red")) : ($(this).parent(".account-input").removeClass("border-red"), $(".tips-account").empty().hide())
}), $(".J-AccountVal:input[name=password]").bind("input propertychange", function () {
    40 < $(this).val().length ? ($(".tips-account.tips-error").html("<p>" + SAIL_ENV.language[SAIL_ENV.language.lang].max_40 + "</p>").show(500), $(this).parent(".account-input").addClass("border-red")) : ($(this).parent(".account-input").removeClass("border-red"), $(".tips-account").empty().hide())
}), $(".J-forgotPassword").click(function () {
    $(".submit-reset-password").show().siblings().hide()
}), $(".J-cancel").click(function () {
    $(".login-customer").show().siblings().hide()
}), $(".J-AddNewAddress").click(function () {
    $(".add-address-wrap").slideDown()
}), $(".J-cancelAddAddress").click(function () {
    $(".add-address-wrap").slideUp()
}), $(".J-OnClickForgotPassword").length && 1 == $(".J-OnClickForgotPassword").val() && $(".J-forgotPassword").click(), $(".J-AddressCountry").change(function () {
    var a = "", e = $(this).find("option:selected").data("id");
    $http.post("/sail/region/get-cities", JSON.stringify({country_id: e}), function (e) {
        0 == e.code && (e.data.map(function (e, t) {
            a += '<option data-id="' + e.id + '" value="' + e.en_name + '">' + e.en_name + "</option>"
        }), e.data.length ? ($(".J-AddressProvince").parent().show(), $(".J-AddressProvince").parent().siblings().css("width", "50%"), $(".J-AddressProvince").empty().append(a)) : ($(".J-AddressProvince").parent().hide(), $(".J-AddressProvince").parent().siblings().css("width", "100%")))
    })
}), $(".J-ContactSbumit").click(function () {
    var e = $(this).siblings("form").find("input[data-type='email']").val(),
        t = $(this).siblings("form").find("input[data-type='email']"), a = {};
    $(".J-ContactVal").each(function () {
        var e = $(this).data("type"), t = $(this).val();
        a[e] = t
    }), new RegExp("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$").test(e) ? (t.removeClass("required").next(".tips").text(""), $http.post("/buyer/page/contact-us", JSON.stringify(a), function (e) {
        0 == e.code && ($(".submit-success").show(), $(".contact-us").hide())
    })) : t.addClass("required").next(".tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].erro_email)
});
var _typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (e) {
    return typeof e
} : function (e) {
    return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
};
$(function () {
    var s = window.sessionStorage;
    ({
        country: {id: "", code: "", name: ""},
        cartList: [],
        cartToken: "",
        coupon_code: "",
        autoDiscount: "",
        amountProduct: "",
        cartProductRes: [],
        subTotalAmount: "",
        discountAmount: "",
        head_rate_value: "",
        pagelocation: "",
        cart_express: !1,
        init: function () {
            var e = this;
            e.pagelocation = $(".sail-event-page-location").val(), e.head_rate_value = $(".J-currency-code").data("rate-value"), $(".J-CartCountry").length && ($(".J-CartCountry").val($(".J-getCurrentState").val()), e.country = {
                code: $(".J-CartCountry").find("option:selected").val(),
                id: $(".J-CartCountry").find("option:selected").data("id"),
                name: $(".J-CartCountry").find("option:selected").data("countries")
            }), "orders" != e.pagelocation && e.getCartInfo(), e.addCart(), e.addGroupCart(), e.addRecommendCart(), e.event()
        },
        event: function () {
            var o = this;
            $(".J-openSlideCart").click(function () {
                o.getCartInfo(), SAIL_ENV.config.show_buycart ? (SAIL_ENV.config.show_buycart = !1, SAIL_ENV.config.mask_layer("hide"), $(".J-BuyCart--Box").removeClass("buy-cart--right")) : (SAIL_ENV.config.show_buycart = !0, SAIL_ENV.config.mask_layer("show"), $(".J-BuyCart--Box").addClass("buy-cart--right"))
            }), $(".J-DiscountTips").on("mouseover", function () {
                $(this).siblings(".cartlist-discount-tips").addClass("discount-tips--show")
            }), $(".J-DiscountTips").on("mouseout", function () {
                $(this).siblings(".cartlist-discount-tips").removeClass("discount-tips--show")
            }), $(document).on("click", ".J-Add, .J-Reduce", function () {
                var e = {
                    index: parseInt($(this).parents(".J-BuyCart").index()),
                    target: $(this).hasClass("J-Add") ? "add" : "reduce",
                    quantity: parseInt($(this).siblings(".jh-input-box").find("input").val())
                };
                $(".J-Add,.J-Reduce").addClass("disabled").attr("disabled", "disabled"), "reduce" == e.target && e.quantity <= 1 && (o.cartList.splice(e.index, 1), o.save()), ("add" == e.target || "reduce" == e.target && 1 < e.quantity) && (e.quantity = "add" == e.target ? e.quantity + 1 : e.quantity - 1, o.cartList[e.index]._quantity = e.quantity)
            }), $(document).on("blur", ".J-CartNumber, .J-ProductNumber", function () {
                var e, t = $(this).val(), a = parseInt($(this).data("inventory-quantity")), i = 0,
                    n = $(this).parents(".J-BuyCart").index();
                if ($(this).hasClass("J-CartNumber")) {
                    if ((i = 9999 < (i = parseInt($(this).val()) <= 0 || "" == t ? 0 : $(this).val().replace(/[^0-9]/g, "")) ? 9999 : i) <= 0) return o.cartList.splice(n, 1), o.save(), !1;
                    o.cartList[n]._quantity = i
                }
                $(this).hasClass("J-ProductNumber") && (a < (i = 9999 < (i = parseInt($(this).val()) <= 0 || "" == t ? 1 : $(this).val().replace(/[^0-9]/g, "")) ? 9999 : i) ? (e = a <= 0 ? 1 : a, $(this).parents(".J-Product").find(".J-InventoryQuantity").text(SAIL_ENV.language[SAIL_ENV.language.lang].max_inventory), $(this).val(e)) : $(this).parents(".J-Product").find(".J-InventoryQuantity").text(""))
            }), $(document).on("click", ".J-CartCouponOpen", function () {
                $(this).toggleClass("cart-coupon-open--show"), $(this).next("div").slideToggle()
            }), $(document).on("keyup", ".J-GetCartCouponVal", function () {
                "" != $.trim($(this).val()) ? $(this).next().removeAttr("disabled").removeClass("jh-btn-disabled") : $(this).next().attr("disabled", "disabled").addClass("jh-btn-disabled")
            }).on("input propertychange", ".J-GetCartCouponVal", function () {
                "" != $.trim($(this).val()) ? $(this).next().removeAttr("disabled").removeClass("jh-btn-disabled") : $(this).next().attr("disabled", "disabled").addClass("jh-btn-disabled"), $(this).hasClass("invalid") && $(this).removeClass("invalid"), $(".J-CartCouponTips").find(".erro-tips").text("")
            }).on("click", ".J-GetCartCoupon", function () {
                o.getCartInfo({coupon: {coupon_code: $.trim($(this).prev().val())}})
            }).on("focus", ".J-GetCartCouponVal", function () {
                /Android /.test(navigator.appVersion) && window.addEventListener("resize", function () {
                    "INPUT" != document.activeElement.tagName && "TEXTAREA" != document.activeElement.tagName || window.setTimeout(function () {
                        document.activeElement.scrollIntoViewIfNeeded()
                    }, 0)
                })
            }), $(document).on("click", ".J-RemoveCoupon, .J-CartCouponClose", function () {
                o.coupon_code = "", localStorage.removeItem("coupon_code"), o.getCartInfo()
            }), $(document).on("click", ".J-ProductAdd", function () {
                var e, t = parseInt($(this).parents(".J-Product").find(".J-ProductNumber").data("inventory-quantity")),
                    a = parseInt($(this).parents(".J-Product").find(".J-ProductNumber").val() || 1) + 1;
                $(this).parents(".J-Product").find(".J-InventoryQuantity").text(""), t < a ? (e = t <= 0 ? 1 : t, $(this).parents(".J-Product").find(".J-InventoryQuantity").text(SAIL_ENV.language[SAIL_ENV.language.lang].max_inventory), $(this).parents(".J-Product").find(".J-ProductNumber").val(e)) : $(this).parents(".J-Product").find(".J-ProductNumber").val(a)
            }), $(document).on("click", ".J-ProductReduce", function () {
                var e = parseInt($(this).parents(".J-Product").find(".J-ProductNumber").data("inventory-quantity")),
                    t = parseInt($(this).parents(".J-Product").find(".J-ProductNumber").val());
                $(this).parents(".J-Product").find(".J-InventoryQuantity").text(""), e < t && $(this).parents(".J-Product").find(".J-InventoryQuantity").text(SAIL_ENV.language[SAIL_ENV.language.lang].max_inventory), t = 0 < --t ? t : 1, $(this).parents(".J-Product").find(".J-ProductNumber").val(t)
            }), $(document).on("change", ".J-QtySelect", function () {
                var e = parseInt($(this).data("inventory-quantity")),
                    t = parseInt($(this).find("option:selected").val());
                $(this).parents(".J-Product").find(".J-InventoryQuantity").text(""), e < t && ($(this).parents(".J-Product").find(".J-InventoryQuantity").text(SAIL_ENV.language[SAIL_ENV.language.lang].max_inventory), t = e), $(this).val(t)
            }), $(document).on("click", ".J-DelCartItem", function () {
                var e = $(this).parents(".J-BuyCart").index();
                o.cartList.splice(e, 1), o.save()
            }), $(".J-close").click(function () {
                $(this).parents(".total-tips").hide()
            }), $(document).on("change", ".J-Cartpag .J-QtySelect", function () {
                var e = $(this).parents(".J-BuyCart").index();
                o.cartList[e]._quantity = $(this).val()
            }), $(".J-Gopay").click(function () {
                var t = $(this);
                $(".product-invalid").length <= 0 && ($(this).addClass("jh-btn-loading"), setTimeout(function () {
                    t.removeClass("jh-btn-loading")
                }, 5e3));
                var i = [];
                o.getCartInfo({}, function () {
                    return !(o.cartList.length <= 0) && ($(".J-Textarea").val() && (s.setItem("card-remark", $(".J-Textarea").val()), e = {
                        cartToken: o.cartToken,
                        remark: $(".J-Textarea").val()
                    }, $http.post("", JSON.stringify(e), function (e) {
                    })), o.extend(o.cartList).map(function (e, t) {
                        var a;
                        e.quantity > e.inventory_quantity && 0 < e.inventory_quantity && 1 != e.is_lower && 1 != e.is_remove && (a = 15 < e.product_title.length ? e.product_title.substring(15, 0) + ".. " : e.product_title, i.push(SAIL_ENV.language[SAIL_ENV.language.lang].inventory_limit(e.inventory_quantity, a, e.title)))
                    }), 0 < i.length && ($plug.testModal(i, !$(".J-Mask").is(":hidden")), $(".J-Gopay").removeClass("jh-btn-loading")), 0 < i.length && o.save({obj: o.extend(o.cartList, "check")}), 0 < $(".J-BuyCart.product-invalid,.J-BuyProduct li.product-invalid").length && ($(".total-tips").show(), t.parents().hasClass("cart-total") ? $("html, body").animate({scrollTop: 0}, 500) : $(".flex-main").animate({scrollTop: 2e5}, 0), $(".J-Gopay").removeClass("jh-btn-loading")), void ($(".J-BuyCart.product-invalid,.J-BuyProduct li.product-invalid").length <= 0 && i.length <= 0 && ($(".total-tips").hide(), window.location.href = "/checkouts/" + o.cartToken + "?step=contact_information")));
                    var e
                })
            }), $(document).on("click", ".add-to-cart", function () {
                var e, i, n, t = $(this).data("show-sale-tag") ? $(this).data("show-sale-tag") : 0,
                    a = $(this).data("show-inventory") ? $(this).data("show-inventory") : 0;
                SAIL_ENV.Product.imgSrc = $(this).siblings("img").attr("src") || $(this).siblings().find("img").attr("src") || $(this).parents(".tab-item").find(".img-wrapper").find("img").attr("src"), $(this).parents().hasClass("template5-body") && (SAIL_ENV.config.show_buycart = !0, SAIL_ENV.config.scrollPosition = $(window).scrollTop()), $(this).data("skuid") ? ((e = {
                    content_ids: [],
                    content_type: "product_group",
                    content_name: 0 < $(this).parents(".J-infiniteList").length ? $.trim($(this).parents(".grid-item").find(".grid-item-picture").find("img").attr("alt")) : $.trim($(this).parents("li.swiper-slide").find(".name").text()) || $.trim($(this).parents(".tab-item").find(".name").text()),
                    content_category: "",
                    currency: $(".J-currency-code").val(),
                    value: 0 < $(this).parents(".J-infiniteList").length ? parseFloat($(this).parents(".grid-item").find(".pay-price").attr("data-seller-price")) : $(this).parents(".swiper-slide").length ? parseFloat($(this).parents(".swiper-slide").find(".pay-price").attr("data-seller-price")) : parseFloat($(this).parents(".good-btn").find(".pay-price").attr("data-seller-price")),
                    num_items: 1,
                    sendout: !0
                }).content_ids.push(parseInt($(this).data("id"))), 0 < $(this).data("inventory-quantity") && (i = {
                    sku_id: $(this).data("skuid"),
                    quantity: "1",
                    attribute: {},
                    new_add: 1
                }, o.cartList.length ? (n = !0, o.cartList.map(function (e, t, a) {
                    n && e.sku_id == i.sku_id ? (e.quantity = parseInt(e.quantity) + parseInt(i.quantity), n = !1) : e.sku_id != i.sku_id && n && t == o.cartList.length - 1 && o.cartList.splice(0, 0, i)
                })) : o.cartList.splice(0, 0, i), $(".template6-body,.showcase-body,.district-body").length && (e.attribute = i.attribute) || $(".cascade-body").length, o.save({
                    side: $(".template6-body").length && "pop" != $(".J-AddCartAction").val() || $(".cascade-body,.pacific-body").length ? "toCartPage" : "showCart",
                    track: !0,
                    track_obj: e
                }))) : ($(".head-cart-popup").removeClass("head-cart-popup--show"), SAIL_ENV.Product.getProduct({product_id: $(this).data("id")}, t, a))
            }), $(".J-CartExpressHide").click(function () {
                o.cart_express ? (o.cart_express = !1, $(".cart-express-main").slideUp(300), $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].cart_express)) : (o.cart_express = !0, $(".cart-express-main").slideDown(300), $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].cart_express_hide))
            }), $(".J-CartCountry").change(function () {
                o.country = {
                    code: $(".J-CartCountry").find("option:selected").val(),
                    id: $(".J-CartCountry").find("option:selected").data("id"),
                    name: $(".J-CartCountry").find("option:selected").data("countries")
                }
            }), $(".J-GetCartExpress").click(function () {
                o.getCartInfo()
            }), $(document).on("click", ".J-closeCartPop", function () {
                $(".add-cart-popup").removeClass("add-cart-popup--show"), $(".showcase-body").length && ($(".header").removeClass("color-white"), $(".nav-icon").removeClass("close J-closeCartPop").addClass("J-NavShow"), $("html, body").removeClass("hidden").css("top", ""), $("html, body").animate({scrollTop: SAIL_ENV.config.scrollPosition}, 0))
            }), $("body").click(function (e) {
                $(".add-cart-popup").is(e.target) || 0 !== $(".add-cart-popup").has(e.target).length || $(".showcase-body").length || $(".add-cart-popup").removeClass("add-cart-popup--show")
            })
        },
        getFreeExpress: function (i, e) {
            var n = this;
            $http.post("/buyer/express/free-express", JSON.stringify({
                country_id: n.country.id,
                total: e
            }), function (e) {
                var t, a;
                0 == e.code && n.subTotalAmount < e.data.val && (a = ', <span class="J-DifferPrice" data-price="' + (t = e.data.val - n.subTotalAmount) / n.head_rate_value + '">' + SAIL_ENV.language[SAIL_ENV.language.lang].cart_express_free(t), $(".J-ExpressGather").html(i + a))
            })
        },
        getCartInfo: function (e, n) {
            "result" == this.pagelocation && (window.localStorage.removeItem("coupon_code"), window.sessionStorage.removeItem("coupon_code"), window.sessionStorage.removeItem("order_number"), window.localStorage.removeItem("flip_clock_stamp")), localStorage.getItem("coupon_code") && (this.coupon_code = localStorage.getItem("coupon_code") || "", $(".J-CartCouponOpen").addClass("cart-coupon-open--show"), $(".J-CartCouponOpen").next("div").slideDown());
            var o = this, t = {
                cart: {cart_token: o.cartToken},
                coupon: {coupon_code: o.coupon_code || ""},
                country_id: o.country.id,
                current_product_id: "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? $(".product-id").val() : ""
            }, r = $.extend(t, e);
            $http.post("", JSON.stringify(r), function (e) {
                if (0 == e.code) {
                    if ("result" == o.pagelocation) {
                        var t = window.localStorage.getItem("checkout");
                        return window.localStorage.removeItem("user_select_insurance"), window.localStorage.removeItem("__local_order_number__"), window.localStorage.removeItem(e.data.cart.token + "_step"), window.localStorage.removeItem(e.data.cart.token + "_coupon"), window.sessionStorage.removeItem(e.data.cart.token + "_step_current"), window.localStorage.removeItem(t + "_step"), window.localStorage.removeItem(t + "_coupon"), window.sessionStorage.removeItem(t + "_step_current"), window.localStorage.removeItem("checkout"), !1
                    }
                    -1 < window.location.href.indexOf("/checkouts/") ? (SAIL_ENV.config.cartType = e.data.cart.type, e.data.copyCouponCode && "" != e.data.copyCouponCode && (SAIL_ENV.config.coupon_code = e.data.copyCouponCode), 2 <= SAIL_ENV.config.cartType ? ($(".return-cart").hide(), $(".J-OrderCrumbs").find("a").hide(), $(".J-OrderCrumbs").find("a").next().hide()) : $(".return-cart").show()) : (s.removeItem(e.data.cartToken + "_step_current"), s.removeItem("card-remark")), o.cartToken = e.data.cart.token, o.cartList = e.data.cart.list || [], o.cartList.map(function (e, t) {
                        e.new_add = 0, Object.defineProperty(e, "_quantity", {
                            get: function () {
                                return this.quantity
                            }, set: function (e) {
                                this.quantity = e, o.save()
                            }
                        })
                    });
                    var a = e.data.coupon.hasOwnProperty("coupon_list") && e.data.coupon.coupon_list.map(function (e) {
                        return e.id
                    }) || [];
                    o.cartList.forEach(function (e) {
                        var t = a.indexOf(Number(e.coupon_id));
                        e.sort_by = t
                    }), 2 == e.data.coupon.type && e.data.coupon.hasOwnProperty("coupon_list") && e.data.coupon.coupon_list.length && (o.cartList = o.cartList.sort(o.makeSort("sort_by")));
                    var i = e.data.coupon.hasOwnProperty("coupon_list") ? e.data.coupon.coupon_list : [];
                    "1" == $(".J-IsRenovation").val() && 0 == e.data.cart.count ? SAIL_ENV.Decoration.init() : (o.makeCartCouponHtml(e.data.coupon, r.coupon.coupon_code), o.makeCartPriceHtml(e.data.total, e.data.coupon.total_discount), o.makeCartHtml(e.data.cart.count, !0, i), o.makeCartExpress(e.data.express, e.data.total.total), n && n())
                }
            })
        },
        addCart: function () {
            var g = this;
            if ($(".J-Product").length < 0) return !1;
            $(".JH-BuyCart, .JH-BuyPayCart").click(function () {
                var e, t = $(this), a = 0, i = {
                    content_ids: [],
                    content_type: "product_group",
                    content_name: $.trim(t.parents(".J-Product").find(".title").eq(0).text()),
                    content_category: "",
                    currency: $(".J-currency-code").val(),
                    value: parseFloat(t.parents(".J-Product").find(".pay-price").attr("data-seller-price")),
                    num_items: 0,
                    sendout: !!t.hasClass("JH-BuyCart")
                };
                $(this).addClass("jh-btn-loading").attr("disabled", "disabled"), setTimeout(function () {
                    t.removeClass("jh-btn-loading")
                }, 5e3), $(".template6-body").length && SAIL_ENV.Product.isSelectedSpecs(), 0 < t.parents(".product-types-box").length ? a = parseInt(t.parents(".product-types-box").data("product-id")) : !(a = "index" == g.pagelocation ? parseInt(t.parents(".JH-Columns").find(".product-id").val()) : parseInt($(".product-id").val())) && t.parents(".J-PopupContainer").length && (a = parseInt(t.parents(".J-PopupContainer").find(".J-ProductInfo").find(".title.sl-main-title").attr("data-id"))), i.content_ids.push(a), "recommend" == $plug.query().origin && (e = [], window.sessionStorage.getItem("product_ids") && (e = JSON.parse(window.sessionStorage.getItem("product_ids"))), o = {
                    event_name: "add_to_cart",
                    params: {ids: []}
                }, e.push($(".product-id").val()), window.sessionStorage.setItem("product_ids", JSON.stringify(e)), o.params.ids.push($(".product-id").val()), $http.post("/buyer/statistics/recommend-logger", JSON.stringify(o))), SAIL_ENV.config.cartType = "1";
                var n, o, r, s = $(this).parents(".pl40"),
                    d = $(this).hasClass("JH-BuyPayCart") && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? $(this).parents(".J-PageContainer").find(".J-Product") : $(this).parents(".JH-Columns").find(".paddL80"),
                    c = {sku_id: "", quantity: "1", attribute: {}, new_add: 1}, l = "", p = "", u = "",
                    h = $(".J-SwitchType").val();
                return $(this).hasClass("JH-BuyPayCart") && (SAIL_ENV.config.cartType = "2"), $(this).hasClass("JH-BuyPayCart") && $(".buy-now-main").length && (c.quantity = $(".buy-now-main").find(".buy-now-img").find(".fr").data("number")), c.quantity = "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() && $(this).hasClass("JH-BuyPayCart") ? $(this).parents(".J-PageContainer").find(".J-ProductNumber").val() || "1" : $(this).parents(".J-Product").find(".J-ProductNumber").val() || $(".J-PageContainer").find(".J-QtySelect").find("option:selected").val() || "1", i.num_items = c.quantity, "select" == h ? ($(".paddL80").length && d.find(".J-Attribute").each(function () {
                    c.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find("option:selected").data("title"), p += $.trim($(this).find(".J-Value").find("option:selected").data("title-code"))
                }), $(".pl40").length && s.find(".J-Attribute").each(function () {
                    c.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find("option:selected").data("title"), u += $.trim($(this).find(".J-Value").find("option:selected").data("title-code"))
                })) : ($(".paddL80").length && d.find(".J-Attribute").each(function () {
                    c.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find(".active").data("title"), p += $.trim($(this).find(".J-Value").find(".active").data("title-code"))
                }), $(".pl40").length && s.find(".J-Attribute").each(function () {
                    c.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find(".active").data("title"), u += $.trim($(this).find(".J-Value").find(".active").data("title-code"))
                })), 0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? ($(".J-SkuList").length && $(".J-SkuList").find("span").each(function () {
                    $.trim(p) == $.trim($(this).data("title-code")) && (l = $(this).data("id"), SAIL_ENV.Product.imgSrc = $(this).data("image-url"))
                }), 1 < $(".J-SkuList").find("span").length && (c.sku_id = l || ""), 1 == $(".J-SkuList").find("span").length && (c.sku_id = $(".J-SkuList").find("span").eq(0).data("id"))) : (n = ".J-SkuList-" + $(this).parents(".JH-Columns.recommend").find(".product-code").val(), $(n).find("span").each(function () {
                    $.trim(p) == $.trim($(this).data("title-code")) && (l = $(this).data("id"), SAIL_ENV.Product.imgSrc = $(this).data("image-url"))
                }), 1 < $(n).find("span").length && (c.sku_id = l || ""), 1 == $(n).find("span").length && (c.sku_id = $(n).find("span").eq(0).data("id"))), SAIL_ENV.Product.skuDetail && 0 < SAIL_ENV.Product.skuDetail.sku_list.length && (SAIL_ENV.Product.skuDetail.sku_list.map(function (e, t) {
                    $.trim(e.title_code) == u && (c.sku_id = e.id, SAIL_ENV.Product.imgSrc = e.image.file_preview || SAIL_ENV.Product.skuDetail.default_image.file_preview)
                }), SAIL_ENV.Product.skuDetail = null), !(!c.sku_id || "" == c.sku_id) && ($(this).hasClass("JH-BuyPayCart") ? ((o = []).push(c), g.save({
                    obj: o,
                    track: !0,
                    track_obj: i
                }), !1) : (g.cartList.length ? (r = !0, g.cartList.map(function (e, t, a) {
                    r && e.sku_id == c.sku_id ? (e.quantity = parseInt(e.quantity) + parseInt(c.quantity), r = !1) : t == g.cartList.length - 1 && r && g.cartList.splice(0, 0, c)
                })) : g.cartList.splice(0, 0, c), $(".template6-body,.showcase-body, .district-body").length && (i.attribute = c.attribute) || $(".cascade-body").length, g.save({
                    type: "add",
                    track: !0,
                    side: $(".template6-body").length && "pop" != $(".J-AddCartAction").val() || $(".cascade-body,.pacific-body").length ? "toCartPage" : "showCart",
                    sku_id: c.sku_id,
                    track_obj: i
                }), void (c = null)))
            })
        },
        addGroupCart: function () {
            var a = this;
            $(this);
            if ($(".J-Product").length < 0) return !1;
            $(document).on("click", ".J-BuyGroupCart", function () {
                var o = {}, i = [], r = [];
                if (SAIL_ENV.Product.imgSrc = $(this).parents(".product-groups-info").find(".J-ProductGroupsImg").find("img").attr("src"), $(".product-groups-info").find("li").each(function (e, t) {
                    var a = {
                        content_ids: [],
                        content_type: "product_group",
                        content_name: $.trim($(this).find(".product-groups-title").text()),
                        content_category: "",
                        currency: $(".J-currency-code").val(),
                        value: parseFloat($(this).find(".pay-price").attr("data-seller-price")),
                        num_items: 1
                    };
                    a.content_ids.push(parseInt($(this).data("product-id"))), i.push(a)
                }), 0 == $(".product-groups-info").find(".checked").length) return !1;
                $(".product-groups-info").find(".checked").each(function () {
                    var e = $(this).find(".product-groups-type").find("option:selected").data("sku-desc").toString().split("·"),
                        a = $(this).find(".product-groups-type").find("option:selected").data("title").toString().split("·"),
                        i = {};
                    e.map(function (e, t) {
                        e && (i[e] = a[t])
                    });
                    var t = {
                        quantity: "1",
                        attribute: i,
                        new_add: 1,
                        sku_id: $(this).find(".product-groups-type").find("option:selected").data("id") + ""
                    }, n = {
                        quantity: "1",
                        attribute: i,
                        name: $.trim($(this).find(".product-groups-title").text()),
                        images_url: $(this).find(".product-groups-type").find("option:selected").data("image-url"),
                        value: parseFloat($(this).find(".pay-price").attr("data-seller-price"))
                    };
                    r.push(n), o[$(this).find(".product-groups-type").find("option:selected").data("id")] = t
                }), a.cartList.length && a.cartList.map(function (e, t, a) {
                    o[e.sku_id] && (e.quantity = parseInt(e.quantity) + 1 + "", delete o[e.sku_id])
                }), Object.keys(o).forEach(function (e, t) {
                    a.cartList.splice(0, 0, o[e])
                }), a.save({
                    side: $(".template6-body").length && "pop" != $(".J-AddCartAction").val() || $(".cascade-body,.pacific-body").length ? "toCartPage" : "showCart",
                    track: !0,
                    track_obj: i,
                    group_obj: r
                }), $(".J-PageContainer").find(".JH-Columns").show(), $(".J-Popup").removeClass("sece--show")
            })
        },
        addRecommendCart: function () {
            var s = this;
            $(document).on("click", ".J-BuyRecommendCart", function () {
                var e = [], t = {
                    content_ids: [],
                    content_type: "product_group",
                    content_name: $.trim($(this).parents(".swiper-slide").find(".title").eq(0).text()),
                    content_category: "",
                    currency: $(".J-currency-code").val(),
                    value: parseFloat($(this).parents(".swiper-slide").find(".pay-price").attr("data-seller-price")),
                    num_items: 1,
                    sendout: !0
                };
                t.content_ids.push(parseInt($(this).parents(".swiper-slide").data("product-id"))), window.sessionStorage.getItem("product_ids") && (e = JSON.parse(window.sessionStorage.getItem("product_ids")));
                var a = {event_name: "add_to_cart", params: {ids: []}};
                e.push($(this).parents(".swiper-slide").data("product-id")), window.sessionStorage.setItem("product_ids", JSON.stringify(e)), a.params.ids.push($(this).parents(".swiper-slide").data("product-id")), $http.post("/buyer/statistics/recommend-logger", JSON.stringify(a)), SAIL_ENV.Product.imgSrc = $(this).parents(".swiper-slide").find(".grid-picture").find("img").attr("src"), SAIL_ENV.config.scrollPosition = $(window).scrollTop();
                var i = $(this).parents(".swiper-slide").find(".attribute").length && $(this).parents(".swiper-slide").find(".attribute").find("option:selected").data("desc").toString().split("·"),
                    n = $(this).parents(".swiper-slide").find(".attribute").length && $(this).parents(".swiper-slide").find(".attribute").find("option:selected").data("title").toString().split("·"),
                    o = {};
                i.length && i.map(function (e, t) {
                    e && (o[e] = n[t])
                });
                var r, a = {
                    quantity: "1",
                    attribute: o,
                    new_add: 1,
                    sku_id: $(this).parents(".swiper-slide").find(".attribute").find("option:selected").data("id") || $(this).data("sku-id")
                };
                s.cartList.length ? (r = !0, s.cartList.map(function (e, t) {
                    r && e.sku_id == a.sku_id ? (e.quantity = parseInt(e.quantity) + parseInt(a.quantity) + "", r = !1) : t == s.cartList.length - 1 && r && s.cartList.splice(0, 0, a)
                })) : s.cartList.splice(0, 0, a), $(".template6-body,.showcase-body,.district-body").length && (t.attribute = a.attribute) || $(".cascade-body").length, s.save({
                    type: "add",
                    track: !0,
                    side: $(".template6-body").length && "pop" != $(".J-AddCartAction").val() || $(".cascade-body,.pacific-body").length ? "toCartPage" : "showCart",
                    addrecommend: "recommend",
                    track_obj: t
                })
            })
        },
        extend: function (e, a) {
            var i = [], n = {};
            return e.map(function (e, t) {
                n[e.sku_id] ? n[e.sku_id].quantity = parseInt(n[e.sku_id].quantity) + parseInt(e.quantity) : (n[e.sku_id] = e, n[e.sku_id].sort_by = t)
            }), Object.keys(n).forEach(function (e, t) {
                "check" == a && n[e].quantity > parseInt(n[e].inventory_quantity) && 0 < n[e].inventory_quantity && 1 != n[e].is_lower && 1 != n[e].is_remove && (n[e].quantity = parseInt(n[e].inventory_quantity)), i.push(n[e])
            }), i = i.sort(this.makeSort("sort_by"))
        },
        makeSort: function (a) {
            return function (e, t) {
                return e[a] - t[a]
            }
        },
        save: function (s) {
            var d = $.extend({
                obj: null,
                track: !1,
                type: "",
                side: "",
                sku_id: "",
                addrecommend: "",
                group_obj: ""
            }, s);
            ($(".template5-body").length || $(".template-modular").length || $(".template6-body,.showcase-body, .district-body,.pacific-body").length) && (SAIL_ENV.config.show_buycart = !0);
            var c = this, e = d.obj ? JSON.parse(JSON.stringify(d.obj)) : JSON.parse(JSON.stringify(c.cartList)),
                t = c.extend(e, "save");
            $http.post("/buyer/cart/add", JSON.stringify({
                cart_data: t,
                coupon_code: c.coupon_code,
                cart_type: SAIL_ENV.config.cartType,
                country_id: c.country.id,
                current_sku_id: "add" == d.type && s.sku_id ? s.sku_id : "",
                current_product_id: "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? $(".product-id").val() : ""
            }), function (e) {
                var i, n, t, a, o, r;
                0 == e.code && (d.track && ("Object" == $plug.toRawType(d.track_obj) && d.track_obj.sendout && (delete d.track_obj.sendout, "function" == typeof fbq && fbq("track", "AddToCart", d.track_obj), "function" == typeof snaptr && snaptr("track", "ADD_CART", {
                    price: d.track_obj.value,
                    currency: d.track_obj.currency,
                    item_ids: d.track_obj.content_ids,
                    item_category: "",
                    number_items: d.track_obj.num_items
                }), "function" == typeof pintrk && pintrk("track", "addtocart", {
                    value: d.track_obj.value,
                    order_quantity: d.track_obj.num_items,
                    currency: d.track_obj.currency
                }), "object" == _typeof(window.uetq) && window.uetq.push("event", "add_to_cart", {}), "function" == typeof gtag && gtag("event", "add_to_cart", {
                    items: [{
                        id: s.sku_id,
                        google_business_vertical: "retail"
                    }]
                }), "function" == typeof stag && stag("page_click", "add_to_cart", {handler: $(".sail-event-page-handler").val()}), window.dotq = window.dotq || [], window.dotq.push({
                    projectId: "10000",
                    properties: {
                        pixelId: "10101331",
                        qstrings: {
                            et: "custom",
                            ea: "AddToCart",
                            gv: d.track_obj.value || "",
                            product_id: s.track_obj.content_ids[0] || ""
                        }
                    }
                })), "Array" == $plug.toRawType(d.track_obj) && d.track_obj.map(function (e, t) {
                    "function" == typeof fbq && fbq("track", "AddToCart", e), "function" == typeof snaptr && snaptr("track", "ADD_CART", {
                        price: e.value,
                        currency: e.currency,
                        item_ids: e.content_ids,
                        item_category: "",
                        number_items: e.num_items
                    }), "function" == typeof gtag && gtag("event", "add_to_cart", {
                        items: [{
                            id: e.content_ids[0],
                            google_business_vertical: "retail"
                        }]
                    }), "function" == typeof pintrk && pintrk("track", "addtocart", {
                        value: e.value,
                        order_quantity: e.num_items,
                        currency: e.currency
                    }), "object" == _typeof(window.uetq) && window.uetq.push("event", "add_to_cart", {}), "function" == typeof stag && stag("page_click", "add_to_cart", {handler: $(".sail-event-page-handler").val()}), window.dotq = window.dotq || [], window.dotq.push({
                        projectId: "10000",
                        properties: {
                            pixelId: "10101331",
                            qstrings: {
                                et: "custom",
                                ea: "AddToCart",
                                gv: e.value || "",
                                product_id: e.content_ids[0] || ""
                            }
                        }
                    })
                })), d.track && "toCartPage" == d.side && window.sessionStorage.setItem("Pixel_Helper", JSON.stringify(d.track_obj)), $(".J-Add,.J-Reduce").removeClass("disabled").removeAttr("disabled"), $(".JH-BuyCart,.J-modelAddToCart .jh-btn").removeClass("jh-btn-loading").removeAttr("disabled"), c.cartToken = e.data.cart.token, "2" == SAIL_ENV.config.cartType && (localStorage.removeItem(c.cartToken + "_step"), window.location.href = "/checkouts/" + c.cartToken + "?step=contact_information"), "showCart" == d.side && (SAIL_ENV.config.show_buycart ? (SAIL_ENV.config.show_buycart = !1, $(".J-Mask").hide(), "recommend" == d.addrecommend && $(".J-Popup").hasClass("sece--show") ? (SAIL_ENV.config.scrollPosition = $(window).scrollTop(), $("html, body").addClass("hidden").css("top", "-" + SAIL_ENV.config.scrollPosition + "px"), $(".head-cart-popup").find(".jh-model-arrow").hide()) : ($("html, body").removeClass("hidden").css("top", ""), $("html, body").animate({scrollTop: SAIL_ENV.config.scrollPosition}, 0), 768 < window.screen.availWidth && $(".head-cart-popup").find(".jh-model-arrow").show()), $(".J-BuyCart--Box").removeClass("buy-cart--right"), $(".J-HeadcartImg").find("img").attr("src", SAIL_ENV.Product.imgSrc), $(".template5-body").length && $(".head-cart-popup").addClass("head-cart-popup--show"), $(".template-modular").length && $(".head-cart-popup").addClass("head-cart-popup--show"), setTimeout(function () {
                    $(".head-cart-popup").removeClass("head-cart-popup--show")
                }, 3e3), $(".template6-body,.showcase-body, .district-body").length && (n = i = "", "Array" == $plug.toRawType(d.track_obj) ? d.group_obj.map(function (t) {
                    var e, a = "";
                    Object.keys(t.attribute).map(function (e) {
                        a = a ? a + "/" + t.attribute[e] : a + t.attribute[e]
                    }), e = "" == a ? "" : '<div class="attribute">' + a + "</div>", i += '<div class="add-list">\n                                                            <div class="current-img"><img src="' + t.images_url + '"></div>\n                                                            <div>\n                                                                <div>' + t.name + "</div>\n                                                                " + e + '\n                                                                <div class="cart-price sl-subhead-title" data-price="' + (t.value / SAIL_ENV.config.headRateValue).toFixed(2) + '">\n                                                                    ' + (SAIL_ENV.config.currencyEntity.symbol + (t.value / SAIL_ENV.config.headRateValue * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)) + "\n                                                                </div>\n                                                            </div>\n                                                        </div>", n += n ? n + "/" + t.title : n + t.title
                }) : (a = t = "", Object.keys(d.track_obj.attribute).map(function (e) {
                    t = t ? t + "/" + d.track_obj.attribute[e] : t + d.track_obj.attribute[e]
                }), a = "" == t ? "" : '<div class="attribute">' + t + "</div>", i = '<div class="add-list">\n                                                        <div class="current-img"><img src="' + SAIL_ENV.Product.imgSrc + '"></div>\n                                                        <div>\n                                                            <div>' + d.track_obj.content_name + "</div>\n                                                            " + a + '\n                                                            <div class="cart-price sl-subhead-title" data-price="' + (d.track_obj.value / SAIL_ENV.config.headRateValue).toFixed(2) + '">\n                                                                ' + (SAIL_ENV.config.currencyEntity.symbol + (d.track_obj.value / SAIL_ENV.config.headRateValue * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)) + "\n                                                            </div>\n                                                        </div>\n                                                    </div>", n = d.track_obj.content_name), $(".add-cart-popup").find(".J-CurrentAddProInfo").empty().append(i), $(".add-cart-popup").find(".J-Total").text(SAIL_ENV.config.currencyEntity.symbol + (e.data.cart.product_amount / SAIL_ENV.config.headRateValue * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)).data("price", e.data.cart.product_amount / SAIL_ENV.config.headRateValue), $(".add-cart-popup").find(".cart-num").text(e.data.cart.count), $(".add-cart-popup").find(".J-CurrentAddProTitle").text(n), $(".add-cart-popup").addClass("add-cart-popup--show"), 1 == $(".add-cart-popup").data("shutdown") && setTimeout(function () {
                    $(".add-cart-popup").removeClass("add-cart-popup--show")
                }, 1e4), $(".showcase-body").length && ($(".header").addClass("color-white"), $(".nav-icon").addClass("close J-closeCartPop").removeClass("J-NavShow"), SAIL_ENV.config.scrollPosition = $(window).scrollTop(), $("html, body").addClass("hidden").css("top", "-" + SAIL_ENV.config.scrollPosition + "px")))) : (SAIL_ENV.config.show_buycart = !0, SAIL_ENV.config.mask_layer("show"), $(".J-BuyCart--Box").addClass("buy-cart--right"))), "toCartPage" == d.side && (window.location.href = "/cart"), e.data.cart.list.length <= 0 && localStorage.removeItem(c.cartToken + "_step"), c.cartList = e.data.cart.list || [], c.cartList.map(function (e, t) {
                    e.new_add = 0, Object.defineProperty(e, "_quantity", {
                        get: function () {
                            return this.quantity
                        }, set: function (e) {
                            this.quantity = e, c.save()
                        }
                    })
                }), o = e.data.coupon.hasOwnProperty("coupon_list") && e.data.coupon.coupon_list.map(function (e) {
                    return e.id
                }) || [], c.cartList.forEach(function (e) {
                    var t = o.indexOf(Number(e.coupon_id));
                    e.sort_by = t
                }), 2 == e.data.coupon.type && e.data.coupon.hasOwnProperty("coupon_list") && (c.cartList = c.cartList.sort(c.makeSort("sort_by"))), r = e.data.coupon.hasOwnProperty("coupon_list") ? e.data.coupon.coupon_list : [], c.makeCartCouponHtml(e.data.coupon, c.coupon_code), c.makeCartPriceHtml(e.data.total, e.data.coupon.total_discount), c.makeCartHtml(e.data.cart.count, !1, r), c.makeCartExpress(e.data.express, e.data.total.total), 0 == $(".J-BuyProduct li.product-invalid").length && $(".total-tips").hide())
            })
        },
        makeCartPriceHtml: function (e, t) {
            var a = this,
                i = "0.00" != t && e.discount.length ? "-" + SAIL_ENV.config.currencyEntity.symbol + (e.discount[0].fee.split(SAIL_ENV.config.headsymbol)[1] / a.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) : "0.00" == t && e.discount.length ? e.discount[0].fee : "";
            $(".J-Total").attr("data-price", (e.total / a.head_rate_value).toFixed(2)), $(".J-Subtotal").attr("data-price", (e.product_amount / a.head_rate_value).toFixed(2)), $(".J-CartDiscount").attr("data-price", (t / a.head_rate_value).toFixed(2)), $(".J-CartDiscount").html("<strong>" + i + "</strong> "), $(".buy-cart-total .J-Total ,.cart-total-price .J-Total").html(SAIL_ENV.config.currencyEntity.currency_code + " <strong>" + SAIL_ENV.config.currencyEntity.symbol + (e.total / a.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</strong> "), $(".buy-cart-total .J-Subtotal ,.subtotal-price .J-Subtotal").html("<strong>" + SAIL_ENV.config.currencyEntity.symbol + (e.product_amount / a.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</strong> "), a.cartList.length <= 0 && ($(".J-CartEmpty").show(), $(".J-CartList").hide()), "0.00" != t || 0 < e.discount.length ? $(".cart-discount,.subtotal-price").addClass("discount--show") : $(".cart-discount,.subtotal-price").removeClass("discount--show"), a.subTotalAmount = e.total
        },
        makeCartCouponHtml: function (e, t) {
            var a, i = "";
            if ($(".discount-tips-id").val() && e.is_open ? 0 < (a = e.coupon_list.filter(function (e) {
                return e.id == $(".discount-tips-id").val()
            })).length ? $(".model-discount-tips-bottom").addClass("model-discount-tips-bottom--show").find("span").text(a[0].match + " " + a[0].next) : $(".model-discount-tips-bottom").addClass("model-discount-tips-bottom--show") : e.is_open && $(".model-discount-tips-bottom").length ? $(".model-discount-tips-bottom").addClass("model-discount-tips-bottom--show").find("span").text(e.matched + " " + e.next) : $(".model-discount-tips-bottom").removeClass("model-discount-tips-bottom--show"), !e.is_auto && e.has_auto ? $(".J-DiscountTips").show() : $(".J-DiscountTips").hide(), 0 == e.error_code && t && window.localStorage.setItem("coupon_code", t), 0 == e.detail.length && 0 == e.error_code) return $(".J-CartCouponTips").empty(), $(".J-Discount-Info").empty(), $(".J-GetCartCouponVal").removeClass("invalid"), !1;
            0 < e.detail.length && 0 == e.error_code ? ($(".J-CartCouponTips").empty(), $(".J-Discount-Info").empty(), e.detail.map(function (e, t) {
                (0 == e.is_auto && 1 == e.type || 0 == e.is_auto && 1 == e.type && 3 == e.coupon_type) && (i += '<div class="cart-coupon-item">\n                                    <span class="iconfont icon-yduizhekou">\n                                        <i class="coupon-close J-CartCouponClose">×</i>\n                                        ' + e.desc + "\n                                    </span>\n                                </div>")
            }), $(".J-GetCartCouponVal").val("").attr("placeholder", SAIL_ENV.language[SAIL_ENV.language.lang].placeholder_discount), $(".J-GetCartCoupon").addClass("jh-btn-disabled").attr("disabled", "disabled"), $(".J-GetCartCouponVal").removeClass("invalid"), $(".J-CartCouponTips").append(i)) : 1 == e.error_code ? ($(".J-CartCouponTips").find(".erro-tips") && $(".J-CartCouponTips").find(".erro-tips,.error-coupon-box").remove(), $(".J-GetCartCouponVal").addClass("invalid"), $(".J-CartCouponTips").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_1 + "</p>")) : 2 == e.error_code ? ($(".J-CartCouponTips").find(".erro-tips") && $(".J-CartCouponTips").find(".erro-tips,.error-coupon-box").remove(), $(".J-CartCouponTips").append('<div class="error-coupon-box"><span class="iconfont icon-gantanhao"></span><div><strong> ' + t + " </strong>" + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_2 + '</div><span class="iconfont icon-close J-RemoveCoupon" ></span></div>'), $(".J-GetCartCouponVal").val("").attr("placeholder", SAIL_ENV.language[SAIL_ENV.language.lang].placeholder_discount), $(".J-GetCartCoupon").addClass("jh-btn-disabled").attr("disabled", "disabled")) : 3 == e.error_code && ($(".J-CartCouponTips").find(".erro-tips") && $(".J-CartCouponTips").find(".erro-tips,.error-coupon-box").remove(), $(".J-CartCouponTips").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_3($(".J-GetCouponVal").val()) + "</p>"))
        },
        makeCartExpress: function (e, t) {
            var a, i = "", n = !0, o = 0, r = this;
            e.list && e.list.length ? (e.list.map(function (e, t) {
                o = t + 1, 0 == e.express_fee && (n = !1), a = 0 == e.express_fee ? SAIL_ENV.language[SAIL_ENV.language.lang].free : SAIL_ENV.config.currencyEntity.symbol + " " + (e.express_fee / r.head_rate_value * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), i += "<li>" + e.express_name + " " + SAIL_ENV.language[SAIL_ENV.language.lang].at + ' <span class="J-ExpressPrice" data-price="' + e.express_fee / r.head_rate_value + '">' + a + "</span> </li>"
            }), $(".J-CartResult").html(i)) : $(".J-CartResult").html(""), $(".J-ExpressGather").html(SAIL_ENV.language[SAIL_ENV.language.lang].cart_express_num(o, r.country.name)), n && r.getFreeExpress($(".J-ExpressGather").html(), t)
        },
        makeCartHtml: function (e, t, _) {
            var f = "", y = "", v = "";
            this.cartList.map(function (t, a) {
                var e, i = "", n = "",
                    o = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? t.price : (parseFloat(t.price / SAIL_ENV.config.headRateValue).toFixed(2) * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2),
                    n = t.image && t.image.file_id && t.image.hasOwnProperty("new") ? "" != t.image.new[SAIL_ENV.config.availWidth] ? t.image.new[SAIL_ENV.config.availWidth] : t.image.new.origin_image : SAIL_ENV.CART_DEFAULT_IMAGES;
                t.is_remove || parseInt(t.quantity), Object.keys(t.attribute).forEach(function (e) {
                    i = i ? i + "/" + t.attribute[e] : i + t.attribute[e]
                }), e = t.quantity <= 50 ? 50 : t.quantity;
                var r, s, d = "";
                if (t.coupon_id != v && _.length && _.map(function (e) {
                    t.coupon_id == e.id && (v = t.coupon_id, r = a, d = 0 == t.coupon_id ? '<div class="space-line"></div>' : '<div class="cart-discount-tips J-CartDiscountTips sl-subhead-title cart-discount-tips-show">\n                                            <span class="iconfont icon-yduizhekou"></span>\n                                            <em>' + (e.match + e.next) + "</em>\n                                        </div>")
                }), d = r == a ? d : "", 0 < $(".J-Cartpag").length) {
                    for (var c = "", l = "", p = "", u = 1; u <= e; u++) t.quantity == u ? p += '<option value="' + u + '" selected="selected"> ' + u + "</option>" : p += '<option value="' + u + '"> ' + u + "</option>";
                    0 == t.is_limitoffer || 1 == t.is_limitoffer && t.limitoffer_product_total <= t.limitoffer_product_discount_total ? c = $("body").hasClass("template5-body") ? (l = '<div class="types-item quantity "><label>' + SAIL_ENV.language[SAIL_ENV.language.lang].qty + ': </label> <span class="iconfont icon-31xiala"></span><select class="J-QtySelect">' + p + "</select> </div>", '<span class="J-DelCartItem">' + SAIL_ENV.language[SAIL_ENV.language.lang].remove + "</span>") : (l = '<div class="jh-input-number jh-input-number-min">\n                                            <span role="button" class="jh-input-number-decrease is-disabled iconfont icon-move J-Reduce"></span>\n                                            <span role="button" class="jh-input-number-increase iconfont icon-add J-Add"></span>\n                                        <div class="jh-input-box">\n                                            <input type="text" class="jh-input J-CartNumber sl-subhead-title" pattern="[0-9]*" data-number="' + t.inventory_quantity + '" value="' + t.quantity + '">\n                                        </div>\n                                        </div>', '<span class="iconfont icon-close J-DelCartItem"></span>') : $("body").hasClass("template5-body") ? l = '<div class="types-item quantity "><label>' + SAIL_ENV.language[SAIL_ENV.language.lang].qty + ': </label> <span class="iconfont icon-31xiala"></span><select disabled="disabled" class="J-QtySelect"><option value="' + u + '" selected="selected">' + t.quantity + "</option></select> </div>" : l += '<div class="jh-input-number jh-input-number-min"><div class="jh-input-box">\n                            <input type="text" disabled="disabled" class="jh-input J-CartNumber sl-subhead-title"  data-number="' + t.inventory_quantity + '" value="' + t.quantity + '">\n                          </div></div>';
                    var h,
                        g = parseInt(t.inventory_quantity) <= 0 ? '<li class="cart-item J-BuyCart product-invalid">' + d + '<div class="cart-img"><div class="sold-out">' + SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out + '</div><div class="cart-text">' : '<li class="cart-item J-BuyCart">' + d + '<div class="cart-img"><div class="cart-text">';
                    h = "" != (h = "1" == t.is_lower || "1" == t.is_remove ? '<li class="cart-item J-BuyCart product-invalid">' + d + '<div class="cart-img"><div class="sold-out cart-unav">Unavailable</div><div class="cart-text">' : "") ? h : g;
                    var m = ' <div class="cart-name"><a href="' + t.preview_url + "?handler=" + t.product_handler + '">' + t.product_title + '</a><div class="cart-types ' + ("" == i ? "display-none" : "") + '">' + i + '</div></div><div class="cart-types">' + i + "</div>";
                    y += h + '<a href="' + t.preview_url + "?handler=" + t.product_handler + '">    <img src="' + n + '" /></a></div>  </div>  <div class="cart-info">' + m + '    <div class="cart-price sl-subhead-title" data-price="' + parseFloat(t.price / SAIL_ENV.config.headRateValue).toFixed(2) + '">' + SAIL_ENV.config.currencyEntity.symbol + o + '</div>    <div class="cart-number">' + l + '</div>    <div class="cart-del J-Delcart">' + c + "</div>  </div></li>"
                }
                0 < $(".J-BuyCart--Box").length && (g = parseInt(t.inventory_quantity) <= 0 ? '<li class="buy-product-item J-BuyCart product-invalid">' + d + '<div class="buy-prod-img"><div class="sold-out">' + SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out + '</div><div class="buy-text">' : '<li class="buy-product-item J-BuyCart">' + d + '<div class="buy-prod-img"><div class="buy-text">', h = (s = "") != (h = "1" == t.is_lower || "1" == t.is_remove ? '<li class="buy-product-item J-BuyCart product-invalid">' + d + '<div class="buy-prod-img"><div class="sold-out buy-unav">' + SAIL_ENV.language[SAIL_ENV.language.lang].btn_unavailable + '</div><div class="buy-text">' : "") ? h : g, 0 == t.is_limitoffer || 1 == t.is_limitoffer && t.limitoffer_product_total <= t.limitoffer_product_discount_total ? s += '<div class="jh-input-number jh-input-number-min">\n                            <span class="jh-input-number-decrease is-disabled iconfont icon-move J-Reduce"></span>\n                            <span class="jh-input-number-increase iconfont icon-add J-Add"></span>\n                            <div class="jh-input-box">\n                              <input type="text" pattern="[0-9]*" class="jh-input J-CartNumber sl-subhead-title" data-number="' + t.inventory_quantity + '" value="' + t.quantity + '">\n                            </div>\n                          </div>\n                          <div class="product-del"><span class="iconfont icon-close J-DelCartItem"></span></div>' : s += '<div class="jh-input-number jh-input-number-min"><div class="jh-input-box">\n                              <input type="text" disabled="disabled" class="jh-input J-CartNumber sl-subhead-title" data-number="' + t.inventory_quantity + '" value="' + t.quantity + '">\n                            </div></div>', f += h + '\n                                <a href="' + t.preview_url + "?handler=" + t.product_handler + '"><img src="' + n + '" /></a>\n                            </div>\n                            </div>\n                            <div class="buy-prod-inform">\n                                <div class="product-name"><a href="' + t.preview_url + "?handler=" + t.product_handler + '">' + t.product_title + '</a></div>\n                                <div class="product-type">' + i + '</div>\n                                <div class="product-price sl-subhead-title" data-price="' + parseFloat(t.price / SAIL_ENV.config.headRateValue).toFixed(2) + '">' + (SAIL_ENV.config.currencyEntity.symbol + o) + " \n                            </div>\n                            " + s + "\n                        </div>\n                    </li>")
            }), 0 < $(".J-BuyProduct").length && $(".J-BuyProduct").empty().append(f), 0 < $(".J-Cartpag").length && $(".J-Cartpag").empty().append(y), 0 < e ? (99 < e ? $(".J-openSlideCart,.head-buycart").find("i").show().text("99+") : $(".J-openSlideCart,.head-buycart").find("i").show().text(e), $(".J-CartEmpty").hide(), $(".J-CartList").show(), 0 < $(".J-Cartpag li.product-invalid").length && $(".J-Cartpag").siblings(".total-tips").show()) : ($(".J-openSlideCart,.head-buycart").find("i").hide(), $(".J-CartEmpty").show(), $(".J-CartList").hide())
        }
    }).init()
}), $(function () {
    var e, t, a, i, n, o, r, s, d, c, l, p, u, h, g, m, _, f = $(".J-infiniteList").data("feed-ended"), y = !1, v = !1,
        b = window.sessionStorage, J = $(".J-infiniteList").data("offset"), I = parseInt($(".J-isOpenCurrency").val()),
        w = $(".video-wrap").length && parseInt($(".video-wrap").data("auto-play")) || 0;

    function C() {
        SAIL_ENV.config.currencyEntity.currency_code && SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(".currency-tips").hide() : ($(".currency-tips").find(".payment-currency").text(SAIL_ENV.config.headcode), $(".currency-tips").find(".display-currency").text(SAIL_ENV.config.currencyEntity.currency_code), $(".currency-tips").show())
    }

    function S() {
        $(".pay-price").each(function () {
            var e = $(this).attr("data-price");
            $(this).parent().parent().hasClass("recom-item") || $(this).parents().hasClass("product-groups-total") || $(this).parents().hasClass("model-add-to-cart") ? $(this).text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)) : $(this).text(SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2))
        }), $(".orig-price").each(function () {
            var e = ($(this).attr("data-price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2),
                t = $(this).attr("data-price"), a = $(this).siblings(".pay-price").attr("data-price");
            $(this).parent().parent().hasClass("recom-item") || $(this).parents().hasClass("product-groups-total") || $(this).parents().hasClass("model-add-to-cart") ? 0 == e || parseFloat(t) <= parseFloat(a) ? $(this).text("") : $(this).text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + e) : 0 == e || parseFloat(t) <= parseFloat(a) ? $(this).text("") : $(this).text(SAIL_ENV.config.currencyEntity.symbol + e)
        }), $(".cart-price").each(function () {
            var e = $(this).attr("data-price");
            $(this).text(SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2))
        }), $(".cart-total .J-Subtotal").each(function () {
            var e = $(this).attr("data-price");
            $(this).find("strong").text(SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2))
        }), $(".cart-total .J-CartDiscount").each(function () {
            var e = $(this).attr("data-price");
            $(this).find("strong").text(SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2))
        }), $(".cart-total,.cart-total-price").find(".J-Total").each(function () {
            var e = $(this).attr("data-price");
            $(this).html(SAIL_ENV.config.currencyEntity.currency_code + " <strong>" + SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2) + "</strong>")
        }), 0 < $(".J-CartCountry").length && $(".J-DifferPrice, .J-ExpressPrice").each(function () {
            var e = $(this).attr("data-price");
            $(this).text(SAIL_ENV.config.currencyEntity.currency_code + SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2))
        }), $(".template6-body").length || $(".save-price").each(function () {
            var e = $(this).attr("data-price");
            $("body").hasClass("template4-body") ? $(this).text(SAIL_ENV.config.currencyEntity.symbol + Math.floor(e * SAIL_ENV.config.currencyEntity.rate_value)) : $(this).text(SAIL_ENV.config.currencyEntity.symbol + (e * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2))
        })
    }

    function E() {
        f = !1;
        var e = {offset: J, category_id: $(".J-infiniteList").data("category-id") || ""};
        $http.post("/buyer/product/dynamic-loading-product", JSON.stringify(e), function (e) {
            var t, a, i, n, o, r, s, d;
            0 == e.code && (n = i = a = t = "", d = s = r = o = 0, J = e.data.next_offset, f = !!e.data.feed_ended, e.data.products.map(function (e) {
                a = SAIL_ENV.config.currencyEntity.symbol || SAIL_ENV.config.headsymbol, d = SAIL_ENV.config.currencyEntity.currency_code && SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? (s = e.price, e.compare_at_price) : (s = (e.jsPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), (e.jsCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)), i = e.limit_offer_tag ? '<div class="sale-discount"><span>' + SAIL_ENV.language[SAIL_ENV.language.lang].sale_discount + "</span></div>" : "", o = '<span class="pay-price sl-subhead-title" data-seller-price="' + e.price + '" data-price="' + e.jsPrice + '" >' + (a + s) + "</span>", r = e.compare_at_price == e.price || 0 == e.compare_at_price ? "" : "<span class='orig-price sl-subhead-title' data-seller-price='" + e.compare_at_price + "' data-price='" + e.jsCompareAtPrice + "' >" + a + d + "</span>", n = "" == e.percent_discount ? "" : '<div class="sale-tag J-openProductPopup">' + e.percent_discount + "</div>", t += '<div class="grid-item one-four-middle" data-id="' + e.product_id + '">\n                                            ' + i + '\n                                            <div class="grid-item-picture">\n                                                <img class="J-openProductPopup blur-img" data-original="' + e.default_image_url + '" src="' + e.default_image_url + '">\n                                                ' + n + '\n                                                <div data-id="' + e.product_id + '" ' + e.sku_tag + '  class="' + e.icon_cart_css + '" >\n                                                    <span class="iconfont icon-cartfill"></span>\n                                                </div>\n                                            </div>\n                                            <div class="grid-item-title J-openProductPopup">\n                                                <p class="price">' + o + r + "</p>\n                                                " + e.widget_star + "\n                                            </div>\n                                        </div>"
            }), $(".J-infiniteList").append(t))
        })
    }

    "index" == $(".sail-event-page-location").val() && window.screen.availWidth < 768 && new Swiper(".J-notify-swiper", {
        breakpoints: {
            watchOverflow: !0,
            autoHeight: !0,
            autoplay: !1,
            768: {slidesPerView: 1, pagination: {el: ".J-notify-swiper .swiper-pagination", clickable: !0}}
        }
    }), $(".J-ImMySearchButtonStyle").click(function () {
        doTrack()
    }), parseInt($(".preview-hide-code").val()) && $(".domain-tips").hide(), I ? (e = $(".J-CurrentStateCode").val(), b.getItem("headerCurrency") ? (SAIL_ENV.config.currencyEntity = JSON.parse(b.getItem("headerCurrency")), SAIL_ENV.config.currencyList = JSON.parse(b.getItem("currencyList")), SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code && SAIL_ENV.config.headcode == SAIL_ENV.config.currencyList[0].currency_code || ($(".currency-more span").html(SAIL_ENV.config.currencyEntity.currency_text), $(".currency-select").find("select").val(SAIL_ENV.config.currencyEntity.currency_code), $(".currency-select").val(SAIL_ENV.config.currencyEntity.currency_code), S()), e != SAIL_ENV.config.currencyEntity.currency_code && ($(".currency-more span").html(SAIL_ENV.config.currencyEntity.currency_text), $(".currency-select").find("select").val(SAIL_ENV.config.currencyEntity.currency_code), $(".currency-select").val(SAIL_ENV.config.currencyEntity.currency_code))) : "orders" != $(".sail-event-page-location").val() && "result" != $(".sail-event-page-location").val() && $http.post("", {}, function (e) {
        0 == e.code && (SAIL_ENV.config.currencyList = e.data, SAIL_ENV.config.currencyEntity.currency_code = e.data[0].currency_code, SAIL_ENV.config.currencyEntity.symbol = e.data[0].symbol, SAIL_ENV.config.currencyEntity.rate_value = e.data[0].rate_value, SAIL_ENV.config.currencyEntity.currency_text = $(".currency-more span").html(), b.setItem("headerCurrency", JSON.stringify(SAIL_ENV.config.currencyEntity)), b.setItem("currencyList", JSON.stringify(SAIL_ENV.config.currencyList)), SAIL_ENV.config.headcode != SAIL_ENV.config.currencyList[0].currency_code && ($(".currency-more span").html(SAIL_ENV.config.currencyEntity.currency_text), $(".currency-select").find("select").val(SAIL_ENV.config.currencyEntity.currency_code), S()))
    }), C()) : "orders" != $(".sail-event-page-location").val() && b.getItem("headerCurrency") && b.removeItem("headerCurrency"), $(document).on("click", ".currency-list li", function () {
        var t = $(".currency-list img").length ? "<img src='" + $(this).find("img").attr("src") + "' />" + $(this).data("currency-code") : $(this).data("currency-code");
        $(".currency-more span").html(t), $(".currency-list").slideUp(500);
        var a = $.trim($(this).data("currency-code"));
        SAIL_ENV.config.currencyList.map(function (e) {
            $.trim(e.currency_code) == a && (SAIL_ENV.config.currencyEntity.currency_code = e.currency_code, SAIL_ENV.config.currencyEntity.rate_value = e.rate_value, SAIL_ENV.config.currencyEntity.symbol = e.symbol, SAIL_ENV.config.currencyEntity.currency_text = t, b.setItem("headerCurrency", JSON.stringify(SAIL_ENV.config.currencyEntity)), C(), S())
        })
    }), $(document).on("click", ".currency-more", function () {
        v ? (v = !1, $(".currency-list").slideUp(500), $(this).removeClass("unfold"), $(this).children("em").addClass("icon-donwn-copy").removeClass("icon-31shouqi")) : (v = !0, $(".currency-list").slideDown(500), $(this).addClass("unfold"), $(this).children("em").removeClass("icon-donwn-copy").addClass("icon-31shouqi"))
    }), $(document).on("mouseleave", ".currency-more", function () {
        v = !1, $(".currency-list").slideUp(500), $(this).removeClass("unfold"), $(this).children("em").addClass("icon-donwn-copy").removeClass("icon-31shouqi")
    }), $(".currency-select > select,.currency-select").change(function () {
        var t = $.trim($(this).find("option:selected").data("currency-code"));
        SAIL_ENV.config.currencyList.map(function (e) {
            $.trim(e.currency_code) == t && (SAIL_ENV.config.currencyEntity.currency_code = e.currency_code, SAIL_ENV.config.currencyEntity.rate_value = e.rate_value, SAIL_ENV.config.currencyEntity.symbol = e.symbol, b.setItem("headerCurrency", JSON.stringify(SAIL_ENV.config.currencyEntity)), C(), S())
        })
    }), 0 < $(".template5-body").length && history.pushState && window.addEventListener("popstate", function () {
        setTimeout(function () {
            var e = $(".sail-event-page-location").val();
            ("/index" == window.location.pathname && "index" != e || "/" == window.location.pathname && "index" != e || "/products" == window.location.pathname && "products" != e) && window.location.reload()
        }, 10)
    }), $(document).on("click", ".jh-btn", function () {
        window.parent.postMessage({cmd: "returnHeight", params: {success: !0, data: {title: "HOEM"}}}, "*")
    }), $(document).on("click", ".J-Mask", function () {
        SAIL_ENV.config.mask_layer("hide"), 0 < $(".J-TestModal").length && $(".J-TestModal").hide(), y && (y = !1, $(".J-NavShow").removeClass("close"), $(".J-PageContainer").removeClass("PageContainer--show"), $(".J-Nav-Drawer").removeClass("drawer--left")), SAIL_ENV.config.show_buycart && (SAIL_ENV.config.show_buycart = !1, $(".J-BuyCart--Box").removeClass("buy-cart--right"))
    }), $(document).on("click", ".J-NavShow", function () {
        y ? (
                y = !1,
                SAIL_ENV.config.mask_layer("hide"),
                $(".J-NavShow").removeClass("close"),
                $(".J-PageContainer").removeClass("PageContainer--show"),
                $(".J-Nav-Drawer").removeClass("drawer--left"),
                $(".showcase-body").length && ($(".header").removeClass("color-white"),
                $(".nav-item-down-menu").slideUp(), $(".nav-item").removeClass("active"),
                $(".search-popup").removeClass("search-popup--show"))
            ) :
            (y = !0, SAIL_ENV.config.mask_layer("show"),
                $(".J-NavShow").addClass("close"),
                $(".J-Nav-Drawer").addClass("drawer--left"),
                $(".J-PageContainer").addClass("PageContainer--show"),
                $(".showcase-body").length && ($(".header").addClass("color-white"),
                $(".menu-popup").show()))
    }), b.getItem("email") && ($(".J-Subscribe").hide(), $(".newsletter-email").val(SAIL_ENV.language[SAIL_ENV.language.lang].subscribe), $(".newsletter-email").attr("disabled", "disabled").addClass("disable-input")), $(".J-Subscribe").click(function () {
        var t = $(this), a = $.trim(t.siblings(".newsletter-email").val());
        new RegExp(SAIL_ENV.config.EmailReg).test(a) ? $http.post("/buyer/user/subscribe", JSON.stringify({email: a}), function (e) {
            0 == e.code ? (b.email = a, $(".J-Subscribe").hide(), $(".newsletter-email").val(SAIL_ENV.language[SAIL_ENV.language.lang].subscribe), $(".newsletter-email").attr("disabled", "disabled").addClass("disable-input")) : t.siblings(".newsletter-email").val(e.msg)
        }) : t.siblings(".newsletter-email").val(SAIL_ENV.language[SAIL_ENV.language.lang].erro_email)
    }), 0 < $(".J-ModelDiscountPopup").length && !sessionStorage.getItem("gradient") && (sessionStorage.setItem("gradient", "gradient"), SAIL_ENV.config.mask_layer("show"), $(".J-ModelDiscountPopup").addClass("model-discount-popup--show")), $(".J-CloseModelDiscount,.J-Mask").click(function () {
        SAIL_ENV.config.mask_layer("hide"), $(".J-ModelDiscountPopup").removeClass("model-discount-popup--show")
    }), $plug.goTop(), $(".JH-product-load-more-text").on("click", function (e) {
        E(), e.stopPropagation(), e.preventDefault()
    }), $(window).scroll(function () {
        $(this).scrollTop() > $(window).height() ? $(".backtop").fadeIn() : $(".backtop").fadeOut();
        var e = $(document).scrollTop() + $(window).height(),
            t = $(".J-infiniteList").length && $(".J-infiniteList").offset().top + $(".J-infiniteList").height();
        if ($(".J-infiniteList").length && t <= e) {
            if (!f) return void $(".JH-product-load-more").remove();
            "0" == $(".J-isPreview").val() && E()
        }
    }), (768 < window.screen.availWidth || 90 == window.orientation || -90 == window.orientation) && 0 < $(".J-NavWidth").length && (t = $(".J-NavMenuWidth").width(), a = $(".J-NavWidth").width(), console.log(t, a, "ss"), 0 <= t - a ? $(".header").find(".head").addClass("mobile") : $(".header").find(".head").removeClass("mobile"), 0 <= t - a ? $(".J-NavMenuWidth").css("visibility", "hidden") : $(".J-NavMenuWidth").css("visibility", "visible")), $(document).on("click", ".J-NavMenu", function () {
        y ? (y = !1, SAIL_ENV.config.mask_layer("hide"), $(".J-Mask").hide(), $(".header").removeClass("nav-menu-show")) : (y = !0, SAIL_ENV.config.mask_layer("show"), $(".J-Mask").hide(), $(".header").addClass("nav-menu-show"))
    }), $(".video-wrap").length && "0" == $(".J-isPreview").val() && "index" == $(".sail-event-page-location").val() && (i = function (e) {
        new YT.Player($(".J-YTPlayer").attr("id"), {
            height: "360",
            width: "640",
            videoId: o,
            playerVars: {autoplay: 1},
            events: {onReady: (e.remove(), $(".J-VideoPlay,.layout-opacity").hide())}
        })
    }, n = $(".video-wrap").data("original-link").match(/^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/), o = !(!n || 11 != n[7].length) && n[7], (r = document.createElement("script")).src = "https://www.youtube.com/player_api", (s = document.getElementsByTagName("script")[0]).parentNode.insertBefore(r, s), $(".J-VideoPlay").click(function () {
        var e = $(this).parents(".video-wrap").find(".cover-plan");
        i(e)
    }), w && $(window).scroll(function () {
        var e = $(".video").length && $(".video").offset().top - 300;
        $(this).scrollTop() > e && i($(".video-wrap").find(".cover-plan"))
    })), $(".template6-body").length && ($(".featured-product,.tab-layout").find(".add-to-cart").each(function () {
        $(this).hasClass("jh-btn-disabled") && $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out)
    }), $(".featured-product").each(function () {
        $(this).find("li").each(function (e) {
            $(this).find(".featured-product-picture").length && (0 == e ? $(this).css("height", $(this).next().height()) : $(this).css("height", $(this).prev().height()))
        })
    }), $(".search-wrap").find(".search-icon").click(function () {
        var e = $(this).siblings(".search").val(),
            t = $(".search-box").find(".search-select").length || window.screen.availWidth < 768 ? $(".search-box").find(".search-select").data("search-type") : 1,
            a = $(".search-box").find(".search-select").length || window.screen.availWidth < 768 ? $(".search-box").find(".search-select").find("option:selected").val() : "";
        window.location = "/search?keyword=" + e + "&sort=&type=" + t + "&val=" + a
    }), $(".search-wrap .search").bind("keydown", function (e) {
        var t = $(this).val(),
            a = $(".search-box").find(".search-select").length || window.screen.availWidth < 768 ? $(".search-box").find(".search-select").data("search-type") : 1,
            i = $(".search-box").find(".search-select").length || window.screen.availWidth < 768 ? $(".search-box").find(".search-select").find("option:selected").val() : "";
        if ("13" == e.keyCode) return window.location = "/search?keyword=" + t + "&sort=&type=" + a + "&val=" + i, !1
    }), $(".banner").hasClass("default") || $(".banner").hasClass("same-size-first") || $(".banner").css("height", $(window).height() - parseInt($(".header").innerHeight())), $(".J-TabMenu").find("div").each(function (e) {
        $(this).click(function () {
            $(".tab-content").find(".content").eq(e).show().siblings().hide(), $(this).addClass("active").siblings().removeClass("active")
        })
    }), $(".J-AccordionMenu").click(function () {
        var e = 0, t = $(this), a = t.parent().index();
        $(".tab-content").find(".product-details").each(function () {
            $(this).is(":visible") && !t.hasClass("active") && a > $(this).parent().index() && $(this).innerHeight() > document.documentElement.clientHeight && (e = $(this).innerHeight())
        }), t.toggleClass("active").siblings(".product-details").slideToggle(300), t.parent().siblings().children(".product-details").slideUp(), t.parent().siblings().children(".accordion-menu").removeClass("active"), $("html,body").animate({scrollTop: $(window).scrollTop() - e + "px"}, 300)
    }), 768 < window.screen.availWidth ? (d = function (e) {
        var t = $(".J-NavList"), a = t[0].offsetLeft;
        "left" === e ? ($(".to-right").show(), a = l < p ? l : p, t.stop().animate({left: -a + "px"}, 300, function () {
            p <= a && ($(".to-left").css("visibility", "hidden"), t.stop().animate({left: -a - 80 + "px"}))
        })) : ($(".to-left").css("visibility", "visible"), a = 10, t.stop().animate({left: a + "px"}, 300, function () {
            0 <= a && ($(".to-right").hide(), t.stop().animate({left: "10px"}))
        }))
    }, $(".J-NavWrap").mouseleave(function () {
        $(".background").css({width: "0px", left: "0px"})
    }), $(".nav-item").hover(function () {
        var e = 0 < parseFloat($(".J-NavList")[0].offsetLeft) ? parseFloat($(this)[0].offsetLeft + $(".J-NavList")[0].offsetLeft) : parseFloat($(this)[0].offsetLeft - -$(".J-NavList")[0].offsetLeft);
        $(".background").css({
            width: $(".J-TemplateStyle").length && "pink" == $(".J-TemplateStyle").val() ? parseFloat($(this).innerWidth()) + "px" : parseFloat($(this).innerWidth() + 15) + "px",
            left: e + "px"
        })
    }), $(".to-left").on("click", function () {
        d("left")
    }), $(".to-right").on("click", function () {
        d("right")
    }), c = $(".J-NavList").innerWidth(), l = $(".J-NavWrap").innerWidth(), (p = c - l) < 0 ? $(".to-right,.to-left").hide() : $(".to-left").show(), $(".search-box").find(".search").focus(function () {
        $(this).parent().siblings(".search-link").show()
    }), $("body").click(function (e) {
        $(e.target).closest(".search-box").length || $(".search-link").hide()
    }), $(".search-select select").change(function () {
        var e = $(".search-select").find("option:selected").data("tag");
        $(".search-select").find("label").text(e)
    })) : ($(".J-FooterMenu").click(function () {
        $(this).siblings("div").toggle(500), $(this).parents(".footer-menu").toggleClass("footer-menu--show")
    }), $(".J-SubMenu").click(function () {
        $(this).toggleClass("nav-item-show")
    }), $(".J-openSearchPopup").length ? $(".J-openSearchPopup").click(function () {
        $(".search-popup").show(), $(".search-popup").find("input").focus()
    }) : $(".search-box").find(".search").focus(function () {
        $(".search-popup").show(), $(".search-popup").find("input").focus()
    }), $(".J-CancelSearch").click(function () {
        $(".search-popup").hide()
    }), $(".search-popup .search").bind("keydown", function (e) {
        var t = $(this).val();
        if ("13" == e.keyCode) return window.location = "/search?keyword=" + t + "&sort=&type=1&val=", !1
    }), $(".grid-item").click(function () {
        $(this).addClass("show-height")
    }), $(".template6-body").length && (h = (u = $(".pagination").find("li")).length, g = 2, m = '<span class="spot">...</span>', u.each(function (e) {
        $(this).hasClass("active") && (g = e)
    }), 9 < h && (g < 5 && 6 < h - g ? (u.slice(6, h - 3).hide(), u.eq(h - 3).before(m)) : h - g < 6 ? (u.slice(3, h - 6).hide(), u.eq(h - 7).before(m)) : (u.slice(3, g - 1).hide(), u.eq(g - 1).before(m), u.slice(g + 2, h - 3).hide(), u.eq(h - 3).before(m)))), $(".head-notice").length ? (_ = $(".head-notice").innerHeight(), $(".menu-box").css("top", _ + "px"), $(".nav-box").css("top", _ + 48 + "px")) : ($(".menu-box").css("top", "0px"), $(".nav-box").css("top", "48px")))), $(".J-back-menu").click(function () {
        $(this).parents(".nav-item-down-menu").slideUp(), $(this).parent(".nav-item").removeClass("active")
    }), $(document).on("click", ".J-Search", function () {
        $(".search-popup").addClass("search-popup--show"), $(".menu-popup").hide()
    }), $(".pacific-body").length && $(".J-openSearchPopup").length && ($(".J-openSearchPopup").click(function () {
        $(".search-popup,.header,.head-notice").css("z-index", "99999"), $(".J-Mask,.search-popup").show(), $(".search-popup").find("input").focus()
    }), $(".J-CancelSearch").click(function () {
        $(".search-popup,.header,.head-notice").removeAttr("style"), $(".J-Mask,.search-popup").hide()
    }), $(".search-popup .search").bind("keydown", function (e) {
        var t = $(this).val();
        if ("13" == e.keyCode) return window.location = "/search?keyword=" + t + "&sort=", !1
    }))
}), $(function () {
    var n, o, e, r = 0, s = !1;
    $(".good-info").find(".add-to-cart").each(function () {
        $(this).hasClass("jh-btn-disabled") ? $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out) : $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_add_to_cart)
    }), n = 0 < $(".head-notice").length && !$(".head-notice").is(":hidden") ? $(".head-notice").outerHeight() : 0, e = 0 < $(".J-NavMenuWidth").length && !$(".J-NavMenuWidth").is(":hidden") ? $(".J-NavMenuWidth").outerHeight() : 0, o = $(".J-Header").outerHeight() + n - e, $(".head-cart-popup").css("top", o), $(".headerIndex").length ? (s = !0, 200 < $(window).scrollTop() && $(".J-HeaderType").removeClass("headerIndex")) : $(".J-HeaderType").length && $(".header-main").css("height", $(".J-HeaderType").outerHeight()), $(window).scroll(function () {
        // var e, t = $(this).scrollTop(), a = $(".banner").length && $(".banner").outerHeight();
        // 0 < $(".J-Header").length && !$(".template6-body").length && (n < t ? ($(".J-Header").addClass("fixed-top"), $(".head-cart-popup").css({top: $(".J-Header").outerHeight()}), $(".showcase-body").length < 0 && $(".J-Header").length && $(".J-PageContainer").css("padding-top", $(".J-Header").outerHeight()), !$(".J-Header").find(".head").hasClass("mobile") && 768 < window.screen.availWidth && (r = (r <= t ? $(".J-NavWidth").addClass("invisible") : $(".J-NavWidth").removeClass("invisible"), t)), window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".header").innerHeight()) + "px"), sessionStorage.setItem("lastSaleTop", parseInt($(".header").innerHeight()) + "px"))) : (0 < $(".J-Mask:visible").length && 0 < $(".template3-body").length || $(".J-Header").removeClass("fixed-top"), $(".head-cart-popup").length && $(".head-cart-popup").css({top: o}), $(".showcase-body").length < 0 && 0 < $(".J-Header").length && $(".J-PageContainer").css("padding-top", 0), window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".header").innerHeight()) + parseInt($(".head-notice").innerHeight()) + 20 + "px"), sessionStorage.setItem("lastSaleTop", parseInt($(".header").innerHeight()) + parseInt($(".head-notice").innerHeight()) + 20 + "px"))), a < t ? $(".J-Header").addClass("color-black") : $(".J-Header").removeClass("color-black")), 0 < $(".J-HeaderType").length && (200 < t ? ($(".head-notice").hide(), r <= t ? ($(".J-HeaderType").removeClass("fixed-top"), s && $(".J-HeaderType").addClass("headerIndex"), r = t, window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", "0"), sessionStorage.setItem("lastSaleTop", "0px"))) : ($(".J-HeaderType").addClass("fixed-top"), s && $(".J-HeaderType").removeClass("headerIndex"), r = t, window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".J-HeaderType").innerHeight()) + "px"), sessionStorage.setItem("lastSaleTop", parseInt($(".J-HeaderType").innerHeight()) + "px")))) : ($("html, body").hasClass("hidden") ? $(".J-HeaderType").removeClass("headerIndex fixed-top") : ($(".J-HeaderType").addClass("fixed-top"), s && $(".J-HeaderType").addClass("headerIndex")), $(".head-notice").show(), window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".J-HeaderType").innerHeight()) + 20 + "px"), sessionStorage.setItem("lastSaleTop", parseInt($(".J-HeaderType").innerHeight()) + 20 + "px")))), $(".template6-body").length && !$(".header").hasClass("nav-menu-show") && (e = $(".head-notice").length ? t <= parseInt($(".head-notice").innerHeight()) ? t : parseInt($(".head-notice").innerHeight()) : 0, t > parseInt($(".header").innerHeight()) ? r < t ? ($(".header").css("transform", "translate3d(0px, -100%, 0px)"), r = t, window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", "0"), sessionStorage.setItem("lastSaleTop", "0px"))) : ($(".header").addClass("fixed-top"), $(".header").css("transform", "translate3d(0px, -" + e + "px, 0px)"), $(".J-PageContainer").css("padding-top", "index" == $(".sail-event-page-location") ? parseInt($(".header").innerHeight() - e) : $(".header").innerHeight()), r = t, window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".logo-box").innerHeight()) + "px"), sessionStorage.setItem("lastSaleTop", parseInt($(".logo-box").innerHeight()) + "px"))) : ($(".header").css("transform", "translate3d(0px, 0px, 0px)"), window.screen.availWidth < 768 && ($(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".header").innerHeight()) + 20 + "px"), sessionStorage.setItem("lastSaleTop", parseInt($(".header").innerHeight()) + 20 + "px"))));
        var i = ($(".J-modelAddToCart").is(":hidden") ? 0 : $(".J-modelAddToCart").outerHeight()) + ($(".model-discount-tips-bottom").is(":hidden") ? 0 : $(".model-discount-tips-bottom").outerHeight());
        $(".J-footer").css("padding-bottom", i + "px")
    }), $(".J-ClearRecentAll").click(function () {
        $http.post("/buyer/product/rem-recent-all ", "", function (e) {
            0 == e.code && $(".product-history").remove()
        })
    }), $(".J-ClearRecent").click(function () {
        var e = {product_id: $(this).data("id")}, t = $(this).parents("li");
        $http.post("/buyer/product/rem-recent", JSON.stringify(e), function (e) {
            0 == e.code && t.remove()
        })
    })
}), $(function () {
    window.SAIL_ENV.Product = {
        sku_id: "",
        imgSrc: "",
        skuDetail: null,
        referrer_url: "",
        bannerSlides: null,
        bannerSlideModel: null,
        isClick: !1,
        imgIndex: 0,
        init: function () {
            this.event()
        },
        event: function () {
            var e, i, a = this;
            $(".pop-close,.product-types-box .jh-btn,.J-Mask").click(function () {
                $(".product-types-box").removeClass("product-types-box--show"), SAIL_ENV.config.mask_layer("hide")
            }), $(document).on("click", ".J-openProductPopup", function () {
                $(".head-cart-popup").removeClass("head-cart-popup--show"), SAIL_ENV.config.scrollPosition = $(window).scrollTop(), a.getProductDetail({product_id: $(this).closest(".grid-item").data("id")})
            }), $(".J-close-popup,.J-PopupContainer .jh-btn").click(function () {
                a.closePopup()
            }), window.screen.availWidth <= 768 ? ($(".product-details-banner").removeClass("view-large-image"), $(".product-banner").length && (1 < $(".swiper-slide").length ? (o = $(".gallery-top .swiper-slide"), e = new Swiper(".gallery-thumbs", {
                watchOverflow: !0,
                watchSlidesVisibility: !0,
                spaceBetween: 14,
                slidesPerView: 4,
                slidesPerGroup: 1,
                navigation: {nextEl: ".swiper-button-next", prevEl: ".swiper-button-prev"},
                breakpoints: {768: {slidesPerView: 4, slidesPerGroup: 1}}
            }), i = new Swiper(".gallery-top", {
                autoHeight: !0,
                spaceBetween: 1,
                slidesPerView: 1,
                pagination: {el: ".swiper-pagination", type: "fraction"},
                breakpoints: {768: {navigation: {nextEl: ".swiper-button-next", prevEl: ".swiper-button-prev"}}},
                thumbs: {swiper: e}
            }), a.bannerSlideModel = function (a) {
                o.each(function (e, t) {
                    if ($(this).data("id") == a) return i.slideTo(e, 500, !1), !1
                })
            }) : $(".banner").children(".swiper-pagination").hide()), $(".JH-FixedBuyCart").click(function () {
                $(".product .JH-BuyCart").click()
            })) : ($(".J-Popup").click(function (e) {
                var t = $(".product-details-popup");
                t.is(e.target) || 0 !== t.has(e.target).length || a.closePopup()
            }), $(".J-Overview").addClass("active").siblings().removeClass("active"));
            var t, n, o, r = $(".product-details-box").find("iframe"), s = $(".product-details-box").find("table");
            0 < r.length && r.each(function () {
                0 < $(this).attr("src").indexOf("www.youtube.com") && $(this).parent().addClass("video-wrapper")
            }), 0 < s.length && s.each(function () {
                $(this).wrap("<div class='table-wrapper'></div>")
            }), window.screen.availWidth <= 768 && $("body").hasClass("template6-body") && ($(".JH-GalleryTop").removeClass("swiper-no-swiping"), $(".grid-three").length && (1 < $(".JH-GalleryTop .swiper-slide").length ? (t = new Swiper(".JH-GalleryThumbs", {
                watchOverflow: !0,
                spaceBetween: 14,
                slidesPerView: 6,
                slidesPerGroup: 6,
                watchSlidesVisibility: !0,
                centerInsufficientSlides: !0,
                navigation: {nextEl: ".JH-Next", prevEl: ".JH-Prev"},
                breakpoints: {768: {slidesPerView: 4.5, slidesPerGroup: 1}}
            }), n = new Swiper(".JH-GalleryTop", {
                watchOverflow: !0,
                autoplay: !1,
                slidesPerView: 1,
                autoHeight: !0,
                pagination: {el: ".JH-GalleryTop .swiper-pagination", type: "fraction"},
                breakpoints: {768: {navigation: {nextEl: ".JH-Next", prevEl: ".JH-Prev"}}},
                thumbs: {swiper: t}
            }), o = $(".JH-GalleryTop .swiper-slide"), a.bannerSlideModel = function (a) {
                o.each(function (e, t) {
                    if ($(this).data("id") == a) return n.slideTo(e, 500, !1), !1
                })
            }) : $(".JH-GalleryTop").children(".swiper-pagination").hide()))
        },
        closePopup: function () {
            SAIL_ENV.config.mask_layer("hide"), $(".flipclock").empty().removeClass(SAIL_ENV.config.holidayStyle), $(".J-sharePopup").length && $(".J-sharePopup").remove(), $(".J-PopupContainer").find(".JH-BuyCart").removeClass("jh-disabled").removeAttr("disabled"), $(".J-PopupContainer").find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_buy), $(".J-PageContainer").find(".JH-Columns").show(), $(".J-Popup").removeClass("sece--show"), $(".J-PopupContainer").find(".J-PopupGroupProductBottom,.J-PopupGroupProductTop,.J-PopupComment,.J-productList").empty(), $(".J-PopupContainer").find(".J-QtySelect").val("1"), $(".product-details-popup,.sece").animate({scrollTop: 0}), window.history.replaceState({}, 0, this.referrer_url)
        },
        productTyle: function () {
            var t = this;
            $(".J-ProductTypes").click(function () {
                var e;
                $(".J-SelectTips").empty().hide(), $(".J-Type").removeClass("shake"), t.isClick = !0, $(this).parents("ul").siblings("p").children(".J-TypeVal").text($(this).text()), $(this).addClass("active").siblings().removeClass("active"), $(".template6-body").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? (t.isSelectedSpecs("check"), e = !0, $(".J-Product").find(".J-Attribute").length && $(".J-Product").find(".J-Attribute").each(function () {
                    $(this).find(".J-ProductTypes").hasClass("active") || (e = !1)
                }), e && t.getProductPrices($(this).parents(".J-Product"))) : t.getProductPrices($(this).parents(".J-Product"))
            })
        },
        getProduct: function (e, i, n) {
            var o, r, s, d = this, c = "", l = 0 < $(".J-SwitchType").length ? $(".J-SwitchType").val() : "tag";
            $http.post("/buyer/product/detail", JSON.stringify(e), function (t) {
                var a;
                0 == t.code && ($(".J-Product-Title").text(t.data.title), d.skuDetail = t.data, 0 < d.skuDetail.sku_list.length && (SAIL_ENV.config.mask_layer("show"), $(".product-types-box").addClass("product-types-box--show").attr("data-product-id", e.product_id), t.data.attribute.map(function (a) {
                    c += "select" == l ? '<div class="types-item J-Attribute"> <p class="font14"><span class="J-Type" data-type="' + a.specName + '">' + a.specName + '</span><span class="types-item-size J-TypeVal" data-type-val="' + a.specName + '">' + a.specName + '</span></p><div class="product-types-select"><select class="J-Value sl-subhead-title">' + a.specItems.map(function (e, t) {
                        return '<option data-title="' + e + '" data-title-code="' + a.specCodes[t] + '">' + e + "</option>"
                    }).join("") + "</select></div></div>" : '<div class="types-item J-Attribute"><p class="font14"><span class="J-Type" data-type="' + a.specName + '">' + a.specName + '</span> <span class="J-TypeVal"></span></p> <ul class="product-types-list J-Value clearfloat ">' + a.specItems.map(function (e, t) {
                        return '<li class="product-types-item J-ProductTypes sl-subhead-title" data-title-code="' + a.specCodes[t] + '" data-title="' + e + '">' + e + "</li>"
                    }).join("") + "</ul></div>"
                }), 0 < $(".product-types-box .jh-specification").length && $(".product-types-box .jh-specification").empty().append(c).show(), $(".J-Product-Img").html('<img src="' + t.data.default_image.file_preview + '" />'), t.data.limitoffer_open ? (a = [], t.data.sku_list.length && t.data.sku_list.map(function (e) {
                    if (t.data.track_sku_id == e.id) return a = e.title.split("·")
                }), $(".product-types-box .J-Attribute").each(function (t) {
                    "select" == l ? $(this).find("select").val(a[t]) : $(this).find("li").each(function (e) {
                        $(this).data("title") == a[t] && $(this).addClass("active")
                    })
                })) : $(".product-types-box .J-Attribute").each(function () {
                    "select" == l || $(this).find("li").eq(0).addClass("active")
                }), $(".product-types-box").find(".J-ProductNumber").val(1), window.screen.availWidth < 768 && d.productTyle(), o = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? t.data.price : (t.data.jsPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), r = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? t.data.compare_at_price : (t.data.jsCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), s = 0 == r || parseFloat(r) <= parseFloat(o) || 0 == o ? "100" : Math.floor((r - o) / r * 100), $(".J-Pay-Price").text(SAIL_ENV.config.currencyEntity.symbol + o).attr("data-price", t.data.jsPrice), $(".J-Pay-Price").attr("data-seller-price", t.data.price), $(".J-Orig-Price").text(SAIL_ENV.config.currencyEntity.symbol + r).attr("data-price", t.data.jsCompareAtPrice), i && 0 < s && ($(".price").find(".sale-tag").remove() && $(".J-Pay-Price").before('<div class="sale-tag sl-subhead-title">' + SAIL_ENV.language[SAIL_ENV.language.lang].save + ' <span class="save-price">' + s + "%</span></div>")), n ? $(".inventory-quantity").show() : $(".inventory-quantity").hide()), d.getProductPrices($(".product-types-box").find(".J-Product")), $(".product-details").find("ul,li").each(function () {
                    $(this).addClass("default")
                }))
            })
        },
        getProductPrices: function (r) {
            var e, n, o, s = this, d = "", c = "", l = "", t = "";
            if ("select" == (0 < $(".J-SwitchType").length ? $(".J-SwitchType").val() : "tag") ? r.find(".J-Attribute").each(function () {
                l += $.trim($(this).find(".J-Value").find("option:selected").data("title-code")), t += "" == t ? $.trim($(this).find(".J-Value").find("option:selected").data("title")) : "/" + $.trim($(this).find(".J-Value").find("option:selected").data("title"))
            }) : r.find(".J-Attribute").each(function () {
                l += $.trim($(this).find(".J-Value").find(".active").data("title-code")), t += "" == t ? $.trim($(this).find(".J-Value").find(".active").data("title")) : "/" + $.trim($(this).find(".J-Value").find(".active").data("title"))
            }), !$(".product-types-box").hasClass("product-types-box--show") && $(".product-details-popup").is(":hidden") || s.skuDetail && 0 < s.skuDetail.sku_list.length && s.skuDetail.sku_list.map(function (e) {
                var t, a = "",
                    i = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? e.price : (e.jsPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2),
                    n = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? e.compare_at_price : (e.jsCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2);
                $.trim(e.title_code) == l && (d = e.id || "", c = d, s.imgSrc = e.image.file_preview || s.skuDetail.default_image.file_preview, r.find(".inventory-quantity").text(SAIL_ENV.language[SAIL_ENV.language.lang].sellable_inventory(e.inventory_quantity)), 1 == e.data_limitoffer_open ? r.find(".J-ProductsTisp").show().find("span").text(SAIL_ENV.language[SAIL_ENV.language.lang].limitoffer(e.data_limitoffer_num)) : r.find(".J-ProductsTisp").hide().find("span").text(""), r.parents().hasClass("product-types-box") && (d = s.isStock(e, $(".product-types-box"), !0), $(".J-Pay-Price").text(SAIL_ENV.config.currencyEntity.symbol + i).attr("data-price", e.jsPrice), $(".J-Pay-Price").attr("data-seller-price", e.price), 0 == n || parseFloat(n) <= parseFloat(i) ? $(".J-Orig-Price").text(" ") : $(".J-Orig-Price").text(SAIL_ENV.config.currencyEntity.symbol + n).attr("data-price", e.compare_at_price), $(".J-Product-Img img").attr("src", e.image.file_preview), 0 == n || parseFloat(n) <= parseFloat(i) ? $(".J-Product").find(".sale-tag").hide() : $(".J-Product").find(".sale-tag").show(), t = 0 == i ? "100" : Math.floor((n - i) / n * 100), $(".J-Product").find(".sale-tag").find(".save-price").text(t + "%")), r.parents().hasClass("product-details-popup") && (a = r || r.parents(".J-Popup").find(".fixed-add-cart"), d = s.isStock(e, $(".product-details-popup"), !0), a.find(".pay-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + i).attr("data-price", e.jsPrice), a.find(".pay-price").attr("data-seller-price", e.price), 0 == n ? a.find(".orig-price").text(" ") : a.find(".orig-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + n).attr("data-price", e.jsCompareAtPrice)), "function" == typeof s.bannerSlides && s.bannerSlides(e.image_id))
            }), $(".product-types-box").length && $(".product-types-box").hasClass("product-types-box--show") || (0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? ($(".J-SkuList").length && $(".J-SkuList").find("span").each(function () {
                $.trim(l) == $.trim($(this).data("title-code")) && (d = $(this).data("id") || "", c = d, d = s.isStock($(this), r), window.paypalisremembered && window.paypalisremembered.paypal && 0 < parseFloat($(this).data("price")) ? ($(".J-BuyNowBtn").hide(), $(".J-PaypalBtn").show()) : ($(".J-BuyNowBtn").show(), $(".J-PaypalBtn").hide()))
            }), 1 == $(".J-SkuList").find("span").length && (d = $(".J-SkuList").find("span").eq(0).data("id"), d = s.isStock($(".J-SkuList").find("span").eq(0), r), window.paypalisremembered && window.paypalisremembered.paypal && 0 < parseFloat($(".J-SkuList").find("span").eq(0).data("price")) ? ($(".J-BuyNowBtn").hide(), $(".J-PaypalBtn").show()) : ($(".J-BuyNowBtn").show(), $(".J-PaypalBtn").hide()))) : (e = r.parents(".JH-Columns").find(".product-code").val(), $(".J-SkuList-" + e).length && $(".J-SkuList-" + e).find("span").each(function () {
                $.trim(l) == $.trim($(this).data("title-code")) && (d = $(this).data("id") || "", c = d, d = s.isStock($(this), r), window.paypalisremembered && window.paypalisremembered.paypal && 0 < parseFloat($(this).data("price")) ? ($(".J-BuyNowBtn").hide(), $(".J-PaypalBtn").show()) : ($(".J-BuyNowBtn").show(), $(".J-PaypalBtn").hide()))
            }), 1 == $(".J-SkuList-" + e).find("span").length && (d = $(".J-SkuList-" + e).find("span").eq(0).data("id"), c = d, d = s.isStock($(".J-SkuList-" + e).find("span").eq(0), r), window.paypalisremembered && window.paypalisremembered.paypal && 0 < parseFloat($(".J-SkuList-" + e).find("span").eq(0).data("price")) ? ($(".J-BuyNowBtn").hide(), $(".J-PaypalBtn").show()) : ($(".J-BuyNowBtn").show(), $(".J-PaypalBtn").hide())))), $(".J-SkuList").find("span").each(function () {
                var e, t, a, i,
                    n = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).data("orig-price") : ($(this).data("price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2),
                    o = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).data("orig-compare-at-price") : ($(this).data("compare-at-price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2);
                l == $.trim($(this).data("title-code")) && (s.sku_id = $.trim($(this).data("id")), s.imgSrc = $(this).data("image-url") || r.siblings(".recom-item").find(".gallery-top").find("img").first().attr("src"), 1 == $(".J-isShowInventory").val() ? $(".inventory-quantity").show().text(SAIL_ENV.language[SAIL_ENV.language.lang].sellable_inventory($(this).data("inventory-quantity"))) : $(".inventory-quantity").hide().text(""), 1 == $.trim($(this).data("limitoffer-open")) ? $(".J-ProductsTisp").show().find("span").text(SAIL_ENV.language[SAIL_ENV.language.lang].limitoffer($(this).data("limitoffer-num"))) : $(".J-ProductsTisp").hide().find("span").text(""), "0" == $(".J-isPreview").val() && s.isClick && $plug.replaceParam(window.location.href, "variant", s.sku_id), $(".J-SingleProductImg").children().find("img").attr("src", $(this).data("image-url")), $(".J-modelAddToCart").find(".product-img").children("img").attr("src", $(this).data("image-url")), (e = $(".price-box,.flex-title,.product-info").length ? $(".paddL80").find(".price-box,.flex-title,.product-info").children(".price") : $(".paddL80").children(".price,.product-price")).find(".pay-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + n).attr("data-price", $(this).data("price")), $(".J-modelAddToCart").find(".pay-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + n).attr("data-price", $(this).data("price")), e.find(".pay-price").attr("data-seller-price", $(this).data("orig-price")), $(".J-modelAddToCart").find(".pay-price").attr("data-seller-price", $(this).data("orig-price")), 0 == o || parseFloat(o) <= parseFloat(n) ? $(".J-modelAddToCart").find(".orig-price").text(" ") : $(".J-modelAddToCart").find(".orig-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + o).attr("data-price", $(this).data("compare-at-price")), 0 == o || parseFloat(o) <= parseFloat(n) ? e.find(".orig-price").text(" ") : e.find(".orig-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + o).attr("data-price", $(this).data("compare-at-price")), 0 == o || parseFloat(o) <= parseFloat(n) ? $(".J-Product").find(".sale-tag").hide() : $(".J-Product").find(".sale-tag").show(), t = 0 == n ? "100" : Math.floor((o - n) / o * 100), $(".J-Product").find(".sale-tag").find(".save-price").text(t + "%"), t = 0 == o || parseFloat(o) <= parseFloat(n) || 0 == n ? "100" : Math.floor((o - n) / o * 100), $(".J-Product").find(".sale-tag").find(".save-price").text(t + "%"), a = $(this).attr("banner-id"), 768 < window.screen.availWidth && $(".product-banner").length && (i = $(".product-banner .gallery-top").find(".swiper-slide").eq(0).data("id"), SAIL_ENV.config.scrollPosition = $(window).scrollTop(), $(".product-banner .gallery-top").find(".swiper-slide").each(function () {
                    $(this).data("id") == a && i != a && ($(this).children("img").attr("src", $(this).children("img").data("original")), $(".product-banner .gallery-top").find(".swiper-wrapper").prepend($(this)), $("html, body").animate({scrollTop: SAIL_ENV.config.scrollPosition}, 0))
                })), 768 < window.screen.availWidth && $(".product").hasClass("grid-three") && (i = $(".product-details-banner .gallery-top").find(".swiper-slide").eq(0).data("id"), $(".recom-item .product-details-banner .gallery-top").find(".swiper-slide").each(function () {
                    $(this).data("id") == a && i != a && ($(this).children("img").attr("src", $(this).children("img").data("original")), $(".product-details-banner .gallery-top").find(".swiper-wrapper").prepend($(this)))
                })), "function" == typeof bannerSlide && bannerSlide($(this).attr("banner-id")), window.screen.availWidth < 768 && ($(".product-banner").length || $(".grid-three").length) && s.bannerSlideModel && s.bannerSlideModel($(this).attr("banner-id")))
            }), -1 == d) return !1;
            if (d && "" != d) "0" == $(".J-isPreview").val() && (0 < $(".product-types-box").length && $(".product-types-box").find(".JH-BuyCart").removeClass("jh-disabled").removeAttr("disabled"), 0 < $(".product-types-box").length && $(".product-types-box").find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_add_to_cart), 0 < $(".J-modelAddToCart").length && $(".J-modelAddToCart").find(".jh-btn").removeClass("jh-disabled").removeAttr("disabled"), 0 < r.find(".JH-BuyCart").length && r.find(".JH-BuyCart").removeClass("jh-disabled").removeAttr("disabled"), 0 < r.find(".JH-BuyCart").length && $("body").hasClass("template5-body") ? r.find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_buy) : r.find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_add_to_cart), 0 < r.find(".JH-BuyPayCart").length && r.find(".JH-BuyPayCart").removeClass("jh-disabled").removeAttr("disabled"), r.find(".Paypal-buy-now").length && r.find(".Paypal-buy-now").show(), r.find(".payment-options").length && r.find(".payment-options").show(), $(".fixed-add-cart").length && $(".fixed-add-cart").find(".JH-FixedBuyCart").removeClass("jh-disabled").removeAttr("disabled"), $(".fixed-add-cart").length && $(".fixed-add-cart").find(".jh-btn").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_buy)); else if ("0" == $(".J-isPreview").val()) {
                var a = 0 == d ? SAIL_ENV.language[SAIL_ENV.language.lang].btn_sold_out : SAIL_ENV.language[SAIL_ENV.language.lang].btn_unavailable;
                return "" == c && (a = SAIL_ENV.language[SAIL_ENV.language.lang].btn_unavailable), 0 < $(".product-types-box").length && $(".product-types-box").find(".JH-BuyCart").addClass("jh-disabled").attr("disabled", "disabled"), 0 < $(".product-types-box").length && $(".product-types-box").find(".btn-text").text(a), 0 < $(".J-modelAddToCart").length && $(".J-modelAddToCart").find(".jh-btn").addClass("jh-disabled").attr("disabled", "disabled"), 0 < r.find(".JH-BuyCart").length && r.find(".JH-BuyCart").addClass("jh-disabled").attr("disabled", "disabled"), 0 < r.find(".JH-BuyCart").length && r.find(".btn-text").text(a), 0 < r.find(".JH-BuyPayCart").length && r.find(".JH-BuyPayCart").addClass("jh-disabled").attr("disabled", "disabled"), r.find(".Paypal-buy-now").length && r.find(".Paypal-buy-now").hide(), r.find(".payment-options").length && r.find(".payment-options").hide(), r.find(".J-BuyNowBtn").length && r.find(".J-BuyNowBtn").hide(), $(".fixed-add-cart").length && $(".fixed-add-cart").find(".JH-FixedBuyCart").addClass("jh-disabled").attr("disabled", "disabled"), $(".fixed-add-cart").length && $(".fixed-add-cart").find(".jh-btn").text(a), !1
            }
            0 < $(".JH-page-location").length && "" == $(".JH-page-location").val() && 0 < $(".recommend.JH-Columns").length && (n = "bannerSlide_" + (e = r.parents(".JH-Columns").find(".product-code").val()), o = r.parents(".JH-Columns").find(".J-isShowInventory").val(), $(".J-SkuList-" + e).find("span").each(function () {
                var e, t,
                    a = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).data("orig-price") : ($(this).data("price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2),
                    i = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).data("orig-compare-at-price") : ($(this).data("compare-at-price") * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2);
                l == $.trim($(this).data("title-code")) && (s.sku_id = $.trim($(this).data("id")), r.find(".pay-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + a).attr("data-price", $(this).data("price")), r.find(".pay-price").attr("data-seller-price", $(this).data("orig-price")), 0 == i || parseFloat(i) <= parseFloat(a) ? r.find(".orig-price").text(" ") : r.find(".orig-price").text(SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + i).attr("data-price", $(this).data("compare-at-price")), 0 != (e = $(this).attr("banner-id") || $(this).prop("banner-id")) && window[n] && window[n](e), 0 == i || parseFloat(i) <= parseFloat(a) ? r.find(".sale-tag").hide() : r.find(".sale-tag").show(), t = 0 == a ? "100" : Math.floor((i - a) / i * 100), r.find(".sale-tag").find(".save-price").text(t + "%"), 1 == o ? r.parents(".JH-Columns").find(".inventory-quantity").show().text(SAIL_ENV.language[SAIL_ENV.language.lang].sellable_inventory($(this).data("inventory-quantity"))) : r.parents(".JH-Columns").find(".inventory-quantity").hide().text(""), 1 == $.trim($(this).data("limitoffer-open")) ? r.parents(".JH-Columns").find(".J-ProductsTisp").show().find("span").text(SAIL_ENV.language[SAIL_ENV.language.lang].limitoffer($.trim($(this).data("limitoffer-num")))) : r.parents(".JH-Columns").find(".J-ProductsTisp").hide().find("span").text(""))
            })), $(".J-HeadcartImg").find("img").attr("src", s.imgSrc), $(".J-modelAddToCart").find(".attribute").text(t)
        },
        getProductDetail: function (e) {
            var w = this;
            $http.post("/buyer/product/pop-detail", JSON.stringify(e), function (a) {
                $(".J-Popup").addClass("sece--show"), $(".J-Popup").find(".product-details-popup,.sece").prop("scrollTop", "0"), SAIL_ENV.config.scrollPosition = $(window).scrollTop(), $("html, body").addClass("hidden").css("top", "-" + SAIL_ENV.config.scrollPosition + "px"), window.screen.availWidth <= 768 && $("html, body").addClass("hidden").css("top", "-" + SAIL_ENV.config.scrollPosition + "px");
                var e, t, i, n, o, r, s, d, c, l, p, u, h, g, m = "", _ = "", f = "", y = "", v = "", b = "", J = "",
                    I = "";
                0 == a.code && (SAIL_ENV.config.holidayStyle = a.data.note_holiday_class, w.referrer_url = a.data.referrer_url, window.history.pushState({}, 0, a.data.detail_url), w.skuDetail = a.data, a.data.images.map(function (e, t) {
                    if (_ += '<div class="swiper-slide swiper-slide-min">\n                                                    <div><img data-original="' + e.file_preview + '" src="' + e.file_preview + '" /></div>\n                                                </div>', f += '<div class="swiper-slide" data-id="' + e.file_id + '"><img data-original="' + e.file_preview + '" src="' + e.file_preview + '"/></div>', d = 1 < a.data.images.length ? '<div class="swiper-container gallery-thumbs" >\n                                                                        <div class="swiper-wrapper">' + _ + '</div>\n                                                                    </div>\n                                                                    <div class="swiper-button-prev iconfont icon-31shouqi"></div>\n                                                                    <div class="swiper-button-next iconfont icon-31xiala"></div>' : "", m = '<div class="product-details-banner" style="display: flex">\n                                               ' + d + '\n                                                <div class="swiper-container gallery-top">\n                                                    <div class="swiper-wrapper">' + f + '</div>\n                                                    <div class="swiper-pagination"></div>\n                                                </div>\n                                            </div>', e.file_id == w.skuDetail.sku_list[0].image_id) return w.imgIndex = t, !1
                }), a.data.attribute.length && a.data.attribute.map(function (a) {
                    y += '<div class="types-item J-Attribute">\n                                            <p class="font14"><span class="J-Type" data-type="' + a.specName + '">' + a.specName + '</span> <span class="J-TypeVal"></span></p>\n                                            <ul class="product-types-list J-Value clearfloat ">\n                                                ' + a.specItems.map(function (e, t) {
                        return '<li class="product-types-item J-ProductTypes sl-subhead-title" data-title-code="' + a.specCodes[t] + '" data-title="' + e + '">' + e + "</li>"
                    }).join("") + "\n                                            </ul>\n                                        </div>"
                }), c = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? a.data.price : (a.data.jsPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), l = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? a.data.compare_at_price : (a.data.jsCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), "1" == a.data.is_open_comment && "1" == a.data.is_show_comment && (v = '<div class="star J-quickToReview"><div class="score">' + a.data.comments.star + "</div><span>" + a.data.comments.num_comment + " " + SAIL_ENV.language[SAIL_ENV.language.lang].reviews + "</span></div>"), "1" == a.data.is_open_comment && "0" == a.data.is_show_comment && (v = '<div class="star J-quickToReview"><div class="score">' + a.data.comments.star + "</div><span></div>"), t = a.data.incentive_share.is_open ? a.data.incentive_share.button_html : "", o = '<p class="price">\n                                    <span class="pay-price sl-subhead-title" data-price="' + a.data.jsPrice + '" data-seller-price="' + a.data.price + '">' + SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + c + '</span>\n                                    <span class="orig-price sl-subhead-title" data-price="' + a.data.jsCompareAtPrice + '" data-seller-price="' + a.data.compare_at_price + '">' + (0 == l || parseFloat(l) <= parseFloat(c) ? "" : SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + l) + "</span>\n                                </p>", e = '<h4 class="title sl-main-title" data-id="' + a.data.id + '" data-handler="' + a.data.handler + '">' + a.data.title + "</h4>\n                                      " + v + o + '\n                                      <div class="products-tisp J-ProductsTisp"><span></span></div>\n                                      ' + t + '\n                                      <div class="jh-specification choose-style-box">' + y + "</div>", p = '<span class="pay-price" data-price="' + a.data.group_products.jsTotalPrice + '" data-orig-price="' + a.data.group_products.totalPrice + '">' + SAIL_ENV.config.currencyEntity.symbol + (SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? a.data.group_products.totalPrice : (a.data.group_products.jsTotalPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)) + "</span>", u = parseFloat(a.data.group_products.totalCompareAtPrice) <= parseFloat(a.data.group_products.totalPrice) ? '<span class="orig-price"></span>' : '<span class="orig-price" data-price="' + a.data.group_products.jsTotalCompareAtPrice + '" data-orig-price="' + a.data.group_products.totalCompareAtPrice + '">' + SAIL_ENV.config.currencyEntity.symbol + (SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? a.data.group_products.totalCompareAtPrice : (a.data.group_products.jsTotalCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2)) + "</span>", a.data.group_products.products && a.data.group_products.products.map(function (t, e) {
                    t.attribute.map(function (e) {
                        return I += e.specName + "·"
                    }), 0 < I.length && (I = I.substr(0, I.length - 1)), h = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? t.price : (t.jsPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), g = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? t.compare_at_price : (t.jsCompareAtPrice * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), r = '<span class="pay-price" data-price="' + t.jsPrice + '" data-seller-price="' + t.price + '" >' + SAIL_ENV.config.currencyEntity.symbol + h + "</span>", s = parseFloat(t.compare_at_price) <= parseFloat(t.price) || 0 == t.compare_at_price ? '<span class="orig-price" data-price="' + t.jsCompareAtPrice + '"></span>' : '<span class="orig-price" data-price="' + t.jsCompareAtPrice + '">' + SAIL_ENV.config.currencyEntity.symbol + g + "</span>", b += '<div class="J-ProductGroupsImg active">\n                                                <div class="product-groups-img">\n                                                    <div>' + (0 == e ? '<img src="' + t.default_image_url + '" alt="">' : "<a href=" + t.target_url + ' ><img src="' + t.default_image_url + '" alt=""></a>') + '\n                                                    </div>\n                                                </div>\n                                                <div class="product-groups-link">+</div>\n                                            </div>', n = 0 == e ? '<p class="product-groups-title">' + t.title + "</p>" : '<p class="product-groups-title"><a href="' + t.handler + '" target="_self">' + t.title + "</a></p>", J += '<li class="checked">\n                                               <span class="jh-checkbox J-ProductGroups jh-checkbox-active"></span>' + n + '\n                                               <select class="product-groups-type ' + (1 < t.sku_list.length ? "" : "select-hide") + '">\n                                                    ' + t.sku_list.map(function (e) {
                        return '<option data-image-url="' + e.image_url + '" data-id="' + e.id + '" data-sku-desc="' + t.desc + '"  data-compare-at-price="' + e.jsCompareAtPrice + '"  \n                                                                data-orig-compare-at-price="' + e.compare_at_price + '" data-price="' + e.jsPrice + '" data-orig-price="' + e.price + '" \n                                                                data-inventory-quantity="' + e.inventory_quantity + '" data-title="' + e.title + '" data-limitoffer-open="' + e.data_limitoffer_open + '">' + e.title + "</option>"
                    }).join("") + '\n                                                </select>\n                                                <div class="price">' + r + s + "</div>\n                                            </li>"
                }), i = '<div class="main product-groups ' + ("upward" == a.data.group_products.location ? "upward" : "downward") + '">\n                                            <h3 class="title sl-main-title">' + a.data.group_products.title + '</h3>\n                                            <div class="product-groups-info clearfloat">' + b + '\n                                                <div class="product-groups-total">\n                                                    <p class="price sl-subhead-title">' + SAIL_ENV.language[SAIL_ENV.language.lang].groups_total_price + "：" + p + u + '</p>\n                                                    <div class="product-groups-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].groups + '</div>\n                                                    <button class="jh-btn sl-main-btn J-BuyGroupCart JH-Event-AddCart sl-subhead-title">' + SAIL_ENV.language[SAIL_ENV.language.lang].add_selected_to_cart + '</button>\n                                                </div>\n                                            </div>\n                                            <div class="product-groups-info"><ul>' + J + "</ul></div>\n                                        </div>", $(".J-PopupContainer").find(".J-ProductSwiper").empty().append(m), $(".J-PopupContainer").find(".J-ProductInfo").empty().append(e), $(".J-priceFixed").empty().append(o), $(".J-PopupContainer").find(".J-Productdetails").empty().append(a.data.body_html + a.data.app_share), a.data.incentive_share.is_open && $(".J-PageContainer").append(a.data.incentive_share.pop_html), a.data.group_products.products && 1 < a.data.group_products.products.length && "upward" == a.data.group_products.location && $(".J-PopupContainer").find(".J-PopupGroupProductTop").empty().append(i), a.data.group_products.products && 1 < a.data.group_products.products.length && "downward" == a.data.group_products.location && $(".J-PopupContainer").find(".J-PopupGroupProductBottom").empty().append(i), $(".J-PopupContainer").find(".J-PopupComment").empty().append(a.data.comments.html), $(".J-PopupContainer").find(".J-Attribute").each(function () {
                    $(this).find("li").eq(0).addClass("active")
                }), $(".J-ProductGroupsImg.active").last().children(".product-groups-link").hide(), 1 < a.data.images.length && w.sliderbannerJs(), window.screen.availWidth < 768 && w.productTyle(), w.getProductPrices($(".J-Popup .J-Product")), "1" == a.data.is_show_comment && SAIL_ENV.Comment.getProductReview(), 1 == a.data.is_open_recommend_product ? (SAIL_ENV.ProductRecommend.getProductRecommend(), $(".J-Related,.model-recommend").show()) : $(".J-Related,.model-recommend").hide(), SAIL_ENV.flipClock.flipClock("details"), $(".product-details").find("ul,li").each(function () {
                    $(this).addClass("default")
                }))
            })
        },
        replaceImg: function (e) {
            return e.replace(/<img [^>]*src=['"]([^'"]+)[^>]*>/gi, function (e, t) {
                return e.replace(/src/gi, 'class="J-LazyLoad" src="https://static.jrtkqk.com/buyer/public/img/default.png"  data-original')
            })
        },
        sliderbannerJs: function () {
            var e = new Swiper(".gallery-thumbs", {
                watchOverflow: !0,
                slidesPerView: 6,
                spaceBetween: 10,
                watchSlidesVisibility: !0,
                direction: "vertical",
                slidesPerColumnFill: "column",
                breakpoints: {768: {slidesPerView: 4, slidesPerGroup: 1, direction: "horizontal"}},
                navigation: {nextEl: ".swiper-button-next", prevEl: ".swiper-button-prev"}
            }), a = new Swiper(".gallery-top", {
                watchOverflow: !0,
                autoplay: !1,
                slidesPerView: 1,
                autoHeight: !1,
                initialSlide: this.imgIndex,
                breakpoints: {
                    768: {
                        navigation: {nextEl: ".swiper-button-next", prevEl: ".swiper-button-prev"},
                        autoHeight: !0
                    }
                },
                pagination: {el: ".swiper-pagination", type: "fraction"},
                thumbs: {swiper: e}
            }), i = $(".gallery-top .swiper-slide");
            this.bannerSlides = function (t) {
                i.each(function (e) {
                    if ($(this).data("id") == t) return a.slideTo(e, 500, !1), !1
                })
            }
        },
        isStock: function (e, t, a) {
            if (0 < t.find(".J-InventoryQuantity").length && t.find(".J-InventoryQuantity").text(""), a) {
                var i = t.find(".J-Product").find(".J-ProductNumber").val() || t.children().find(".J-QtySelect").find("option:selected").val();
                return t.find(".J-Product").find(".J-ProductNumber").data("inventory-quantity", e.inventory_quantity), t.children().find(".J-QtySelect").data("inventory-quantity", e.inventory_quantity), e.inventory_quantity <= 0 ? 0 : i > parseInt(e.inventory_quantity) ? ($plug.testModal(e.inventory_quantity, !$(".J-Mask").is(":hidden")), t.find(".J-Product").find(".J-ProductNumber").val(parseInt(e.inventory_quantity)), t.parents(".JH-Columns").find(".J-QtySelect").val(parseInt(e.inventory_quantity)), -1) : e.id
            }
            i = t.parents(".JH-Columns").find(".J-ProductNumber").val() || t.children().find(".J-QtySelect").find("option:selected").val();
            return t.parents(".JH-Columns").find(".J-ProductNumber").data("inventory-quantity", e.data("inventory-quantity")), t.children().find(".J-QtySelect").data("inventory-quantity", e.data("inventory-quantity")), e.data("inventory-quantity") <= 0 ? 0 : i > e.data("inventory-quantity") ? ($plug.testModal(e.data("inventory-quantity"), !$(".J-Mask").is(":hidden")), t.parents(".JH-Columns").find(".J-ProductNumber").val(e.data("inventory-quantity")), t.parents(".JH-Columns").find(".J-QtySelect").val(e.data("inventory-quantity")), -1) : e.data("id")
        },
        isSelectedSpecs: function (a) {
            var i, n;
            $(".template6-body").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() && (i = "", n = 0 < $(".J-SwitchType").length ? $(".J-SwitchType").val() : "tag", $(".J-Product").find(".J-Attribute").length && $(".J-Product").find(".J-Attribute").each(function (e) {
                var t = !0;
                "select" == n ? "0" == $(this).find(".J-Value").find("option:selected").val() && (i += "" == i ? $.trim($(this).find(".J-Type").data("type")) : " & " + $.trim($(this).find(".J-Type").data("type")), "check" != a && $(this).find(".J-Type").addClass("shake")) : ($(this).find(".J-ProductTypes").each(function () {
                    $(this).hasClass("active") && (t = !1)
                }), t && (i += "" == i ? $.trim($(this).find(".J-Type").data("type")) : " & " + $.trim($(this).find(".J-Type").data("type")), "check" != a && $(this).find(".J-Type").addClass("shake")))
            }), "" != i ? "check" == a ? $(".Paypal-buy-now.realbtn").hide() : ("modelAddToCart" == a && $("body,html").animate({scrollTop: $(".J-Product").offset().top}, 500), $(".JH-BuyCart, .JH-BuyPayCart").removeClass("jh-btn-loading").removeAttr("disabled"), $(".J-SelectTips").html(SAIL_ENV.language[SAIL_ENV.language.lang].select_sku_attribute(i)).show()) : ("check" == a && $(".Paypal-buy-now.realbtn").show(), "modelAddToCart" == a && $(".product .JH-BuyCart").click(), "layer" == a && (SAIL_ENV.config.mask_layer("show"), 768 < window.screen.availWidth ? $(".buy-now-main").show() : $(".buy-now-main").addClass("buy-now-main--show"))))
        }
    }, SAIL_ENV.Product.init()
}), $(function () {
    window.sessionStorage;
    var t, e = !1, a = !1;
    $(document).on("click", ".J-getCode", function () {
        SAIL_ENV.config.mask_layer("show"), $(".J-sharePopup").addClass("share-popup--show")
    }), $(document).on("click", ".J-Mask,.J-closePopup", function () {
        SAIL_ENV.config.mask_layer("hide"), $(".J-sharePopup").removeClass("share-popup--show"), $(".J-copyCode").siblings(".copy-tips").hide()
    }), $(document).on("click", ".J-copyCode", function () {
        $(".J-copyCode").select(), document.execCommand("Copy"), 768 < window.screen.availWidth && $(this).siblings(".copy-tips").show()
    }), $(document).on("click", ".share-btn .J-MediaShare", function () {
        setTimeout(function () {
            $(".J-sharePopup").find(".share-succeed").removeClass("display-none").siblings(".share-box").addClass("display-none")
        }, 5e3)
    }), $(document).on("click", ".J-showShare", function () {
        $(".sidebar-share").find(".share-channel").slideToggle(300)
    }), 0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() && ($(".J-ShareSource").length && "" != $(".J-ShareSource").val() && window.sessionStorage.setItem("share_source", $(".J-ShareSource").val()), -1 < window.location.href.indexOf("variant") && (t = window.location.href.split("variant=")[1], $(".J-SkuList").length && $(".J-SkuList").find("span").each(function () {
        var e;
        $.trim(t) == $.trim($(this).data("id")) && (0 != (e = $(this).attr("banner-id")) && "function" == typeof bannerSlide && bannerSlide($(this).attr("banner-id")), 768 < window.screen.availWidth && $(".product-banner").length && $(".product-banner .gallery-top").find(".swiper-slide").each(function () {
            $(this).data("id") == e && ($(this).children("img").attr("src", $(this).children("img").data("original")), $(".product-banner .gallery-top").find(".swiper-wrapper").prepend($(this)))
        }))
    })), $(".J-Product").find(".J-ProductNumber").length && "" == $(".J-ProductNumber").val() && $(".J-ProductNumber").val(1), $(".product-details").find("ul,li").each(function () {
        $(this).addClass("default")
    })), ("PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() || -1 < $("body").hasClass("template5-body")) && ($(".product-details").append(window.DetallesHtml), $(".product-details").find("ul,li").each(function () {
        $(this).addClass("default")
    })), $(document).on("click", ".J-PopupContainer .J-quickToReview,.J-PopupContainer .J-Pages span", function () {
        768 < window.screen.availWidth ? $(".sece").animate({scrollTop: $(".sece").scrollTop() + $(".J-PopupComment").position().top}, 500) : $(".product-details-popup").animate({scrollTop: $(".product-details-popup").scrollTop() + $(".J-PopupComment").position().top}, 500)
    }), $(document).on("click", ".J-Overview", function () {
        $(".product-details-popup").animate({scrollTop: 0}, 500), $(this).addClass("active").siblings().removeClass("active")
    }), $(document).on("click", ".J-Detail", function () {
        $(".product-details-popup").animate({scrollTop: $(".J-Productdetails").position().top}, 500), $(this).addClass("active").siblings().removeClass("active")
    }), $(document).on("click", ".J-Related", function () {
        $(".product-details-popup").animate({scrollTop: $(".product-details-popup").scrollTop() + $(".model-recommend").position().top}, 500), $(this).addClass("active").siblings().removeClass("active")
    }), $(".J-isCartPage").length && window.screen.availWidth < 768 && ($(".J-backPrev").show(), $(".J-backPrev").click(function () {
        window.history.back(-1)
    })), $(document).on("click", ".J-TestModalClose, .J-TestModalMask", function () {
        $(".J-TestModalMask").hide().remove(), 0 < $(".J-TestModal").length && $(".J-TestModal").hide().remove()
    }), $(".J-Tips").on("mouseover", function () {
        $(this).parent(".order-write-item").find(".phone-tips").addClass("phone-tips--show")
    }), $(".J-Tips").on("mouseout", function () {
        $(this).parent(".order-write-item").find(".phone-tips").removeClass("phone-tips--show")
    }), $(".J-CloseCartPopup").click(function () {
        $(".head-cart-popup").removeClass("head-cart-popup--show")
    }), 768 < window.screen.availWidth ? ($(".J-TestModalClose").click(function () {
        SAIL_ENV.config.mask_layer("hide"), 0 < $(".J-TestModal").length && $(".J-TestModal").hide()
    }), $(document).on("click", ".close", function () {
        SAIL_ENV.config.show_buycart && (SAIL_ENV.config.show_buycart = !1, SAIL_ENV.config.mask_layer("hide"), $(".J-BuyCart--Box").removeClass("buy-cart--right"))
    })) : ($(".J-Mask").click(function () {
        SAIL_ENV.config.mask_layer("hide"), 0 < $(".J-TestModal").length && $(".J-TestModal").hide(), a = !1, $(".J-HeadSearchBox").removeClass("head-search--show"), $(".J-Mask").removeClass("white-opacity"), SAIL_ENV.config.mask_layer("hide"), screen.width < 768 && $(".header,.head-notice").removeClass("zindex")
    }), $(".close").click(function () {
        SAIL_ENV.config.mask_layer("hide"), $(".J-NavShow").removeClass("close"), $(".J-PageContainer").removeClass("PageContainer--show"), $(".J-Nav-Drawer").removeClass("drawer--left"), 0 < $(".J-TestModalMask").length && ($(".J-TestModal").hide().remove(), $(".J-TestModalMask").hide().remove()), $(".showcase-body").length && ($(".header").removeClass("color-white"), $(".nav-item-down-menu").slideUp(), $(".nav-item").removeClass("active"), $(".search-popup").removeClass("search-popup--show"))
    }), $.fn.grooveshark = function () {
        return this.each(function () {
            var a = this, i = $(this).width();
            $(".J-MenuPanel", a).css("left", i + "px").hide(), $(".J-Menu span", a).click(function () {
                var e = $(this).attr("rel");
                $(".J-Menu li", a).each(function () {
                    var e = $(this);
                    e.hasClass("active") && e.removeClass("active")
                }), $(this).parents("li").addClass("active"), $(".nav-menu-title h3").text($(this).parents("li").text()), $(".J-MenuTitle span").show();
                var t = $(".J-Menu").height();
                $("." + e, a).css({"z-index": 2, "min-height": t}).show().animate({left: "0px"}, 500, function () {
                    $(".J-MenuPanel", a).each(function () {
                        0 == $(this).hasClass(e) && $(this).css({left: i + "px", "z-index": 1}).hide()
                    })
                })
            })
        })
    }, $.fn.backhome = function () {
        return this.each(function () {
            var e = $(this).width();
            $(".active", this).each(function () {
                $(this).removeClass(".active")
            }), $(".J-MenuTitle h3").text("Menu"), $(".J-MenuTitle span").hide(), $(".J-MenuPanel", this).each(function () {
                $(this).animate({left: e + "px"}, 500, function () {
                    $(this).hide()
                })
            })
        })
    }, $(".J-MenuMain").grooveshark(), $(".J-backhome").click(function () {
        $(".J-MenuMain").backhome()
    }), $(".close").click(function () {
        SAIL_ENV.config.show_buycart && (SAIL_ENV.config.show_buycart = !1, SAIL_ENV.config.mask_layer("hide"), $(".J-BuyCart--Box").removeClass("buy-cart--right"))
    })), $(".J-NavMenuWidth").find(".nav-item").each(function (e) {
        $(this).children().hasClass("nav-item-down-menu") ? $(this).children(":first").attr("href", "javascript:;") : $(this).addClass("nav-single")
    }), $(".nav-drawer .nav-item, .nav .nav-item").each(function (e) {
        1 < $(this).children().length && $(this).children(":first").attr("href", "javascript:;")
    });

    function i(e, t) {
        this.el = e || {}, this.multiple = t || !1, this.el.find(".nav-item > a").on("click", {
            el: this.el,
            multiple: this.multiple
        }, this.dropdown)
    }

    var n, o, r, s, d, c, l, p, u, h, g, m, _, f, y, v;
    i.prototype.dropdown = function (e) {
        var t = e.data.el, a = $(this), i = a.next();
        i.slideToggle(), a.parent().toggleClass("active"), e.data.multiple || t.find(".nav-item-down-menu").not(i).slideUp(500).parent().removeClass("active")
    }, new i($(".nav-drawer"), !1), $(document).on("click", ".J-HeadSearch", function () {
        screen.width < 768 ? $(".J-HeadSearchBox").css({top: 0}) : $(".J-HeadSearchBox").css({top: $(".J-HeadSearch").parents(".header").height()}), a ? (a = !1, $(".J-HeadSearchBox").removeClass("head-search--show"), $(".J-HeadSearchBox").css({top: $(".J-HeadSearch").parents(".header").height() - 1})) : (a = !0, $(".J-HeadSearchBox").addClass("head-search--show"), $(".J-HeadSearchBox").find("input").focus(), screen.width < 768 && ($(this).parents().find(".header,.head-notice").addClass("zindex"), $("body").hasClass("template4-body") && $(".J-Mask").addClass("white-opacity"), SAIL_ENV.config.mask_layer("show")))
    }), "0" == $(".J-HeadSearchBox").height() && $(".J-HeadSearchBox").find("input").val(""), $(".J-openSearchBox").click(function () {
        $(".mobile-search-box").addClass("mobile-search-box--show"), $(".mobile-search-box").find("input").focus()
    }), $(".J-closeSearchBox").click(function () {
        $(".mobile-search-box").removeClass("mobile-search-box--show")
    }), $(".J-OrderBuy .fl").click(function () {
        e ? (e = !1, $(this).parents(".J-OrderBuy").removeClass("order-buy-cart--show"), $(".J-OrderListBox").slideUp(500), $(".show-order").text(SAIL_ENV.language[SAIL_ENV.language.lang].order_show), $(".J-showDiscount").show()) : (e = !0, $(this).parents(".J-OrderBuy").addClass("order-buy-cart--show"), $(".J-OrderListBox").slideDown(), $(".J-showDiscount").hide(500), $(".show-order").text(SAIL_ENV.language[SAIL_ENV.language.lang].order_hide))
    }), $(".J-showDiscount").click(function () {
        $(this).hide(), e || (e = !0, $(this).addClass("order-buy-cart--show"), $(".J-OrderListBox").slideDown(500), $(".show-order").text(SAIL_ENV.language[SAIL_ENV.language.lang].order_hide)), $("body,html").animate({scrollTop: $(".order-coupon-input").offset().top - 40}, 500), $(".order-coupon-input").find("input").focus()
    }), $(".newsletter-email").focus(function () {
        $(".newsletter-email").removeClass("disable-input").val("")
    }), $(".J-modelAddToCart").length && ($(".J-modelAddToCart").find(".product-img").children("img").attr("src", $(".J-SkuList").find("span:first").data("image-url")), n = $(".product-details-box").length && $(".product-details-box").offset().top - 40, $(window).on("scroll", function () {
        var e = $(document).scrollTop();
        n <= e ? $(".J-modelAddToCart").addClass("fixed-bottom").css("bottom", $(".model-discount-tips-bottom").is(":hidden") ? 0 : $(".model-discount-tips-bottom").height()) : $(".J-modelAddToCart").removeClass("fixed-bottom")
    }), $(".J-modelAddToCart .jh-btn").click(function () {
        $(this).addClass("jh-btn-loading").attr("disabled", "disabled"), $(".template6-body").length ? SAIL_ENV.Product.isSelectedSpecs("modelAddToCart") : $(".product .JH-BuyCart").click()
    })), $(document).on("click", ".payment-options", function () {
        var e, t, a = $(this).parents(".JH-Columns"), i = "", n = "", o = null, r = 0, s = 0;
        $(".template2-body").find(".J-Product").addClass("relative"), 0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? $(".template6-body").length ? SAIL_ENV.Product.isSelectedSpecs("layer") : (SAIL_ENV.config.mask_layer("show"), 768 < window.screen.availWidth ? $(".buy-now-main").show() : $(".buy-now-main").addClass("buy-now-main--show")) : (SAIL_ENV.config.mask_layer("show"), 768 < window.screen.availWidth ? a.find(".buy-now-main").show() : a.find(".buy-now-main").addClass("buy-now-main--show")), e = 0 < a.find(".J-ProductNumber").length ? a.find(".J-ProductNumber").val() : 1, 0 < a.find(".J-Attribute").find("select").length ? a.find(".J-Product").find(".J-Attribute").each(function () {
            i += $.trim($(this).find(".J-Value").find("option:selected").data("title-code")), n += "" == n ? $.trim($(this).find(".J-Value").find("option:selected").data("title")) : "/" + $.trim($(this).find(".J-Value").find("option:selected").data("title"))
        }) : a.find(".J-Product").find(".J-Attribute").each(function () {
            i += $.trim($(this).find(".J-Value").find(".active").data("title-code")), n += "" == n ? $.trim($(this).find(".J-Value").find(".active").data("title")) : "/" + $.trim($(this).find(".J-Value").find(".active").data("title"))
        }), 0 < $(".J-SkuList").length ? $(".J-SkuList").find("span").each(function () {
            i == $.trim($(this).data("title-code")) && (s = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).data("orig-price") : (parseFloat($(this).data("orig-price") / SAIL_ENV.config.headRateValue).toFixed(2) * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), r = SAIL_ENV.config.currencyEntity.symbol + s, o = SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + (s * e).toFixed(2))
        }) : (t = a.find(".product-code").val(), 0 < $(".J-SkuList-" + t).length && $(".J-SkuList-" + t).find("span").each(function () {
            i == $.trim($(this).data("title-code")) && (s = SAIL_ENV.config.headcode == SAIL_ENV.config.currencyEntity.currency_code ? $(this).data("orig-price") : (parseFloat($(this).data("orig-price") / SAIL_ENV.config.headRateValue).toFixed(2) * SAIL_ENV.config.currencyEntity.rate_value).toFixed(2), r = SAIL_ENV.config.currencyEntity.symbol + s, o = SAIL_ENV.config.currencyEntity.currency_code + " " + SAIL_ENV.config.currencyEntity.symbol + (s * e).toFixed(2))
        })), 0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? ($(".J-GetBuyNowCouponVal").val(""), $(".buy-now-main").find(".buy-now-types").text(n), $(".buy-now-main").find(".buy-now-img").find(".fr").text(e), $(".buy-now-main").find(".buy-now-img").find(".fr").data("number", e), $(".buy-now-main").find(".buy-now-total").find("div").eq(1).text(o), $(".buy-now-main").find(".buy-now-total").find("div").eq(1).data("price", o), $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled"), $(".buy-now-main").find(".buy-now-iform").find(".buy-now-price").text(r)) : (a.find(".J-GetBuyNowCouponVal").val(""), a.find(".buy-now-main").find(".buy-now-types").text(n), a.find(".buy-now-main").find(".buy-now-img").find(".fr").text(e), a.find(".buy-now-main").find(".buy-now-img").find(".fr").data("number", e), a.find(".buy-now-main").find(".buy-now-total").find("div").eq(1).text(o), a.find(".buy-now-main").find(".buy-now-total").find("div").eq(1).data("price", o), a.find(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled"), a.find(".buy-now-main").find(".buy-now-iform").find(".buy-now-price").text(r))
    }), $(document).on("click", ".buy-now-tips", function () {
        $(this).hide(), $(this).next("div").show()
    }), $(document).on("click", ".J-BuyNowClose,.J-Mask", function () {
        $(".template2-body").find(".J-Product").removeClass("relative"), SAIL_ENV.config.mask_layer("hide"), $(".J-BuyNowCouponTips").empty(), $(".J-BuyNowDiscountInfo").empty(), 768 < window.screen.availWidth ? $(".buy-now-main").hide() : $(".buy-now-main").removeClass("buy-now-main--show"), $(".buy-now-main").find(".buy-now-tips-box").find(".buy-now-tips").show(), $(".buy-now-main").find(".buy-now-tips-box").children("div").hide()
    }), $(document).on("click", ".J-GetBuyNowCoupon", function () {
        var n = "", o = "", e = function (e) {
            var t = $(".JH-page-location").val(), a = "", i = "",
                n = "" == t ? e.parents(".JH-Columns.recommend").find(".product-code").val() : "",
                o = "" == t ? e.parents(".JH-Columns.recommend") : $(".JH-Columns"),
                r = "" == t ? e.parents(".JH-Columns.recommend").find(".J-SkuList-" + n) : $(".J-SkuList");
            0 < o.find(".J-Attribute").find("select").length ? o.find(".J-Product").find(".J-Attribute").each(function () {
                i += $.trim($(this).find(".J-Value").find("option:selected").data("title-code"))
            }) : o.find(".J-Product").find(".J-Attribute").each(function () {
                i += $.trim($(this).find(".J-Value").find(".active").data("title-code"))
            });
            0 < r.find("span").length && (r.find("span").each(function () {
                $.trim(i) == $.trim($(this).data("title-code")) && (a = $(this).data("id") || "")
            }), 1 < r.find("span").length && (a = a || $plug.query().variant || ""), 1 == r.find("span").length && (a = r.find("span").eq(0).data("id")));
            return a
        }($(this)), t = {
            coupon_code: "" == $(".JH-page-location").val() ? $(this).parents(".JH-Columns.recommend").find(".J-GetBuyNowCouponVal").val() : $(".J-GetBuyNowCouponVal").val(),
            sku_id: e,
            quantity: "" == $(".JH-page-location").val() ? $(this).parents(".JH-Columns.recommend").find(".buy-now-main").find(".buy-now-img").find(".fr").text() : $(".buy-now-main").find(".buy-now-img").find(".fr").text()
        };
        $.trim(t.coupon_code) ? $http.post("/buyer/order/product-coupon-info", JSON.stringify(t), function (i) {
            0 == i.code && 0 == parseInt(i.data.amount_discount) && ($(".buy-now-submit").find("p").hide(), $(".buy-now-submit").find(".paypal-btn").hide(), $(".buy-now-submit").find(".paypal-button-funding").hide()), i.data && 0 == i.data.coupon.error_code ? (window.sessionStorage.setItem("coupon_code", t.coupon_code), $(".J-BuyNowCouponTips").empty(), 0 < i.data.total.discount.length && i.data.total.discount.map(function (e, t) {
                var a = "",
                    a = "0.00" == i.data.total.express_amount ? '<i class="J-Discount">' + e.fee + "</i>" : "-" + SAIL_ENV.config.headsymbol + '<i class="J-Discount">' + e.fee.split("$")[1] + "</i>";
                n += '<div class="buy-coupon-item"><span class="iconfont icon-yduizhekou">\n                                    <i class="coupon-close J-BuyCouponClose">×</i>\n                                    ' + e.desc + "\n                                 </div>", o += '<p>\n                                            <span class="J-CouponDesc"><span class="iconfont icon-yduizhekou"></span>' + e.desc + '</span>\n                                            <span class="fr">' + a + "</span>\n                                        </p>"
            }), 0 < $(".J-BuyNowDiscountInfo").length && $(".J-BuyNowDiscountInfo").empty().append("<div>" + SAIL_ENV.language[SAIL_ENV.language.lang].discount + "</div><div>" + o + "</div>"), $(".J-BuyNowCouponTips").append(n)) : ($(".J-BuyNowCouponTips").find(".erro-tips") && $(".J-BuyNowCouponTips").find(".erro-tips").remove(), $(".J-BuyNowCouponTips").append(SAIL_ENV.language[SAIL_ENV.language.lang].coupon_tips(i.data.coupon.error_code, $(".J-GetBuyNowCouponVal").val()))), $(".buy-now-main").find(".buy-now-total").find("div").eq(1).text($(".J-currency-code").val() + " " + $(".J-currency-code").data("symbol") + i.data.total.subtotal)
        }) : $(".J-BuyNowCouponTips").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_1 + "</p>")
    }), 0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() && ($(document).on("click", ".product .J-quickToReview,.J-Pages span", function () {
        $("body,html").animate({scrollTop: $(".reviews").offset().top}, 500)
    }), $(".product-code").val(), $(".Paypal-buy-now").click(function () {
        SAIL_ENV.Product.isSelectedSpecs()
    }), 0 < $(".template6-body").length ? (o = 0 < $(".J-SwitchType").length ? $(".J-SwitchType").val() : "tag", r = !0, "select" == o ? $(".J-Product").find(".J-Attribute").length && $(".J-Product").find(".J-Attribute").each(function () {
        "0" == $(this).find(".J-Value").find("option:selected").val() && (r = !1)
    }) : $(".J-Product").find(".J-Attribute").length && $(".J-Product").find(".J-Attribute").each(function () {
        $(this).find(".J-ProductTypes").hasClass("active") || (r = !1)
    }), r && SAIL_ENV.Product.getProductPrices($(".JH-Columns").find(".J-Product")), SAIL_ENV.Product.isSelectedSpecs("check")) : SAIL_ENV.Product.getProductPrices($(".JH-Columns").find(".J-Product")), 0 < $(".J-recent-order-names").length && "" !== $(".J-recent-order-names").val() && (s = null, d = 10, p = l = c = "", u = $(".J-recent-order-names").val().split(","), g = [], (m = h = 0) < $(".J-SkuList").length && ($(".J-SkuList").find("span").each(function () {
        g.push($(this).attr("data-image-url"))
    }), g.length && (m = Math.round(Math.random() * (g.length - 1)))), s = setInterval(function e() {
        l = u[h];
        p = g[m];
        c = '<div class="lastSale-wrap">\n            <div class="lastSale-imgBox">\n                <img src="' + p + '" alt="">\n            </div>\n            <div class="lastSale-textBox">\n                <p>' + l + "</p>\n                <p>" + SAIL_ENV.language[SAIL_ENV.language.lang].product_lastSale + "</p>\n            </div>\n        </div>";
        window.screen.availWidth < 768 && (c = '<div class="lastSale-wrap">\n                <div class="lastSale-imgBox">\n                    <img src="' + SAIL_ENV.STATIC_HOST + '/buyer/public/img/lastSale.png" alt="">\n                </div>\n                <div class="lastSale-textBox">\n                    <p>' + l + "</p>\n                    <p>" + SAIL_ENV.language[SAIL_ENV.language.lang].product_lastSale + "</p>\n                </div>\n            </div>");
        $(".J-lastSale-wrap").append(c);
        {
            var t, a;
            window.screen.availWidth < 768 && (t = sessionStorage.getItem("lastSaleTop") || 0, a = $(".head-notice").length ? $(".head-notice").innerHeight() : 0, ($(".template1-body,.pacific-body, .district-body").length || $(".template2-body").length || $(".cascade-body").length) && ($(window).scrollTop() > parseInt($(".header").innerHeight()) + a ? ($(".J-lastSale-wrap .lastSale-wrap").addClass("lastSale-mobWrap"), $(".J-lastSale-wrap .lastSale-wrap").css("top", "0px")) : ($(".J-lastSale-wrap .lastSale-wrap").removeClass("lastSale-mobWrap"), $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".header").innerHeight()) + a + 20 + "px"))), 0 < $(".J-Header").length && !$(".template6-body").length && ($(window).scrollTop() > parseInt($(".header").innerHeight()) + a ? $(".J-lastSale-wrap .lastSale-wrap").addClass("lastSale-mobWrap") : $(".J-lastSale-wrap .lastSale-wrap").removeClass("lastSale-mobWrap")), 0 < $(".J-HeaderType").length && ($(window).scrollTop() > parseInt($(".header").innerHeight()) ? $(".J-lastSale-wrap .lastSale-wrap").addClass("lastSale-mobWrap") : $(".J-lastSale-wrap .lastSale-wrap").removeClass("lastSale-mobWrap")), $(".template6-body").length && !$(".header").hasClass("nav-menu-show") && ($(window).scrollTop() > parseInt($(".header").innerHeight()) ? $(".J-lastSale-wrap .lastSale-wrap").addClass("lastSale-mobWrap") : $(".J-lastSale-wrap .lastSale-wrap").removeClass("lastSale-mobWrap")), t ? $(".J-lastSale-wrap .lastSale-wrap").css("top", t) : $(".head-notice").length ? (0 < $(".J-Header").length && !$(".template6-body").length && $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".J-Header").innerHeight()) + a + 20 + "px"), 0 < $(".J-HeaderType").length && $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".J-HeaderType").innerHeight()) + 20 + "px"), $(".template6-body").length && !$(".header").hasClass("nav-menu-show") && ($(".template6-body").length && $(".header").hasClass("nav-menu-show") && $(".J-lastSale-wrap").css("display", "none"), $(".template6-body").length && !$(".header").hasClass("nav-menu-show") && ($(".J-lastSale-wrap").css("display", "block"), $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".header").innerHeight()) + 20 + "px")))) : (0 < $(".J-Header").length && !$(".template6-body").length && $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".J-Header").innerHeight()) + 20 + "px"), 0 < $(".J-HeaderType").length && $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".J-HeaderType").innerHeight()) + 20 + "px"), $(".template6-body").length && !$(".header").hasClass("nav-menu-show") && $(".J-lastSale-wrap .lastSale-wrap").css("top", parseInt($(".logo-box").innerHeight()) + 20 + "px")), $(".template6-body").length && $(".header").hasClass("nav-menu-show") && $(".J-lastSale-wrap").css("display", "none"), $(".template6-body").length && !$(".header").hasClass("nav-menu-show") && $(".J-lastSale-wrap").css("display", "block"))
        }
        $(".template4-body").length && $(".hassan-body").length ? $(".J-lastSale-wrap .lastSale-wrap").addClass("hassan-lastSale") : $(".J-lastSale-wrap .lastSale-wrap").removeClass("hassan-lastSale");
        setTimeout(function () {
            $(".J-lastSale-wrap .lastSale-wrap").css("opacity", "0")
        }, 3e3);
        setTimeout(function () {
            clearInterval(s), s = null, $(".J-lastSale-wrap").empty(), d = Math.round(5 * Math.random() + 5), h = h + 1 >= u.length ? 0 : h + 1, m = Math.round(Math.random() * (g.length - 1)), s = setInterval(e, 1e3 * d)
        }, 4e3)
    }, 1e3 * d))), $(document).on("change", ".J-Value", function () {
        var e;
        $(".J-SelectTips").empty().hide(), $(".J-Type").removeClass("shake"), SAIL_ENV.Product.isClick = !0, $(this).siblings(".specification-name").find(".J-TypeVal").text($(this).find("option:selected").text()), $(".template6-body").length ? (SAIL_ENV.Product.isSelectedSpecs("check"), e = !0, "0" == $(this).find("option:first").val() && $(this).find("option:first").remove(), $(".J-Product").find(".J-Attribute").length && $(".J-Product").find(".J-Attribute").each(function () {
            "0" == $(this).find(".J-Value").find("option:selected").val() && (e = !1)
        }), e && SAIL_ENV.Product.getProductPrices($(this).parents(".J-Product"))) : SAIL_ENV.Product.getProductPrices($(this).parents(".J-Product"))
    }), 768 < window.screen.availWidth ? ($(document).on("click", ".J-ProductTypes", function () {
        var e;
        $(".J-SelectTips").empty().hide(), $(".J-Type").removeClass("shake"), SAIL_ENV.Product.isClick = !0, $(this).parents("ul").siblings("p").children(".J-TypeVal").text($(this).text()), $(this).addClass("active").siblings().removeClass("active"), $(".template6-body").length ? (SAIL_ENV.Product.isSelectedSpecs("check"), e = !0, $(".J-Product").find(".J-Attribute").length && $(".J-Product").find(".J-Attribute").each(function () {
            $(this).find(".J-ProductTypes").hasClass("active") || (e = !1)
        }), e && SAIL_ENV.Product.getProductPrices($(this).parents(".J-Product"))) : SAIL_ENV.Product.getProductPrices($(this).parents(".J-Product"))
    }), 0 < $(".view-large-image").length && (y = $(".gallery-top .swiper-slide").length, $(document).on("click", ".gallery-top img", function () {
        $("#Paypal-buy-now").hide(), $(".layer-img").children("img").attr("src", $(this).attr("src")), $(".product-big-img").addClass("product-big-img--show"), $(".J-Mask").addClass("white"), SAIL_ENV.config.mask_layer("show"), f = $(this).parent().index(), _ = f, $(".J-bigImgPrev").click(function () {
            0 == _ ? _ = y - 1 : (--_, v = $(".gallery-top .swiper-slide").eq(_).find("img").attr("src"), $(".layer-img").children("img").attr("src", v))
        }), $(".J-bigImgNext").click(function () {
            _ == y - 1 ? _ = 0 : (_ += 1, v = $(".gallery-top .swiper-slide").eq(_).find("img").attr("src"), $(".layer-img").children("img").attr("src", v))
        })
    }), $(".J-bigImgClose,.layer-img").click(function () {
        $("#Paypal-buy-now").show(), $(".product-big-img").removeClass("product-big-img--show"), $(".layer-img").children("img").attr("src", ""), $(".J-Mask").removeClass("white"), SAIL_ENV.config.mask_layer("hide")
    }))) : SAIL_ENV.Product.productTyle()
});
_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (e) {
    return typeof e
} : function (e) {
    return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
};
$(function () {
    var r = window.sessionStorage, s = window.localStorage, d = $(".J-IsSinglePage").val();
    "orders" == $(".sail-event-page-location").val() && 0 < $("#paypal-payment-button").find("iframe").length && $(document.getElementById("paypal-payment-button").getElementsByTagName("iframe")[0].contentWindow.document), $(".J-OrderVal,.J-BillVal").on("keyup", function () {
        "" == $(this).val() ? $(this).parent(".order-write-item").removeClass("order-write--show") : ($(this).parent(".order-write-item").addClass("order-write--show"), $(this).removeClass("invalid").siblings(".jh-input-tips").text("").hide())
    }), $(".J-OrderVal,.J-BillVal").each(function () {
        $(".jh-select").parent(".order-write-item").addClass("order-write--show"), "" == $(this).val() || 0 < $(this).find("option:selected").length ? $(this).parent(".order-write-item").removeClass("order-write--show") : ($(this).parent(".order-write-item").addClass("order-write--show"), $(this).removeClass("invalid").siblings(".jh-input-tips").text("").hide())
    }), $(".J-MorePaymentIcon").mouseover(function () {
        $(".all-payment-icon").show()
    }), $(".J-MorePaymentIcon").mouseout(function () {
        $(".all-payment-icon").hide()
    }), $(document).on("click", ".J-Mask,.J-close", function () {
        SAIL_ENV.config.mask_layer("hide"), $(".J-versionTips").hide()
    }), localStorage.getItem("__local_order_number__") || localStorage.removeItem("user_select_insurance");
    ({
        order_number: "",
        country_value: "",
        province_value: "",
        userAddress: [],
        orderRes: {},
        matchList: [],
        resolve: null,
        orderNo: "",
        expressIndex: 0,
        contryId: "",
        contryCode: "",
        paymethod: "",
        isBuyQuickly: null,
        cartToken: "",
        paypalSel: 0,
        coupon_type: "",
        isExistCacheAddress: !1,
        checkout_step: "contact_information",
        isUserOper: !1,
        product_list: null,
        isOpenCreditcard: null,
        cartList: null,
        gtagSkuList: [],
        showIDNumber: !1,
        orderInfor: {
            is_recommend: "0",
            express_id: "",
            shipping_email: "",
            shipping_last_name: "",
            shipping_first_name: "",
            shipping_city: "",
            contry_id: "",
            shipping_contry: "",
            shipping_contry_code: "",
            shipping_province: "",
            shipping_province_code: "",
            shipping_address: "",
            shipping_other_address: "",
            shipping_id_number: "",
            tax_number: "",
            tax_type: "CPF",
            shipping_phone: "",
            shipping_zip_code: "",
            amount: "",
            amount_product: "",
            express_amount: "",
            amount_discount: "",
            currency: "",
            currency_label: "",
            pay_card_number: "",
            pay_card_mmyy: "",
            pay_card_cvv: "",
            billing_first_name: "",
            billing_last_name: "",
            billing_city: "",
            billing_province: "",
            billing_province_code: "",
            billing_contry: "",
            billing_contry_code: "",
            billing_address: "",
            billing_other_address: "",
            billing_email: "",
            billing_phone: "",
            billing_zip_code: "",
            coupon_code: "",
            express_name: "",
            express_fee: "",
            cart_type: "",
            order_step: "1",
            currentState: ""
        },
        taxObj: {
            type: "CPF",
            reg: {
                CPF: "^([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})?$",
                CNPJ: "^([0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{1,2})?$"
            }
        },
        validation: [{
            type: "shipping_email",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.email,
            reg: SAIL_ENV.config.EmailReg
        }, {
            type: "shipping_first_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.first_name,
            reg: ""
        }, {
            type: "shipping_last_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.last_name,
            reg: ""
        }, {
            type: "shipping_address",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.address,
            reg: ""
        }, {
            type: "shipping_other_address",
            verify: !1,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.other_address,
            reg: ""
        }, {
            type: "tax_number",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.tax_number,
            reg: "^([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})?$"
        }, {
            type: "shipping_phone",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.phone,
            reg: ""
        }, {
            type: "shipping_zip_code",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.zip_code,
            reg: ""
        }, {
            type: "shipping_city",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.city,
            reg: ""
        }, {
            type: "pay_card_number",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.pay_card_number,
            reg: ""
        }, {
            type: "pay_card_mmyy",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.pay_card_mmyy,
            reg: "^([0-9]{2}/[0-9]{2})?$"
        }, {
            type: "pay_card_cvv",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.pay_card_cvv,
            reg: "^([0-9]{3,4})?$"
        }, {
            type: "billing_first_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.first_name,
            reg: ""
        }, {
            type: "billing_last_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.last_name,
            reg: ""
        }, {
            type: "billing_address",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.address,
            reg: ""
        }, {
            type: "billing_other_address",
            verify: !1,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.other_address,
            reg: ""
        }, {
            type: "billing_phone",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.phone,
            reg: ""
        }, {
            type: "billing_city",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.city,
            reg: ""
        }, {
            type: "billing_zip_code",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.zip_code,
            reg: ""
        }, {
            type: "shipping_id_number",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.cod_id,
            reg: "^([1-2]{1}[0-9]{9})?$"
        }],
        init: function () {
            var e, t, i = this;
            if ("1" == d) return !1;
            if (i.currentState = $(".J-getCurrentState").length && $(".J-getCurrentState").val(), 1 == $(".J-Country").find("option").length && ($(".J-Country").find("option").eq(0).prop("selected", !0), i.checkRequired($(".J-Country").val())), "orders" == $(".sail-event-page-location").val()) {
                "undefined" != $plug.query().coupon_code && (i.orderInfor.coupon_code = $plug.query().coupon_code), i.cartToken = $plug.getToKen(), i.getCacheData();
                var a, n, o = {
                    isShowPhone: $(".J-isShowPhone").val(),
                    currentState: $(".J-getCurrentState").val(),
                    isOpenPaypal: parseInt($(".isOpenPaypal").val()),
                    isOpenCod: parseInt($(".isOpenCod").val()),
                    isShowOtherAddress: $(".J-isShowOtherAddress").val(),
                    isOpenEmailMarketing: $(".J-isOpenEmailMarketing").val(),
                    emailval: $(".J-OrderVal[data-type='shipping_email']").val()
                };
                if (i.isOpenCreditcard = parseInt($(".isOpenCreditcard").val()), "US" == i.currentState && $(".J-paypal-payment").removeClass("display-flex"), "1" == o.isOpenEmailMarketing ? $(".J-Offers").find(".jh-checkbox").addClass("jh-checkbox-active") : "3" == o.isOpenEmailMarketing && $(".J-Offers").remove(), "2" == o.isShowPhone ? (a = "Phone (Optional)", i.editvalidation("shipping_phone", "billing_phone", !1), $(".J-OrderVal[data-type='shipping_phone']").attr("placeholder", a), $(".J-BillVal[data-type='billing_phone']").attr("placeholder", a), $(".J-OrderVal[data-type='shipping_phone']").parent().find("label").text(a), $(".J-BillVal[data-type='billing_phone']").parent().find("label").text(a)) : "3" == o.isShowPhone && ($(".J-OrderVal[data-type='shipping_phone']").parent().parent().remove(), $(".J-BillVal[data-type='billing_phone']").parent().parent().remove()), "1" == o.isShowOtherAddress ? (n = SAIL_ENV.language[SAIL_ENV.language.lang].other_address, i.editvalidation("shipping_other_address", "billing_other_address", !0), $(".J-OrderVal[data-type='shipping_other_address']").attr("placeholder", n), $(".J-BillVal[data-type='billing_other_address']").attr("placeholder", n), $(".J-OrderVal[data-type='shipping_other_address']").parent().find("label").text(n), $(".J-BillVal[data-type='billing_other_address']").parent().find("label").text(n)) : "3" == o.isShowOtherAddress && ($(".J-OrderVal[data-type='shipping_other_address']").parent().parent().remove(), $(".J-BillVal[data-type='billing_other_address']").parent().parent().remove()), $('.J-OrderVal[data-type="shipping_email"]').val("").focus().val(o.emailval), i.isBuyQuickly = 1 == $(".J-IsCreatedPay").val() ? 1 : 0, 1 == i.isBuyQuickly ? ($(".J-placeShipping").find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_complete_order), $(".J-CustomerInfor").find(".paypal-checkout-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].paypal).addClass("paypal-remembered-tips")) : $(".J-paypal-payment").addClass("display-flex"), 0 < $(".J-PaymentPriority").length && (i.paymethod = $(".J-PaymentPriority").val()), o.isOpenPaypal && (1 != i.isBuyQuickly && i.paypalPayment({
                    id: "#paypal-button",
                    type: 1,
                    paymentType: "paypal"
                }), 1 != i.isBuyQuickly && "US" == i.currentState && i.paypalPayment({
                    id: "#paypal-button-funding",
                    type: 1,
                    paymentType: "whiteBar"
                })), i.isOpenCreditcard || o.isOpenPaypal || o.isOpenCod || $(".J-PaymentMethod").find(".J-CreateOrder").addClass("jh-disabled").attr("disabled", "disabled"), $plug.query().step) switch (i.checkout_step = $plug.query().step, localStorage.getItem(i.cartToken + "_step") && i.checkout_step != localStorage.getItem && (i.checkout_step = localStorage.getItem(i.cartToken + "_step")), r.getItem(i.cartToken + "_step_current") && (i.checkout_step = r.getItem(i.cartToken + "_step_current")), $plug.query().orderNumberFromEmail && (i.checkout_step = $plug.query().step), $plug.replaceParam(window.location.href, "step", i.checkout_step), $plug.query().step) {
                    case"contact_information":
                        i.fadeIn(0, !0);
                        break;
                    case"shipping_method":
                        i.fadeIn(1, !0);
                        break;
                    default:
                        i.fadeIn(2, !0)
                } else i.fadeIn(0, !0)
            }
            1 == parseInt($(".preview-hide-code").val()) && 0 < $(".J-Gopay").length && $(".J-Gopay").attr("disabled", "disabled").addClass("jh-btn-disabled"), 0 < $(".J-PaypalClientId").length && (SAIL_ENV.PAYPAL_CLIENT.hasOwnProperty("production") ? SAIL_ENV.PAYPAL_CLIENT.production = $(".J-PaypalClientId").val() : SAIL_ENV.PAYPAL_CLIENT.sandbox = $(".J-PaypalClientId").val() || "sb"), 0 < $(".JH-page-location").length && "PAGE_PRODUCT_DETAIL" == $(".JH-page-location").val() ? (e = $(".product-code").val(), window.paypalisremembered && window.paypalisremembered.paypal && (i.paypalPayment({
                id: "#Paypal-buy-now-" + e,
                type: 1,
                bool: !0,
                paymentType: "paypal",
                status: !0
            }), i.paypalPayment({
                id: "#Paypal-buy-now-popup-" + e,
                type: 1,
                bool: !0,
                paymentType: "paypal"
            }), "US" == i.currentState && i.paypalPayment({
                id: "#paypal-button-funding-" + e,
                type: 1,
                bool: !0,
                paymentType: "whiteBar"
            }))) : 0 < $(".JH-page-location").length && "" == $(".JH-page-location").val() && 0 < $(".recommend.JH-Columns").length && $(".recommend.JH-Columns").each(function (e, t) {
                var a = $(this).find(".product-code").val();
                SAIL_ENV.Product.getProductPrices($(this).find(".J-Product")), window.paypalisremembered && window.paypalisremembered.paypal && $("#Paypal-buy-now-" + a).length && (i.paypalPayment({
                    id: "#Paypal-buy-now-" + a,
                    type: 1,
                    bool: !0,
                    path: "index",
                    paymentType: "paypal"
                }), i.paypalPayment({
                    id: "#Paypal-buy-now-popup-" + a,
                    type: 1,
                    bool: !0,
                    path: "index",
                    paymentType: "paypal"
                }), "US" == i.currentState && i.paypalPayment({
                    id: "#paypal-button-funding-" + a,
                    type: 1,
                    bool: !0,
                    path: "index",
                    paymentType: "whiteBar"
                }))
            }), 0 < $(".template5-body").length && "index" == $(".sail-event-page-location").val() && i.eventReturn(), 0 < $(".J-OrderResults").length && i.eventReturn(), i.event(), 0 < $(".J-Textarea").length && (t = r.getItem("card-remark") || "", $(".J-Textarea").val(t)), i.isPaymentProgress()
        },
        checkRequired: function (e) {
            "HK" == e || "MO" == e ? (this.editvalidation("shipping_zip_code", "billing_zip_code", !1), $(".J-ZipCode").removeClass("invalid"), $(".J-ZipCode").siblings(".jh-input-tips").text("").hide(), $(".J-BillVal[data-type='billing_zip_code']").removeClass("invalid"), $(".J-BillVal[data-type='billing_zip_code']").siblings(".jh-input-tips").text("").hide()) : this.editvalidation("shipping_zip_code", "billing_zip_code", !0)
        },
        editvalidation: function (a, i, n) {
            this.validation.map(function (e, t) {
                e.type != a && e.type != i || (e.verify = n)
            })
        },
        getCacheData: function () {
            var t = this, e = {
                source: $plug.query().source,
                buyerId: $plug.query().oriBuyerId,
                cartToken: t.cartToken,
                orderNumberFromEmail: $plug.query().orderNumberFromEmail,
                isShowCustomerInfo: $plug.query().isShowCustomerInfo
            }, a = {buyer_id: e.buyerId};
            "1" == e.isShowCustomerInfo && (a.isShowCustomerInfo = "1", a.cartToken = e.cartToken), e.orderNumberFromEmail && (a.order_number = e.orderNumberFromEmail), sessionStorage.getItem("coupon_code") && "" != sessionStorage.getItem("coupon_code") && (t.orderInfor.coupon_code = sessionStorage.getItem("coupon_code")), localStorage.getItem("coupon_code") && "" != localStorage.getItem("coupon_code") && (t.orderInfor.coupon_code = localStorage.getItem("coupon_code")), SAIL_ENV.config.coupon_code && "" != SAIL_ENV.config.coupon_code && (t.orderInfor.coupon_code = SAIL_ENV.config.coupon_code), $(".J-GetCouponVal").val(t.orderInfor.coupon_code), $http.post("/buyer/order/order-cache-billing-info", JSON.stringify(a), function (e) {
                0 == e.code && e.data && "Object" == $plug.toRawType(e.data.buyer) && 5 < Object.keys(e.data.buyer).length ? (t.setCacheAddress(e.data.buyer), t.getStepData(e.data.buyer), t.makeUserAddress(null, !1), t.isExistCacheAddress = !0) : (t.buyerCheckout(), t.makeUserAddress(null, !0))
            })
        },
        setCacheAddress: function (i, e) {
            var n = this, o = !1;
            if (!i || "Array" == $plug.toRawType(i) || Object.keys(i).length <= 0) return !1;
            $(".J-OrderVal").each(function (e) {
                var t, a = $(this).data("type");
                a && a.replace(/_/g, " ");
                "shipping_contry" != $(this).data("type") && "shipping_province" != $(this).data("type") && (t = i[a] ? i[$(this).data("type")] : "", $(this).val(t), (n.orderInfor[a] = t) && $(this).parents(".order-write-item").addClass("order-write--show"), t || $(this).parents(".order-write-item").removeClass("order-write--show"), a && "paypal" == a && $(this).addClass("invalid")), "shipping_contry" == a && i.shipping_contry_code && (n.country_value = i.shipping_contry_code, n.orderInfor.contry_id = i.contry_id, n.orderInfor.shipping_contry = i.shipping_contry, n.orderInfor.shipping_contry_code = i.shipping_contry_code, $(".J-Country").find("option[value=" + i.shipping_contry_code + "]").eq(0).prop("selected", !0), $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                    $(this).val() == i.shipping_contry_code && (o = !0)
                }), i.tax_type && (n.orderInfor.tax_type = i.tax_type), i.shipping_province_code && (n.orderInfor.shipping_province = i.shipping_province, n.orderInfor.shipping_province_code = i.shipping_province_code), n.getRegionLibrary(i.shipping_contry_code, !0, null), n.checkRequired(i.shipping_contry_code)), ("shipping_contry" == a && !i.shipping_contry_code || "shipping_contry" == a && "" == i.shipping_contry_code) && n.getUserIpAddress(), null != i.is_select_insurance && (n.is_select_insurance_cache = i.is_select_insurance)
            }), o ? ($(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide()) : (n.orderInfor.shipping_province = "", n.orderInfor.shipping_province_code = "", n.country_value = $(".J-CustomerInfor").find(".J-Country").val(), n.orderInfor.contry_id = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id"), n.orderInfor.shipping_contry = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("countries"), n.orderInfor.shipping_contry_code = $(".J-CustomerInfor").find(".J-Country").val(), n.getRegionLibrary(n.orderInfor.shipping_contry_code, !0, null), e && "paypal" == e && $(".J-CustomerInfor").find(".J-Country").addClass("invalid"), e && "paypal" == e && $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].no_logistics).show()), n.cloneInfor(), $(".J-BillVal").each(function (e) {
                var t = $(this).data("type");
                "billing_contry" != t && "billing_province" != t && $(this).val(n.orderInfor[t])
            })
        },
        eventReturn: function () {
            window.addEventListener("popstate", function () {
                0 < $(".J-Popup").length && $(".J-Popup").hasClass("sece--show") && ($("html, body").removeClass("hidden").css("top", ""), $("html, body").animate({scrollTop: SAIL_ENV.config.scrollPosition}, 0), $(".J-Popup").removeClass("sece--show"), $(".J-PopupContainer").find(".J-PopupGroupProductBottom,.J-PopupGroupProductTop,.J-PopupComment,.J-productList").empty(), $(".J-PopupContainer").find(".J-QtySelect").val("1"), window.history.replaceState({}, 0, SAIL_ENV.Product.referrer_url))
            }, !1)
        },
        isPaymentProgress: function () {
            var t = this;
            -1 < window.location.href.indexOf("step=shipping_method") && t.isBuyQuickly && $http.post("/buyer/order/get-payment-status", {}, function (e) {
                0 == e.code && (3 == e.data.code ? window.location.href = e.data.url : 4 == e.data.code ? ($plug.loading("Your previous order is being paid, you cannot submit the order again now, please wait."), setTimeout(function () {
                    t.isPaymentProgress()
                }, 1500)) : $plug.closeLoading())
            })
        },
        getBuyQuickly: function () {
            var t = this;
            $http.post("/payment/paypal-union/is-created-express-pay", {}, function (e) {
                0 == e.code ? t.isBuyQuickly = e.data.is_created_express_pay : t.isBuyQuickly = 0
            })
        },
        makeSort: function (a) {
            return function (e, t) {
                return e[a] - t[a]
            }
        },
        buyerCheckout: function (e, n) {
            var o = this, t = "1";
            "shipping_method" == o.checkout_step && (t = "2"), "payment_method" == o.checkout_step && (t = "3");
            var a = {
                order_step: t,
                cart: {cart_type: o.cart_type, cart_token: o.cartToken},
                express: {
                    country_id: o.contryId,
                    express_id: "1" == t ? "" : o.orderInfor.express_id,
                    province_name: o.orderInfor.shipping_province || "",
                    province_code: o.orderInfor.shipping_province_code || ""
                },
                coupon: {coupon_code: o.orderInfor.coupon_code},
                current_page: {contact_information: 1, shipping_method: 1, payment_method: 3}[o.checkout_step]
            }, i = window.localStorage.getItem("user_select_insurance"), r = o.local_is_select_insurance;
            1 == i && (r = 1), "contact_information" == o.checkout_step && (r = 0), a.is_select_insurance = r;
            var s = $.extend(a, e);
            "" == s.express.country_id && (s.express.country_id = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id")), $http.post("/buyer/checkout", JSON.stringify(s), function (e) {
                var t, a, i;
                0 == e.code && (0 == e.data.cart.list.length && (window.location.href = "/cart"), o.showIDNumber = e.data.is_over_amount_limit, "SA" == o.orderInfor.shipping_contry_code && o.showIDNumber && "COD" == o.paymethod ? $(".J-PaymentMethod").find(".order-id-munber").show() : $(".J-PaymentMethod").find(".order-id-munber").hide(), o.cartList = e.data, o.contain_insurance = e.data.total.contain_insurance, o.makeCouponHtml(e.data.coupon, s.coupon.coupon_code), o.makeMatchHtml(e.data.express), t = e.data.cart.list, a = e.data.coupon.hasOwnProperty("coupon_list") && e.data.coupon.coupon_list.map(function (e) {
                    return e.id
                }) || [], t.forEach(function (e) {
                    var t = a.indexOf(Number(e.coupon_id));
                    e.sort_by = t
                }), 2 == e.data.coupon.type && e.data.coupon.hasOwnProperty("coupon_list") && (t = t.sort(o.makeSort("sort_by"))), i = e.data.coupon.hasOwnProperty("coupon_list") ? e.data.coupon.coupon_list : [], o.makeOrderHtml(t, e.data.total.total, i), o.local_is_select_insurance = localStorage.getItem("user_select_insurance"), null == o.local_is_select_insurance && (o.local_is_select_insurance = e.data.express.insurance_select), o.makeOrderPriceHtml(e.data.total, e.data.express.is_match), localStorage.getItem("__local_order_number__") && "contact_information" != o.checkout_step && o.watchInsuranceCheckboxStatus(), 0 < e.data.cart.list.length && 0 == e.data.express.error_code && 0 < e.data.express.list.length && n && n())
            })
        },
        getUserIpAddress: function () {
            var t = this, a = null, i = "US", n = $(".J-UserIp").val();
            sessionStorage.getItem(n) ? (a = JSON.parse(sessionStorage.getItem(n)), $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                $(this).val() == a.countryCode && (i = a.countryCode, t.orderInfor.shipping_province_code = a.region)
            }), $(".J-CustomerInfor").find(".J-Country").find("option[value=" + i + "]").eq(0).prop("selected", !0), t.getRegionLibrary(i, !0)) : $http.post("/buyer/user/ip-detail", {}, function (e) {
                0 == e.code && "Object" == $plug.toRawType(e.data) && "success" == e.data.status && (a = e.data, sessionStorage.setItem(n, JSON.stringify(e.data)), $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                    $(this).val() == a.countryCode && (i = a.countryCode, t.orderInfor.shipping_province_code = a.region)
                })), $(".J-CustomerInfor").find(".J-Country").find("option[value=" + i + "]").eq(0).prop("selected", !0), t.getRegionLibrary(i, !0)
            }), t.checkRequired(i)
        },
        changeTest: function (e) {
            Countries[e] && Countries[e].hasOwnProperty("labels") && "Object" == $plug.toRawType(Countries[e].labels) && (Countries[e].labels.province && "" != Countries[e].labels.province && $(".J-Province").prev().text(Countries[e].labels.province), Countries[e].labels.zip && "" != Countries[e].labels.zip ? ($(".J-ZipCode").prop("placeholder", Countries[e].labels.zip), $(".J-ZipCode").prev().text(Countries[e].labels.zip)) : ($(".J-ZipCode").prop("placeholder", CountriesDefaultInfo.labels.zip), $(".J-ZipCode").prev().text(CountriesDefaultInfo.labels.zip)))
        },
        getRegionLibrary: function (i, e, n) {
            var o = this, t = n ? n.find(".J-Country").val() : $(".J-CustomerInfor").find(".J-Country").val(),
                a = JSON.parse(s.getItem("order_data"));
            if (e || $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                a && $(this).data("countries") == a.shipping_contry && (i = item.code)
            }), !(i = i && t == i ? i : t) || "" == i) return !1;
            Object.keys(Countries).forEach(function (e, t) {
                var a;
                e == i && (Countries[e].provinces && "Object" == $plug.toRawType(Countries[e].provinces) ? (a = "", a = Countries[i].labels && Countries[i].labels.province ? Countries[i].labels.province : SAIL_ENV.language[SAIL_ENV.language.lang].state, o.makeRegionHtml(Countries[e].provinces, n, a)) : (n ? n.find(".J-Country").parent(".order-write-item").addClass("order-write-whole") : $(".J-Country").parent(".order-write-item").addClass("order-write-whole"), n ? n.find(".J-Province").empty() : $(".J-Province").empty(), n ? n.find(".J-Province").parent(".order-write-item").hide() : $(".J-Province").parent(".order-write-item").hide()))
            }), n && !n.hasClass("J-CustomerInfor") || (o.showBrazilTax(i), o.changeUserShippingBox(i), "SA" == i && o.showIDNumber && "COD" == o.paymethod ? $(".J-PaymentMethod").find(".order-id-munber").show() : $(".J-PaymentMethod").find(".order-id-munber").hide())
        },
        showBrazilTax: function (e) {
            var t = this;
            t.validation.map(function (e) {
                "tax_number" == e.type && (e.reg = t.taxObj.reg[t.orderInfor.tax_type])
            }), $(".J-CustomerInfor").find(".J-TaxCode").val(this.orderInfor.tax_type), "BR" == e ? $(".J-CustomerInfor").find(".order-br-taxno").show() : $(".J-CustomerInfor").find(".order-br-taxno").hide()
        },
        changeUserShippingBox: function (e) {
            switch (e) {
                case"GB":
                    $(".J-CustomerInfor").find(".J-ZipCode").parent().hide(), $(".J-CustomerInfor").find(".J-Country").parent().addClass("order-write-whole-line"), $(".J-CustomerInfor").find(".order-write-list[name=postcode]").show().children().show(), $(".J-GoogleMapAddress[name=Address]").parent(".order-write-item").find(".icon-dingwei").hide();
                    break;
                default:
                    $(".J-CustomerInfor").find(".J-ZipCode").parent().show(), $(".J-CustomerInfor").find(".order-write-list[name=postcode]").hide(), $(".J-CustomerInfor").find(".J-Country").parent().removeClass("order-write-whole-line"), $(".J-GoogleMapAddress[name=Address]").parent(".order-write-item").find(".icon-dingwei").show()
            }
        },
        getStepData: function (a) {
            var i = this;
            "shipping_method" == i.checkout_step && "Object" == $plug.toRawType(a) || "payment_method" == i.checkout_step && "Object" == $plug.toRawType(a) ? (Object.keys(a).forEach(function (e, t) {
                "" != a[e] && (i.orderInfor[e] = a[e])
            }), i.setCacheAddress(i.orderInfor), i.contryId = a.contry_id, i.buyerCheckout()) : a && i.buyerCheckout();
            var e = "" == i.orderInfor.shipping_other_address ? i.orderInfor.shipping_other_address : i.orderInfor.shipping_other_address + ", ",
                t = "" == i.orderInfor.shipping_province_code ? i.orderInfor.shipping_province_code : i.orderInfor.shipping_province_code + ", ";
            $(".J-Email").text(i.orderInfor.shipping_email), $(".J-Address").text(i.orderInfor.shipping_address + ", " + e + i.orderInfor.shipping_city + ", " + t + i.orderInfor.shipping_zip_code + ", " + i.orderInfor.shipping_contry), "payment_method" == i.checkout_step && ($(".J-express-name").text(i.orderInfor.express_name || ""), $(".J-express-fee").text(SAIL_ENV.config.headsymbol + i.orderInfor.express_fee || ""))
        },
        sendEmail: function () {
            var e = {
                countryId: this.contryId,
                orderAmount: this.cartList.total.total,
                weight_gram: this.cartList.cart.weight_gram
            };
            e.order_number = this.order_number || "", "" == e.order_number && window.sessionStorage.getItem("order_number") && (e.order_number = window.sessionStorage.getItem("order_number")), $http.post("/buyer/express/send-mail", JSON.stringify(e))
        },
        isValidationFn: function (o) {
            var r = !0, e = this;
            if (1 == e.paypalSel) return $(".J-BillVal").each(function () {
                var a = $(this).data("type"), i = $.trim($(this).val()), n = $(this),
                    i = "INPUT" == $(this).get(0).tagName ? $.trim($(this).val()) : $(this).find("option:selected").data("countries");
                e.orderInfor[a] = i, e.validation.map(function (e, t) {
                    e.verify && e.type == a && (o && n.removeClass("invalid"), o && n.siblings(".jh-input-tips").text("").hide(), i && "" != i && (!e.reg || new RegExp(e.reg, "i").test(i)) || (e.reg && !new RegExp(e.reg, "i").test(i) && o && n.siblings(".jh-input-tips").text(e.tips[1]).show(), i && "" != i || o && n.siblings(".jh-input-tips").text(e.tips[0]).show(), o && n.addClass("invalid"), $(".J-CreateOrder").removeClass("jh-btn-loading"), r = !1))
                }), $(".J-PaymentMethod").find(".J-Province").length && "-1000" == $(".J-PaymentMethod").find(".J-Province").find("option:selected").val() ? (r = !1, o && $(".J-PaymentMethod").find(".J-Province").addClass("invalid"), o && $(".J-PaymentMethod").find(".J-Province").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].select_province).show()) : (o && $(".J-PaymentMethod").find(".J-Province").removeClass("invalid"), o && $(".J-PaymentMethod").find(".J-Province").siblings(".jh-input-tips").text("").hide())
            }), r
        },
        validationOrder: function (e, t) {
            var o, r = this, s = {country: ""}, d = !0;
            1 == e ? (o = {}, s.country = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("countries"), $(".J-OrderVal").each(function () {
                var a, i, n;
                $(this).parent(".order-write-item").is(":visible") && (a = $(this).data("type"), i = $.trim($(this).val()), n = $(this), "shipping_contry" == $(this).data("type") || "shipping_province" == $(this).data("type") ? o[$(this).data("type")] = $(this).find("option:selected").text() : o[$(this).data("type")] = $(this).val(), "shipping_email" == a && (s.email = i), "shipping_zip_code" == a && (s.zip_code = i), r.validation.map(function (e, t) {
                    e.verify && e.type == a && (n.removeClass("invalid"), n.siblings(".jh-input-tips").text("").hide(), i && "" != i && (!e.reg || new RegExp(e.reg, "i").test(i)) || (n.siblings(".jh-input-tips").text(e.tips[0]).show(), n.addClass("invalid"), d = !1), "tax_number" == e.type && $plug.isSame(i) && (n.siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].tax_number).show(), n.addClass("invalid"), d = !1))
                }), "shipping_address" == $(this).data("type") && $(".J-OrderVal").val().length < 2 && (n.siblings(".jh-input-tips").text("").show(), n.addClass("invalid"), d = !1))
            }), $(".J-CustomerInfor").find('.J-OrderVal[data-type="shipping_address"]').val().length < 2 && (d = !1, $(".J-CustomerInfor").find('.J-OrderVal[data-type="shipping_address"]').addClass("invalid"), $(".J-CustomerInfor").find('.J-OrderVal[data-type="shipping_address"]').siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].google_map).show()), $(".J-CustomerInfor").find(".J-Country").val() && "" != $(".J-CustomerInfor").find(".J-Country").val() ? ($(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide()) : (d = !1, $(".J-CustomerInfor").find(".J-Country").addClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].select_country).show()), $(".J-CustomerInfor").find(".J-Province").length && "-1000" == $(".J-CustomerInfor").find(".J-Province").find("option:selected").val() || "" == $(".J-CustomerInfor").find(".J-Province").val() || !$(".J-CustomerInfor").find(".J-Country").val() ? (d = !1, $(".J-CustomerInfor").find(".J-Province").addClass("invalid"), $(".J-CustomerInfor").find(".J-Province").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].select_province).show()) : ($(".J-CustomerInfor").find(".J-Province").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Province").siblings(".jh-input-tips").text("").hide()), d || ("function" == typeof stag && stag("page_click", "user_behavior", {
                type: "check",
                additional: JSON.stringify(o),
                button_pos: "",
                button_name: "information"
            }), window.screen.availWidth < 768 && $("body,html").animate({scrollTop: $(".J-OrderVal.invalid").length && $(".J-OrderVal.invalid").first().offset().top - 40}, 500)), d && (r.contryId = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id"), r.orderInfor.shipping_province_code = $(".J-CustomerInfor").find(".J-Province").find("option:selected").val(), $(".J-OrderVal").each(function () {
                var e = $(this).data("type"),
                    t = "INPUT" == $(this).get(0).tagName ? $.trim($(this).val()) : $(this).find("option:selected").data("countries") || $(this).find("option:selected").text();
                "shipping_contry" == e && (r.orderInfor.shipping_contry_code = $(this).val(), r.orderInfor.contry_id = $(this).find("option:selected").data("id"), r.orderInfor.shipping_contry = $(this).find("option:selected").data("countries")), "shipping_province" == e && (r.orderInfor.shipping_province = $(".J-CustomerInfor").find(".J-Province").find("option:selected").data("province"), r.orderInfor.shipping_province_code = $(".J-CustomerInfor").find(".J-Province").find("option:selected").val()), r.orderInfor[e] = t
            }), $(".J-placeCustomer").addClass("jh-btn-loading"), setTimeout(function () {
                $(".J-placeCustomer").removeClass("jh-btn-loading")
            }, 8e3), r.cloneInfor(), r.createOrder(0, function () {
                r.fadeIn(1), $(".paypal-inform-box").hide(), r.checkout_step = "shipping_method", window.sessionStorage.setItem("index", e), window.sessionStorage.setItem("orderInfor", JSON.stringify(r.orderInfor)), $(".order-header-main").find(".order-step-mobile, .order-step").addClass("order-step-02").removeClass("order-step-01"), $(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide(), r.getStepData(), r.buyerCheckout({order_step: "2"}), (!localStorage.getItem(r.cartToken + "_step") || localStorage.getItem(r.cartToken + "_step") && "payment_method" != localStorage.getItem(r.cartToken + "_step")) && localStorage.setItem(r.cartToken + "_step", "shipping_method"), sessionStorage.setItem(r.cartToken + "_step_current", "shipping_method"), $plug.replaceParam(window.location.href, "step", "shipping_method"), $(".J-BillVal").each(function () {
                    var e = $(this).data("type");
                    "billing_contry" != e && "billing_province" != e && $(this).val(r.orderInfor[e])
                })
            }))) : (o = {}, $(".J-BillVal").each(function () {
                var a, i, n;
                $(this).parent(".order-write-item").is(":visible") && (a = $(this).data("type"), i = $.trim($(this).val()), n = $(this), "billing_contry" == $(this).data("type") || "billing_province" == $(this).data("type") ? o[$(this).data("type")] = $(this).find("option:selected").text() : o[$(this).data("type")] = $(this).val(), r.validation.map(function (e, t) {
                    e.verify && e.type == a && (n.removeClass("invalid"), n.siblings(".jh-input-tips").text("").hide(), i && "" != i && (!e.reg || new RegExp(e.reg, "i").test(i)) || (n.siblings(".jh-input-tips").text(e.tips[0]).show(), n.addClass("invalid"), d = !1, e.reg && !new RegExp(e.reg, "i").test(i) && "shipping_id_number" == e.type && (n.siblings(".jh-input-tips").text(e.tips[2]).show(), n.addClass("invalid"), d = !1)))
                }), "billing_address" == $(this).data("type") && $(this).val().length < 2 && (n.siblings(".jh-input-tips").text("").show(), n.addClass("invalid"), d = !1))
            }), d && (parseInt((new Date).getTime() / 1e3), parseInt($(".J-orderUpdateTime").val()), r.product_list.map(function (e, t) {
                e.inventory_quantity <= 0 && "0" != $(".J-orderUpdateTime").val() && "0" == $(".J-IsRenovation").val() && (window.location.href = "/cart")
            }), $(".J-BillVal").each(function () {
                var e = $(this).data("type"),
                    t = "INPUT" == $(this).get(0).tagName ? $.trim($(this).val()) : $(this).find("option:selected").data("countries") || $(this).find("option:selected").text();
                "billing_contry" == e && (r.orderInfor.billing_contry_code = $(this).val(), r.orderInfor.billing_contry = $(this).find("option:selected").data("countries")), "billing_province" == e && (r.orderInfor.billing_province_code = $(this).val(), r.orderInfor.billing_province = $(this).find("option:selected").data("province")), r.orderInfor[e] = t
            }), r.buyerCheckout({order_step: "3"}, function () {
                r.createOrder(1, t)
            })))
        },
        cloneInfor: function () {
            this.orderInfor.billing_email = this.orderInfor.shipping_email, this.orderInfor.billing_contry = this.orderInfor.shipping_contry, this.orderInfor.billing_contry_code = this.orderInfor.shipping_contry_code, this.orderInfor.billing_zip_code = this.orderInfor.shipping_zip_code, this.orderInfor.billing_phone = this.orderInfor.shipping_phone, this.orderInfor.billing_address = this.orderInfor.shipping_address, this.orderInfor.billing_city = this.orderInfor.shipping_city, this.orderInfor.billing_province = this.orderInfor.shipping_province, this.orderInfor.billing_province_code = this.orderInfor.shipping_province_code, this.orderInfor.billing_last_name = this.orderInfor.shipping_last_name, this.orderInfor.billing_first_name = this.orderInfor.shipping_first_name, this.orderInfor.billing_other_address = this.orderInfor.shipping_other_address, $(".J-PaymentMethod").find(".J-Country").find("option[value=" + this.orderInfor.shipping_contry_code + "]").eq(0).prop("selected", !0), this.getRegionLibrary(this.orderInfor.shipping_contry_code, !0, $(".J-PaymentMethod"))
        },
        isPayMoney: function () {
            "0.00" == this.orderRes.amount ? ($(".pay-free").show(), $(".paypal-inform-box").hide(), $(".order-payment-box").hide()) : ($(".pay-free").hide(), $(".paypal-inform-box").show(), $(".order-payment-box").show())
        },
        removeCoupon: function () {
            var e = {cart_token: this.cartToken, filed: "coupon_code"};
            this.orderInfor.coupon_code = "", localStorage.removeItem("coupon_code"), $http.post("/buyer/cart/del-cart-filed", JSON.stringify(e), function (e) {
                0 == e.code && 0 < $(".error-coupon-box").length && $(".error-coupon-box").remove()
            })
        },
        formatNumber: function (a, e) {
            return "card_number" == e ? a.replace(/\s/g, "").replace(/[^\d]/g, "").replace(/(\d{4})(?=\d)/g, "$1 ") : (a = a.replace(/[^0-9]+/g, ""), {
                CPF: [{
                    string: ".",
                    start: 0,
                    end: 3
                }, {string: ".", start: 3, end: 6}, {string: "-", start: 6, end: 9}, {string: "", start: 9, end: -1}],
                CNPJ: [{string: ".", start: 0, end: 2}, {string: ".", start: 2, end: 5}, {
                    string: "/",
                    start: 5,
                    end: 8
                }, {string: "-", start: 8, end: 12}, {string: "", start: 12, end: -1}],
                card_mmyy: [{string: "/", start: 0, end: 2}, {string: "", start: 2, end: -1}]
            }[e].map(function (e, t) {
                return -1 != e.end ? a.substring(e.start, e.end) + (a.length >= e.end ? e.string : "") : a.substring(e.start, a.length)
            }).join(""))
        },
        event: function () {
            var i = this;
            $(document).on("click", ".J-RemoveCoupon", function () {
                i.removeCoupon()
            }), $(document).on("keyup", ".J-GetBuyNowCouponVal", function () {
                "" != $.trim($(this).val()) ? $(".J-GetBuyNowCoupon").removeAttr("disabled").removeClass("jh-btn-disabled") : $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled")
            }), $(".J-GetBuyNowCouponVal").bind("input propertychange", function () {
                "" != $.trim($(this).val()) ? $(".J-GetBuyNowCoupon").removeAttr("disabled").removeClass("jh-btn-disabled") : $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled")
            }), $(document).on("click", ".J-BuyCouponClose", function () {
                $(".J-BuyNowCouponTips").empty(), $(".J-BuyNowDiscountInfo").empty(), $(".J-GetBuyNowCouponVal").val(""), $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled"), $(".buy-now-main").find(".buy-now-total").find("div").eq(1).text($(".buy-now-main").find(".buy-now-total").find("div").eq(1).data("price")), $(".buy-now-submit").find("p").show(), $(".buy-now-submit").find(".paypal-btn").show(), $(".buy-now-submit").find(".paypal-button-funding").show()
            }), $(document).on("click", ".J-MaskLoadClose", function () {
                $(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")
            }), $(".J-ZipCode").change(function () {
                var e = $(this).val();
                $(this).hasClass("J-OrderVal") && $(".J-CustomerInfor").find(".J-ZipCode").val(e)
            }), $(".J-ZipCode").blur(function () {
                var e = $(this).val();
                $(this).hasClass("J-OrderVal") && $(".J-CustomerInfor").find(".J-ZipCode").val(e)
            }), $(".J-TaxCode").change(function () {
                i.orderInfor.tax_type = $(this).val(), i.validation.map(function (e) {
                    "tax_number" == e.type && (e.reg = i.taxObj.reg[i.orderInfor.tax_type])
                })
            });
            var e = "", t = "", a = "";
            $(".J-TaxVal").keyup(function () {
                e.length < $(this).val().length && $(this).val(i.formatNumber($(this).val(), i.orderInfor.tax_type)), e = $(this).val()
            }), $(".J-TaxVal").blur(function () {
                $(this).val(i.formatNumber($(this).val(), i.orderInfor.tax_type))
            }), $(".J-CardNumber").keydown(function () {
                t.length < $(this).val().length && $(this).val(i.formatNumber($(this).val(), "card_number")), t = $(this).val()
            }), $(".J-CardNumber").blur(function () {
                $(this).val(i.formatNumber($(this).val(), "card_number"))
            }), $(".J-CardMMYY").keyup(function () {
                a.length < $(this).val().length && $(this).val(i.formatNumber($(this).val(), "card_mmyy")), a = $(this).val()
            }), $(".J-CardMMYY").blur(function () {
                $(this).val(i.formatNumber($(this).val(), "card_mmyy"))
            }), $(".J-CODID").blur(function () {
                var e = $(this).val();
                e && "" != e ? new RegExp("^([1-2]{1}[0-9]{9})?$", "i").test(e) ? ($(this).removeClass("invalid"), $(this).siblings(".jh-input-tips").text("").hide()) : ($(this).siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].validation.cod_id[2]).show(), $(this).addClass("invalid")) : ($(this).siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].validation.cod_id[0]).show(), $(this).addClass("invalid"))
            }), $(".J-Country").change(function () {
                var e = null, t = "";
                $(".J-PaymentMethod").is(":hidden") || (e = $(".J-PaymentMethod")), $(".J-CustomerInfor").is(":hidden") || (e = $(".J-CustomerInfor")), $(this).val() && "" != $(this).val() && (t = $(this).val(), -1 < $(".J-Country").find("option[value=" + t + "]").index() && ($(".J-CustomerInfor").is(":hidden") ? i.orderInfor.billing_contry_code = t : i.orderInfor.shipping_contry_code = t, i.getRegionLibrary(t, !0, e), $(".J-CustomerInfor").is(":hidden") || i.changeUserShippingBox(t)), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: $(".J-CustomerInfor").find(".J-Country").find("option:selected").prop("outerHTML"),
                    button_pos: "change",
                    button_name: "countries"
                }), $(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide()), i.changeTest(t), e.find(".J-Country").find("option[value=" + t + "]").eq(0).prop("selected", !0), i.checkRequired(t)
            }), $(".J-Province").change(function () {
                var e = null, t = "";
                $(".J-PaymentMethod").is(":hidden") || (e = $(".J-PaymentMethod")), $(".J-CustomerInfor").is(":hidden") || (e = $(".J-CustomerInfor")), $(this).val() && "" != $(this).val() && ($(".J-CustomerInfor").is(":hidden") ? i.orderInfor.billing_province_code = $(this).val() : i.orderInfor.shipping_province_code = $(this).val(), t = $(this).val()), e.find(".J-Province").find("option[value=" + t + "]").prop("selected", !0)
            }), $(".J-PhoneVal").keydown(function () {
                var e, t = $(this).val();
                (t.indexOf("(") <= -1 || -1 < t.indexOf("(") && -1 < t.indexOf(")")) && (e = $(".J-CustomerInfor").find(".J-Country").val(), t = new libphonenumber.AsYouType(e).input(t), $(this).val(t))
            }), $(document).on("click", ".J-ChangeInformation", function () {
                $(".paypal-inform-box").show(), i.fadeIn(0), r.setItem(i.cartToken + "_step_current", "contact_information"), $(this).hasClass("focus-address") ? setTimeout(function () {
                    $('.J-OrderVal[data-type="shipping_address"]').focus()
                }, 1e3) : setTimeout(function () {
                    $('.J-OrderVal[data-type="shipping_email"]').focus()
                }, 1e3), $plug.replaceParam(window.location.href, "step", "contact_information"), "" == i.paymethod && $(".J-PaymentMethod").find(".J-PaymentFailed").hide(), $(".order-header-main").find(".order-step-mobile, .order-step").addClass("order-step-01").removeClass("order-step-02").removeClass("order-step-03"), i.checkout_step = "contact_information", i.buyerCheckout(), $(".J-Insurance-Info").addClass("display-none")
            }), $(document).on("click", ".J-ChangeShipping", function () {
                $(".J-placeCustomer").click()
            }), $(document).on("click", ".J-ChangePayment", function () {
                $(".J-placeShipping").click()
            }), $(".J-placeCustomer").click(function () {
                i.checkRequired($(".J-Country").val()), i.orderInfor.order_step = "1", i.validationOrder(1), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: $(".J-CustomerInfor").find(".J-Country").find("option:selected").prop("outerHTML"),
                    button_pos: "1",
                    button_name: "continue"
                }), "function" == typeof stag && stag("page_load", "shipping", {
                    type: "trace",
                    button_pos: "2",
                    button_name: "shipping"
                })
            }), $(".J-placeShipping").click(function () {
                var e = $(this);
                if (!i.matchList || !i.matchList.length) return !1;
                if (i.orderInfor.order_step = "2", i.orderInfor.express_id = $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("id"), i.orderInfor.express_fee = $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("fee"), i.orderInfor.express_name = $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("title"), $(".J-express-name").text(i.orderInfor.express_name || ""), $(".J-express-fee").text(SAIL_ENV.config.headsymbol + i.orderInfor.express_fee || ""), $(this).addClass("jh-btn-loading"), setTimeout(function () {
                    e.removeClass("jh-btn-loading")
                }, 8e3), 1 == i.isBuyQuickly) {
                    if (0 == $(".J-OfficialVersion").val()) return SAIL_ENV.config.mask_layer("show"), $(".J-versionTips").show(), !1;
                    var t = {currency: $(".J-currency-code").val(), value: parseFloat(i.orderInfor.amount)};
                    return "function" == typeof snaptr && snaptr("track", "ADD_BILLING", {
                        price: t.value,
                        currency: t.currency
                    }), "function" == typeof gtag && gtag("event", "add_payment_info", {items: i.gtagSkuList}), i.validationOrder(3), "function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: "paypal",
                        button_pos: "2",
                        button_name: "complete"
                    }), "function" == typeof stag && stag("page_load", "shipping", {
                        type: "trace",
                        button_pos: "2",
                        button_name: "shipping"
                    }), !1
                }
                i.createOrder(0, function () {
                    i.checkout_step = "payment_method", localStorage.setItem(i.cartToken + "_step", "payment_method"), r.setItem(i.cartToken + "_step_current", "payment_method"), $plug.replaceParam(window.location.href, "step", "payment_method"), localStorage.setItem("user_select_insurance", i.local_is_select_insurance || 0), localStorage.setItem("__local_order_number__", i.order_number), i.fadeIn(2), "" == i.paymethod && $(".J-PaymentMethod").find(".J-PaymentFailed").show(), $(".order-header-main").find(".order-step-mobile, .order-step").addClass("order-step-03").removeClass("order-step-01").removeClass("order-step-02"), i.isPayMoney(), i.buyerCheckout({order_step: "2"}), i.getBuyQuickly();
                    var e = $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("title") + "-" + $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("fee");
                    "function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: e,
                        button_pos: "2",
                        button_name: "continue"
                    }), "function" == typeof stag && stag("page_load", "complete", {
                        type: "trace",
                        button_pos: "3",
                        button_name: "complete"
                    })
                })
            }), $(".J-paypalAdd").click(function () {
                var e = $(this).index();
                i.paypalSel = $(this).index(), $(this).find(".jh-radio").addClass("jh-radio-active"), $(this).siblings().find(".jh-radio").removeClass("jh-radio-active"), e ? (i.isValidationFn(!1), $(this).siblings(".order-paypal-box").slideDown(300)) : $(this).siblings(".order-paypal-box").slideUp(300)
            }), $(".J-CreateOrder").click(function () {
                var e = {currency: $(".J-currency-code").val(), value: parseFloat(i.orderInfor.amount)};
                if ("function" == typeof fbq && fbq("track", "AddPaymentInfo", e), "function" == typeof gtag && gtag("event", "add_payment_info", {items: i.gtagSkuList}), 0 == $(".J-OfficialVersion").val()) return SAIL_ENV.config.mask_layer("show"), $(".J-versionTips").show(), !1;
                var t = $(this);
                i.orderInfor.order_step = "3", $(this).addClass("jh-btn-loading"), setTimeout(function () {
                    t.removeClass("jh-btn-loading")
                }, 5e3), i.validationOrder(3), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: i.paymethod,
                    button_pos: "3",
                    button_name: "complete"
                })
            }), $(".J-Offers").click(function () {
                $(this).children(".jh-checkbox").hasClass("jh-checkbox-active") ? ($(this).children(".jh-checkbox").removeClass("jh-checkbox-active"), i.orderInfor.is_recommend = "0") : (i.orderInfor.is_recommend = "1", $(this).children(".jh-checkbox").addClass("jh-checkbox-active"))
            }), $(".J-GetCoupon").click(function () {
                var e = $.trim($(this).siblings(".J-GetCouponVal").val());
                i.buyerCheckout({coupon: {coupon_code: e}}), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: e,
                    button_name: "apply"
                }), $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled")
            }), $(document).on("click", ".J-CouponClose", function () {
                i.removeCoupon(), $(".J-CouponItem").empty(), $(".J-GetCouponVal").val(""), $(".J-Discount-Info").empty(), i.buyerCheckout()
            }), "" == $(".J-GetCouponVal").val() && $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled"), $(".J-GetCouponVal").on("keyup", function () {
                "" == $(this).val() ? $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled") : $(".J-GetCoupon").removeClass("jh-disabled").removeAttr("disabled")
            }), $(".J-GetCouponVal").bind("input propertychange", function () {
                $(this).hasClass("invalid") && $(this).removeClass("invalid"), $(".J-CouponItem").find(".erro-tips").text(""), "" == $(this).val() ? $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled") : $(".J-GetCoupon").removeClass("jh-disabled").removeAttr("disabled")
            }), $(".J-Textarea").keyup(function () {
                var e = $(this).val();
                $(".J-Textarea").val(e)
            }), $(document).on("click", ".J-SwitchPal", function () {
                var e = $(this).data("type");
                $(".J-SwitchPal").siblings(".order-paypal-box").stop().slideUp(300), $(this).siblings(".order-paypal-box").stop().slideDown(300), i.paymethod = e, "SA" == i.orderInfor.shipping_contry_code && i.showIDNumber && "COD" == i.paymethod ? $(".J-PaymentMethod").find(".order-id-munber").show() : $(".J-PaymentMethod").find(".order-id-munber").hide(), $(".J-SwitchPal").find(".jh-radio").removeClass("jh-radio-active"), $(this).find(".jh-radio").addClass("jh-radio-active"), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: "",
                    button_pos: e,
                    button_name: "payment_method"
                })
            }), $(".J-BillVal").change(function () {
                i.isValidationFn()
            }), $(".J-LogOut").click(function () {
                $http.post("/buyer/user/logout", {}, function (e) {
                    0 == e.code && ($(".J-LogOut").parents(".order-write-list").remove(), $(".J-CustomerInfor").find(".order-title").append(SAIL_ENV.language[SAIL_ENV.language.lang].log_in($(".J-LoginReferer").val())), $('.J-OrderVal[data-type="shipping_email"]').parents(".order-write-list").show())
                })
            }), $(".J-GetUserAddress").change(function () {
                var a = $(this).find("option:selected").data("addressid");
                if ("-100" == a) return i.makeUserAddress({}), !1;
                i.userAddress.map(function (e, t) {
                    e.shipping_id == a && i.makeUserAddress(e)
                })
            }), $(document).on("click", ".J-SaveInformation", function () {
                $(this).children(".jh-checkbox").hasClass("jh-checkbox-active") ? $(this).children(".jh-checkbox").removeClass("jh-checkbox-active") : $(this).children(".jh-checkbox").addClass("jh-checkbox-active")
            }), $(".J-GoogleMapAddress").focus(function () {
                $(".J-GoogleMapAddress").prop("autocomplete", "none"), window.screen.availWidth <= 768 && 200 < $(this).offset().top - $(document).scrollTop() && $("body,html").animate({scrollTop: $(this).offset().top - 200}, 500)
            }), $(".J-GoogleMapAddress").blur(function () {
                $(".J-GoogleMapAddress").prop("autocomplete", ""), setTimeout(function () {
                    0 < $(".sail-address-box").length && $(".sail-address-box").hide()
                }, 1e3)
            }), $(document).on("keyup", ".J-GoogleMapAddress", function () {
                var t = $(this), e = $(this).prop("name"),
                    a = {input: $(this).val(), countryCode: $(".J-CustomerInfor").find(".J-Country").val()};
                return i.isUserOper = !1, ("GB" != a.countryCode || "Address" != e) && ($.trim($(this).val()).length < 4 || 200 < $.trim($(this).val()).length ? (0 < $(".sail-address-box").length && $(".sail-address-box").hide(), t.parent(".order-write-item").find(".jh-input-tips").show().text(SAIL_ENV.language[SAIL_ENV.language.lang].google_map), !1) : (t.parent(".order-write-item").find(".jh-input-tips").hide().text(""), 0 < $(".sail-address-box").length && $(".sail-address-box").show(), void $http.get("/buyer/user/google-map", a, function (e) {
                    0 == e.code && $(".J-GoogleMapAddress").is(":focus") && i.googleMap(t.parent(), e.data, t.val())
                })))
            }), $(document).click(function (e) {
                var t, a;
                "orders" == $(".sail-event-page-location").val() && (t = $(e.target).attr("class"), a = $.trim($(".J-GoogleMapAddress").val()).length, $(".J-CustomerInfor").find(".J-Country").val(), t && -1 < t.indexOf("google-map") || t && -1 < t.indexOf("J-GoogleMapAddress") ? 0 < $(".sail-address-box").length && !i.isUserOper && 1 < a && $(".sail-address-box").show() : 0 < $(".sail-address-box").length && $(".sail-address-box").remove())
            }), $(document).on("click", ".J-GetSaiLAddress", function () {
                var e = {placeid: $(this).data("placeid")},
                    t = ($(this), $(this).parents(".order-write-item").find(".J-GoogleMapAddress").val());
                $http.get("/buyer/user/google-map-detail", e, function (e) {
                    0 == e.code && i.eachAddress(e.data, t)
                })
            }), $(document).on("click", ".insurance-order-checkbox", function (e) {
                var t = $(this).find(".jh-checkbox").hasClass("jh-checkbox-active");
                t ? $(".insurance-order-checkbox .jh-checkbox").removeClass("jh-checkbox-active") : $(".insurance-order-checkbox .jh-checkbox").addClass("jh-checkbox-active"), i.local_is_select_insurance = t ? 0 : 1, i.orderInfor.is_select_insurance = t ? 0 : 1, localStorage.setItem("user_select_insurance", i.local_is_select_insurance), t ? $(".J-Insurance-Info").addClass("display-none") : $(".J-Insurance-Info").removeClass("display-none"), t && SAIL_ENV.config.isMobile && ($(".J-Mask").css("background", "rgba(0,0,0,.4)").show(), $("body").append('\n                        <div class="insurance-alert-box">\n                            <div class="insurance-alert-box-title">' + SAIL_ENV.language[SAIL_ENV.language.lang].insurance_alert + '</div>\n                            <div class="insurance-alert-box-ok">' + SAIL_ENV.language[SAIL_ENV.language.lang].insurance_alert_ok + "</div>\n                        </div>\n                   "), $(document).on("click", ".insurance-alert-box-ok, .J-Mask", function (e) {
                    $(".insurance-alert-box").remove(), $(".J-Mask").hide().css("background", "rgba(0,0,0,.6)"), e.preventDefault(), e.stopPropagation()
                })), i.watchInsuranceCheckboxStatus(), e.preventDefault(), e.stopPropagation()
            }), $(document).on("click", ".privacy-item, .icon-shopping-privacy", function () {
                var t = this;
                $(".privacy-mask").css("display", "flex"), $("body").css("overflow", "hidden"), setTimeout(function () {
                    $(".privacy-dialog-title").html($(t).data("title") || "");
                    var e = $(t).find(".privacy-item-html").html() || "";
                    $(t).hasClass("icon-shopping-privacy") && (e = (e = $("textarea.privacy-item-html").text() || "").replace(/<script>.*<\/script>/gim, "")), $(".privacy-dialog-body").html(e), $(".privacy-dialog").show()
                }, 60)
            }).on("click", ".privacy-btn-ok, .privacy-mask", function (e) {
                var t = e && e.originalEvent ? e.originalEvent.srcElement.className : "";
                "privacy-btn-ok" != t && "privacy-mask" != t || ($("body").css("overflow", "auto"), $(".privacy-mask").hide(), $(".privacy-dialog").hide())
            })
        },
        subGoogleMapString: function (e) {
            if (e.hasOwnProperty("matched_substrings") && 0 < e.matched_substrings.length) {
                var i = e.description, n = "", o = 0;
                return e.matched_substrings.forEach(function (e) {
                    var t = e.offset, a = e.offset + e.length;
                    n += i.substring(o, t) + ('<sapn class="emphasis">' + i.substring(t, a)) + "</sapn>", o = a
                }), n += i.substring(o)
            }
            return e.description
        },
        googleMap: function (e, t) {
            var i, n = this;
            "Object" == $plug.toRawType(t) && 0 < t.predictions.length && (i = 0 < e.find(".sail-address-box").length ? "" : "<div class='sail-address-box'><div class='sail-address-title google-map'>" + SAIL_ENV.language[SAIL_ENV.language.lang].google_map_suggestions + " <span class='iconfont icon-close J-CloseAddress'></span></div><div class='sail-address-list'>", t.predictions.map(function (e, t) {
                var a = n.subGoogleMapString(e);
                i += "<div class='sail-address-item J-GetSaiLAddress' data-placeId=" + e.place_id + " >" + a + "</div>"
            }), i += 0 < e.find(".sail-address-box").length ? "" : '</div><div class="combo-box__footer google-map"><svg class="google-map" id="powered-by-google" width="116" height="15"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 116 15"><path fill="#737373" d="M4.025 3.572c1.612 0 2.655 1.283 2.655 3.27 0 1.974-1.05 3.27-2.655 3.27-.902 0-1.63-.393-1.974-1.06h-.09v3.057H.95V3.68h.96v1.054h.094c.404-.726 1.16-1.166 2.02-1.166zm-.24 5.63c1.16 0 1.852-.884 1.852-2.36 0-1.477-.692-2.362-1.846-2.362-1.14 0-1.86.91-1.86 2.362 0 1.447.72 2.36 1.857 2.36zm7.072.91c-1.798 0-2.912-1.243-2.912-3.27 0-2.033 1.114-3.27 2.912-3.27 1.8 0 2.913 1.237 2.913 3.27 0 2.027-1.114 3.27-2.913 3.27zm0-.91c1.196 0 1.87-.866 1.87-2.36 0-1.5-.674-2.362-1.87-2.362-1.195 0-1.87.862-1.87 2.362 0 1.494.675 2.36 1.87 2.36zm12.206-5.518H22.05l-1.244 5.05h-.094L19.3 3.684h-.966l-1.412 5.05h-.094l-1.242-5.05h-1.02L16.336 10h1.02l1.406-4.887h.093L20.268 10h1.025l1.77-6.316zm3.632.78c-1.008 0-1.71.737-1.787 1.856h3.48c-.023-1.12-.69-1.857-1.693-1.857zm1.664 3.9h1.005c-.305 1.085-1.277 1.747-2.66 1.747-1.752 0-2.848-1.262-2.848-3.26 0-1.987 1.113-3.276 2.847-3.276 1.705 0 2.742 1.213 2.742 3.176v.386h-4.542v.047c.053 1.248.75 2.04 1.822 2.04.815 0 1.366-.3 1.63-.857zM31.03 10h1.01V6.086c0-.89.696-1.535 1.657-1.535.2 0 .563.038.645.06V3.6c-.13-.018-.34-.03-.504-.03-.838 0-1.565.434-1.752 1.05h-.094v-.938h-.96V10zm6.915-5.537c-1.008 0-1.71.738-1.787 1.857h3.48c-.023-1.12-.69-1.857-1.693-1.857zm1.664 3.902h1.005c-.304 1.084-1.277 1.746-2.66 1.746-1.752 0-2.848-1.262-2.848-3.26 0-1.987 1.113-3.276 2.847-3.276 1.705 0 2.742 1.213 2.742 3.176v.386h-4.542v.047c.053 1.248.75 2.04 1.822 2.04.815 0 1.366-.3 1.63-.857zm5.01 1.746c-1.62 0-2.657-1.28-2.657-3.266 0-1.98 1.05-3.27 2.654-3.27.878 0 1.622.416 1.98 1.108h.087V1.177h1.008V10h-.96V8.992h-.094c-.4.703-1.15 1.12-2.02 1.12zm.232-5.63c-1.15 0-1.846.89-1.846 2.364 0 1.476.69 2.36 1.846 2.36 1.148 0 1.857-.9 1.857-2.36 0-1.447-.715-2.362-1.857-2.362zm7.875-3.115h1.024v3.123c.23-.3.507-.53.827-.688.32-.16.668-.238 1.043-.238.78 0 1.416.27 1.9.806.49.537.73 1.33.73 2.376 0 .992-.24 1.817-.72 2.473-.48.656-1.145.984-1.997.984-.476 0-.88-.114-1.207-.344-.195-.137-.404-.356-.627-.657v.8h-.97V1.363zm4.02 7.225c.284-.454.426-1.05.426-1.794 0-.66-.142-1.207-.425-1.64-.283-.434-.7-.65-1.25-.65-.48 0-.9.177-1.264.532-.36.356-.542.942-.542 1.758 0 .59.075 1.068.223 1.435.277.694.795 1.04 1.553 1.04.57 0 .998-.227 1.28-.68zM63.4 3.726h1.167c-.148.402-.478 1.32-.99 2.754-.383 1.077-.703 1.956-.96 2.635-.61 1.602-1.04 2.578-1.29 2.93-.25.35-.68.527-1.29.527-.147 0-.262-.006-.342-.017-.08-.012-.178-.034-.296-.065v-.96c.183.05.316.08.4.093.08.012.152.018.215.018.195 0 .338-.03.43-.094.092-.065.17-.144.232-.237.02-.033.09-.193.21-.48.122-.29.21-.506.264-.646l-2.32-6.457h1.196l1.68 5.11 1.694-5.11zM73.994 5.282V6.87h3.814c-.117.89-.416 1.54-.87 1.998-.557.555-1.427 1.16-2.944 1.16-2.35 0-4.184-1.882-4.184-4.217 0-2.332 1.835-4.215 4.184-4.215 1.264 0 2.192.497 2.873 1.135l1.122-1.117C77.04.697 75.77 0 73.99 0c-3.218 0-5.923 2.606-5.923 5.805 0 3.2 2.705 5.804 5.923 5.804 1.738 0 3.048-.57 4.073-1.628 1.05-1.045 1.382-2.522 1.382-3.71 0-.366-.028-.708-.087-.992h-5.37zm10.222-1.29c-2.082 0-3.78 1.574-3.78 3.748 0 2.154 1.698 3.747 3.78 3.747S87.998 9.9 87.998 7.74c0-2.174-1.7-3.748-3.782-3.748zm0 6.018c-1.14 0-2.127-.935-2.127-2.27 0-1.348.983-2.27 2.124-2.27 1.142 0 2.128.922 2.128 2.27 0 1.335-.986 2.27-2.128 2.27zm18.54-5.18h-.06c-.37-.438-1.083-.838-1.985-.838-1.88 0-3.52 1.632-3.52 3.748 0 2.102 1.64 3.747 3.52 3.747.905 0 1.618-.4 1.988-.852h.06v.523c0 1.432-.773 2.2-2.012 2.2-1.012 0-1.64-.723-1.9-1.336l-1.44.593c.414.994 1.51 2.213 3.34 2.213 1.94 0 3.58-1.135 3.58-3.902v-6.74h-1.57v.645zm-1.9 5.18c-1.144 0-2.013-.968-2.013-2.27 0-1.323.87-2.27 2.01-2.27 1.13 0 2.012.967 2.012 2.282.006 1.31-.882 2.258-2.01 2.258zM92.65 3.992c-2.084 0-3.783 1.574-3.783 3.748 0 2.154 1.7 3.747 3.782 3.747 2.08 0 3.78-1.587 3.78-3.747 0-2.174-1.7-3.748-3.78-3.748zm0 6.018c-1.143 0-2.13-.935-2.13-2.27 0-1.348.987-2.27 2.13-2.27 1.14 0 2.126.922 2.126 2.27 0 1.335-.986 2.27-2.127 2.27zM105.622.155h1.628v11.332h-1.628m6.655-1.477c-.843 0-1.44-.38-1.83-1.135l5.04-2.07-.168-.426c-.314-.84-1.274-2.39-3.227-2.39-1.94 0-3.554 1.516-3.554 3.75 0 2.1 1.595 3.745 3.736 3.745 1.725 0 2.724-1.05 3.14-1.658l-1.285-.852c-.427.62-1.01 1.032-1.854 1.032zm-.117-4.612c.668 0 1.24.342 1.427.826l-3.405 1.4c0-1.574 1.122-2.226 1.978-2.226z"></path></svg></svg></div></div>', 0 < e.find(".sail-address-box").length ? e.find(".sail-address-list").empty().append(i) : e.append(i))
        },
        eachAddress: function (e, t) {
            var a, i = this, n = "", o = "", r = "", s = $(".J-CustomerInfor").find(".J-Country").val();
            if (s = $(".J-CustomerInfor").find(".J-Country").val(), a = $(".J-CustomerInfor").find(".J-Country").find("option:selected").val(), "Object" == $plug.toRawType(e.result) && 0 < e.result.address_components.length) {
                for (var d, c = {address: "", province: ""}, l = e.result.address_components.length - 1; 0 <= l; l--) {
                    var p = e.result.address_components[l].types[0];
                    switch (p) {
                        case"country":
                            var u = !1, h = e.result.address_components[l].short_name,
                                g = e.result.address_components[l].short_name;
                            $(".J-CustomerInfor").find(".J-Country").find("option").each(function (e, t) {
                                $(this).removeProp("selected"), $(this).val() == h && (u = !0)
                            }), u && (r = g, i.country_value = g, $(".J-Country").find("option[value=" + g + "]").eq(0).prop("selected", !0), i.checkRequired(r));
                            break;
                        case"administrative_area_level_1":
                            var h = e.result.address_components[l].long_name,
                                m = e.result.address_components[l].short_name;
                            c.province = e.result.address_components[l].long_name, $(".J-CustomerInfor").find(".J-Province").val("-1000"), a == i.country_value ? $(".J-CustomerInfor").find(".J-Province").val(m) : (i.province_value = h, i.getRegionLibrary(r, !0, $(".J-CustomerInfor"))), $(".J-CustomerInfor").find(".J-Province").next().hide(), $(".J-CustomerInfor").find(".J-Province").removeClass("invalid");
                            break;
                        case"postal_code":
                            o = e.result.address_components[l].long_name;
                            break;
                        case"postal_town":
                            h = e.result.address_components[l].long_name;
                            "GB" == s && (document.getElementById("locality").value = e.result.address_components[l].long_name, 0 < h.length && ($(document.getElementById("locality")).next().hide(), $(document.getElementById("locality")).removeClass("invalid"), $(document.getElementById("locality")).parent().addClass("order-write--show")));
                            break;
                        default:
                            h = e.result.address_components[l].long_name;
                            "street_number" != p && "route" != p || (n = e.result.address_components[l].long_name + " " + n, c.address = n), -1 < p.indexOf("locality") && "GB" != s && (document.getElementById("locality").value = e.result.address_components[l].long_name, 0 < h.length && ($(document.getElementById("locality")).next().hide(), $(document.getElementById("locality")).removeClass("invalid"), $(document.getElementById("locality")).parent().addClass("order-write--show")), c.address = h)
                    }
                }
                "GB" == s ? (d = "" != o ? o : t, $(".J-ZipCode.J-GoogleMapAddress").val(d), document.getElementById("postal_code") && (document.getElementById("postal_code").value = d), 0 < d.length && ($(".J-ZipCode.J-GoogleMapAddress").next().hide(), $(".J-ZipCode.J-GoogleMapAddress").removeClass("invalid"), $(".J-ZipCode.J-GoogleMapAddress").parent().addClass("order-write--show"))) : ($(".J-ZipCode.J-GoogleMapAddress").val = o, document.getElementById("postal_code") && (document.getElementById("postal_code").value = o), 0 < o.length && ($(document.getElementById("postal_code")).next().hide(), $(document.getElementById("postal_code")).removeClass("invalid"), $(document.getElementById("postal_code")).parent().addClass("order-write--show")));
                t = "" != n ? n : "GB" == s ? "" : t;
                document.getElementById("street_number").value = $.trim(t), 0 < t.length && ($(document.getElementById("street_number")).next().hide(), $(document.getElementById("street_number")).removeClass("invalid"), $(document.getElementById("street_number")).parent().addClass("order-write--show")), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: "Address",
                    button_pos: c.address + ";" + c.province,
                    button_name: "google map"
                })
            }
            i.isUserOper = !0, setTimeout(function () {
                $(".J-GoogleMapAddress").focus()
            }, 100)
        },
        fadeIn: function (e, t) {
            var a = localStorage.getItem(this.cartToken + "_step");
            t ? ($(".J-OrderCrumbs").find(".J-step" + e).addClass("active").siblings().removeClass("active"), $(".order-step").hide(), $(".order-step").eq(e).show(), 2 == e ? $(".step-section-inform").find(".row").eq(2).show() : $(".step-section-inform").find(".row").eq(2).hide(), 0 == e ? $(".step-section-inform").hide() : $(".step-section-inform").show()) : ($(".J-OrderCrumbs").find(".J-step" + e).addClass("active").siblings().removeClass("active"), $(".order-step").fadeOut(500), setTimeout(function () {
                $(".order-step").eq(e).fadeIn(500), 2 == e ? $(".step-section-inform").find(".row").eq(2).show() : $(".step-section-inform").find(".row").eq(2).hide(), 0 == e ? $(".step-section-inform").fadeOut(500) : $(".step-section-inform").fadeIn(500)
            }, 500)), "payment_method" == a ? ($(".J-step0").addClass("J-ChangeInformation"), $(".J-step1").addClass("J-ChangeShipping"), $(".J-step2").addClass("J-ChangePayment")) : ($(".J-step2").removeClass("J-ChangePayment"), 1 <= e ? $(".J-step0").addClass("J-ChangeInformation") : $(".J-step0").removeClass("J-ChangeInformation"), 2 == e ? $(".J-step1").addClass("J-ChangeShipping") : $(".J-step1").removeClass("J-ChangeShipping")), setTimeout(function () {
                "payment_method" == a && "contact_information" == $plug.query().step && $(".J-step2").removeClass("J-ChangePayment")
            }, 10)
        },
        createOrder: function (i, n) {
            var o = this;
            if ("" == o.orderInfor[void 0] && delete o.orderInfor[void 0], o.orderInfor.shipping_contry_code && "" != o.orderInfor.shipping_contry_code || $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                o.orderInfor.shipping_contry == $(this).data("countries") && (o.orderInfor.shipping_contry_code = item.code, o.orderInfor.contry_id = item.id)
            }), o.orderInfor.cartToken = o.cartToken, o.orderInfor.checkout_step = o.checkout_step, window.location.href.includes("orderNumberFromEmail") && (o.orderInfor.order_number_from_email = $plug.query().orderNumberFromEmail), "1" == $(".J-isShowPhone").val() && "" == $.trim(o.orderInfor.shipping_phone)) return $plug.replaceParam(window.location.href, "step", "contact_information"), !1;
            $http.post("/buyer/order/create", JSON.stringify(o.orderInfor), function (t) {
                if (503 == t.code && "0" == $(".J-IsRenovation").val() && (window.location.href = "/cart"), 0 == t.code && (o.order_number = t.data.order_number, window.sessionStorage.setItem("order_number", o.order_number)), 1500 == t.code && window.location.reload(), 101 == t.code) return $plug.replaceParam(window.location.href, "step", "contact_information"), !1;
                var e, a;
                if (0 == t.code && 0 == i && (e = {
                    is_recommend: o.orderInfor.is_recommend,
                    shipping_email: o.orderInfor.shipping_email,
                    shipping_first_name: o.orderInfor.shipping_first_name,
                    shipping_last_name: o.orderInfor.shipping_last_name,
                    shipping_address: o.orderInfor.shipping_address,
                    shipping_other_address: o.orderInfor.shipping_other_address,
                    shipping_contry: o.orderInfor.shipping_contry,
                    shipping_city: o.orderInfor.shipping_city,
                    shipping_province: o.orderInfor.shipping_province,
                    shipping_phone: o.orderInfor.shipping_phone,
                    shipping_zip_code: o.orderInfor.shipping_zip_code,
                    shipping_contry_code: o.orderInfor.shipping_contry_code,
                    shipping_province_code: o.orderInfor.shipping_province_code
                }, s.setItem("order_data", JSON.stringify(e)), n && n(), o.orderNo = t.data.order_number), 0 == t.code && 1 == i) {
                    if ($(".J-PaymentFailed").hide(), "card" == o.paymethod && $plug.loading("Payment In Progress!"), 1 == o.isBuyQuickly) return jQuery.post("/payment/paypal-union/capture-order", {
                        cartToken: o.cartToken,
                        orderNumber: o.order_number
                    }, function (e) {
                        var t;
                        $(".J-CreateOrder").removeClass("jh-btn-loading"), 0 < $(".J-Loading").length && ($(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")), 10003 == e.code && (localStorage.setItem(o.cartToken + "_step", "payment_method"), r.setItem(o.cartToken + "_step_current", "payment_method"), $plug.replaceParam(window.location.href, "step", "payment_method"), $plug.replaceParam(window.location.href, "error", "PAYMENT_ERROR"), window.location.reload()), 0 == e.code ? (window.localStorage.removeItem("coupon_code"), window.localStorage.removeItem(o.cartToken + "_step"), window.localStorage.removeItem("user_select_insurance"), localStorage.removeItem("user_select_insurance"), t = e.data.order_url.split("?")[1].split("order_hash_paypal=")[1], window.location.href = "/checkouts/" + t + "/thank_you") : ($(".J-PaymentFailed").find(".J-PaymentFailed--text").text(e.msg), $(".J-PaymentFailed").show())
                    }), !1;
                    0 == o.isBuyQuickly && "card" == o.paymethod && "0.00" != o.orderInfor.amount && (a = {order_number: t.data.order_number}, $plug.loading("Payment In Progress!"), window.screen.availWidth <= 768 ? a.isMobile = "1" : a.isMobile = "0", window.location.href = "/payment/creditcard/create-payment?order_number=" + t.data.order_number + "&isMobile=" + a.isMobile), (0 == o.isBuyQuickly && "paypal" == o.paymethod || "0.00" == o.orderInfor.amount) && (a = {
                        cartToken: o.cartToken,
                        order_number: t.data.order_number
                    }, 0 == o.isBuyQuickly && jQuery.post("/payment/paypal-union/create-order", a, function (e) {
                        return 10003 == e.code && window.location.reload(), 301 == e.code ? (window.location.href = "/checkouts/" + t.data.order_number_hash + "/thank_you", !1) : void (0 == e.code ? window.location.href = e.data.href : ($(".J-PaymentFailed").find(".J-PaymentFailed--text").text(e.msg), $(".J-PaymentFailed").show()))
                    })), 0 == o.isBuyQuickly && "COD" == o.paymethod && "0.00" != o.orderInfor.amount && (a = {order_number: t.data.order_number}, $plug.loading("Payment In Progress!"), window.screen.availWidth <= 768 ? a.isMobile = "1" : a.isMobile = "0", window.location.href = "/payment/cash-delivery/create-payment?order_number=" + t.data.order_number + "&isMobile=" + a.isMobile)
                }
            })
        },
        paypalPayment: function (s) {
            if ($(".placeholder-line").hide(), "object" != ("undefined" == typeof paypal ? "undefined" : _typeof(paypal))) return !1;
            var d = this, e = {
                env: SAIL_ENV.PAYPAL_ENV, locale: "en_US", payment: function (t) {
                    var e, a, i, n, o, r;
                    1 == s.type && s.bool && "function" == typeof stag && stag("page_click", "buy_it_now", {
                        handler: $(".sail-event-page-handler").val(),
                        additional: $plug.query().variant || $(s.id).parents(".JH-Columns").find(".product-id").val()
                    }), 1 == s.type ? ("function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: "1",
                        button_pos: "",
                        button_name: "paypal"
                    }), o = null, a = e = "", i = "index" == s.path ? $(s.id).parents(".JH-Columns") : $(".JH-Columns"), n = "index" == s.path ? i.find(".product-code").val() : $(".product-code").val(), "index" == s.path ? i.find(".product-id").val() : $(".product-code").val(), o = s.bool ? {
                        sku_id: "",
                        attribute: {},
                        cart_type: "2",
                        quantity: 0 < i.find(".J-ProductNumber").length ? i.find(".J-ProductNumber").val() : 1
                    } : {cart_type: "1"}, s.bool && (0 < i.find(".J-Attribute").find("select").length ? i.find(".J-Product").find(".J-Attribute").each(function () {
                        a += $.trim($(this).find(".J-Value").find("option:selected").data("title-code")), o.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find("option:selected").data("title")
                    }) : i.find(".J-Product").find(".J-Attribute").each(function () {
                        a += $.trim($(this).find(".J-Value").find(".active").data("title-code")), o.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find(".active").data("title")
                    }), "index" == s.path ? 0 < i.find(".J-SkuList-" + n).find("span").length && (i.find(".J-SkuList-" + n).find("span").each(function () {
                        $.trim(a) == $.trim($(this).data("title-code")) && (e = $(this).data("id"))
                    }), 1 < i.find(".J-SkuList-" + n).find("span").length && (o.sku_id = e || ""), 1 == i.find(".J-SkuList-" + n).find("span").length && (o.sku_id = i.find(".J-SkuList-" + n).find("span").eq(0).data("id"))) : 0 < $(".J-SkuList").find("span").length && ($(".J-SkuList").find("span").each(function () {
                        $.trim(a) == $.trim($(this).data("title-code")) && (e = $(this).data("id"))
                    }), 1 < $(".J-SkuList").find("span").length && (o.sku_id = e || $plug.query().variant || ""), 1 == $(".J-SkuList").find("span").length && (o.sku_id = $(".J-SkuList").find("span").eq(0).data("id")))), s.bool || (o.cartToken = d.cartToken), r = "/payment/paypal-union/create-order", $http.post(r, JSON.stringify(o), function (e) {
                        10003 == e.code && window.location.reload(), 0 == e.code ? (t(e.data.token), s.bool && (d.cartToken = e.data.cartToken)) : ($plug.message.error(e.msg), "function" == typeof stag && stag("page_click", "user_behavior", {
                            type: "check",
                            additional: e.msg,
                            button_pos: r,
                            button_name: ""
                        }))
                    })) : (d.resolve = t, d.validationOrder(3, t), "function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: "paypal",
                        button_pos: "3",
                        button_name: "complete"
                    }))
                }, onAuthorize: function (e) {
                    var a, t = {
                        payerID: e.payerID,
                        orderID: e.orderID,
                        cartToken: d.cartToken,
                        paymentToken: e.paymentToken
                    };
                    1 == s.type && $http.post("/payment/paypal-union/save-payment-token-info", JSON.stringify(e), function (e) {
                        0 == e.code && (s.bool ? ("function" == typeof fbq && fbq("track", "AddToCart"), "function" == typeof snaptr && snaptr("track", "ADD_CART"), "function" == typeof gtag && gtag("event", "add_to_cart"), "function" == typeof pintrk && pintrk("track", "addtocart"), "object" == _typeof(window.uetq) && window.uetq.push("event", "add_to_cart"), "function" == typeof fbq && fbq("track", "InitiateCheckout"), "function" == typeof snaptr && snaptr("track", "START_CHECKOUT"), "function" == typeof gtag && gtag("event", "begin_checkout"), localStorage.removeItem(d.cartToken + "_step"), r.removeItem(d.cartToken + "_step_current"), r.removeItem("user_select_insurance"), r.removeItem("user_select_insurance"), r.removeItem("card-remark"), window.location.href = "/checkouts/" + d.cartToken + "?step=contact_information") : $http.post("/payment/paypal-union/get-order-info", {}, function (e) {
                            0 == e.code && e.data && e.data.buyer && (d.isBuyQuickly = 1, d.paymethod = "paypal", $(".J-paypal-payment").hide(), $(".J-PaymentMethod").remove(), $(".J-placeShipping").find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_complete_order), $(".J-CustomerInfor").find(".paypal-checkout-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].paypal).addClass("paypal-remembered-tips"), d.isExistCacheAddress || d.setCacheAddress(e.data.buyer, "paypal"))
                        }))
                    }), 2 == s.type && ($(".J-PaymentFailed").hide(), $plug.loading("Payment In Progress!"), a = "/payment/paypal-union/capture-order", $.ajax({
                        type: "post",
                        data: t,
                        url: a,
                        dataType: "json",
                        success: function (e) {
                            var t;
                            $(".J-CreateOrder").removeClass("jh-btn-loading"), 0 < $(".J-Loading").length && ($(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")), 10003 == respolonse.code && ($plug.replaceParam(window.location.href, "error", "PAYMENT_ERROR"), window.location.reload()), 0 == e.code ? (window.localStorage.removeItem("coupon_code"), window.localStorage.removeItem(d.cartToken + "_step"), window.localStorage.removeItem("user_select_insurance"), window.localStorage.removeItem("__local_order_number__"), t = e.data.order_url.split("?")[1].split("order_hash_paypal=")[1], window.location.href = "/checkouts/" + t + "/thank_you") : ($(".J-PaymentFailed").find(".J-PaymentFailed--text").text(e.msg), $(".J-PaymentFailed").show(), "function" == typeof stag && stag("page_click", "user_behavior", {
                                type: "check",
                                additional: e.msg,
                                button_pos: a,
                                button_name: ""
                            }))
                        }
                    }))
                }, onCancel: function () {
                    $(".J-CreateOrder").removeClass("jh-btn-loading"), 0 < $(".J-Loading").length && $(".J-MaskLoad, .J-Loading").hide()
                }, onError: function () {
                    window.location.reload()
                }
            };
            switch (s.paymentType) {
                case"whiteBar":
                    e.funding = {allowed: [paypal.FUNDING.CREDIT]}, e.client = SAIL_ENV.PAYPAL_CLIENT, e.style = {
                        label: "credit",
                        size: "responsive",
                        shape: "rect",
                        tagline: !1,
                        height: 44
                    };
                    break;
                default:
                    e.commit = 1 != s.type, e.style = {
                        layout: "horizontal",
                        size: "responsive",
                        color: "gold",
                        shape: "rect",
                        label: "paypal",
                        maxbuttons: 1,
                        height: 2 == s.type ? 55 : 44,
                        tagline: !1
                    }
            }
            "object" == ("undefined" == typeof paypal ? "undefined" : _typeof(paypal)) && paypal.Button.render(e, s.id)
        },
        paypalCard: function (e) {
            var r = this, s = !0;
            paypal.Button.render({
                env: SAIL_ENV.PAYPAL_ENV,
                style: {
                    layout: "vertical",
                    size: "responsive",
                    color: "blue",
                    shape: "rect",
                    label: "paypal",
                    height: 55,
                    tagline: !1
                },
                payment: function (e, t) {
                    var a = {
                        cartToken: r.cartToken,
                        order_number: r.order_number || window.sessionStorage.getItem("order_number")
                    }, o = {};
                    return $(".J-BillVal").each(function () {
                        var a, i, n;
                        $(this).parent(".order-write-item").is(":visible") && (a = $(this).data("type"), i = $.trim($(this).val()), n = $(this), "billing_contry" == $(this).data("type") || "billing_province" == $(this).data("type") ? o[$(this).data("type")] = $(this).find("option:selected").text() : o[$(this).data("type")] = $(this).val(), r.validation.map(function (e, t) {
                            e.verify && e.type == a && (n.removeClass("invalid"), n.siblings(".jh-input-tips").text("").hide(), i && "" != i || (n.siblings(".jh-input-tips").text(e.tips[0]).show(), n.addClass("invalid"), s = !1))
                        }), "billing_address" == $(this).data("type") && $(this).val().length < 2 && (n.siblings(".jh-input-tips").text("").show(), n.addClass("invalid"), s = !1))
                    }), !!s && (r.createOrder(0), t.request.post("/payment/paypal-union/create-order", a).then(function (e) {
                        return e.data.token
                    }))
                },
                onAuthorize: function (e) {
                    $http.post("/payment/paypal-union/capture-order", JSON.stringify(e), function (e) {
                        window.location.href = e.data.order_url
                    })
                }
            }, e.id)
        },
        makeUserAddress: function (e, a) {
            var i = this,
                n = '<option value="New address" data-addressId="-100">' + SAIL_ENV.language[SAIL_ENV.language.lang].new_address + "</option>";
            e ? i.setCacheAddress(e) : $http.post("/buyer/user-center/get-address", JSON.stringify({}), function (e) {
                var t;
                0 == e.code && 0 < e.data.data.length ? (i.userAddress = e.data.data || [], t = i.userAddress[0], 0 < i.userAddress.length && i.userAddress.map(function (e, t) {
                    n += 0 == t && a ? '<option value="' + e.shipping_address + '" data-addressId="' + e.shipping_id + '" selected="selected">' + e.shipping_address + "</option>" : '<option value="' + e.shipping_address + '" data-addressId="' + e.shipping_id + '">' + e.shipping_address + "</option>"
                }), a && i.setCacheAddress(t), $(".J-GetUserAddress").empty().append(n), $('.J-OrderVal[data-type="shipping_email"]').parents(".order-write-list").hide()) : s.getItem("order_data") ? ((t = JSON.parse(s.getItem("order_data"))).is_recommend ? 0 < $(".J-Offers").length && $(".J-Offers").children(".jh-checkbox").addClass("jh-checkbox-active") : 0 < $(".J-Offers").length && $(".J-Offers").children(".jh-checkbox").removeClass("jh-checkbox-active"), a && i.setCacheAddress(t)) : a && i.getUserIpAddress()
            })
        },
        makeMatchHtml: function (o) {
            var e, t = this, a = "";
            if (1400 == o.error_code && t.sendEmail(), o.list.length <= 0 && (e = "payment_method", e = 1500 == o.error_code ? ($(".shipping-tips .shipping-tips-text").hide(), $(".shipping-tips .shipping-tips-text-no-province").show(), "shipping_method") : ($(".shipping-tips .shipping-tips-text").show(), $(".shipping-tips .shipping-tips-text-no-province").hide(), "payment_method"), t.checkout_step == e && (t.fadeIn(1, !0), $(".shipping-tips").show(), setTimeout(function () {
                $(".shipping-tips").slideUp()
            }, 5e3))), 0 == o.error_code) {
                if (!o.list || o.list.length <= 0) return $(".J-shipping-match").hide(), $(".J-MethodsLoading").hide(), $(".J-MethodsEmpty").show(), !1;
                t.matchList = o.list, "" != t.orderInfor.express_id && t.orderInfor.express_id != o.selected && ($(".J-PaymentMethod").is(":hidden") || t.fadeIn(1), $(".shipping-tips").show(), setTimeout(function () {
                    $(".shipping-tips").slideUp()
                }, 5e3)), t.orderInfor.express_id = o.selected, t.matchList && (a = t.matchList.map(function (e, t) {
                    var a = "0.00" == e.express_fee ? "<span>" + SAIL_ENV.language[SAIL_ENV.language.lang].free + "</span>" : SAIL_ENV.config.headsymbol + e.express_fee,
                        i = e.express_fee != e.origin_fee ? "<span class='through-span'>" + SAIL_ENV.config.headsymbol + e.origin_fee + "</span>" : "",
                        n = e.id == o.selected ? "jh-radio-active" : "";
                    return '<li data-id="' + e.id + '" >\n                                <div class="fl shipping-match-sel">\n                                    <span class="jh-radio ' + n + '" data-id="' + e.id + '" data-title="' + e.express_name + '" data-originfee="' + e.origin_fee + '" data-fee="' + e.express_fee + '"></span>\n                                </div>\n                                <div class="shipping-match-details"><font>' + e.express_name + '</font></div>\n                                <div class="fr shipping-match-price">' + i + a + "</div>\n                            </li>"
                })), 0 < $(".J-shipping-match").length && $(".J-shipping-match").empty().append(a), $(".J-shipping-match li").click(function () {
                    t.orderInfor.express_id = $(this).data("id"), $(this).find(".shipping-match-sel > span").addClass("jh-radio-active"), $(this).siblings().find(".shipping-match-sel > span").removeClass("jh-radio-active"), t.orderRes.shipping = $(this).find(".jh-radio.jh-radio-active").data("fee"), t.orderRes.total = (parseFloat(t.orderRes.product_payable_amount) + parseFloat(t.orderRes.shipping)).toFixed(2) + "", t.contain_insurance = 0, t.makeOrderPriceHtml();
                    var e = $(this).find(".jh-radio.jh-radio-active").data("title") + "-" + $(this).find(".jh-radio.jh-radio-active").data("fee");
                    "function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: e,
                        button_pos: "2",
                        button_name: "match"
                    })
                }), $(".J-shipping-match").show(), $(".J-MethodsLoading").hide(), $(".J-MethodsEmpty").hide(), $(".J-placeCustomer").removeClass("jh-btn-loading"), $(".J-placeShipping").removeAttr("disabled").removeClass("jh-disabled"), $(".unavailable-products").hide()
            } else {
                $(".J-shipping-match").hide(), $(".J-MethodsLoading").hide(), $(".J-MethodsEmpty").show();
                var i = 0 < o.no_express_sku.length && o.no_express_sku.map(function (t) {
                    var a = "";
                    return Object.keys(t.attribute).forEach(function (e) {
                        a = a ? a + "/" + t.attribute[e] : a + t.attribute[e]
                    }), '<div class="order-item">\n                                <div class="order-img">\n                                    <div><img src="' + (t.image && t.image.file_preview) + '"></div>\n                                    <span class="fr">' + t.quantity + '</span> \n                                </div>\n                                <div class="order-iform">\n                                    <div class="order-name">' + t.product_title + '</div>\n                                    <div class="order-types">' + a + '</div>\n                                </div>\n                                <div class="order-price">' + (SAIL_ENV.config.headsymbol + t.price) + "</div>\n                            </div>"
                });
                0 < o.no_express_sku.length && $(".unavailable-products").empty().append(i).show()
            }
        },
        makeInsuranceHtml: function (e) {
            0 < location.href.indexOf("contact_information") || e.has_insurance && 1 == e.has_insurance && (null != this.local_is_select_insurance || localStorage.getItem("__local_order_number__") || (this.local_is_select_insurance = e.insurance_select), this.watchInsuranceCheckboxStatus())
        },
        watchInsuranceCheckboxStatus: function () {
            var e = this, t = e.cartList.total.insurance;
            if (e.cartList.express.has_insurance && 1 == e.cartList.express.has_insurance) $(".insurance-order-checkbox").removeClass("display-none"), 0 < t ? ($(".insurance-order-subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2)), $(".J-Insurance-Subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2))) : ($(".insurance-order-subtotal").html("&nbsp;Free").css("font-size: 14px;"), $(".J-Insurance-Subtotal").text("Free")); else if (0 == e.cartList.express.has_insurance) return void $(".insurance-order-checkbox .jh-checkbox").removeClass("jh-checkbox-active");
            1 == e.local_is_select_insurance && "contact_information" != e.checkout_step ? ($(".insurance-order-checkbox .jh-checkbox").addClass("jh-checkbox-active"), $(".J-Insurance-Info").removeClass("display-none")) : 0 == e.local_is_select_insurance && ($(".insurance-order-checkbox .jh-checkbox").removeClass("jh-checkbox-active"), $(".J-Insurance-Info").addClass("display-none")), this.countInsuranceTotalPrice()
        },
        countInsuranceTotalPrice: function () {
            var e = this, t = parseFloat(e.orderRes.total),
                a = $(".J-shipping-match li").find(".jh-radio.jh-radio-active").data("originfee"),
                i = parseFloat(parseFloat(e.orderRes.product_amount) + parseFloat(0 < a ? a : 0)).toFixed(2);
            1 == e.local_is_select_insurance && (i = parseFloat(parseFloat(i) + parseFloat(e.orderRes.insurance)).toFixed(2)), 1 == e.contain_insurance ? 0 == e.local_is_select_insurance && (t = parseFloat(parseFloat(t) - parseFloat(e.orderRes.insurance)).toFixed(2)) : 1 == e.local_is_select_insurance && (t = parseFloat(parseFloat(t) + parseFloat(e.orderRes.insurance)).toFixed(2)), e.orderInfor.is_select_insurance = e.local_is_select_insurance, $(".order-total").find(".J-Total").html(SAIL_ENV.config.headcode + " <strong>" + SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2) + "</strong> "), $(".order-buy-price.J-Total").html("<strong>" + SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2) + "</strong> "), 0 < e.orderRes.discount.length && ($(".order-buy-price.J-Subtotal").text(SAIL_ENV.config.headsymbol + i), Number(parseFloat(i) + parseFloat(0 < a ? a : 0)).toFixed(2) == Number(t) ? $(".order-buy-price.J-Subtotal").hide() : $(".order-buy-price.J-Subtotal").show())
        },
        makeOrderPriceHtml: function (e, t) {
            var a = this, i = "";
            $(".paypal-inform-box").hide(), e && e.hasOwnProperty("amount") && 0 < parseFloat(e.amount) && $(".paypal-inform-box").show(), e && (a.orderRes = e, a.orderInfor.amount = e.amount), a.isPayMoney();
            var n, o = $(".J-shipping-match li").find(".jh-radio.jh-radio-active").data("originfee"),
                r = parseFloat(a.orderRes.product_amount) + parseFloat(0 < o ? o : 0);
            1 == a.local_is_select_insurance && 1 == a.orderRes.contain_insurance && (n = a.cartList.total.insurance, r = parseFloat(r) + parseFloat(n)), Number(r).toFixed(2) == Number(a.orderRes.total) ? $(".order-buy-price.J-Subtotal").hide() : $(".order-buy-price.J-Subtotal").show(), $(".order-buy-price.J-Total").html("<strong>" + SAIL_ENV.config.headsymbol + parseFloat(a.orderRes.total).toFixed(2) + "</strong> "), $(".order-total").find(".J-Total").html(SAIL_ENV.config.headcode + " <strong>" + SAIL_ENV.config.headsymbol + parseFloat(a.orderRes.total).toFixed(2) + "</strong> "), $(".J-Shipping").text("0" == t ? SAIL_ENV.language[SAIL_ENV.language.lang].calculated : 0 < a.orderRes.shipping ? SAIL_ENV.config.headsymbol + a.orderRes.shipping : SAIL_ENV.language[SAIL_ENV.language.lang].free), $(".J-Subtotal").text(SAIL_ENV.config.headsymbol + a.orderRes.product_amount), $(".order-buy-price.J-Subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(r).toFixed(2)), a.orderRes.discount.length && a.orderRes.discount.map(function (e) {
                i += '<div class="fl">' + SAIL_ENV.language[SAIL_ENV.language.lang].discount + '</div><div class="order-discount"><p>\n            <span class="J-CouponDesc"><span class="iconfont icon-yduizhekou"></span>' + e.desc + '</span>\n            <span class="fr"><i class="J-Discount">' + e.fee + "</i></span>\n            </p></div>"
            }), $(".J-Discount-Info").length && $(".J-Discount-Info").empty().append(i), a.cartList.express && a.cartList.express.list && 0 < a.cartList.express.list.length && a.makeInsuranceHtml(a.cartList.express, a.cartList.total.insurance)
        },
        makeOrderHtml: function (e, t, r) {
            var a, s = this, d = "", c = {
                content_ids: [],
                content_type: "product_group",
                currency: $(".J-currency-code").val(),
                value: parseFloat(t),
                num_items: 0
            }, l = "";
            (s.product_list = e).map(function (t, a) {
                var i, n, o = "", e = parseInt((new Date).getTime() / 1e3);
                parseInt(e - $(".J-orderUpdateTime").val());
                ("1" == t.is_invalid || t.inventory_quantity <= 0) && "0" == $(".J-IsRenovation").val() && (window.location.href = "/cart"), t.is_invalid || (Object.keys(t.attribute).forEach(function (e) {
                    o = o ? o + "/" + t.attribute[e] : o + t.attribute[e]
                }), i = "", t.coupon_id != l && r.length && r.map(function (e) {
                    t.coupon_id == e.id && (l = t.coupon_id, n = a, i = 0 == t.coupon_id || "" == e.match ? 0 == n ? "" : '<div class="space-line"></div>' : '<div class="order-discount-tips"> \n                                    <span class="iconfont icon-yduizhekou"></span>\n                                    <em>' + e.match + "</em>\n                                </div>")
                }), d += (i = n == a ? i : "") + '\n                                <div class="order-item">\n                                    <div class="order-img">\n                                        <div><img src="' + (t.image && t.image.file_preview) + '" /></div>\n                                        <span class="fr">' + t.quantity + '</span> \n                                    </div>\n                                    <div class="order-iform">\n                                        <div class="order-name">' + t.product_title + '</div>\n                                        <div class="order-types">' + o + '</div>\n                                    </div>\n                                    <div class="order-price">' + (SAIL_ENV.config.headsymbol + t.price) + "</div>\n                                </div>"), c.content_ids.indexOf(parseInt(t.product_id)) <= -1 && c.content_ids.push(parseInt(t.product_id)), s.gtagSkuList.push({
                    id: t.sku_id,
                    google_business_vertical: "retail"
                }), c.num_items += parseInt(t.quantity)
            }), 0 < $(".J-OrderByCart").length && $(".J-OrderByCart").empty().append(d), 420 < $(".J-OrderByCart").find(".order-item").outerHeight() * $(".J-OrderByCart").find(".order-item").length && $(".J-OrderListBox").find(".scroll-items").length <= 0 && (a = "<span class='scroll-items'>" + SAIL_ENV.language[SAIL_ENV.language.lang].scroll_more + "<i class='iconfont icon-xia'></i></span>", $(".J-OrderByCart").append(a), $(".J-OrderByCart").scroll(function () {
                $(".J-OrderListBox").find(".scroll-items").fadeOut(350, function () {
                    $(".J-OrderListBox").find(".scroll-items").remove()
                })
            })), window.localStorage.getItem("checkout") && window.localStorage.getItem("checkout") == $plug.getToKen() || ("function" == typeof fbq && fbq("track", "InitiateCheckout", c), "function" == typeof snaptr && snaptr("track", "START_CHECKOUT", {
                price: c.value,
                currency: c.currency,
                item_ids: c.content_ids,
                item_category: "",
                number_items: c.num_items
            }), "function" == typeof gtag && gtag("event", "begin_checkout", {items: s.gtagSkuList}), window.localStorage.setItem("checkout", $plug.getToKen()))
        },
        makeRegionHtml: function (a, e, t) {
            var i = this, n = "", o = "";
            "" != i.province_value && "" != i.country_value && (o = i.province_value), "" != i.orderInfor.shipping_province && (o = i.orderInfor.shipping_province), a && 0 < Object.keys(a).length && (i.orderInfor.shipping_province_code ? n += '<option value="-1000"  disabled="disabled" > ' + t + " </option>" : n += '<option value="-1000"  disabled="disabled" selected > ' + t + " </option>", Object.keys(a).forEach(function (e, t) {
                o.toLowerCase() == e.toLowerCase() || i.orderInfor.shipping_province_code == a[e].code ? n += '<option value="' + a[e].code + '" selected data-province="' + e + '">' + e + "</option>" : n += '<option value="' + a[e].code + '" data-province="' + e + '">' + e + "</option>"
            }), e ? e.find(".J-Province").val("") : $(".J-Province").val(""), e ? e.find(".J-Country").parent(".order-write-item").removeClass("order-write-whole") : $(".J-Country").parent(".order-write-item").removeClass("order-write-whole"), e ? e.find(".J-Province").empty().append(n) : $(".J-Province").empty().append(n), e ? e.find(".J-Province").parent(".order-write-item").show() : $(".J-Province").parent(".order-write-item").show())
        },
        makeCouponHtml: function (e, t) {
            var a = "";
            if (0 == e.error_code && (t && window.localStorage.setItem("coupon_code", t), t && (this.orderInfor.coupon_code = t)), 0 == e.detail.length && 0 == e.error_code) return $(".J-CouponItem").empty(), $(".J-Discount-Info").empty(), $(".J-GetCouponVal").removeClass("invalid"), !1;
            0 < e.detail.length && 0 == e.error_code ? ($(".J-CouponItem").empty(), $(".J-Discount-Info").empty(), e.detail.map(function (e, t) {
                (0 == e.is_auto && 1 == e.type || 0 == e.is_auto && 1 == e.type && 3 == e.coupon_type) && (a += '<div class="order-coupon-item"><span class="iconfont icon-yduizhekou"><i class="coupon-close J-CouponClose">×</i>' + e.desc + "</div>")
            }), $(".J-GetCouponVal").val("").attr("placeholder", SAIL_ENV.language[SAIL_ENV.language.lang].placeholder_discount), $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled"), $(".J-GetCouponVal").removeClass("invalid"), $(".J-CouponItem").append(a)) : 1 == e.error_code ? ($(".J-CouponItem").find(".erro-tips") && $(".J-CouponItem").find(".erro-tips,.error-coupon-box").remove(), $(".J-GetCouponVal").addClass("invalid"), $(".J-CouponItem").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_1 + "</p>")) : 2 == e.error_code ? ($(".J-CouponItem").find(".erro-tips") && $(".J-CouponItem").find(".erro-tips,.error-coupon-box").remove(), $(".J-CouponItem").append('<div class="error-coupon-box"><span class="iconfont icon-gantanhao"></span><div><strong> ' + t + " </strong> " + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_2 + ' </div><span class="iconfont icon-close J-RemoveCoupon" ></span></div>'), $(".J-GetCouponVal").val("").attr("placeholder", SAIL_ENV.language[SAIL_ENV.language.lang].placeholder_discount), $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled")) : 3 == e.error_code && ($(".J-CouponItem").find(".erro-tips") && $(".J-CouponItem").find(".erro-tips,.error-coupon-box").remove(), $(".J-CouponItem").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_3($(".J-GetCouponVal").val()) + "</p>"))
        }
    }).init()
});
_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (e) {
    return typeof e
} : function (e) {
    return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
};
$(function () {
    var r = window.sessionStorage, s = window.localStorage, l = $(".J-IsSinglePage").val(), t = !1, p = !1;
    "orders" == $(".sail-event-page-location").val() && 0 < $("#paypal-payment-button").find("iframe").length && $(document.getElementById("paypal-payment-button").getElementsByTagName("iframe")[0].contentWindow.document), $(".J-OrderVal,.J-BillVal").on("keyup", function () {
        "" == $(this).val() ? $(this).parent(".order-write-item").removeClass("order-write--show") : ($(this).parent(".order-write-item").addClass("order-write--show"), $(this).removeClass("invalid").siblings(".jh-input-tips").text("").hide())
    }), $(".J-OrderVal,.J-BillVal").each(function () {
        $(".jh-select").parent(".order-write-item").addClass("order-write--show"), "" == $(this).val() || 0 < $(this).find("option:selected").length ? $(this).parent(".order-write-item").removeClass("order-write--show") : ($(this).parent(".order-write-item").addClass("order-write--show"), $(this).removeClass("invalid").siblings(".jh-input-tips").text("").hide())
    }), $(".J-MorePaymentIcon").mouseover(function () {
        $(".all-payment-icon").show()
    }), $(".J-MorePaymentIcon").mouseout(function () {
        $(".all-payment-icon").hide()
    }), $(document).on("click", ".J-Mask,.J-close", function () {
        SAIL_ENV.config.mask_layer("hide"), $(".J-versionTips").hide()
    }), $(".J-MoreSetting").click(function () {
        var e = p ? ".J-PaymentMethod" : ".J-ShippingMethod,.J-PaymentMethod";
        t = t ? ($(e).slideUp(500), $(".J-SettingsInfo").slideDown(500), $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].expand_all_settings), !1) : ($(e).slideDown(500), $(".J-SettingsInfo").slideUp(500), $(this).text(SAIL_ENV.language[SAIL_ENV.language.lang].collapse_all_settings), !0)
    }), localStorage.getItem("__local_order_number__") || localStorage.removeItem("user_select_insurance");
    ({
        order_number: "",
        country_value: "",
        province_value: "",
        userAddress: [],
        orderRes: {},
        matchList: [],
        resolve: null,
        orderNo: "",
        expressIndex: 0,
        contryId: "",
        contryCode: "",
        paymethod: "",
        isBuyQuickly: null,
        cartToken: "",
        paypalSel: 0,
        coupon_type: "",
        isExistCacheAddress: !1,
        checkout_step: "contact_information",
        isUserOper: !1,
        product_list: null,
        isOpenCreditcard: null,
        cartList: null,
        gtagSkuList: [],
        showIDNumber: !1,
        orderInfor: {
            is_recommend: "0",
            express_id: "",
            shipping_email: "",
            shipping_last_name: "",
            shipping_first_name: "",
            shipping_city: "",
            contry_id: "",
            shipping_contry: "",
            shipping_contry_code: "",
            shipping_province: "",
            shipping_province_code: "",
            shipping_address: "",
            shipping_other_address: "",
            tax_number: "",
            tax_type: "CPF",
            shipping_phone: "",
            shipping_zip_code: "",
            amount: "",
            amount_product: "",
            express_amount: "",
            amount_discount: "",
            currency: "",
            currency_label: "",
            pay_card_number: "",
            pay_card_mmyy: "",
            pay_card_cvv: "",
            billing_first_name: "",
            billing_last_name: "",
            billing_city: "",
            billing_province: "",
            billing_province_code: "",
            billing_contry: "",
            billing_contry_code: "",
            billing_address: "",
            billing_other_address: "",
            billing_email: "",
            billing_phone: "",
            billing_zip_code: "",
            coupon_code: "",
            express_name: "",
            express_fee: "",
            cart_type: "",
            order_step: "1",
            currentState: ""
        },
        taxObj: {
            type: "CPF",
            reg: {
                CPF: "^([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})?$",
                CNPJ: "^([0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{1,2})?$"
            }
        },
        validation: [{
            type: "shipping_email",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.email,
            reg: SAIL_ENV.config.EmailReg
        }, {
            type: "shipping_first_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.first_name,
            reg: ""
        }, {
            type: "shipping_last_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.last_name,
            reg: ""
        }, {
            type: "shipping_address",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.address,
            reg: ""
        }, {
            type: "shipping_other_address",
            verify: !1,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.other_address,
            reg: ""
        }, {
            type: "tax_number",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.tax_number,
            reg: "^([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})?$"
        }, {
            type: "shipping_phone",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.phone,
            reg: ""
        }, {
            type: "shipping_zip_code",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.zip_code,
            reg: ""
        }, {
            type: "shipping_city",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.city,
            reg: ""
        }, {
            type: "pay_card_number",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.pay_card_number,
            reg: ""
        }, {
            type: "pay_card_mmyy",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.pay_card_mmyy,
            reg: "^([0-9]{2}/[0-9]{2})?$"
        }, {
            type: "pay_card_cvv",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.pay_card_cvv,
            reg: "^([0-9]{3,4})?$"
        }, {
            type: "billing_first_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.first_name,
            reg: ""
        }, {
            type: "billing_last_name",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.last_name,
            reg: ""
        }, {
            type: "billing_address",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.address,
            reg: ""
        }, {
            type: "billing_other_address",
            verify: !1,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.other_address,
            reg: ""
        }, {
            type: "billing_phone",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.phone,
            reg: ""
        }, {
            type: "billing_city",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.city,
            reg: ""
        }, {
            type: "billing_zip_code",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.zip_code,
            reg: ""
        }, {
            type: "shipping_id_number",
            verify: !0,
            tips: SAIL_ENV.language[SAIL_ENV.language.lang].validation.cod_id,
            reg: "^([1-2]{1}[0-9]{9})?$"
        }],
        init: function () {
            var e = this;
            if ("0" == l) return !1;
            e.currentState = $(".J-getCurrentState").length && $(".J-getCurrentState").val(), 1 == $(".J-Country").find("option").length && ($(".J-Country").find("option").eq(0).prop("selected", !0), e.checkRequired($(".J-Country").val()));
            var t, a, i, n, o = $(".J-Country").val();
            "1" == l && $(".J-OrderVal,.J-BillVal").blur(function () {
                var t = $(this).data("type"), a = $.trim($(this).val()), i = $(this);
                e.validation.map(function (e) {
                    e.verify && e.type == t && "HK" != o && "MO" != o && (i.removeClass("invalid"), i.siblings(".jh-input-tips").text("").hide(), a && "" != a && (!e.reg || new RegExp(e.reg, "i").test(a)) || (i.siblings(".jh-input-tips").text(e.tips[0]).show(), i.addClass("invalid")), "tax_number" == e.type && $plug.isSame(a) && (i.siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].tax_number).show(), i.addClass("invalid")))
                }), "shipping_last_name" != t && "shipping_first_name" != t && "shipping_email" != t || (e.orderInfor.shipping_email = $('.J-OrderVal[data-type="shipping_email"]').val(), e.orderInfor.shipping_last_name = $('.J-OrderVal[data-type="shipping_last_name"]').val(), e.orderInfor.shipping_first_name = $('.J-OrderVal[data-type="shipping_first_name"]').val(), "" != e.orderInfor.shipping_last_name && "" != e.orderInfor.shipping_first_name && new RegExp(SAIL_ENV.config.EmailReg).test(e.orderInfor.shipping_email) && e.createUnpayEmail())
            }), "orders" == $(".sail-event-page-location").val() && ("undefined" != $plug.query().coupon_code && (e.orderInfor.coupon_code = $plug.query().coupon_code), e.cartToken = $plug.getToKen(), e.getCacheData(), t = {
                isShowPhone: $(".J-isShowPhone").val(),
                currentState: $(".J-getCurrentState").val(),
                isOpenPaypal: parseInt($(".isOpenPaypal").val()),
                isOpenCod: parseInt($(".isOpenCod").val()),
                isShowOtherAddress: $(".J-isShowOtherAddress").val(),
                isOpenEmailMarketing: $(".J-isOpenEmailMarketing").val(),
                emailval: $(".J-OrderVal[data-type='shipping_email']").val()
            }, e.isOpenCreditcard = parseInt($(".isOpenCreditcard").val()), "1" == t.isOpenEmailMarketing ? $(".J-Offers").find(".jh-checkbox").addClass("jh-checkbox-active") : "3" == t.isOpenEmailMarketing && $(".J-Offers").remove(), "2" == t.isShowPhone ? (a = "Phone (Optional)", e.editvalidation("shipping_phone", "billing_phone", !1), $(".J-OrderVal[data-type='shipping_phone']").attr("placeholder", a), $(".J-BillVal[data-type='billing_phone']").attr("placeholder", a), $(".J-OrderVal[data-type='shipping_phone']").parent().find("label").text(a), $(".J-BillVal[data-type='billing_phone']").parent().find("label").text(a)) : "3" == t.isShowPhone && ($(".J-OrderVal[data-type='shipping_phone']").parent().parent().remove(), $(".J-BillVal[data-type='billing_phone']").parent().parent().remove()), "1" == t.isShowOtherAddress ? (i = SAIL_ENV.language[SAIL_ENV.language.lang].other_address, e.editvalidation("shipping_other_address", "billing_other_address", !0), $(".J-OrderVal[data-type='shipping_other_address']").attr("placeholder", i), $(".J-BillVal[data-type='billing_other_address']").attr("placeholder", i), $(".J-OrderVal[data-type='shipping_other_address']").parent().find("label").text(i), $(".J-BillVal[data-type='billing_other_address']").parent().find("label").text(i)) : "3" == t.isShowOtherAddress && ($(".J-OrderVal[data-type='shipping_other_address']").parent().parent().remove(), $(".J-BillVal[data-type='billing_other_address']").parent().parent().remove()), $('.J-OrderVal[data-type="shipping_email"]').val("").focus().val(t.emailval), e.isBuyQuickly = 1 == $(".J-IsCreatedPay").val() ? 1 : 0, 1 == e.isBuyQuickly ? ($(".J-placeShipping").find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_complete_order), $(".J-CustomerInfor").find(".paypal-checkout-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].paypal).addClass("paypal-remembered-tips")) : $(".J-paypal-payment").addClass("display-flex"), 0 < $(".J-PaymentPriority").length && (e.paymethod = "COD"), e.isOpenCreditcard || t.isOpenPaypal || t.isOpenCod || $(".J-PaymentMethod").find(".J-CreateOrder").addClass("jh-disabled").attr("disabled", "disabled"), $plug.query().step && (e.checkout_step = $plug.query().step, localStorage.getItem(e.cartToken + "_step") && e.checkout_step != localStorage.getItem && (e.checkout_step = localStorage.getItem(e.cartToken + "_step")), r.getItem(e.cartToken + "_step_current") && (e.checkout_step = r.getItem(e.cartToken + "_step_current")), $plug.query().orderNumberFromEmail && (e.checkout_step = $plug.query().step), $plug.replaceParam(window.location.href, "step", e.checkout_step)), e.fadeIn(0, !0)), 1 == parseInt($(".preview-hide-code").val()) && 0 < $(".J-Gopay").length && $(".J-Gopay").attr("disabled", "disabled").addClass("jh-btn-disabled"), 0 < $(".template5-body").length && "index" == $(".sail-event-page-location").val() && e.eventReturn(), 0 < $(".J-OrderResults").length && e.eventReturn(), e.event(), 0 < $(".J-Textarea").length && (n = r.getItem("card-remark") || "", $(".J-Textarea").val(n)), e.isPaymentProgress()
        },
        checkRequired: function (e) {
            "HK" == e || "MO" == e ? (this.editvalidation("shipping_zip_code", "billing_zip_code", !1), $(".J-ZipCode").removeClass("invalid"), $(".J-ZipCode").siblings(".jh-input-tips").text("").hide(), $(".J-BillVal[data-type='billing_zip_code']").removeClass("invalid"), $(".J-BillVal[data-type='billing_zip_code']").siblings(".jh-input-tips").text("").hide()) : this.editvalidation("shipping_zip_code", "billing_zip_code", !0)
        },
        editvalidation: function (a, i, n) {
            this.validation.map(function (e, t) {
                e.type != a && e.type != i || (e.verify = n)
            })
        },
        getCacheData: function () {
            var t = this, e = {
                source: $plug.query().source,
                buyerId: $plug.query().oriBuyerId,
                cartToken: t.cartToken,
                orderNumberFromEmail: $plug.query().orderNumberFromEmail,
                isShowCustomerInfo: $plug.query().isShowCustomerInfo
            }, a = {buyer_id: e.buyerId};
            "1" == e.isShowCustomerInfo && (a.isShowCustomerInfo = "1", a.cartToken = e.cartToken), e.orderNumberFromEmail && (a.order_number = e.orderNumberFromEmail), sessionStorage.getItem("coupon_code") && "" != sessionStorage.getItem("coupon_code") && (t.orderInfor.coupon_code = sessionStorage.getItem("coupon_code")), localStorage.getItem("coupon_code") && "" != localStorage.getItem("coupon_code") && (t.orderInfor.coupon_code = localStorage.getItem("coupon_code")), SAIL_ENV.config.coupon_code && "" != SAIL_ENV.config.coupon_code && (t.orderInfor.coupon_code = SAIL_ENV.config.coupon_code), $(".J-GetCouponVal").val(t.orderInfor.coupon_code), $http.post("/buyer/order/order-cache-billing-info", JSON.stringify(a), function (e) {
                0 == e.code && e.data && "Object" == $plug.toRawType(e.data.buyer) && 5 < Object.keys(e.data.buyer).length ? (t.setCacheAddress(e.data.buyer), t.getStepData(e.data.buyer), t.makeUserAddress(null, !1), t.isExistCacheAddress = !0) : (t.buyerCheckoutSingle(), t.makeUserAddress(null, !0))
            })
        },
        setCacheAddress: function (i, e) {
            var n = this, o = !1;
            if (!i || "Array" == $plug.toRawType(i) || Object.keys(i).length <= 0) return !1;
            $(".J-OrderVal").each(function (e) {
                var t, a = $(this).data("type");
                a && a.replace(/_/g, " ");
                "shipping_contry" != $(this).data("type") && "shipping_province" != $(this).data("type") && (t = i[a] ? i[$(this).data("type")] : "", $(this).val(t), (n.orderInfor[a] = t) && $(this).parents(".order-write-item").addClass("order-write--show"), t || $(this).parents(".order-write-item").removeClass("order-write--show"), a && "paypal" == a && $(this).addClass("invalid")), "shipping_contry" == a && i.shipping_contry_code && (n.country_value = i.shipping_contry_code, n.orderInfor.contry_id = i.contry_id, n.orderInfor.shipping_contry = i.shipping_contry, n.orderInfor.shipping_contry_code = i.shipping_contry_code, $(".J-Country").find("option[value=" + i.shipping_contry_code + "]").eq(0).prop("selected", !0), $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                    $(this).val() == i.shipping_contry_code && (o = !0)
                }), i.tax_type && (n.orderInfor.tax_type = i.tax_type), i.shipping_province_code && (n.orderInfor.shipping_province = i.shipping_province, n.orderInfor.shipping_province_code = i.shipping_province_code), n.getRegionLibrary(i.shipping_contry_code, !0, null), n.checkRequired(i.shipping_contry_code)), ("shipping_contry" == a && !i.shipping_contry_code || "shipping_contry" == a && "" == i.shipping_contry_code) && n.getUserIpAddress(), null != i.is_select_insurance && (n.is_select_insurance_cache = i.is_select_insurance)
            }), o ? ($(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide()) : (n.orderInfor.shipping_province = "", n.orderInfor.shipping_province_code = "", n.country_value = $(".J-CustomerInfor").find(".J-Country").val(), n.orderInfor.contry_id = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id"), n.orderInfor.shipping_contry = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("countries"), n.orderInfor.shipping_contry_code = $(".J-CustomerInfor").find(".J-Country").val(), n.getRegionLibrary(n.orderInfor.shipping_contry_code, !0, null), e && "paypal" == e && $(".J-CustomerInfor").find(".J-Country").addClass("invalid"), e && "paypal" == e && $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].no_logistics).show()), n.cloneInfor(), $(".J-BillVal").each(function (e) {
                var t = $(this).data("type");
                "billing_contry" != t && "billing_province" != t && $(this).val(n.orderInfor[t])
            })
        },
        eventReturn: function () {
            window.addEventListener("popstate", function () {
                0 < $(".J-Popup").length && $(".J-Popup").hasClass("sece--show") && ($("html, body").removeClass("hidden").css("top", ""), $("html, body").animate({scrollTop: SAIL_ENV.config.scrollPosition}, 0), $(".J-Popup").removeClass("sece--show"), $(".J-PopupContainer").find(".J-PopupGroupProductBottom,.J-PopupGroupProductTop,.J-PopupComment,.J-productList").empty(), $(".J-PopupContainer").find(".J-QtySelect").val("1"), window.history.replaceState({}, 0, SAIL_ENV.Product.referrer_url))
            }, !1)
        },
        isPaymentProgress: function () {
            var t = this;
            -1 < window.location.href.indexOf("step=shipping_method") && t.isBuyQuickly && $http.post("/buyer/order/get-payment-status", {}, function (e) {
                0 == e.code && (3 == e.data.code ? window.location.href = e.data.url : 4 == e.data.code ? ($plug.loading("Your previous order is being paid, you cannot submit the order again now, please wait."), setTimeout(function () {
                    t.isPaymentProgress()
                }, 1500)) : $plug.closeLoading())
            })
        },
        getBuyQuickly: function () {
            var t = this;
            $http.post("/payment/paypal-union/is-created-express-pay", {}, function (e) {
                0 == e.code ? t.isBuyQuickly = e.data.is_created_express_pay : t.isBuyQuickly = 0
            })
        },
        makeSort: function (a) {
            return function (e, t) {
                return e[a] - t[a]
            }
        },
        buyerCheckoutSingle: function (e, n) {
            var o = this, t = "2";
            "shipping_method" == o.checkout_step && (t = "2"), "payment_method" == o.checkout_step && (t = "3");
            var a = "", i = "";
            "-1000" != $(".J-CustomerInfor").find(".J-Province").find("option:selected").val() && (a = $(".J-CustomerInfor").find(".J-Province").find("option:selected").data("province"), i = $(".J-CustomerInfor").find(".J-Province").find("option:selected").val());
            var r = {
                order_step: t,
                cart: {cart_type: o.cart_type, cart_token: o.cartToken},
                express: {
                    country_id: $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id"),
                    express_id: "1" == t ? "" : o.orderInfor.express_id,
                    province_name: a,
                    province_code: i
                },
                coupon: {coupon_code: o.orderInfor.coupon_code},
                current_page: {contact_information: 1, shipping_method: 1, payment_method: 3}[o.checkout_step]
            }, s = window.localStorage.getItem("user_select_insurance"), d = o.local_is_select_insurance;
            1 == s && (d = 1), r.is_select_insurance = d;
            var c = $.extend(r, e);
            "" == c.express.country_id && (c.express.country_id = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id")), "1" == l && (c.is_single_page = "1"), "1" == l && window.location.href.includes("orderNumberFromEmail") && (c.order_number_for_email = $plug.query().orderNumberFromEmail), $http.post("/buyer/checkout", JSON.stringify(c), function (i) {
                var e, a, t;
                0 == i.code && (0 == i.data.cart.list.length && (window.location.href = "/cart"), 0 < i.data.express.no_express_sku.length ? (p = !0, $(".J-ShippingMethod").show(), $(".shipping-poptips").hide()) : (p = !1, $(".J-ShippingMethod").hide(), $(".shipping-poptips").show()), o.showIDNumber = i.data.is_over_amount_limit, "SA" == o.orderInfor.shipping_contry_code && o.showIDNumber && "COD" == o.paymethod ? $(".J-CustomerInfor").find(".order-id-munber").show() : $(".J-CustomerInfor").find(".order-id-munber").hide(), o.cartList = i.data, o.contain_insurance = i.data.total.contain_insurance, "1" == l && window.location.href.includes("orderNumberFromEmail") && $(".J-OrderVal").each(function (e) {
                    var t = $(this).data("type"),
                        a = i.data.order_detail[t] ? i.data.order_detail[$(this).data("type")] : "";
                    "shipping_email" != t && "shipping_last_name" != t && "shipping_first_name" != t || ($(this).val(a), (o.orderInfor[t] = a) ? $(this).parents(".order-write-item").addClass("order-write--show") : $(this).parents(".order-write-item").removeClass("order-write--show"))
                }), "1" == l && "0" == i.data.express.has_insurance ? $(".J-Insurance-Subtotal").parent("p").hide() : $(".J-Insurance-Subtotal").parent("p").show(), o.makeCouponHtml(i.data.coupon, c.coupon.coupon_code), o.makeMatchHtmlSingle(i.data.express), e = i.data.cart.list, a = i.data.coupon.hasOwnProperty("coupon_list") && i.data.coupon.coupon_list.map(function (e) {
                    return e.id
                }) || [], e.forEach(function (e) {
                    var t = a.indexOf(Number(e.coupon_id));
                    e.sort_by = t
                }), 2 == i.data.coupon.type && i.data.coupon.hasOwnProperty("coupon_list") && (e = e.sort(o.makeSort("sort_by"))), t = i.data.coupon.hasOwnProperty("coupon_list") ? i.data.coupon.coupon_list : [], o.makeOrderHtml(e, i.data.total.total, t), o.local_is_select_insurance = localStorage.getItem("user_select_insurance"), null == o.local_is_select_insurance && (o.local_is_select_insurance = i.data.express.insurance_select), o.makeOrderPriceHtml(i.data.total, i.data.express.is_match), localStorage.getItem("__local_order_number__") && "contact_information" != o.checkout_step && o.watchInsuranceCheckboxStatusSingle(), 0 < i.data.cart.list.length && 0 == i.data.express.error_code && 0 < i.data.express.list.length && n && n())
            })
        },
        getUserIpAddress: function () {
            var t = this, a = null, i = "US", n = $(".J-UserIp").val();
            sessionStorage.getItem(n) ? (a = JSON.parse(sessionStorage.getItem(n)), $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                $(this).val() == a.countryCode && (i = a.countryCode, t.orderInfor.shipping_province_code = a.region)
            }), $(".J-CustomerInfor").find(".J-Country").find("option[value=" + i + "]").eq(0).prop("selected", !0), t.getRegionLibrary(i, !0)) : $http.post("/buyer/user/ip-detail", {}, function (e) {
                0 == e.code && "Object" == $plug.toRawType(e.data) && "success" == e.data.status && (a = e.data, sessionStorage.setItem(n, JSON.stringify(e.data)), $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                    $(this).val() == a.countryCode && (i = a.countryCode, t.orderInfor.shipping_province_code = a.region)
                })), $(".J-CustomerInfor").find(".J-Country").find("option[value=" + i + "]").eq(0).prop("selected", !0), t.getRegionLibrary(i, !0)
            }), t.checkRequired(i)
        },
        changeTest: function (e) {
            Countries[e] && Countries[e].hasOwnProperty("labels") && "Object" == $plug.toRawType(Countries[e].labels) && (Countries[e].labels.province && "" != Countries[e].labels.province && $(".J-Province").prev().text(Countries[e].labels.province), Countries[e].labels.zip && "" != Countries[e].labels.zip ? ($(".J-ZipCode").prop("placeholder", Countries[e].labels.zip), $(".J-ZipCode").prev().text(Countries[e].labels.zip)) : ($(".J-ZipCode").prop("placeholder", CountriesDefaultInfo.labels.zip), $(".J-ZipCode").prev().text(CountriesDefaultInfo.labels.zip)))
        },
        getRegionLibrary: function (i, e, n) {
            var o = this, t = n ? n.find(".J-Country").val() : $(".J-CustomerInfor").find(".J-Country").val(),
                a = JSON.parse(s.getItem("order_data"));
            if (e || $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                a && $(this).data("countries") == a.shipping_contry && (i = item.code)
            }), !(i = i && t == i ? i : t) || "" == i) return !1;
            Object.keys(Countries).forEach(function (e, t) {
                var a;
                e == i && (Countries[e].provinces && "Object" == $plug.toRawType(Countries[e].provinces) ? (a = "", a = Countries[i].labels && Countries[i].labels.province ? Countries[i].labels.province : SAIL_ENV.language[SAIL_ENV.language.lang].state, o.makeRegionHtml(Countries[e].provinces, n, a)) : (n ? n.find(".J-Country").parent(".order-write-item").addClass("order-write-whole") : $(".J-Country").parent(".order-write-item").addClass("order-write-whole"), n ? n.find(".J-Province").empty() : $(".J-Province").empty(), n ? n.find(".J-Province").parent(".order-write-item").hide() : $(".J-Province").parent(".order-write-item").hide()))
            }), n && !n.hasClass("J-CustomerInfor") || (o.showBrazilTax(i), o.changeUserShippingBox(i), "SA" == i && o.showIDNumber && "COD" == o.paymethod ? $(".J-CustomerInfor").find(".order-id-munber").show() : $(".J-CustomerInfor").find(".order-id-munber").hide())
        },
        showBrazilTax: function (e) {
            var t = this;
            t.validation.map(function (e) {
                "tax_number" == e.type && (e.reg = t.taxObj.reg[t.orderInfor.tax_type])
            }), $(".J-CustomerInfor").find(".J-TaxCode").val(this.orderInfor.tax_type), "BR" == e ? $(".J-CustomerInfor").find(".order-br-taxno").show() : $(".J-CustomerInfor").find(".order-br-taxno").hide()
        },
        changeUserShippingBox: function (e) {
            switch (e) {
                case"GB":
                    $(".J-CustomerInfor").find(".J-ZipCode").parent().hide(), $(".J-CustomerInfor").find(".J-Country").parent().addClass("order-write-whole-line"), $(".J-CustomerInfor").find(".order-write-list[name=postcode]").show().children().show(), $(".J-GoogleMapAddress[name=Address]").parent(".order-write-item").find(".icon-dingwei").hide();
                    break;
                default:
                    $(".J-CustomerInfor").find(".J-ZipCode").parent().show(), $(".J-CustomerInfor").find(".order-write-list[name=postcode]").hide(), $(".J-CustomerInfor").find(".J-Country").parent().removeClass("order-write-whole-line"), $(".J-GoogleMapAddress[name=Address]").parent(".order-write-item").find(".icon-dingwei").show()
            }
        },
        getStepData: function (a) {
            var i = this;
            "1" == l && "Object" == $plug.toRawType(a) ? (Object.keys(a).forEach(function (e, t) {
                "" != a[e] && (i.orderInfor[e] = a[e])
            }), i.setCacheAddress(i.orderInfor), i.contryId = a.contry_id, i.buyerCheckoutSingle()) : a && i.buyerCheckoutSingle(), "1" == l && "" != i.orderInfor.shipping_email && "" != i.orderInfor.shipping_last_name && "" != i.orderInfor.shipping_first_name && i.createUnpayEmail()
        },
        createUnpayEmail: function () {
            var e = {
                shipping_first_name: this.orderInfor.shipping_first_name,
                shipping_last_name: this.orderInfor.shipping_last_name,
                shipping_email: this.orderInfor.shipping_email,
                order_number_from_email: window.location.href.includes("orderNumberFromEmail") ? $plug.query().orderNumberFromEmail : "",
                cartToken: this.cartToken
            };
            "function" == typeof stag && stag("page_click", "user_behavior", {
                type: "trace",
                additional: $(".J-CustomerInfor").find(".J-Country").find("option:selected").prop("outerHTML"),
                button_pos: "1",
                button_name: "continue"
            }), "function" == typeof stag && stag("page_load", "shipping", {
                type: "trace",
                button_pos: "2",
                button_name: "shipping"
            }), $http.post("/buyer/order/create-unpay-email", JSON.stringify(e))
        },
        sendEmail: function () {
            var e = {
                countryId: this.contryId,
                orderAmount: this.cartList.total.total,
                weight_gram: this.cartList.cart.weight_gram
            };
            e.order_number = this.order_number || "", "" == e.order_number && window.sessionStorage.getItem("order_number") && (e.order_number = window.sessionStorage.getItem("order_number")), $http.post("/buyer/express/send-mail", JSON.stringify(e))
        },
        isValidationFn: function (o) {
            var r = !0, e = this;
            if (1 == e.paypalSel) return $(".J-BillVal").each(function () {
                var a = $(this).data("type"), i = $.trim($(this).val()), n = $(this),
                    i = "INPUT" == $(this).get(0).tagName ? $.trim($(this).val()) : $(this).find("option:selected").data("countries");
                e.orderInfor[a] = i, e.validation.map(function (e, t) {
                    e.verify && e.type == a && (o && n.removeClass("invalid"), o && n.siblings(".jh-input-tips").text("").hide(), i && "" != i && (!e.reg || new RegExp(e.reg, "i").test(i)) || (e.reg && !new RegExp(e.reg, "i").test(i) && o && n.siblings(".jh-input-tips").text(e.tips[1]).show(), i && "" != i || o && n.siblings(".jh-input-tips").text(e.tips[0]).show(), o && n.addClass("invalid"), $(".J-CreateOrder").removeClass("jh-btn-loading"), r = !1))
                }), $(".J-PaymentMethod").find(".J-Province").length && "-1000" == $(".J-PaymentMethod").find(".J-Province").find("option:selected").val() ? (r = !1, o && $(".J-PaymentMethod").find(".J-Province").addClass("invalid"), o && $(".J-PaymentMethod").find(".J-Province").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].select_province).show()) : (o && $(".J-PaymentMethod").find(".J-Province").removeClass("invalid"), o && $(".J-PaymentMethod").find(".J-Province").siblings(".jh-input-tips").text("").hide())
            }), r
        },
        validationOrder: function (e) {
            var t, o = this, r = {country: ""}, s = !0, d = !0;
            "single" == e && (t = {}, $(".J-OrderVal").each(function () {
                var a, i, n;
                $(this).parent(".order-write-item").is(":visible") && (a = $(this).data("type"), i = $.trim($(this).val()), n = $(this), "shipping_contry" == $(this).data("type") || "shipping_province" == $(this).data("type") ? t[$(this).data("type")] = $(this).find("option:selected").text() : t[$(this).data("type")] = $(this).val(), "shipping_email" == a && (r.email = i), "shipping_zip_code" == a && (r.zip_code = i), o.validation.map(function (e, t) {
                    e.verify && e.type == a && (n.removeClass("invalid"), n.siblings(".jh-input-tips").text("").hide(), i && "" != i && (!e.reg || new RegExp(e.reg, "i").test(i)) || (n.siblings(".jh-input-tips").text(e.tips[0]).show(), n.addClass("invalid"), s = !1), "tax_number" == e.type && $plug.isSame(i) && (n.siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].tax_number).show(), n.addClass("invalid"), s = !1))
                }), "shipping_address" == $(this).data("type") && $(".J-OrderVal").val().length < 2 && (n.siblings(".jh-input-tips").text("").show(), n.addClass("invalid"), s = !1))
            }), $(".J-CustomerInfor").find('.J-OrderVal[data-type="shipping_address"]').val().length < 2 && (s = !1, $(".J-CustomerInfor").find('.J-OrderVal[data-type="shipping_address"]').addClass("invalid"), $(".J-CustomerInfor").find('.J-OrderVal[data-type="shipping_address"]').siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].google_map).show()), $(".J-CustomerInfor").find(".J-Country").val() && "" != $(".J-CustomerInfor").find(".J-Country").val() ? ($(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide()) : (s = !1, $(".J-CustomerInfor").find(".J-Country").addClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].select_country).show()), $(".J-CustomerInfor").find(".J-Province").length && "-1000" == $(".J-CustomerInfor").find(".J-Province").find("option:selected").val() || "" == $(".J-CustomerInfor").find(".J-Province").val() || !$(".J-CustomerInfor").find(".J-Country").val() ? (s = !1, $(".J-CustomerInfor").find(".J-Province").addClass("invalid"), $(".J-CustomerInfor").find(".J-Province").siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].select_province).show()) : ($(".J-CustomerInfor").find(".J-Province").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Province").siblings(".jh-input-tips").text("").hide()), s || ("function" == typeof stag && stag("page_click", "user_behavior", {
                type: "check",
                additional: JSON.stringify(t),
                button_pos: "",
                button_name: "information"
            }), window.screen.availWidth < 768 && $("body,html").animate({scrollTop: $(".J-OrderVal.invalid").length && $(".J-OrderVal.invalid").first().offset().top - 40}, 500)), s && (t = {}, o.contryId = $(".J-CustomerInfor").find(".J-Country").find("option:selected").data("id"), o.orderInfor.shipping_province_code = $(".J-CustomerInfor").find(".J-Province").find("option:selected").val(), $(".J-OrderVal").each(function () {
                var e = $(this).data("type"),
                    t = "INPUT" == $(this).get(0).tagName ? $.trim($(this).val()) : $(this).find("option:selected").data("countries") || $(this).find("option:selected").text();
                "shipping_contry" == e && (o.orderInfor.shipping_contry_code = $(this).val(), o.orderInfor.contry_id = $(this).find("option:selected").data("id"), o.orderInfor.shipping_contry = $(this).find("option:selected").data("countries")), "shipping_province" == e && (o.orderInfor.shipping_province = $(".J-CustomerInfor").find(".J-Province").find("option:selected").data("province"), o.orderInfor.shipping_province_code = $(".J-CustomerInfor").find(".J-Province").find("option:selected").val()), o.orderInfor[e] = t, o.cloneInfor()
            }), $(".J-BillVal").each(function () {
                var a, i, n;
                $(this).parent(".order-write-item").is(":visible") && (a = $(this).data("type"), i = $.trim($(this).val()), n = $(this), "billing_contry" == $(this).data("type") || "billing_province" == $(this).data("type") ? t[$(this).data("type")] = $(this).find("option:selected").text() : t[$(this).data("type")] = $(this).val(), o.validation.map(function (e, t) {
                    e.verify && e.type == a && (n.removeClass("invalid"), n.siblings(".jh-input-tips").text("").hide(), i && "" != i && (!e.reg || new RegExp(e.reg, "i").test(i)) || (n.siblings(".jh-input-tips").text(e.tips[0]).show(), n.addClass("invalid"), d = !1))
                }), "billing_address" == $(this).data("type") && $(this).val().length < 2 && (n.siblings(".jh-input-tips").text("").show(), n.addClass("invalid"), d = !1))
            }), d && "1" == l && (parseInt((new Date).getTime() / 1e3), parseInt($(".J-orderUpdateTime").val()), o.product_list.map(function (e, t) {
                e.inventory_quantity <= 0 && "0" != $(".J-orderUpdateTime").val() && "0" == $(".J-IsRenovation").val() && (window.location.href = "/cart")
            }), $(".J-BillVal").each(function () {
                var e = $(this).data("type"),
                    t = "INPUT" == $(this).get(0).tagName ? $.trim($(this).val()) : $(this).find("option:selected").data("countries") || $(this).find("option:selected").text();
                "billing_contry" == e && (o.orderInfor.billing_contry_code = $(this).val(), o.orderInfor.billing_contry = $(this).find("option:selected").data("countries")), "billing_province" == e && (o.orderInfor.billing_province_code = $(this).val(), o.orderInfor.billing_province = $(this).find("option:selected").data("province")), o.orderInfor[e] = t
            }), 0 == o.paypalSel && this.cloneInfor(), o.buyerCheckoutSingle({order_step: "3"}, function () {
                o.createOrder(1)
            }))))
        },
        cloneInfor: function () {
            this.orderInfor.billing_email = this.orderInfor.shipping_email, this.orderInfor.billing_contry = this.orderInfor.shipping_contry, this.orderInfor.billing_contry_code = this.orderInfor.shipping_contry_code, this.orderInfor.billing_zip_code = this.orderInfor.shipping_zip_code, this.orderInfor.billing_phone = this.orderInfor.shipping_phone, this.orderInfor.billing_address = this.orderInfor.shipping_address, this.orderInfor.billing_city = this.orderInfor.shipping_city, this.orderInfor.billing_province = this.orderInfor.shipping_province, this.orderInfor.billing_province_code = this.orderInfor.shipping_province_code, this.orderInfor.billing_last_name = this.orderInfor.shipping_last_name, this.orderInfor.billing_first_name = this.orderInfor.shipping_first_name, this.orderInfor.billing_other_address = this.orderInfor.shipping_other_address, $(".J-PaymentMethod").find(".J-Country").find("option[value=" + this.orderInfor.shipping_contry_code + "]").eq(0).prop("selected", !0), this.getRegionLibrary(this.orderInfor.shipping_contry_code, !0, $(".J-PaymentMethod"))
        },
        isPayMoney: function () {
            "0.00" == this.orderRes.amount ? ($(".pay-free").show(), $(".paypal-inform-box").hide(), $(".order-payment-box").hide()) : ($(".pay-free").hide(), $(".paypal-inform-box").show(), $(".order-payment-box").show())
        },
        removeCoupon: function () {
            var e = {cart_token: this.cartToken, filed: "coupon_code"};
            this.orderInfor.coupon_code = "", localStorage.removeItem("coupon_code"), $http.post("/buyer/cart/del-cart-filed", JSON.stringify(e), function (e) {
                0 == e.code && 0 < $(".error-coupon-box").length && $(".error-coupon-box").remove()
            })
        },
        formatNumber: function (a, e) {
            return "card_number" == e ? a.replace(/\s/g, "").replace(/[^\d]/g, "").replace(/(\d{4})(?=\d)/g, "$1 ") : (a = a.replace(/[^0-9]+/g, ""), {
                CPF: [{
                    string: ".",
                    start: 0,
                    end: 3
                }, {string: ".", start: 3, end: 6}, {string: "-", start: 6, end: 9}, {string: "", start: 9, end: -1}],
                CNPJ: [{string: ".", start: 0, end: 2}, {string: ".", start: 2, end: 5}, {
                    string: "/",
                    start: 5,
                    end: 8
                }, {string: "-", start: 8, end: 12}, {string: "", start: 12, end: -1}],
                card_mmyy: [{string: "/", start: 0, end: 2}, {string: "", start: 2, end: -1}]
            }[e].map(function (e, t) {
                return -1 != e.end ? a.substring(e.start, e.end) + (a.length >= e.end ? e.string : "") : a.substring(e.start, a.length)
            }).join(""))
        },
        event: function () {
            var i = this;
            $(document).on("click", ".J-RemoveCoupon", function () {
                i.removeCoupon()
            }), $(document).on("keyup", ".J-GetBuyNowCouponVal", function () {
                "" != $.trim($(this).val()) ? $(".J-GetBuyNowCoupon").removeAttr("disabled").removeClass("jh-btn-disabled") : $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled")
            }), $(".J-GetBuyNowCouponVal").bind("input propertychange", function () {
                "" != $.trim($(this).val()) ? $(".J-GetBuyNowCoupon").removeAttr("disabled").removeClass("jh-btn-disabled") : $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled")
            }), $(document).on("click", ".J-BuyCouponClose", function () {
                $(".J-BuyNowCouponTips").empty(), $(".J-BuyNowDiscountInfo").empty(), $(".J-GetBuyNowCouponVal").val(""), $(".J-GetBuyNowCoupon").attr("disabled", "disabled").addClass("jh-btn-disabled"), $(".buy-now-main").find(".buy-now-total").find("div").eq(1).text($(".buy-now-main").find(".buy-now-total").find("div").eq(1).data("price")), $(".buy-now-submit").find("p").show(), $(".buy-now-submit").find(".paypal-btn").show(), $(".buy-now-submit").find(".paypal-button-funding").show()
            }), $(document).on("click", ".J-MaskLoadClose", function () {
                $(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")
            }), $(".J-ZipCode").change(function () {
                var e = $(this).val();
                $(this).hasClass("J-OrderVal") && $(".J-CustomerInfor").find(".J-ZipCode").val(e)
            }), $(".J-ZipCode").blur(function () {
                var e = $(this).val();
                $(this).hasClass("J-OrderVal") && $(".J-CustomerInfor").find(".J-ZipCode").val(e)
            }), $(".J-TaxCode").change(function () {
                i.orderInfor.tax_type = $(this).val(), i.validation.map(function (e) {
                    "tax_number" == e.type && (e.reg = i.taxObj.reg[i.orderInfor.tax_type])
                })
            });
            var e = "", t = "", a = "";
            $(".J-TaxVal").keyup(function () {
                e.length < $(this).val().length && $(this).val(i.formatNumber($(this).val(), i.orderInfor.tax_type)), e = $(this).val()
            }), $(".J-TaxVal").blur(function () {
                $(this).val(i.formatNumber($(this).val(), i.orderInfor.tax_type))
            }), $(".J-CardNumber").keydown(function () {
                t.length < $(this).val().length && $(this).val(i.formatNumber($(this).val(), "card_number")), t = $(this).val()
            }), $(".J-CardNumber").blur(function () {
                $(this).val(i.formatNumber($(this).val(), "card_number"))
            }), $(".J-CardMMYY").keyup(function () {
                a.length < $(this).val().length && $(this).val(i.formatNumber($(this).val(), "card_mmyy")), a = $(this).val()
            }), $(".J-CardMMYY").blur(function () {
                $(this).val(i.formatNumber($(this).val(), "card_mmyy"))
            }), $(".J-CODID").blur(function () {
                var e = $(this).val();
                e && "" != e ? new RegExp("^([1-2]{1}[0-9]{9})?$", "i").test(e) ? ($(this).removeClass("invalid"), $(this).siblings(".jh-input-tips").text("").hide()) : ($(this).siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].validation.cod_id[2]).show(), $(this).addClass("invalid")) : ($(this).siblings(".jh-input-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].validation.cod_id[0]).show(), $(this).addClass("invalid"))
            }), $(".J-Country").change(function () {
                var e = null, t = "";
                $(".J-PaymentMethod").is(":hidden") || (e = $(".J-PaymentMethod")), $(".J-CustomerInfor").is(":hidden") || (e = $(".J-CustomerInfor")), i.orderInfor.express_id = "", $(this).val() && "" != $(this).val() && (t = $(this).val(), -1 < $(".J-Country").find("option[value=" + t + "]").index() && ($(".J-CustomerInfor").is(":hidden") ? i.orderInfor.billing_contry_code = t : i.orderInfor.shipping_contry_code = t, i.getRegionLibrary(t, !0, e), $(".J-CustomerInfor").is(":hidden") || i.changeUserShippingBox(t)), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: $(".J-CustomerInfor").find(".J-Country").find("option:selected").prop("outerHTML"),
                    button_pos: "change",
                    button_name: "countries"
                }), $(".J-CustomerInfor").find(".J-Country").removeClass("invalid"), $(".J-CustomerInfor").find(".J-Country").siblings(".jh-input-tips").text("").hide()), i.changeTest(t), e.find(".J-Country").find("option[value=" + t + "]").eq(0).prop("selected", !0), i.buyerCheckoutSingle(), i.checkRequired(t)
            }), $(".J-Province").change(function () {
                var e = null, t = "";
                $(".J-PaymentMethod").is(":hidden") || (e = $(".J-PaymentMethod")), $(".J-CustomerInfor").is(":hidden") || (e = $(".J-CustomerInfor")), $(this).val() && "" != $(this).val() && ($(".J-CustomerInfor").is(":hidden") ? i.orderInfor.billing_province_code = $(this).val() : i.orderInfor.shipping_province_code = $(this).val(), t = $(this).val()), e.find(".J-Province").find("option[value=" + t + "]").prop("selected", !0)
            }), $(".J-PhoneVal").keydown(function () {
                var e, t = $(this).val();
                (t.indexOf("(") <= -1 || -1 < t.indexOf("(") && -1 < t.indexOf(")")) && (e = $(".J-CustomerInfor").find(".J-Country").val(), t = new libphonenumber.AsYouType(e).input(t), $(this).val(t))
            }), $(".J-paypalAdd").click(function () {
                var e = $(this).index();
                i.paypalSel = $(this).index(), $(this).find(".jh-radio").addClass("jh-radio-active"), $(this).siblings().find(".jh-radio").removeClass("jh-radio-active"), e ? (i.isValidationFn(!1), $(this).siblings(".order-paypal-box").slideDown(300)) : $(this).siblings(".order-paypal-box").slideUp(300)
            }), $(".J-CreateOrder").click(function () {
                var e = {currency: $(".J-currency-code").val(), value: parseFloat(i.orderInfor.amount)};
                if ("function" == typeof fbq && fbq("track", "AddPaymentInfo", e), "function" == typeof gtag && gtag("event", "add_payment_info", {items: i.gtagSkuList}), i.checkRequired($(".J-Country").val()), 0 == $(".J-OfficialVersion").val()) return SAIL_ENV.config.mask_layer("show"), $(".J-versionTips").show(), !1;
                var t = $(this);
                i.orderInfor.order_step = "3", $(this).addClass("jh-btn-loading"), setTimeout(function () {
                    t.removeClass("jh-btn-loading")
                }, 5e3), i.validationOrder("single"), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: i.paymethod,
                    button_pos: "3",
                    button_name: "complete"
                })
            }), $(".J-Offers").click(function () {
                $(this).children(".jh-checkbox").hasClass("jh-checkbox-active") ? ($(this).children(".jh-checkbox").removeClass("jh-checkbox-active"), i.orderInfor.is_recommend = "0") : (i.orderInfor.is_recommend = "1", $(this).children(".jh-checkbox").addClass("jh-checkbox-active"))
            }), $(".J-GetCoupon").click(function () {
                var e = $.trim($(this).siblings(".J-GetCouponVal").val());
                i.buyerCheckoutSingle({coupon: {coupon_code: e}}), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: e,
                    button_name: "apply"
                }), $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled")
            }), $(document).on("click", ".J-CouponClose", function () {
                i.removeCoupon(), $(".J-CouponItem").empty(), $(".J-GetCouponVal").val(""), $(".J-Discount-Info").empty(), i.buyerCheckoutSingle()
            }), "" == $(".J-GetCouponVal").val() && $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled"), $(".J-GetCouponVal").on("keyup", function () {
                "" == $(this).val() ? $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled") : $(".J-GetCoupon").removeClass("jh-disabled").removeAttr("disabled")
            }), $(".J-GetCouponVal").bind("input propertychange", function () {
                $(this).hasClass("invalid") && $(this).removeClass("invalid"), $(".J-CouponItem").find(".erro-tips").text(""), "" == $(this).val() ? $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled") : $(".J-GetCoupon").removeClass("jh-disabled").removeAttr("disabled")
            }), $(".J-Textarea").keyup(function () {
                var e = $(this).val();
                $(".J-Textarea").val(e)
            }), $(document).on("click", ".J-SwitchPal", function () {
                var e = $(this).data("type");
                $(".J-SwitchPal").siblings(".order-paypal-box").stop().slideUp(300), $(this).siblings(".order-paypal-box").stop().slideDown(300), i.paymethod = e, "SA" == i.orderInfor.shipping_contry_code && i.showIDNumber && "COD" == i.paymethod ? $(".J-CustomerInfor").find(".order-id-munber").show() : $(".J-CustomerInfor").find(".order-id-munber").hide(), $(".J-SwitchPal").find(".jh-radio").removeClass("jh-radio-active"), $(this).find(".jh-radio").addClass("jh-radio-active"), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: "",
                    button_pos: e,
                    button_name: "payment_method"
                })
            }), $(".J-BillVal").change(function () {
                i.isValidationFn()
            }), $(".J-LogOut").click(function () {
                $http.post("/buyer/user/logout", {}, function (e) {
                    0 == e.code && ($(".J-LogOut").parents(".order-write-list").remove(), $(".J-CustomerInfor").find(".order-title").append(SAIL_ENV.language[SAIL_ENV.language.lang].log_in($(".J-LoginReferer").val())), $('.J-OrderVal[data-type="shipping_email"]').parents(".order-write-list").show())
                })
            }), $(".J-GetUserAddress").change(function () {
                var a = $(this).find("option:selected").data("addressid");
                if ("-100" == a) return i.makeUserAddress({}), !1;
                i.userAddress.map(function (e, t) {
                    e.shipping_id == a && i.makeUserAddress(e)
                })
            }), $(document).on("click", ".J-SaveInformation", function () {
                $(this).children(".jh-checkbox").hasClass("jh-checkbox-active") ? $(this).children(".jh-checkbox").removeClass("jh-checkbox-active") : $(this).children(".jh-checkbox").addClass("jh-checkbox-active")
            }), $(".J-GoogleMapAddress").focus(function () {
                $(".J-GoogleMapAddress").prop("autocomplete", "none"), window.screen.availWidth <= 768 && 200 < $(this).offset().top - $(document).scrollTop() && $("body,html").animate({scrollTop: $(this).offset().top - 200}, 500)
            }), $(".J-GoogleMapAddress").blur(function () {
                $(".J-GoogleMapAddress").prop("autocomplete", ""), setTimeout(function () {
                    0 < $(".sail-address-box").length && $(".sail-address-box").hide()
                }, 1e3)
            }), $(document).on("keyup", ".J-GoogleMapAddress", function () {
                var t = $(this), e = $(this).prop("name"),
                    a = {input: $(this).val(), countryCode: $(".J-CustomerInfor").find(".J-Country").val()};
                return i.isUserOper = !1, ("GB" != a.countryCode || "Address" != e) && ($.trim($(this).val()).length < 4 || 200 < $.trim($(this).val()).length ? (0 < $(".sail-address-box").length && $(".sail-address-box").hide(), t.parent(".order-write-item").find(".jh-input-tips").show().text(SAIL_ENV.language[SAIL_ENV.language.lang].google_map), !1) : (t.parent(".order-write-item").find(".jh-input-tips").hide().text(""), 0 < $(".sail-address-box").length && $(".sail-address-box").show(), void $http.get("/buyer/user/google-map", a, function (e) {
                    0 == e.code && $(".J-GoogleMapAddress").is(":focus") && i.googleMap(t.parent(), e.data, t.val())
                })))
            }), $(document).click(function (e) {
                var t, a;
                "orders" == $(".sail-event-page-location").val() && (t = $(e.target).attr("class"), a = $.trim($(".J-GoogleMapAddress").val()).length, $(".J-CustomerInfor").find(".J-Country").val(), t && -1 < t.indexOf("google-map") || t && -1 < t.indexOf("J-GoogleMapAddress") ? 0 < $(".sail-address-box").length && !i.isUserOper && 1 < a && $(".sail-address-box").show() : 0 < $(".sail-address-box").length && $(".sail-address-box").remove())
            }), $(document).on("click", ".J-GetSaiLAddress", function () {
                var e = {placeid: $(this).data("placeid")},
                    t = ($(this), $(this).parents(".order-write-item").find(".J-GoogleMapAddress").val());
                $http.get("/buyer/user/google-map-detail", e, function (e) {
                    0 == e.code && i.eachAddress(e.data, t)
                })
            }), $(document).on("click", ".insurance-order-checkbox", function (e) {
                var t = $(this).find(".jh-checkbox").hasClass("jh-checkbox-active");
                t ? $(".insurance-order-checkbox .jh-checkbox").removeClass("jh-checkbox-active") : $(".insurance-order-checkbox .jh-checkbox").addClass("jh-checkbox-active"), i.local_is_select_insurance = t ? 0 : 1, i.orderInfor.is_select_insurance = t ? 0 : 1, localStorage.setItem("user_select_insurance", i.local_is_select_insurance), t ? $(".J-Insurance-Info").addClass("display-none") : $(".J-Insurance-Info").removeClass("display-none"), t && SAIL_ENV.config.isMobile && ($(".J-Mask").css("background", "rgba(0,0,0,.4)").show(), $("body").append('\n                        <div class="insurance-alert-box">\n                            <div class="insurance-alert-box-title">' + SAIL_ENV.language[SAIL_ENV.language.lang].insurance_alert + '</div>\n                            <div class="insurance-alert-box-ok">' + SAIL_ENV.language[SAIL_ENV.language.lang].insurance_alert_ok + "</div>\n                        </div>\n                   "), $(document).on("click", ".insurance-alert-box-ok, .J-Mask", function (e) {
                    $(".insurance-alert-box").remove(), $(".J-Mask").hide().css("background", "rgba(0,0,0,.6)"), e.preventDefault(), e.stopPropagation()
                })), i.watchInsuranceCheckboxStatusSingle(), e.preventDefault(), e.stopPropagation()
            }), $(document).on("click", ".privacy-item, .icon-shopping-privacy", function () {
                var t = this;
                $(".privacy-mask").css("display", "flex"), $("body").css("overflow", "hidden"), setTimeout(function () {
                    $(".privacy-dialog-title").html($(t).data("title") || "");
                    var e = $(t).find(".privacy-item-html").html() || "";
                    $(t).hasClass("icon-shopping-privacy") && (e = (e = $("textarea.privacy-item-html").text() || "").replace(/<script>.*<\/script>/gim, "")), $(".privacy-dialog-body").html(e), $(".privacy-dialog").show()
                }, 60)
            }).on("click", ".privacy-btn-ok, .privacy-mask", function (e) {
                var t = e && e.originalEvent ? e.originalEvent.srcElement.className : "";
                "privacy-btn-ok" != t && "privacy-mask" != t || ($("body").css("overflow", "auto"), $(".privacy-mask").hide(), $(".privacy-dialog").hide())
            })
        },
        subGoogleMapString: function (e) {
            if (e.hasOwnProperty("matched_substrings") && 0 < e.matched_substrings.length) {
                var i = e.description, n = "", o = 0;
                return e.matched_substrings.forEach(function (e) {
                    var t = e.offset, a = e.offset + e.length;
                    n += i.substring(o, t) + ('<sapn class="emphasis">' + i.substring(t, a)) + "</sapn>", o = a
                }), n += i.substring(o)
            }
            return e.description
        },
        googleMap: function (e, t) {
            var i, n = this;
            "Object" == $plug.toRawType(t) && 0 < t.predictions.length && (i = 0 < e.find(".sail-address-box").length ? "" : "<div class='sail-address-box'><div class='sail-address-title google-map'>" + SAIL_ENV.language[SAIL_ENV.language.lang].google_map_suggestions + " <span class='iconfont icon-close J-CloseAddress'></span></div><div class='sail-address-list'>", t.predictions.map(function (e, t) {
                var a = n.subGoogleMapString(e);
                i += "<div class='sail-address-item J-GetSaiLAddress' data-placeId=" + e.place_id + " >" + a + "</div>"
            }), i += 0 < e.find(".sail-address-box").length ? "" : '</div><div class="combo-box__footer google-map"><svg class="google-map" id="powered-by-google" width="116" height="15"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 116 15"><path fill="#737373" d="M4.025 3.572c1.612 0 2.655 1.283 2.655 3.27 0 1.974-1.05 3.27-2.655 3.27-.902 0-1.63-.393-1.974-1.06h-.09v3.057H.95V3.68h.96v1.054h.094c.404-.726 1.16-1.166 2.02-1.166zm-.24 5.63c1.16 0 1.852-.884 1.852-2.36 0-1.477-.692-2.362-1.846-2.362-1.14 0-1.86.91-1.86 2.362 0 1.447.72 2.36 1.857 2.36zm7.072.91c-1.798 0-2.912-1.243-2.912-3.27 0-2.033 1.114-3.27 2.912-3.27 1.8 0 2.913 1.237 2.913 3.27 0 2.027-1.114 3.27-2.913 3.27zm0-.91c1.196 0 1.87-.866 1.87-2.36 0-1.5-.674-2.362-1.87-2.362-1.195 0-1.87.862-1.87 2.362 0 1.494.675 2.36 1.87 2.36zm12.206-5.518H22.05l-1.244 5.05h-.094L19.3 3.684h-.966l-1.412 5.05h-.094l-1.242-5.05h-1.02L16.336 10h1.02l1.406-4.887h.093L20.268 10h1.025l1.77-6.316zm3.632.78c-1.008 0-1.71.737-1.787 1.856h3.48c-.023-1.12-.69-1.857-1.693-1.857zm1.664 3.9h1.005c-.305 1.085-1.277 1.747-2.66 1.747-1.752 0-2.848-1.262-2.848-3.26 0-1.987 1.113-3.276 2.847-3.276 1.705 0 2.742 1.213 2.742 3.176v.386h-4.542v.047c.053 1.248.75 2.04 1.822 2.04.815 0 1.366-.3 1.63-.857zM31.03 10h1.01V6.086c0-.89.696-1.535 1.657-1.535.2 0 .563.038.645.06V3.6c-.13-.018-.34-.03-.504-.03-.838 0-1.565.434-1.752 1.05h-.094v-.938h-.96V10zm6.915-5.537c-1.008 0-1.71.738-1.787 1.857h3.48c-.023-1.12-.69-1.857-1.693-1.857zm1.664 3.902h1.005c-.304 1.084-1.277 1.746-2.66 1.746-1.752 0-2.848-1.262-2.848-3.26 0-1.987 1.113-3.276 2.847-3.276 1.705 0 2.742 1.213 2.742 3.176v.386h-4.542v.047c.053 1.248.75 2.04 1.822 2.04.815 0 1.366-.3 1.63-.857zm5.01 1.746c-1.62 0-2.657-1.28-2.657-3.266 0-1.98 1.05-3.27 2.654-3.27.878 0 1.622.416 1.98 1.108h.087V1.177h1.008V10h-.96V8.992h-.094c-.4.703-1.15 1.12-2.02 1.12zm.232-5.63c-1.15 0-1.846.89-1.846 2.364 0 1.476.69 2.36 1.846 2.36 1.148 0 1.857-.9 1.857-2.36 0-1.447-.715-2.362-1.857-2.362zm7.875-3.115h1.024v3.123c.23-.3.507-.53.827-.688.32-.16.668-.238 1.043-.238.78 0 1.416.27 1.9.806.49.537.73 1.33.73 2.376 0 .992-.24 1.817-.72 2.473-.48.656-1.145.984-1.997.984-.476 0-.88-.114-1.207-.344-.195-.137-.404-.356-.627-.657v.8h-.97V1.363zm4.02 7.225c.284-.454.426-1.05.426-1.794 0-.66-.142-1.207-.425-1.64-.283-.434-.7-.65-1.25-.65-.48 0-.9.177-1.264.532-.36.356-.542.942-.542 1.758 0 .59.075 1.068.223 1.435.277.694.795 1.04 1.553 1.04.57 0 .998-.227 1.28-.68zM63.4 3.726h1.167c-.148.402-.478 1.32-.99 2.754-.383 1.077-.703 1.956-.96 2.635-.61 1.602-1.04 2.578-1.29 2.93-.25.35-.68.527-1.29.527-.147 0-.262-.006-.342-.017-.08-.012-.178-.034-.296-.065v-.96c.183.05.316.08.4.093.08.012.152.018.215.018.195 0 .338-.03.43-.094.092-.065.17-.144.232-.237.02-.033.09-.193.21-.48.122-.29.21-.506.264-.646l-2.32-6.457h1.196l1.68 5.11 1.694-5.11zM73.994 5.282V6.87h3.814c-.117.89-.416 1.54-.87 1.998-.557.555-1.427 1.16-2.944 1.16-2.35 0-4.184-1.882-4.184-4.217 0-2.332 1.835-4.215 4.184-4.215 1.264 0 2.192.497 2.873 1.135l1.122-1.117C77.04.697 75.77 0 73.99 0c-3.218 0-5.923 2.606-5.923 5.805 0 3.2 2.705 5.804 5.923 5.804 1.738 0 3.048-.57 4.073-1.628 1.05-1.045 1.382-2.522 1.382-3.71 0-.366-.028-.708-.087-.992h-5.37zm10.222-1.29c-2.082 0-3.78 1.574-3.78 3.748 0 2.154 1.698 3.747 3.78 3.747S87.998 9.9 87.998 7.74c0-2.174-1.7-3.748-3.782-3.748zm0 6.018c-1.14 0-2.127-.935-2.127-2.27 0-1.348.983-2.27 2.124-2.27 1.142 0 2.128.922 2.128 2.27 0 1.335-.986 2.27-2.128 2.27zm18.54-5.18h-.06c-.37-.438-1.083-.838-1.985-.838-1.88 0-3.52 1.632-3.52 3.748 0 2.102 1.64 3.747 3.52 3.747.905 0 1.618-.4 1.988-.852h.06v.523c0 1.432-.773 2.2-2.012 2.2-1.012 0-1.64-.723-1.9-1.336l-1.44.593c.414.994 1.51 2.213 3.34 2.213 1.94 0 3.58-1.135 3.58-3.902v-6.74h-1.57v.645zm-1.9 5.18c-1.144 0-2.013-.968-2.013-2.27 0-1.323.87-2.27 2.01-2.27 1.13 0 2.012.967 2.012 2.282.006 1.31-.882 2.258-2.01 2.258zM92.65 3.992c-2.084 0-3.783 1.574-3.783 3.748 0 2.154 1.7 3.747 3.782 3.747 2.08 0 3.78-1.587 3.78-3.747 0-2.174-1.7-3.748-3.78-3.748zm0 6.018c-1.143 0-2.13-.935-2.13-2.27 0-1.348.987-2.27 2.13-2.27 1.14 0 2.126.922 2.126 2.27 0 1.335-.986 2.27-2.127 2.27zM105.622.155h1.628v11.332h-1.628m6.655-1.477c-.843 0-1.44-.38-1.83-1.135l5.04-2.07-.168-.426c-.314-.84-1.274-2.39-3.227-2.39-1.94 0-3.554 1.516-3.554 3.75 0 2.1 1.595 3.745 3.736 3.745 1.725 0 2.724-1.05 3.14-1.658l-1.285-.852c-.427.62-1.01 1.032-1.854 1.032zm-.117-4.612c.668 0 1.24.342 1.427.826l-3.405 1.4c0-1.574 1.122-2.226 1.978-2.226z"></path></svg></svg></div></div>', 0 < e.find(".sail-address-box").length ? e.find(".sail-address-list").empty().append(i) : e.append(i))
        },
        eachAddress: function (e, t) {
            var a, i = this, n = "", o = "", r = "", s = $(".J-CustomerInfor").find(".J-Country").val();
            if (s = $(".J-CustomerInfor").find(".J-Country").val(), a = $(".J-CustomerInfor").find(".J-Country").find("option:selected").val(), "Object" == $plug.toRawType(e.result) && 0 < e.result.address_components.length) {
                for (var d, c = {address: "", province: ""}, l = e.result.address_components.length - 1; 0 <= l; l--) {
                    var p = e.result.address_components[l].types[0];
                    switch (p) {
                        case"country":
                            var u = !1, h = e.result.address_components[l].short_name,
                                g = e.result.address_components[l].short_name;
                            $(".J-CustomerInfor").find(".J-Country").find("option").each(function (e, t) {
                                $(this).removeProp("selected"), $(this).val() == h && (u = !0)
                            }), u && (r = g, i.country_value = g, $(".J-Country").find("option[value=" + g + "]").eq(0).prop("selected", !0), i.checkRequired(r));
                            break;
                        case"administrative_area_level_1":
                            var h = e.result.address_components[l].long_name,
                                m = e.result.address_components[l].short_name;
                            c.province = e.result.address_components[l].long_name, $(".J-CustomerInfor").find(".J-Province").val("-1000"), a == i.country_value ? $(".J-CustomerInfor").find(".J-Province").val(m) : (i.province_value = h, i.getRegionLibrary(r, !0, $(".J-CustomerInfor"))), $(".J-CustomerInfor").find(".J-Province").next().hide(), $(".J-CustomerInfor").find(".J-Province").removeClass("invalid");
                            break;
                        case"postal_code":
                            o = e.result.address_components[l].long_name;
                            break;
                        case"postal_town":
                            h = e.result.address_components[l].long_name;
                            "GB" == s && (document.getElementById("locality").value = e.result.address_components[l].long_name, 0 < h.length && ($(document.getElementById("locality")).next().hide(), $(document.getElementById("locality")).removeClass("invalid"), $(document.getElementById("locality")).parent().addClass("order-write--show")));
                            break;
                        default:
                            h = e.result.address_components[l].long_name;
                            "street_number" != p && "route" != p || (n = e.result.address_components[l].long_name + " " + n, c.address = n), -1 < p.indexOf("locality") && "GB" != s && (document.getElementById("locality").value = e.result.address_components[l].long_name, 0 < h.length && ($(document.getElementById("locality")).next().hide(), $(document.getElementById("locality")).removeClass("invalid"), $(document.getElementById("locality")).parent().addClass("order-write--show")), c.address = h)
                    }
                }
                "GB" == s ? (d = "" != o ? o : t, $(".J-ZipCode.J-GoogleMapAddress").val(d), document.getElementById("postal_code") && (document.getElementById("postal_code").value = d), 0 < d.length && ($(".J-ZipCode.J-GoogleMapAddress").next().hide(), $(".J-ZipCode.J-GoogleMapAddress").removeClass("invalid"), $(".J-ZipCode.J-GoogleMapAddress").parent().addClass("order-write--show"))) : ($(".J-ZipCode.J-GoogleMapAddress").val = o, document.getElementById("postal_code") && (document.getElementById("postal_code").value = o), 0 < o.length && ($(document.getElementById("postal_code")).next().hide(), $(document.getElementById("postal_code")).removeClass("invalid"), $(document.getElementById("postal_code")).parent().addClass("order-write--show")));
                t = "" != n ? n : "GB" == s ? "" : t;
                document.getElementById("street_number").value = $.trim(t), 0 < t.length && ($(document.getElementById("street_number")).next().hide(), $(document.getElementById("street_number")).removeClass("invalid"), $(document.getElementById("street_number")).parent().addClass("order-write--show")), "function" == typeof stag && stag("page_click", "user_behavior", {
                    type: "trace",
                    additional: "Address",
                    button_pos: c.address + ";" + c.province,
                    button_name: "google map"
                })
            }
            i.isUserOper = !0, setTimeout(function () {
                $(".J-GoogleMapAddress").focus()
            }, 100)
        },
        fadeIn: function (e, t) {
            var a = localStorage.getItem(this.cartToken + "_step");
            t ? ($(".J-OrderCrumbs").find(".J-step" + e).addClass("active").siblings().removeClass("active"), $(".order-step").hide(), $(".order-step").eq(e).show(), 2 == e ? $(".step-section-inform").find(".row").eq(2).show() : $(".step-section-inform").find(".row").eq(2).hide(), 0 == e ? $(".step-section-inform").hide() : $(".step-section-inform").show()) : ($(".J-OrderCrumbs").find(".J-step" + e).addClass("active").siblings().removeClass("active"), $(".order-step").fadeOut(500), setTimeout(function () {
                $(".order-step").eq(e).fadeIn(500), 2 == e ? $(".step-section-inform").find(".row").eq(2).show() : $(".step-section-inform").find(".row").eq(2).hide(), 0 == e ? $(".step-section-inform").fadeOut(500) : $(".step-section-inform").fadeIn(500)
            }, 500)), "payment_method" == a ? ($(".J-step0").addClass("J-ChangeInformation"), $(".J-step1").addClass("J-ChangeShipping"), $(".J-step2").addClass("J-ChangePayment")) : ($(".J-step2").removeClass("J-ChangePayment"), 1 <= e ? $(".J-step0").addClass("J-ChangeInformation") : $(".J-step0").removeClass("J-ChangeInformation"), 2 == e ? $(".J-step1").addClass("J-ChangeShipping") : $(".J-step1").removeClass("J-ChangeShipping")), setTimeout(function () {
                "payment_method" == a && "contact_information" == $plug.query().step && $(".J-step2").removeClass("J-ChangePayment")
            }, 10)
        },
        createOrder: function (i, n) {
            var o = this;
            if ("" == o.orderInfor[void 0] && delete o.orderInfor[void 0], o.orderInfor.shipping_contry_code && "" != o.orderInfor.shipping_contry_code || $(".J-CustomerInfor").find(".J-Country").find("option").each(function () {
                o.orderInfor.shipping_contry == $(this).data("countries") && (o.orderInfor.shipping_contry_code = item.code, o.orderInfor.contry_id = item.id)
            }), o.orderInfor.cartToken = o.cartToken, o.orderInfor.checkout_step = o.checkout_step, window.location.href.includes("orderNumberFromEmail") && (o.orderInfor.order_number_from_email = $plug.query().orderNumberFromEmail), "1" == $(".J-isShowPhone").val() && "" == $.trim(o.orderInfor.shipping_phone)) return $plug.replaceParam(window.location.href, "step", "contact_information"), !1;
            $http.post("/buyer/order/create", JSON.stringify(o.orderInfor), function (t) {
                if (503 == t.code && "0" == $(".J-IsRenovation").val() && (window.location.href = "/cart"), 0 == t.code && (o.order_number = t.data.order_number, window.sessionStorage.setItem("order_number", o.order_number)), 1500 == t.code && window.location.reload(), 101 == t.code) return $plug.replaceParam(window.location.href, "step", "contact_information"), !1;
                var e, a;
                if (0 == t.code && 0 == i && (e = {
                    is_recommend: o.orderInfor.is_recommend,
                    shipping_email: o.orderInfor.shipping_email,
                    shipping_first_name: o.orderInfor.shipping_first_name,
                    shipping_last_name: o.orderInfor.shipping_last_name,
                    shipping_address: o.orderInfor.shipping_address,
                    shipping_other_address: o.orderInfor.shipping_other_address,
                    shipping_contry: o.orderInfor.shipping_contry,
                    shipping_city: o.orderInfor.shipping_city,
                    shipping_province: o.orderInfor.shipping_province,
                    shipping_phone: o.orderInfor.shipping_phone,
                    shipping_zip_code: o.orderInfor.shipping_zip_code,
                    shipping_contry_code: o.orderInfor.shipping_contry_code,
                    shipping_province_code: o.orderInfor.shipping_province_code
                }, s.setItem("order_data", JSON.stringify(e)), n && n(), o.orderNo = t.data.order_number), 0 == t.code && 1 == i) {
                    if ($(".J-PaymentFailed").hide(), "card" == o.paymethod && $plug.loading("Payment In Progress!"), 1 == o.isBuyQuickly) return jQuery.post("/payment/paypal-union/capture-order", {
                        cartToken: o.cartToken,
                        orderNumber: o.order_number
                    }, function (e) {
                        var t;
                        $(".J-CreateOrder").removeClass("jh-btn-loading"), 0 < $(".J-Loading").length && ($(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")), 10003 == e.code && (localStorage.setItem(o.cartToken + "_step", "payment_method"), r.setItem(o.cartToken + "_step_current", "payment_method"), $plug.replaceParam(window.location.href, "step", "payment_method"), $plug.replaceParam(window.location.href, "error", "PAYMENT_ERROR"), window.location.reload()), 0 == e.code ? (window.localStorage.removeItem("coupon_code"), window.localStorage.removeItem(o.cartToken + "_step"), window.localStorage.removeItem("user_select_insurance"), localStorage.removeItem("user_select_insurance"), t = e.data.order_url.split("?")[1].split("order_hash_paypal=")[1], window.location.href = "/checkouts/" + t + "/thank_you") : ($(".J-PaymentFailed").find(".J-PaymentFailed--text").text(e.msg), $(".J-PaymentFailed").show())
                    }), !1;
                    0 == o.isBuyQuickly && "card" == o.paymethod && "0.00" != o.orderInfor.amount && (a = {order_number: t.data.order_number}, $plug.loading("Payment In Progress!"), window.screen.availWidth <= 768 ? a.isMobile = "1" : a.isMobile = "0", window.location.href = "/payment/creditcard/create-payment?order_number=" + t.data.order_number + "&isMobile=" + a.isMobile), (0 == o.isBuyQuickly && "paypal" == o.paymethod || "0.00" == o.orderInfor.amount) && (a = {
                        cartToken: o.cartToken,
                        order_number: t.data.order_number
                    }, 0 == o.isBuyQuickly && jQuery.post("/payment/paypal-union/create-order", a, function (e) {
                        return 10003 == e.code && window.location.reload(), 301 == e.code ? (window.location.href = "/checkouts/" + t.data.order_number_hash + "/thank_you", !1) : void (0 == e.code ? window.location.href = e.data.href : ($(".J-PaymentFailed").find(".J-PaymentFailed--text").text(e.msg), $(".J-PaymentFailed").show()))
                    })), 0 == o.isBuyQuickly && "COD" == o.paymethod && "0.00" != o.orderInfor.amount && (a = {order_number: t.data.order_number}, $plug.loading("Payment In Progress!"), window.screen.availWidth <= 768 ? a.isMobile = "1" : a.isMobile = "0", window.location.href = "/payment/cash-delivery/create-payment?order_number=" + t.data.order_number + "&isMobile=" + a.isMobile)
                }
            })
        },
        paypalPayment: function (s) {
            if ($(".placeholder-line").hide(), "object" != ("undefined" == typeof paypal ? "undefined" : _typeof(paypal))) return !1;
            var d = this, e = {
                env: SAIL_ENV.PAYPAL_ENV, locale: "en_US", payment: function (t) {
                    var e, a, i, n, o, r;
                    1 == s.type && s.bool && "function" == typeof stag && stag("page_click", "buy_it_now", {
                        handler: $(".sail-event-page-handler").val(),
                        additional: $plug.query().variant || $(s.id).parents(".JH-Columns").find(".product-id").val()
                    }), 1 == s.type ? ("function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: "1",
                        button_pos: "",
                        button_name: "paypal"
                    }), o = null, a = e = "", i = "index" == s.path ? $(s.id).parents(".JH-Columns") : $(".JH-Columns"), n = "index" == s.path ? i.find(".product-code").val() : $(".product-code").val(), "index" == s.path ? i.find(".product-id").val() : $(".product-code").val(), o = s.bool ? {
                        sku_id: "",
                        attribute: {},
                        cart_type: "2",
                        quantity: 0 < i.find(".J-ProductNumber").length ? i.find(".J-ProductNumber").val() : 1
                    } : {cart_type: "1"}, s.bool && (0 < i.find(".J-Attribute").find("select").length ? i.find(".J-Product").find(".J-Attribute").each(function () {
                        a += $.trim($(this).find(".J-Value").find("option:selected").data("title-code")), o.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find("option:selected").data("title")
                    }) : i.find(".J-Product").find(".J-Attribute").each(function () {
                        a += $.trim($(this).find(".J-Value").find(".active").data("title-code")), o.attribute[$(this).find(".J-Type").data("type")] = $(this).find(".J-Value").find(".active").data("title")
                    }), "index" == s.path ? 0 < i.find(".J-SkuList-" + n).find("span").length && (i.find(".J-SkuList-" + n).find("span").each(function () {
                        $.trim(a) == $.trim($(this).data("title-code")) && (e = $(this).data("id"))
                    }), 1 < i.find(".J-SkuList-" + n).find("span").length && (o.sku_id = e || ""), 1 == i.find(".J-SkuList-" + n).find("span").length && (o.sku_id = i.find(".J-SkuList-" + n).find("span").eq(0).data("id"))) : 0 < $(".J-SkuList").find("span").length && ($(".J-SkuList").find("span").each(function () {
                        $.trim(a) == $.trim($(this).data("title-code")) && (e = $(this).data("id"))
                    }), 1 < $(".J-SkuList").find("span").length && (o.sku_id = e || $plug.query().variant || ""), 1 == $(".J-SkuList").find("span").length && (o.sku_id = $(".J-SkuList").find("span").eq(0).data("id")))), s.bool || (o.cartToken = d.cartToken), r = "/payment/paypal-union/create-order", $http.post(r, JSON.stringify(o), function (e) {
                        10003 == e.code && window.location.reload(), 0 == e.code ? (t(e.data.token), s.bool && (d.cartToken = e.data.cartToken)) : ($plug.message.error(e.msg), "function" == typeof stag && stag("page_click", "user_behavior", {
                            type: "check",
                            additional: e.msg,
                            button_pos: r,
                            button_name: ""
                        }))
                    })) : (d.resolve = t, d.validationOrder(3, t), "function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: "paypal",
                        button_pos: "3",
                        button_name: "complete"
                    }))
                }, onAuthorize: function (e) {
                    var a, t = {
                        payerID: e.payerID,
                        orderID: e.orderID,
                        cartToken: d.cartToken,
                        paymentToken: e.paymentToken
                    };
                    1 == s.type && $http.post("/payment/paypal-union/save-payment-token-info", JSON.stringify(e), function (e) {
                        0 == e.code && (s.bool ? ("function" == typeof fbq && fbq("track", "AddToCart"), "function" == typeof snaptr && snaptr("track", "ADD_CART"), "function" == typeof gtag && gtag("event", "add_to_cart"), "function" == typeof fbq && fbq("track", "InitiateCheckout"), "function" == typeof snaptr && snaptr("track", "START_CHECKOUT"), "function" == typeof gtag && gtag("event", "begin_checkout"), localStorage.removeItem(d.cartToken + "_step"), r.removeItem(d.cartToken + "_step_current"), r.removeItem("user_select_insurance"), r.removeItem("user_select_insurance"), r.removeItem("card-remark"), window.location.href = "/checkouts/" + d.cartToken + "?step=contact_information") : $http.post("/payment/paypal-union/get-order-info", {}, function (e) {
                            0 == e.code && e.data && e.data.buyer && (d.isBuyQuickly = 1, d.paymethod = "paypal", $(".J-paypal-payment").hide(), $(".J-PaymentMethod").remove(), $(".J-placeShipping").find(".btn-text").text(SAIL_ENV.language[SAIL_ENV.language.lang].btn_complete_order), $(".J-CustomerInfor").find(".paypal-checkout-tips").text(SAIL_ENV.language[SAIL_ENV.language.lang].paypal).addClass("paypal-remembered-tips"), d.isExistCacheAddress || d.setCacheAddress(e.data.buyer, "paypal"))
                        }))
                    }), 2 == s.type && ($(".J-PaymentFailed").hide(), $plug.loading("Payment In Progress!"), a = "/payment/paypal-union/capture-order", $.ajax({
                        type: "post",
                        data: t,
                        url: a,
                        dataType: "json",
                        success: function (e) {
                            var t;
                            $(".J-CreateOrder").removeClass("jh-btn-loading"), 0 < $(".J-Loading").length && ($(".J-MaskLoad, .J-Loading").hide(), $("html, body").removeClass("hidden")), 10003 == respolonse.code && ($plug.replaceParam(window.location.href, "error", "PAYMENT_ERROR"), window.location.reload()), 0 == e.code ? (window.localStorage.removeItem("coupon_code"), window.localStorage.removeItem(d.cartToken + "_step"), window.localStorage.removeItem("user_select_insurance"), window.localStorage.removeItem("__local_order_number__"), t = e.data.order_url.split("?")[1].split("order_hash_paypal=")[1], window.location.href = "/checkouts/" + t + "/thank_you") : ($(".J-PaymentFailed").find(".J-PaymentFailed--text").text(e.msg), $(".J-PaymentFailed").show(), "function" == typeof stag && stag("page_click", "user_behavior", {
                                type: "check",
                                additional: e.msg,
                                button_pos: a,
                                button_name: ""
                            }))
                        }
                    }))
                }, onCancel: function () {
                    $(".J-CreateOrder").removeClass("jh-btn-loading"), 0 < $(".J-Loading").length && $(".J-MaskLoad, .J-Loading").hide()
                }, onError: function () {
                    window.location.reload()
                }
            };
            switch (s.paymentType) {
                case"whiteBar":
                    e.funding = {allowed: [paypal.FUNDING.CREDIT]}, e.client = SAIL_ENV.PAYPAL_CLIENT, e.style = {
                        label: "credit",
                        size: "responsive",
                        shape: "rect",
                        tagline: !1,
                        height: 44
                    };
                    break;
                default:
                    e.commit = 1 != s.type, e.style = {
                        layout: "horizontal",
                        size: "responsive",
                        color: "gold",
                        shape: "rect",
                        label: "paypal",
                        maxbuttons: 1,
                        height: 2 == s.type ? 55 : 44,
                        tagline: !1
                    }
            }
            "object" == ("undefined" == typeof paypal ? "undefined" : _typeof(paypal)) && paypal.Button.render(e, s.id)
        },
        paypalCard: function (e) {
            var r = this, s = !0;
            paypal.Button.render({
                env: SAIL_ENV.PAYPAL_ENV,
                style: {
                    layout: "vertical",
                    size: "responsive",
                    color: "blue",
                    shape: "rect",
                    label: "paypal",
                    height: 55,
                    tagline: !1
                },
                payment: function (e, t) {
                    var a = {
                        cartToken: r.cartToken,
                        order_number: r.order_number || window.sessionStorage.getItem("order_number")
                    }, o = {};
                    return $(".J-BillVal").each(function () {
                        var a, i, n;
                        $(this).parent(".order-write-item").is(":visible") && (a = $(this).data("type"), i = $.trim($(this).val()), n = $(this), "billing_contry" == $(this).data("type") || "billing_province" == $(this).data("type") ? o[$(this).data("type")] = $(this).find("option:selected").text() : o[$(this).data("type")] = $(this).val(), r.validation.map(function (e, t) {
                            e.verify && e.type == a && (n.removeClass("invalid"), n.siblings(".jh-input-tips").text("").hide(), i && "" != i || (n.siblings(".jh-input-tips").text(e.tips[0]).show(), n.addClass("invalid"), s = !1))
                        }), "billing_address" == $(this).data("type") && $(this).val().length < 2 && (n.siblings(".jh-input-tips").text("").show(), n.addClass("invalid"), s = !1))
                    }), !!s && (r.createOrder(0), t.request.post("/payment/paypal-union/create-order", a).then(function (e) {
                        return e.data.token
                    }))
                },
                onAuthorize: function (e) {
                    $http.post("/payment/paypal-union/capture-order", JSON.stringify(e), function (e) {
                        window.location.href = e.data.order_url
                    })
                }
            }, e.id)
        },
        makeUserAddress: function (e, a) {
            var i = this,
                n = '<option value="New address" data-addressId="-100">' + SAIL_ENV.language[SAIL_ENV.language.lang].new_address + "</option>";
            e ? i.setCacheAddress(e) : $http.post("/buyer/user-center/get-address", JSON.stringify({}), function (e) {
                var t;
                0 == e.code && 0 < e.data.data.length ? (i.userAddress = e.data.data || [], t = i.userAddress[0], 0 < i.userAddress.length && i.userAddress.map(function (e, t) {
                    n += 0 == t && a ? '<option value="' + e.shipping_address + '" data-addressId="' + e.shipping_id + '" selected="selected">' + e.shipping_address + "</option>" : '<option value="' + e.shipping_address + '" data-addressId="' + e.shipping_id + '">' + e.shipping_address + "</option>"
                }), a && i.setCacheAddress(t), $(".J-GetUserAddress").empty().append(n), $('.J-OrderVal[data-type="shipping_email"]').parents(".order-write-list").hide()) : s.getItem("order_data") ? ((t = JSON.parse(s.getItem("order_data"))).is_recommend ? 0 < $(".J-Offers").length && $(".J-Offers").children(".jh-checkbox").addClass("jh-checkbox-active") : 0 < $(".J-Offers").length && $(".J-Offers").children(".jh-checkbox").removeClass("jh-checkbox-active"), a && i.setCacheAddress(t)) : a && i.getUserIpAddress()
            })
        },
        makeMatchHtmlSingle: function (o) {
            var t = this, e = "";
            if (1400 == o.error_code && t.sendEmail(), o.list.length <= 0 && (1500 == o.error_code ? ($(".shipping-tips .shipping-tips-text").hide(), $(".shipping-tips .shipping-tips-text-no-province").show()) : ($(".shipping-tips .shipping-tips-text").show(), $(".shipping-tips .shipping-tips-text-no-province").hide()), "1" == l && ($(".shipping-tips").show(), setTimeout(function () {
                $(".shipping-tips").slideUp()
            }, 5e3), $(".J-SettingsInfo").find(".J-express-name").text(SAIL_ENV.language[SAIL_ENV.language.lang].no_shipping), $(".J-SettingsInfo").find(".shipping-fees").hide(), $(".J-CreateOrder").addClass("jh-disabled").attr("disabled", "disabled"), $(".insurance-order-checkbox").addClass("display-none"))), 0 == o.error_code) {
                if (!o.list || o.list.length <= 0) return $(".J-shipping-match").hide(), $(".J-MethodsLoading").hide(), $(".J-MethodsEmpty").show(), !1;
                $(".J-SettingsInfo").find(".shipping-fees").show(), $(".J-CreateOrder").removeClass("jh-disabled").removeAttr("disabled"), t.cartList.express.has_insurance && 1 == t.cartList.express.has_insurance && $(".insurance-order-checkbox").removeClass("display-none"), t.matchList = o.list, t.orderInfor.express_id = o.selected, t.matchList && (e = t.matchList.map(function (e, t) {
                    var a = "0.00" == e.express_fee ? "<span>" + SAIL_ENV.language[SAIL_ENV.language.lang].free + "</span>" : SAIL_ENV.config.headsymbol + e.express_fee,
                        i = e.express_fee != e.origin_fee ? "<span class='through-span'>" + SAIL_ENV.config.headsymbol + e.origin_fee + "</span>" : "",
                        n = e.id == o.selected ? "jh-radio-active" : "";
                    return '<li data-id="' + e.id + '" >\n                                <div class="fl shipping-match-sel">\n                                    <span class="jh-radio ' + n + '" data-id="' + e.id + '" data-title="' + e.express_name + '" data-originfee="' + e.origin_fee + '" data-fee="' + e.express_fee + '"></span>\n                                </div>\n                                <div class="shipping-match-details"><font>' + e.express_name + '</font></div>\n                                <div class="fr shipping-match-price">' + i + a + "</div>\n                            </li>"
                })), 0 < $(".J-shipping-match").length && $(".J-shipping-match").empty().append(e), t.orderInfor.express_fee = $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("fee"), t.orderInfor.express_name = $(".J-shipping-match").find(".jh-radio.jh-radio-active").data("title"), $(".J-shipping-match li").click(function () {
                    t.orderInfor.express_id = $(this).data("id"), t.orderInfor.express_fee = $(this).find(".shipping-match-sel > span").data("fee"), t.orderInfor.express_name = $(this).find(".shipping-match-sel > span").data("title"), $(this).find(".shipping-match-sel > span").addClass("jh-radio-active"), $(this).siblings().find(".shipping-match-sel > span").removeClass("jh-radio-active"), t.orderRes.shipping = $(this).find(".jh-radio.jh-radio-active").data("fee"), t.orderRes.total = (parseFloat(t.orderRes.product_payable_amount) + parseFloat(t.orderRes.shipping)).toFixed(2) + "", t.contain_insurance = 0, t.makeOrderPriceHtml(), $(".J-express-name").text(t.orderInfor.express_name || ""), $(".J-express-fee").text(0 < t.orderInfor.express_fee ? SAIL_ENV.config.headsymbol + t.orderInfor.express_fee : SAIL_ENV.language[SAIL_ENV.language.lang].free);
                    var e = $(this).find(".jh-radio.jh-radio-active").data("title") + "-" + $(this).find(".jh-radio.jh-radio-active").data("fee");
                    "function" == typeof stag && stag("page_click", "user_behavior", {
                        type: "trace",
                        additional: e,
                        button_pos: "2",
                        button_name: "match"
                    })
                }), $(".J-express-name").text(t.orderInfor.express_name || ""), $(".J-express-fee").text(0 < t.orderInfor.express_fee ? SAIL_ENV.config.headsymbol + t.orderInfor.express_fee : SAIL_ENV.language[SAIL_ENV.language.lang].free), $(".J-shipping-match").show(), $(".J-MethodsLoading").hide(), $(".J-MethodsEmpty").hide(), $(".J-placeCustomer").removeClass("jh-btn-loading"), $(".J-placeShipping").removeAttr("disabled").removeClass("jh-disabled"), $(".unavailable-products").hide()
            } else {
                $(".J-shipping-match").hide(), $(".J-MethodsLoading").hide(), $(".J-MethodsEmpty").show();
                var a = 0 < o.no_express_sku.length && o.no_express_sku.map(function (t) {
                    var a = "";
                    return Object.keys(t.attribute).forEach(function (e) {
                        a = a ? a + "/" + t.attribute[e] : a + t.attribute[e]
                    }), '<div class="order-item">\n                                <div class="order-img">\n                                    <div><img src="' + (t.image && t.image.file_preview) + '"></div>\n                                    <span class="fr">' + t.quantity + '</span> \n                                </div>\n                                <div class="order-iform">\n                                    <div class="order-name">' + t.product_title + '</div>\n                                    <div class="order-types">' + a + '</div>\n                                </div>\n                                <div class="order-price">' + (SAIL_ENV.config.headsymbol + t.price) + "</div>\n                            </div>"
                });
                0 < o.no_express_sku.length && $(".unavailable-products").empty().append(a).show()
            }
        },
        makeInsuranceHtmlSingle: function (e) {
            e.has_insurance && 1 == e.has_insurance && (null != this.local_is_select_insurance || localStorage.getItem("__local_order_number__") || (this.local_is_select_insurance = e.insurance_select), this.watchInsuranceCheckboxStatusSingle())
        },
        watchInsuranceCheckboxStatusSingle: function () {
            var e = this, t = e.cartList.total.insurance;
            if (e.cartList.express.has_insurance && 1 == e.cartList.express.has_insurance) $(".insurance-order-checkbox").removeClass("display-none"), 0 < t ? ($(".insurance-order-subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2)), $(".J-Insurance-Subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2))) : ($(".insurance-order-subtotal").html("&nbsp;Free").css("font-size: 14px;"), $(".J-Insurance-Subtotal").text("Free")); else if (0 == e.cartList.express.has_insurance) return $(".insurance-order-checkbox .jh-checkbox").removeClass("jh-checkbox-active"), void $(".J-Insurance-Subtotal").parent("p").hide();
            1 == e.local_is_select_insurance ? ($(".insurance-order-checkbox .jh-checkbox").addClass("jh-checkbox-active"), $(".J-Insurance-Info").removeClass("display-none"), $(".J-Insurance-Subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2))) : 0 == e.local_is_select_insurance && ($(".insurance-order-checkbox .jh-checkbox").removeClass("jh-checkbox-active"), $(".J-Insurance-Info").addClass("display-none"), $(".J-Insurance-Subtotal").text(SAIL_ENV.language[SAIL_ENV.language.lang].did_not_buy)), this.countInsuranceTotalPrice()
        },
        countInsuranceTotalPrice: function () {
            var e = this, t = parseFloat(e.orderRes.total),
                a = $(".J-shipping-match li").find(".jh-radio.jh-radio-active").data("originfee"),
                i = parseFloat(parseFloat(e.orderRes.product_amount) + parseFloat(0 < a ? a : 0)).toFixed(2);
            1 == e.local_is_select_insurance && (i = parseFloat(parseFloat(i) + parseFloat(e.orderRes.insurance)).toFixed(2)), 1 == e.contain_insurance ? 0 == e.local_is_select_insurance && (t = parseFloat(parseFloat(t) - parseFloat(e.orderRes.insurance)).toFixed(2)) : 1 == e.local_is_select_insurance && (t = parseFloat(parseFloat(t) + parseFloat(e.orderRes.insurance)).toFixed(2)), e.orderInfor.is_select_insurance = e.local_is_select_insurance, $(".order-total").find(".J-Total").html(SAIL_ENV.config.headcode + " <strong>" + SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2) + "</strong> "), $(".order-buy-price.J-Total").html("<strong>" + SAIL_ENV.config.headsymbol + parseFloat(t).toFixed(2) + "</strong> "), 0 < e.orderRes.discount.length && ($(".order-buy-price.J-Subtotal").text(SAIL_ENV.config.headsymbol + i), Number(parseFloat(i) + parseFloat(0 < a ? a : 0)).toFixed(2) == Number(t) ? $(".order-buy-price.J-Subtotal").hide() : $(".order-buy-price.J-Subtotal").show()), "1" == l && ("0.00" == t ? ($(".pay-free").show(), $(".paypal-inform-box").hide(), $(".order-payment-box").hide()) : ($(".pay-free").hide(), $(".paypal-inform-box").show(), $(".order-payment-box").show()))
        },
        makeOrderPriceHtml: function (e, t) {
            var a = this, i = "";
            $(".paypal-inform-box").hide(), e && e.hasOwnProperty("amount") && 0 < parseFloat(e.amount) && $(".paypal-inform-box").show(), e && (a.orderRes = e, a.orderInfor.amount = e.amount), a.isPayMoney();
            var n, o = $(".J-shipping-match li").find(".jh-radio.jh-radio-active").data("originfee"),
                r = parseFloat(a.orderRes.product_amount) + parseFloat(0 < o ? o : 0);
            1 == a.local_is_select_insurance && 1 == a.orderRes.contain_insurance && (n = a.cartList.total.insurance, r = parseFloat(r) + parseFloat(n)), Number(r).toFixed(2) == Number(a.orderRes.total) ? $(".order-buy-price.J-Subtotal").hide() : $(".order-buy-price.J-Subtotal").show(), $(".order-buy-price.J-Total").html("<strong>" + SAIL_ENV.config.headsymbol + parseFloat(a.orderRes.total).toFixed(2) + "</strong> "), $(".order-total").find(".J-Total").html(SAIL_ENV.config.headcode + " <strong>" + SAIL_ENV.config.headsymbol + parseFloat(a.orderRes.total).toFixed(2) + "</strong> "), $(".J-Shipping").text("0" == t ? SAIL_ENV.language[SAIL_ENV.language.lang].calculated : 0 < a.orderRes.shipping ? SAIL_ENV.config.headsymbol + a.orderRes.shipping : SAIL_ENV.language[SAIL_ENV.language.lang].free), $(".J-Subtotal").text(SAIL_ENV.config.headsymbol + a.orderRes.product_amount), $(".order-buy-price.J-Subtotal").text(SAIL_ENV.config.headsymbol + parseFloat(r).toFixed(2)), a.orderRes.discount.length && a.orderRes.discount.map(function (e) {
                i += '<div class="fl">' + SAIL_ENV.language[SAIL_ENV.language.lang].discount + '</div><div class="order-discount"><p>\n            <span class="J-CouponDesc"><span class="iconfont icon-yduizhekou"></span>' + e.desc + '</span>\n            <span class="fr"><i class="J-Discount">' + e.fee + "</i></span>\n            </p></div>"
            }), $(".J-Discount-Info").length && $(".J-Discount-Info").empty().append(i), a.cartList.express && a.cartList.express.list && 0 < a.cartList.express.list.length && a.makeInsuranceHtmlSingle(a.cartList.express, a.cartList.total.insurance)
        },
        makeOrderHtml: function (e, t, r) {
            var a, s = this, d = "", c = {
                content_ids: [],
                content_type: "product_group",
                currency: $(".J-currency-code").val(),
                value: parseFloat(t),
                num_items: 0
            }, l = "";
            (s.product_list = e).map(function (t, a) {
                var i, n, o = "", e = parseInt((new Date).getTime() / 1e3);
                parseInt(e - $(".J-orderUpdateTime").val());
                ("1" == t.is_invalid || t.inventory_quantity <= 0) && "0" == $(".J-IsRenovation").val() && (window.location.href = "/cart"), t.is_invalid || (Object.keys(t.attribute).forEach(function (e) {
                    o = o ? o + "/" + t.attribute[e] : o + t.attribute[e]
                }), i = "", t.coupon_id != l && r.length && r.map(function (e) {
                    t.coupon_id == e.id && (l = t.coupon_id, n = a, i = 0 == t.coupon_id || "" == e.match ? 0 == n ? "" : '<div class="space-line"></div>' : '<div class="order-discount-tips"> \n                                    <span class="iconfont icon-yduizhekou"></span>\n                                    <em>' + e.match + "</em>\n                                </div>")
                }), d += (i = n == a ? i : "") + '\n                                <div class="order-item">\n                                    <div class="order-img">\n                                        <div><img src="' + (t.image && t.image.file_preview) + '" /></div>\n                                        <span class="fr">' + t.quantity + '</span> \n                                    </div>\n                                    <div class="order-iform">\n                                        <div class="order-name">' + t.product_title + '</div>\n                                        <div class="order-types">' + o + '</div>\n                                    </div>\n                                    <div class="order-price">' + (SAIL_ENV.config.headsymbol + t.price) + "</div>\n                                </div>"), c.content_ids.indexOf(parseInt(t.product_id)) <= -1 && c.content_ids.push(parseInt(t.product_id)), s.gtagSkuList.push({
                    id: t.sku_id,
                    google_business_vertical: "retail"
                }), c.num_items += parseInt(t.quantity)
            }), 0 < $(".J-OrderByCart").length && $(".J-OrderByCart").empty().append(d), 420 < $(".J-OrderByCart").find(".order-item").outerHeight() * $(".J-OrderByCart").find(".order-item").length && $(".J-OrderListBox").find(".scroll-items").length <= 0 && (a = "<span class='scroll-items'>" + SAIL_ENV.language[SAIL_ENV.language.lang].scroll_more + "<i class='iconfont icon-xia'></i></span>", $(".J-OrderByCart").append(a), $(".J-OrderByCart").scroll(function () {
                $(".J-OrderListBox").find(".scroll-items").fadeOut(350, function () {
                    $(".J-OrderListBox").find(".scroll-items").remove()
                })
            })), window.localStorage.getItem("checkout") && window.localStorage.getItem("checkout") == $plug.getToKen() || ("function" == typeof fbq && fbq("track", "InitiateCheckout", c), "function" == typeof snaptr && snaptr("track", "START_CHECKOUT", {
                price: c.value,
                currency: c.currency,
                item_ids: c.content_ids,
                item_category: "",
                number_items: c.num_items
            }), "function" == typeof gtag && gtag("event", "begin_checkout", {items: s.gtagSkuList}), window.localStorage.setItem("checkout", $plug.getToKen()))
        },
        makeRegionHtml: function (a, e, t) {
            var i = this, n = "", o = "";
            "" != i.province_value && "" != i.country_value && (o = i.province_value), "" != i.orderInfor.shipping_province && (o = i.orderInfor.shipping_province), a && 0 < Object.keys(a).length && (i.orderInfor.shipping_province_code ? n += '<option value="-1000"  disabled="disabled" > ' + t + " </option>" : n += '<option value="-1000"  disabled="disabled" selected > ' + t + " </option>", Object.keys(a).forEach(function (e, t) {
                o.toLowerCase() == e.toLowerCase() || i.orderInfor.shipping_province_code == a[e].code ? n += '<option value="' + a[e].code + '" selected data-province="' + e + '">' + e + "</option>" : n += '<option value="' + a[e].code + '" data-province="' + e + '">' + e + "</option>"
            }), e ? e.find(".J-Province").val("") : $(".J-Province").val(""), e ? e.find(".J-Country").parent(".order-write-item").removeClass("order-write-whole") : $(".J-Country").parent(".order-write-item").removeClass("order-write-whole"), e ? e.find(".J-Province").empty().append(n) : $(".J-Province").empty().append(n), e ? e.find(".J-Province").parent(".order-write-item").show() : $(".J-Province").parent(".order-write-item").show())
        },
        makeCouponHtml: function (e, t) {
            var a = "";
            if (0 == e.error_code && (t && window.localStorage.setItem("coupon_code", t), t && (this.orderInfor.coupon_code = t)), 0 == e.detail.length && 0 == e.error_code) return $(".J-CouponItem").empty(), $(".J-Discount-Info").empty(), $(".J-GetCouponVal").removeClass("invalid"), !1;
            0 < e.detail.length && 0 == e.error_code ? ($(".J-CouponItem").empty(), $(".J-Discount-Info").empty(), e.detail.map(function (e, t) {
                (0 == e.is_auto && 1 == e.type || 0 == e.is_auto && 1 == e.type && 3 == e.coupon_type) && (a += '<div class="order-coupon-item"><span class="iconfont icon-yduizhekou"><i class="coupon-close J-CouponClose">×</i>' + e.desc + "</div>")
            }), $(".J-GetCouponVal").val("").attr("placeholder", SAIL_ENV.language[SAIL_ENV.language.lang].placeholder_discount), $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled"), $(".J-GetCouponVal").removeClass("invalid"), $(".J-CouponItem").append(a)) : 1 == e.error_code ? ($(".J-CouponItem").find(".erro-tips") && $(".J-CouponItem").find(".erro-tips,.error-coupon-box").remove(), $(".J-GetCouponVal").addClass("invalid"), $(".J-CouponItem").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_1 + "</p>")) : 2 == e.error_code ? ($(".J-CouponItem").find(".erro-tips") && $(".J-CouponItem").find(".erro-tips,.error-coupon-box").remove(), $(".J-CouponItem").append('<div class="error-coupon-box"><span class="iconfont icon-gantanhao"></span><div><strong> ' + t + " </strong> " + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_2 + ' </div><span class="iconfont icon-close J-RemoveCoupon" ></span></div>'), $(".J-GetCouponVal").val("").attr("placeholder", SAIL_ENV.language[SAIL_ENV.language.lang].placeholder_discount), $(".J-GetCoupon").addClass("jh-disabled").attr("disabled", "disabled")) : 3 == e.error_code && ($(".J-CouponItem").find(".erro-tips") && $(".J-CouponItem").find(".erro-tips,.error-coupon-box").remove(), $(".J-CouponItem").append('<p class="erro-tips">' + SAIL_ENV.language[SAIL_ENV.language.lang].tips_coupon_error_3($(".J-GetCouponVal").val()) + "</p>"))
        }
    }).init()
});
