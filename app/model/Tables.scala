package model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = Catalogo.schema ++ Categoria.schema ++ Prenda.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Catalogo
   *  @param idcatalogo Database column idCatalogo SqlType(INT), PrimaryKey
   *  @param idtipo Database column idTipo SqlType(INT), Default(None)
   *  @param nombre Database column nombre SqlType(VARCHAR), Length(255,true)
   *  @param orden Database column orden SqlType(INT) */
  case class CatalogoRow(idcatalogo: Int, idtipo: Option[Int] = None, nombre: String, orden: Int)
  /** GetResult implicit for fetching CatalogoRow objects using plain SQL queries */
  implicit def GetResultCatalogoRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[String]): GR[CatalogoRow] = GR{
    prs => import prs._
    CatalogoRow.tupled((<<[Int], <<?[Int], <<[String], <<[Int]))
  }
  /** Table description of table catalogo. Objects of this class serve as prototypes for rows in queries. */
  class Catalogo(_tableTag: Tag) extends Table[CatalogoRow](_tableTag, "catalogo") {
    def * = (idcatalogo, idtipo, nombre, orden) <> (CatalogoRow.tupled, CatalogoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(idcatalogo), idtipo, Rep.Some(nombre), Rep.Some(orden)).shaped.<>({r=>import r._; _1.map(_=> CatalogoRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column idCatalogo SqlType(INT), PrimaryKey */
    val idcatalogo: Rep[Int] = column[Int]("idCatalogo", O.PrimaryKey)
    /** Database column idTipo SqlType(INT), Default(None) */
    val idtipo: Rep[Option[Int]] = column[Option[Int]]("idTipo", O.Default(None))
    /** Database column nombre SqlType(VARCHAR), Length(255,true) */
    val nombre: Rep[String] = column[String]("nombre", O.Length(255,varying=true))
    /** Database column orden SqlType(INT) */
    val orden: Rep[Int] = column[Int]("orden")
  }
  /** Collection-like TableQuery object for table Catalogo */
  lazy val Catalogo = new TableQuery(tag => new Catalogo(tag))

  /** Entity class storing rows of table Categoria
   *  @param idcategoria Database column idCategoria SqlType(INT), PrimaryKey
   *  @param nombre Database column nombre SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param descripcion Database column descripcion SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param idpadre Database column idPadre SqlType(INT), Default(None)
   *  @param porcentajeprestamo Database column porcentajePrestamo SqlType(DECIMAL), Default(None)
   *  @param limiterefrendos Database column limiteRefrendos SqlType(INT), Default(None)
   *  @param limitemonto Database column limiteMonto SqlType(DECIMAL), Default(None) */
  case class CategoriaRow(idcategoria: Int, nombre: Option[String] = None, descripcion: Option[String] = None, idpadre: Option[Int] = None, porcentajeprestamo: Option[scala.math.BigDecimal] = None, limiterefrendos: Option[Int] = None, limitemonto: Option[scala.math.BigDecimal] = None)
  /** GetResult implicit for fetching CategoriaRow objects using plain SQL queries */
  implicit def GetResultCategoriaRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[scala.math.BigDecimal]]): GR[CategoriaRow] = GR{
    prs => import prs._
    CategoriaRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int], <<?[scala.math.BigDecimal], <<?[Int], <<?[scala.math.BigDecimal]))
  }
  /** Table description of table categoria. Objects of this class serve as prototypes for rows in queries. */
  class Categoria(_tableTag: Tag) extends Table[CategoriaRow](_tableTag, "categoria") {
    def * = (idcategoria, nombre, descripcion, idpadre, porcentajeprestamo, limiterefrendos, limitemonto) <> (CategoriaRow.tupled, CategoriaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(idcategoria), nombre, descripcion, idpadre, porcentajeprestamo, limiterefrendos, limitemonto).shaped.<>({r=>import r._; _1.map(_=> CategoriaRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column idCategoria SqlType(INT), PrimaryKey */
    val idcategoria: Rep[Int] = column[Int]("idCategoria", O.PrimaryKey)
    /** Database column nombre SqlType(VARCHAR), Length(255,true), Default(None) */
    val nombre: Rep[Option[String]] = column[Option[String]]("nombre", O.Length(255,varying=true), O.Default(None))
    /** Database column descripcion SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val descripcion: Rep[Option[String]] = column[Option[String]]("descripcion", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column idPadre SqlType(INT), Default(None) */
    val idpadre: Rep[Option[Int]] = column[Option[Int]]("idPadre", O.Default(None))
    /** Database column porcentajePrestamo SqlType(DECIMAL), Default(None) */
    val porcentajeprestamo: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("porcentajePrestamo", O.Default(None))
    /** Database column limiteRefrendos SqlType(INT), Default(None) */
    val limiterefrendos: Rep[Option[Int]] = column[Option[Int]]("limiteRefrendos", O.Default(None))
    /** Database column limiteMonto SqlType(DECIMAL), Default(None) */
    val limitemonto: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("limiteMonto", O.Default(None))
  }
  /** Collection-like TableQuery object for table Categoria */
  lazy val Categoria = new TableQuery(tag => new Categoria(tag))

  /** Entity class storing rows of table Prenda
   *  @param idprenda Database column idPrenda SqlType(INT), PrimaryKey
   *  @param idcategoria Database column idCategoria SqlType(INT), Default(None)
   *  @param piezas Database column piezas SqlType(INT), Default(None)
   *  @param serie Database column serie SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param porcentajeprestamo Database column porcentajePrestamo SqlType(FLOAT), Default(None)
   *  @param idsubcategoria Database column idSubcategoria SqlType(INT), Default(None)
   *  @param descripcion Database column descripcion SqlType(TEXT), Default(None)
   *  @param prestamo Database column prestamo SqlType(FLOAT), Default(None)
   *  @param modelo Database column modelo SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param avaluo Database column avaluo SqlType(FLOAT), Default(None) */
  case class PrendaRow(idprenda: Int, idcategoria: Option[Int] = None, piezas: Option[Int] = None, serie: Option[String] = None, porcentajeprestamo: Option[Float] = None, idsubcategoria: Option[Int] = None, descripcion: Option[String] = None, prestamo: Option[Float] = None, modelo: Option[String] = None, avaluo: Option[Float] = None)
  /** GetResult implicit for fetching PrendaRow objects using plain SQL queries */
  implicit def GetResultPrendaRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Float]]): GR[PrendaRow] = GR{
    prs => import prs._
    PrendaRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[String], <<?[Float], <<?[Int], <<?[String], <<?[Float], <<?[String], <<?[Float]))
  }
  /** Table description of table prenda. Objects of this class serve as prototypes for rows in queries. */
  class Prenda(_tableTag: Tag) extends Table[PrendaRow](_tableTag, "prenda") {
    def * = (idprenda, idcategoria, piezas, serie, porcentajeprestamo, idsubcategoria, descripcion, prestamo, modelo, avaluo) <> (PrendaRow.tupled, PrendaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(idprenda), idcategoria, piezas, serie, porcentajeprestamo, idsubcategoria, descripcion, prestamo, modelo, avaluo).shaped.<>({r=>import r._; _1.map(_=> PrendaRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column idPrenda SqlType(INT), PrimaryKey */
    val idprenda: Rep[Int] = column[Int]("idPrenda", O.PrimaryKey)
    /** Database column idCategoria SqlType(INT), Default(None) */
    val idcategoria: Rep[Option[Int]] = column[Option[Int]]("idCategoria", O.Default(None))
    /** Database column piezas SqlType(INT), Default(None) */
    val piezas: Rep[Option[Int]] = column[Option[Int]]("piezas", O.Default(None))
    /** Database column serie SqlType(VARCHAR), Length(50,true), Default(None) */
    val serie: Rep[Option[String]] = column[Option[String]]("serie", O.Length(50,varying=true), O.Default(None))
    /** Database column porcentajePrestamo SqlType(FLOAT), Default(None) */
    val porcentajeprestamo: Rep[Option[Float]] = column[Option[Float]]("porcentajePrestamo", O.Default(None))
    /** Database column idSubcategoria SqlType(INT), Default(None) */
    val idsubcategoria: Rep[Option[Int]] = column[Option[Int]]("idSubcategoria", O.Default(None))
    /** Database column descripcion SqlType(TEXT), Default(None) */
    val descripcion: Rep[Option[String]] = column[Option[String]]("descripcion", O.Default(None))
    /** Database column prestamo SqlType(FLOAT), Default(None) */
    val prestamo: Rep[Option[Float]] = column[Option[Float]]("prestamo", O.Default(None))
    /** Database column modelo SqlType(VARCHAR), Length(50,true), Default(None) */
    val modelo: Rep[Option[String]] = column[Option[String]]("modelo", O.Length(50,varying=true), O.Default(None))
    /** Database column avaluo SqlType(FLOAT), Default(None) */
    val avaluo: Rep[Option[Float]] = column[Option[Float]]("avaluo", O.Default(None))
  }
  /** Collection-like TableQuery object for table Prenda */
  lazy val Prenda = new TableQuery(tag => new Prenda(tag))
}
