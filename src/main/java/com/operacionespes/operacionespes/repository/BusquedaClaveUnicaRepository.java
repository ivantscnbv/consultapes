package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaClaveUnicaRepository extends JpaRepository<RelacionesArbol, Integer> {

    @Query(value = "SELECT a.ArbolId, " +
            "a.PersonaMoralId AS Clave_PES, " +
            "a.SubSectorId, " +
            "TRIM(b.PersonaMoralRazonSocial) AS Razón_Social, " +
            "b.PersonaMoralNomcorto AS NombreCorto, " +
            "b.PersonaMoralRFC AS RFC, " +
            "b.PersonaMoralFechaConstitucion AS FechaConstitucion, " +
            "CASE a.Filial " +
            "WHEN 1 THEN 'Filia' " +
            "ELSE 'Nacional' " +
            "END AS Origen, " +
            "a.AreaId, " +
            "COALESCE(a.PadrePersonaMoralId, 0) AS Tenedoraid, " +
            "COALESCE(a.GrupoFinanciero, 0) AS GrupoFinanciero, " +
            "a.SituacionId, " +
            "d.EstatusId, " +
            "f.GrupoEstatusId " +
            "FROM RelacionesArbol a, " +
            "PersonasMorales b, " +
            "SubSectores c, " +
            "Situaciones d, " +
            "Estatus f, " +
            "Areas g " +
            "WHERE " +
            "a.PersonaMoralId = b.PersonaMoralId AND " +
            "a.SubSectorId = c.SubSectorId AND " +
            "a.SituacionId = d.SituacionId AND " +
            "d.EstatusId = f.EstatusId AND " +
            "a.AreaId = g.AreaId AND " +
            "a.EstadoId = 1 AND " +
            "b.EstadoId = 1 AND " +
            "c.EstadoId = 1 AND " +
            "d.EstadoId = 1 AND " +
            "f.EstadoId = 1 AND " +
            "g.EstadoId = 1 AND " +
            "a.ArbolId = :ArbolId")
    List<Object[]> queryDatosGenerales(@Param("ArbolId") Integer ArbolId);

    @Query(value = "SELECT r.ClaveDinamicaId AS ClaveId, r.Valor_ClaveDinamica AS Valor " +
            "FROM RelacionesClavesDinamicasArbol r " +
            "WHERE r.RelacionesArbol_ArbolId = :ArbolId")
    List<Object[]> queryClavesDinamicas(@Param("ArbolId") Integer ArbolId);

    @Query(value = "SELECT " +
            "    a.TipoDireccionId AS TipoDireccion, " +
            "    TRIM(a.DireccionCalle) AS Calle, " +
            "    a.DireccionCP AS CP, " +
            "    TRIM(c.ColoniaNombreLargo) AS Colonia, " +
            "    TRIM(d.MunicipioNombreLargo) AS DelOMup, " +
            "    TRIM(e.EstadoPaisNombre) AS Estado, " +
            "    TRIM(b.PaisNombre) AS Pais, " +
            "    a.DireccionTelefono AS Telefono " +
            "FROM " +
            "    RelacionesDirecciones a, " +
            "    Paises b, " +
            "    Colonia c, " +
            "    MunicipioDel d, " +
            "    EstadoPais e " +
            "WHERE " +
            "    a.PaisId = b.PaisId AND " +
            "    a.DireccionColonia = c.ColoniaId AND " +
            "    a.DireccionDelegacion = c.MunicipioId AND " +
            "    a.EstadoPaisId = c.EstadoMunicipioId AND " +
            "    a.DireccionDelegacion = d.MunicipioId AND " +
            "    a.EstadoPaisId = d.EstadoMunicipioId AND " +
            "    a.EstadoPaisId = e.EstadoPaisId AND " +
            "    a.PaisId = e.PaisId AND " +
            "    a.RelacionesArbol_ArbolId = :ArbolId")
    List<Object[]> queryDirecciones(@Param("ArbolId") Integer ArbolId);

    @Query(value = "SELECT TRIM(c.ContactoTitulo) AS Titulo, " +
            "       TRIM(c.ContactoNombre) AS Nombre, " +
            "       TRIM(c.ContactoPaterno) AS ApellidoPaterno, " +
            "       TRIM(c.ContactoMaterno) AS ApellidoMaterno, " +
            "       c.CargoId AS Cargo " +
            "FROM RelacionesContactos c " +
            "WHERE c.ArbolId = :ArbolId")
    List<Object[]> queryContactos(@Param("ArbolId") Integer ArbolId);
}
