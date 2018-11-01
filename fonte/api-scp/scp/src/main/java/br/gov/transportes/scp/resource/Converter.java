/**
 * @author transportes
 * @date 23/10/2015
 * @file Converter.java
 */

package br.gov.transportes.scp.resource;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


/**
 * @author transportes
 * @date 23/10/2015
 * @class Converter
 * @description
 */
public class Converter {

    private static final Logger LOGGER = Logger.getLogger(Converter.class);

    /**
     * Constructor
     */
    private Converter() {
        // para nao ser instanciada
        super();
    }


    /**
     * Atribui os valores de campos correspondentes de uma string Json para o objeto de destino.
     * 
     * @param String jsonString
     * @param objetoDestino
     * @return
     * @throws NegocioException
     */
    public static <T1> T1 convertJSONToObject(String jsonString, Class<T1> classeDestino) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            if (jsonString != null && classeDestino != null) {
                return mapper.readValue(jsonString, classeDestino);
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Atribui os valores de campos correspondentes de uma lista Json para uma lista do objeto de
     * destino.
     * 
     * @param String jsonString
     * @param objetoDestino
     * @return
     * @throws NegocioException
     */
    public static <T1> List<T1> convertJSONToList(String jsonList, Class<T1> classeDestino) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            if (jsonList != null && classeDestino != null) {
                return mapper.readValue(jsonList,
                        TypeFactory.defaultInstance().constructCollectionType(List.class, classeDestino));
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }


    /**
     * Atribui os valores de campos objeto para uma string JSON.
     * 
     * @description
     * @param objetoOrigem
     * @return
     * @throws NegocioException
     */
    public static <T1> String convertObjectToJSON(T1 objetoOrigem) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(objetoOrigem);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }


    /**
     * Atribui os valores de campos correspondentes de um objeto para um outro objeto de destino. Os
     * campos do objeto de destino que ja estiverem preenchidos nao serao substituidos
     * 
     * @param objetoOrigem
     * @param objetoDestino
     * @return
     * @throws NegocioException
     */
    public static <T1, T2> T2 convertEntity(T1 objetoOrigem, T2 objetoDestino) throws Exception {

        if (objetoOrigem != null && objetoDestino != null) {
            Class<? extends Object> classe = objetoOrigem.getClass();
            Class<? extends Object> classeDestino = objetoDestino.getClass();

            Field[] listaCampos = classe.getDeclaredFields();
            for (int i = 0; i < listaCampos.length; i++) {
                Field campo = listaCampos[i];
                try {
                    Field campoDestino = classeDestino.getDeclaredField(campo.getName());
                    campo.setAccessible(true);
                    campoDestino.setAccessible(true);
                    atribuiValorAoDestino(objetoOrigem, objetoDestino, campo, campoDestino);
                } catch (NoSuchFieldException e) {
                    LOGGER.log(Logger.Level.TRACE, e);
                    continue;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    LOGGER.error(e.getMessage(), e);
                    throw new Exception(e.getMessage());
                }
            }
        }
        return objetoDestino;
    }

    /**
     * Atribui os valores de campos correspondentes de um objeto para um outro objeto de destino. Os
     * campos do objeto de destino que ja estiverem preenchidos nao serao substituidos
     * 
     * @param objetoOrigem
     * @param objetoDestino
     * @return
     * @throws NegocioException
     */
    public static <T1, T2> List<T2> convertEntityList(List<T1> listaObjetoOrigem, Class<T2> classeObjDestino)
            throws Exception {
        List<T2> listaRetorno = new ArrayList<T2>();
        for (T1 objetoOrigem : listaObjetoOrigem) {
            try {
                T2 objetoDestino = classeObjDestino.newInstance();
                objetoDestino = convertEntity(objetoOrigem, objetoDestino);
                listaRetorno.add(objetoDestino);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new Exception(e.getMessage(), e);
            }

        }
        return listaRetorno;
    }

    /**
     * Atribui valor ao destino quanto necessario
     * 
     * @param objetoOrigem
     * @param objetoDestino
     * @param campo
     * @param campoDestino
     * @throws IllegalAccessException
     */
    private static void atribuiValorAoDestino(Object objetoOrigem, Object objetoDestino, Field campo, Field campoDestino)
            throws IllegalAccessException {
        if (campoDestino.get(objetoDestino) == null && campoDestino.getType().equals(campo.getType())) {
            campoDestino.set(objetoDestino, campo.get(objetoOrigem));
        }
    }


    /**
     * @param <T, T1>
     * @method pegarValorCampo
     * @date 05/10/2015
     * @returnType RelatorioEscolhaTO
     * @param objetoOrigem
     * @param nomeCamposSelecionados
     * @return
     * @throws NegocioException
     * @description Metodo responsavel por preencher o objeto destino apenas com os atributos que
     *              foram escolhidos
     */
    public static <T1> T1 preencherCamposEscolhidos(Object objetoOrigem, List<String> nomeCamposSelecionados,
            Class<T1> classeObjDestino) throws Exception {
        try {
            Class<? extends Object> classeObjOrigem = objetoOrigem.getClass();
            T1 objetoDestino = classeObjDestino.newInstance();
            for (String nomeCampo : nomeCamposSelecionados) {
                preencherCampo(objetoDestino, objetoOrigem, classeObjOrigem, classeObjDestino, nomeCampo);
            }
            return objetoDestino;
        } catch (SecurityException | IllegalAccessException | InstantiationException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * @method preencherCampo
     * @date 07/12/2015
     * @returnType void
     * @param objetoDestino
     * @param objetoOrigem
     * @param campoOrigem
     * @param campoDestino
     * @param valorCampo
     * @param classeObjOrigem
     * @param classeObjDestino
     * @param nomeCampo
     * @description Metodo criado para separar parte do codigo do converter generico, atendendo
     *              assim o sonar
     */
    private static <T, T1> void preencherCampo(T1 objetoDestino, Object objetoOrigem, Class<T> classeObjOrigem,
            Class<T1> classeObjDestino, String nomeCampo) {
        Field campoOrigem;
        Field campoDestino;
        Object valorCampo;
        try {
            campoOrigem = classeObjOrigem.getDeclaredField(nomeCampo);
            campoDestino = classeObjDestino.getDeclaredField(nomeCampo);
            campoOrigem.setAccessible(true);
            campoDestino.setAccessible(true);
            valorCampo = campoOrigem.get(objetoOrigem);
            campoDestino.set(objetoDestino, valorCampo);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            LOGGER.log(Logger.Level.TRACE, e);
            // nao fazer nada
        }
    }
}
