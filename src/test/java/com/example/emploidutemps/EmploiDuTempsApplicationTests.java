package com.example.emploidutemps;

import com.example.emploidutemps.repositories.*;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class EmploiDuTempsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MatiereRepository matiereDao;
    @Autowired
    private CourRepository coursDao;
    @Autowired
    private EnseignantRepository enseignantDao;
    @Autowired
    private ClasseRepository classeDao;
    @Autowired
    private AnneRepository anneeScolaireDao;

    @Autowired
    private EmploiTempRepository emploiTempRepository;


    @Autowired
    private MockMvc mvc;

    private JSONObject json;

    private JSONObject json_classe;

    private JSONObject json_annee;

    private JSONObject json_enseignant;


    private JSONObject json_cours;

    private JSONObject json_emploi;

    @BeforeAll
    @AfterAll
    public void clearDataBase() {
        this.matiereDao.deleteAll();
        json = null;
        json_classe = null;
        json_annee = null;
        json_enseignant = null;
    }

    @BeforeAll
    @AfterAll
    public void clearDataBaseClasse() {
        this.classeDao.deleteAll();
        json = null;
        json_classe = null;
        json_annee = null;
        json_enseignant = null;
    }

    @BeforeAll
    @AfterAll
    public void clearDataBaseEnseignant() {
        this.enseignantDao.deleteAll();
        json = null;
        json_classe = null;
        json_annee = null;
        json_enseignant = null;
        json_cours = null;
    }

    @BeforeAll
    @AfterAll
    public void clearDataBaseAnneeScolaire() {
        this.anneeScolaireDao.deleteAll();
        json = null;
        json_classe = null;
        json_annee = null;
        json_enseignant = null;
    }

    @BeforeAll
    @AfterAll
    public void clearDataBaseCours() {
        this.coursDao.deleteAll();
        json = null;
        json_classe = null;
        json_annee = null;
        json_enseignant = null;
    }

    @BeforeAll
    @AfterAll
    public void clearDataBaseEmploi() {
        this.emploiTempRepository.deleteAll();
        json = null;
        json_classe = null;
        json_annee = null;
        json_enseignant = null;
    }


    @Test
    @Order(value = 1)
    @DisplayName("1-CREER UNE MATIERE")
    public void testThatWecanCreateMatiere() throws Exception {
        MvcResult result = this.mvc.perform(
                        MockMvcRequestBuilders
                                .post("/matieres/add")
                                .content("{"
                                        + "\"code\": \"CSC352\","
                                        + "\"intitule\":\"Spring-boot\""
                                        + "}"
                                ).contentType(MediaType.APPLICATION_JSON)

                ).andDo(print())
                .andExpect(jsonPath("$.code", is("CSC352")))
                .andExpect(jsonPath("$.intitule", is("Spring-boot")))
                .andReturn();
        json = new JSONObject(result.getResponse().getContentAsString());
    }

    @Test
    @Order(value = 2)
    @DisplayName("2-DETAILS D'UNE MATIERE")
    public void testThatWeCanReadMatiere() throws Exception {

        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/matieres/findById/" + json.getInt("id"))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("CSC352")))
                .andExpect(jsonPath("$.intitule", is("Spring-boot")));

    }

    @Test
    @Order(value = 3)
    @DisplayName("3-LISTE  DES MATIERE")
    public void testThatWeCanShowMatierelist() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/matieres/all")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code", is("CSC352")))
                .andExpect(jsonPath("$[0].intitule", is("Spring-boot")));

    }

    @Test
    @Order(value = 4)
    @DisplayName("4-MODIFIER UNE MATIERE")
    public void testThatWecanUpdateMatiere() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .put("/matieres/update")
                                .content("{"
                                        + "\"id\":" + json.getInt("id") + ","
                                        + "\"code\": \"CSC241\","
                                        + "\"intitule\":\"Python\""
                                        + "}").contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(json.getInt("id"))))
                .andExpect(jsonPath("$.code", is("CSC241")))
                .andExpect(jsonPath("$.intitule", is("Python")));
    }


    @Test
    @Order(value = 5)
    @DisplayName("6-CREER UNE CLASSE")
    public void testThatWecanCreateClasse() throws Exception {
        MvcResult result = this.mvc.perform(
                        MockMvcRequestBuilders
                                .post("/classes/add")
                                .content("{"
                                        + "\"code\": \"AMPHI100\","
                                        + "\"intitule\":\"Salle de Soutenance\""
                                        + "}"
                                ).contentType(MediaType.APPLICATION_JSON)

                ).andDo(print())
                .andExpect(jsonPath("$.code", is("AMPHI100")))
                .andExpect(jsonPath("$.intitule", is("Salle de Soutenance")))
                .andReturn();
        json_classe = new JSONObject(result.getResponse().getContentAsString());

    }

    @Test
    @Order(value = 6)
    @DisplayName("7-DETAILS SUR UNE CLASSE")
    public void testThatWeCanReadClasse() throws Exception {

        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/classes/findById/" + json_classe.getInt("id"))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("AMPHI100")))
                .andExpect(jsonPath("$.intitule", is("Salle de Soutenance")));

    }

    @Test
    @Order(value = 7)
    @DisplayName("8-AFFICHER LA LISTE DES CLASSE")
    public void testThatWeCanShowClasselist() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/classes/all")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code", is("AMPHI100")))
                .andExpect(jsonPath("$[0].intitule", is("Salle de Soutenance")));

    }

    @Test
    @Order(value = 8)
    @DisplayName("9-MODIFIER UNE CLASSE")
    public void testThatWecanUpdateClasse() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .put("/classes/update")
                                .content("{"
                                        + "\"id\":" + json_classe.getInt("id") + ","
                                        + "\"code\": \"RHD\","
                                        + "\"intitule\":\"JAVA3\""
                                        + "}").contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(json_classe.getInt("id"))))
                .andExpect(jsonPath("$.code", is("RHD")))
                .andExpect(jsonPath("$.intitule", is("JAVA3")));
    }


    @Test
    @Order(value = 9)
    @DisplayName("11-CREER UNE ANNEE SCOLAIRE")
    public void testThatWecanCreateAnneeScolaire() throws Exception {
        MvcResult result = this.mvc.perform(
                        MockMvcRequestBuilders
                                .post("/annees/add")
                                .content("{"
                                        + "\"code\": \"CAN\","
                                        + "\"dateDebut\":\"2023-11-05T00:00:00.000+00:00\","
                                        + "\"dateFin\":\"2023-12-20T00:00:00.000+00:00\""
                                        + "}"
                                ).contentType(MediaType.APPLICATION_JSON)

                ).andDo(print())
                .andExpect(jsonPath("$.code", is("CAN")))
                .andExpect(jsonPath("$.dateDebut", is("2023-11-05T00:00:00.000+00:00")))
                .andExpect(jsonPath("$.dateFin", is("2023-12-20T00:00:00.000+00:00")))
                .andReturn();
        json_annee = new JSONObject(result.getResponse().getContentAsString());

    }

    @Test
    @Order(value = 10)
    @DisplayName("12-DETAILS SUR UNE ANNEESCOLAIRE")
    public void testThatWeCanReadAnneScolaire() throws Exception {

        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/annees/findById/" + json_annee.getInt("id"))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("CAN")))
                .andExpect(jsonPath("$.dateDebut", is("2023-11-05T00:00:00.000+00:00")))
                .andExpect(jsonPath("$.dateFin", is("2023-12-20T00:00:00.000+00:00")));

    }


    @Test
    @Order(value = 11)
    @DisplayName("13-AFFICHER LA LISTE DES ANNEE-SCOLAIRE")
    public void testThatWeCanShowAnneescolairelist() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/annees/all")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code", is("CAN")))
                .andExpect(jsonPath("$[0].dateDebut", is("2023-11-05T00:00:00.000+00:00")))
                .andExpect(jsonPath("$[0].dateFin", is("2023-12-20T00:00:00.000+00:00")));

    }


    @Test
    @Order(value = 12)
    @DisplayName("14-MODIFIER UNE ANNEE-SCOLAIRE")
    public void testThatWecanUpdateAnneeScolaire() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .put("/annees/update")
                                .content("{"
                                        + "\"id\":" + json_annee.getInt("id") + ","
                                        + "\"code\": \"CAN2024\","
                                        + "\"dateDebut\":\"2023-11-05T00:00:00.000+00:00\","
                                        + "\"dateFin\":\"2023-12-20T00:00:00.000+00:00\""
                                        + "}").contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(json_annee.getInt("id"))))
                .andExpect(jsonPath("$.code", is("CAN2024")))
                .andExpect(jsonPath("$.dateDebut", is("2023-11-05T00:00:00.000+00:00")))
                .andExpect(jsonPath("$.dateFin", is("2023-12-20T00:00:00.000+00:00"))
                );
    }


    @Test
    @Order(value = 13)
    @DisplayName("16-CREER UN ENSEIGNANT")
    public void testThatWecanCreateEnseignant() throws Exception {
        MvcResult result = this.mvc.perform(
                        MockMvcRequestBuilders
                                .post("/enseigants/add")
                                .content("{"
                                        + "\"nom\": \"BATANA\","
                                        + "\"prenom\":\"Ferdinah\","
                                        + "\"tel\":\"90835024\","
                                        + "\"email\":\"ferdinahbatana@gmail.com\""
                                        + "}"
                                ).contentType(MediaType.APPLICATION_JSON)

                ).andDo(print())
                .andExpect(jsonPath("$.nom", is("BATANA")))
                .andExpect(jsonPath("$.prenom", is("Ferdinah")))
                .andExpect(jsonPath("$.tel", is("90835024")))
                .andExpect(jsonPath("$.email", is("ferdinahbatana@gmail.com")))
                .andReturn();
        json_enseignant = new JSONObject(result.getResponse().getContentAsString());

    }

    @Test
    @Order(value = 14)
    @DisplayName("17-DETAILS SUR UN ENSEIGNAT")
    public void testThatWeCanReadEnseignant() throws Exception {

        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/enseigants/findById/" + json_enseignant.getInt("id"))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", is("BATANA")))
                .andExpect(jsonPath("$.prenom", is("Ferdinah")))
                .andExpect(jsonPath("$.tel", is("90835024")))
                .andExpect(jsonPath("$.email", is("ferdinahbatana@gmail.com"))
                );

    }

    @Test
    @Order(value = 15)
    @DisplayName("18-AFFICHER LA LISTE DES  ENSEIGNANT")
    public void testThatWeCanShowEnseignantlist() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .get("/enseigants/all")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom", is("BATANA")))
                .andExpect(jsonPath("$[0].prenom", is("Ferdinah")))
                .andExpect(jsonPath("$[0].tel", is("90835024")))
                .andExpect(jsonPath("$[0].email", is("ferdinahbatana@gmail.com")));
    }

    @Test
    @Order(value = 16)
    @DisplayName("19-MODIFIER UN ENSEIGNANT")
    public void testThatWecanUpdateEnseignant() throws Exception {
        this.mvc.perform(
                        MockMvcRequestBuilders
                                .put("/enseigants/update")
                                .content("{"
                                        + "\"id\":" + json_enseignant.getInt("id") + ","
                                        + "\"nom\": \"ALI OURO-NILLE\","
                                        + "\"prenom\":\"HODIA\","
                                        + "\"tel\":\"90835024\","
                                        + "\"email\":\"aliahodia@gmail.com\""
                                        + "}").contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(json_enseignant.getInt("id"))))
                .andExpect(jsonPath("$.nom", is("ALI OURO-NILLE")))
                .andExpect(jsonPath("$.prenom", is("HODIA")))
                .andExpect(jsonPath("$.tel", is("90835024")))
                .andExpect(jsonPath("$.email", is("aliahodia@gmail.com")));
    }

    @Test
    @Order(value = 17)
    @DisplayName("21-CREER UN COURS")
    public void testThatWecanCreateCours() throws Exception {
        MvcResult result = this.mvc.perform(
                        MockMvcRequestBuilders
                                .post("/cours/add")
                                .content("{"
                                        + "\"id\":" + 1 + ","
                                        + "\"id_matiere\":" + json.getInt("id") + ","
                                        + "\"id_enseignant\":" + json_enseignant.getInt("id") + ","
                                        + "\"id_classe\":" + json_classe.getInt("id") + ","
                                        + "\"id_annee_scolaire\":" + json_annee.getInt("id") + "}"
                                ).contentType(MediaType.APPLICATION_JSON)

                ).andDo(print())
                .andExpect(jsonPath("$.id_matiere", is(json.getInt("id"))))
                .andExpect(jsonPath("$.id_enseignant", is(json_enseignant.getInt("id"))))
                .andExpect(jsonPath("$.id_classe", is(json_classe.getInt("id"))))
                .andExpect(jsonPath("$.id_annee_scolaire", is(json_annee.getInt("id"))))
                .andReturn();
        json_cours = new JSONObject(result.getResponse().getContentAsString());

    }


//
//    @Test
//   @Order(value = 18)
//    @DisplayName("17-DETAILS SUR UN COURS")
//    public void testThatWeCanReadCours() throws Exception {
//
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/cours/findById/" + json_cours.getInt("id"))
//                ).andDo(print())
//                .andExpect(jsonPath("$.matiere.matiere_id", is(1)))
//                .andExpect(jsonPath("$.enseignant.enseignant_id", is(json_enseignant.getInt("id"))))
//                .andExpect(jsonPath("$.classe.classe_id", is(json_classe.getInt("id"))))
//                .andExpect(jsonPath("$.anneeScolaire", is(json_annee.getInt("id")))
//                );
//
//    }




    ////##############################################################
//    @Test
//    @Order(value = 23)
//    @DisplayName("5-SUPRIMER UNE MATIERE")
//    public void testThatDeleteMatiere() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .delete("/matieres/delete/" + json.getInt("id"))
//                ).andDo(print())
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    @Order(value = 20)
//    @DisplayName("10-SUPPRIMER UNE CLASSE")
//    public void testThatDeleteClasse() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .delete("/classes/delete/" + json_classe.getInt("id"))
//                ).andDo(print())
//                .andExpect(status().isOk());
//
//    }

//    @Test
//    @Order(value = 21)
//    @DisplayName("15-SUPPRIMER UNE ANNEE-SCOLAIRE ")
//    public void testThatDeleteAnneeScolaire() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .delete("/annees/delete/" + json_annee.getInt("id"))
//                ).andDo(print())
//                .andExpect(status().isOk());
//
//    }

//    @Test
//    @Order(value = 22)
//    @DisplayName("20-SUPPRIMER UNE ENSEIGNANT ")
//    public void testThatDeleteEnseignant() throws Exception {
//        this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .delete("/enseigants/delete/" + json_enseignant.getInt("id"))
//                ).andDo(print())
//                .andExpect(status().isOk());
//
//
//    }

//    @Test
//    @Order(value =19 )
//    @DisplayName("19-CREER UN EMPLOI")
//    public void testThatWecanCreateEmploiTemp() throws Exception {
//        MvcResult result = this.mvc.perform(
//                        MockMvcRequestBuilders
//                                .post("/emplois/add")
//                                .content("{"
//                                        + "\"id\":" + 1 + ","
//                                        + "\"enseignant\":" + json_enseignant.getInt("id") + ","
//                                        + "\"matiere\":" + json.getInt("id") + ","
//                                        + "\"heureDebut\":\"12:00:03\","
//                                        + "\"heureFin\":\"13:00:03\","
//                                        + "\"salle\":" + json_classe.getInt("id") + "}"
//                                ).contentType(MediaType.APPLICATION_JSON)
//
//                ).andDo(print())
//                .andExpect(jsonPath("$.enseignant", is(json_enseignant.getInt("id"))))
//                .andExpect(jsonPath("$.matiere", is(json.getInt("id"))))
//                .andExpect(jsonPath("$.salle", is(json_classe.getInt("id"))))
//                .andExpect(jsonPath("$.heureDebut", is("12:00:03")))
//                .andExpect(jsonPath("$.heureFin", is("13:00:03")))
//                .andReturn();
//        json_emploi = new JSONObject(result.getResponse().getContentAsString());
//
//    }

}





