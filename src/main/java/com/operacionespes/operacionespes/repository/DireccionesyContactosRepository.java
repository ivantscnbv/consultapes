package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DireccionesyContactosRepository extends JpaRepository<RelacionesArbol,Integer> {

    // Consulta para obtener los ArbolId
    @Query(value = "SELECT ArbolId " +
            "FROM RelacionesArbol " +
            "WHERE PersonaMoralId = :PersonaMoralId AND SubSectorId = :SubSectorId ",
            nativeQuery = true)
    List<Integer> obtenerArbolIds(@Param("PersonaMoralId") Integer personaMoralId,
                                  @Param("SubSectorId") Integer subSectorId);

    @Query(value = "SELECT a.DireccionId, " +
            "a.TipoDireccionId AS tipoDireccionId, " +
            "RTRIM(f.TipoDireccionNombre) AS tipoDireccionDescripcion, " +
            "RTRIM(a.DireccionCalle) AS calleNumero, " +
            "RTRIM(a.DireccionCiudad) AS Ciudad, " +
            "a.DireccionCP AS codigoPostal, " +
            "RTRIM(c.ColoniaNombreLargo) AS Colonia, " +
            "a.DireccionColonia AS ColoniaId, " +
            "RTRIM(d.MunicipioNombreLargo) AS DelOMup, " +
            "a.DireccionDelegacion AS delegacionMunicipioId, " +
            "RTRIM(e.EstadoPaisNombre) AS Estado, " +
            "a.EstadoPaisId, " +
            "RTRIM(b.PaisNombre) AS Pais, " +
            "a.PaisId, " +
            "RTRIM(a.DireccionTelefono) AS Telefono, " +
            "RTRIM(a.DireccionFax) AS faxes, " +
            "RTRIM(es.EstadoId) AS Activos " +
            "FROM RelacionesDirecciones a, " +
            "Paises b, " +
            "Colonia c, " +
            "MunicipioDel d, " +
            "EstadoPais e, " +
            "TipoDireccion f, " +
            "Estados es " +
            "WHERE a.PaisId = b.PaisId " +
            "AND a.DireccionColonia = c.ColoniaId " +
            "AND a.DireccionDelegacion = c.MunicipioId " +
            "AND a.EstadoPaisId = c.EstadoMunicipioId " +
            "AND a.DireccionDelegacion = d.MunicipioId " +
            "AND a.EstadoPaisId = d.EstadoMunicipioId " +
            "AND a.EstadoPaisId = e.EstadoPaisId " +
            "AND a.PaisId = e.PaisId " +
            "AND a.TipoDireccionId = f.TipoDireccionId " +
            "AND es.EstadoId = 1 " +
            "AND a.RelacionesArbol_ArbolId = :ArbolId ",
            nativeQuery = true)
    List<Object[]> obtenerDireccionesyContactosQuery(@Param("ArbolId") Integer ArbolId);

    @Query( value = "SELECT RTRIM(c.ContactoTitulo) AS Titulo,\n" +
            "RTRIM(c.ContactoNombre) AS Nombre,\n" +
            "RTRIM(c.ContactoPaterno) AS paterno,\n" +
            "RTRIM(c.ContactoMaterno) AS materno,\n" +
            "c.CargoId as cargoId,\n" +
            "RTRIM(d.CargoNombre) AS cargoDescripcion\n" +
            "FROM RelacionesContactos c JOIN\n" +
            "Cargos d ON (c.CargoId=d.CargoId)\n" +
            "JOIN RelacionesDirecciones rd ON rd.RelacionesArbol_ArbolId = c.ArbolId\n" +
            "WHERE \n" +
            "c.EstadoId=1 AND\n" +
            "--d.EstadoId=1 AND (el estado del cargo no debe afectar a la consulta de contactos)\n" +
            "rd.EstadoId = 1 AND\n" +
            "rd.DireccionId= :DireccionId",nativeQuery = true)

    List<Object[]> obtenerDireccionesIdQuery(@Param("DireccionId") Integer DireccionId);

}
