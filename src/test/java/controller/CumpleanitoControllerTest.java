package controller;

import com.example.FutbolManager.AbstractController;
import com.example.FutbolManager.services.CumpleanitoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CumpleanitoControllerTest extends AbstractController {
    @MockBean
    private CumpleanitoService cumpleanitoService;

    @Test
    public void getListaDePagos() throws Exception{
    final ResultActions resultActions =givenController().perform(MockMvcRequestBuilders
            .get("/cumpleanito")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
