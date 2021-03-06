package org.libsdl.openxcom.config;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexey on 06.08.2015.
 */
public class Xcom2DataChecker implements DataChecker {

    private final static String SUBDIR_NAME = "TFTD";

    private final static String[] CommonDirs = {
            "anims",
            "flop_int",
            "geodata",
            "geograph",
            "maps",
            "routes",
            "sound",
            "terrain",
            "ufograph",
            "units"
    };

    private final static String[] CommonFiles = {
            // GEODATA:
            "backpals.dat" ,
            "biglets.dat" ,
            "cos.dat" ,
            "english.dat" ,
            "english2.dat" ,
            "french.dat" ,
            "french2.dat" ,
            "german.dat" ,
            "german2.dat" ,
            "interwin.dat" ,
            "lang1.dat" ,
            "lang2.dat" ,
            "lang3.dat" ,
            "loftemps.dat" ,
            "obdata.dat" ,
            "palettes.dat" ,
            "scang.dat" ,
            "sine.dat" ,
            "smallset.dat" ,
            "spanish.dat" ,
            "spanish2.dat" ,
            "world.dat" ,

            // geograph:
            "back01.scr" ,
            "back02.scr" ,
            "back03.scr" ,
            "back04.scr" ,
            "back05.scr" ,
            "back06.scr" ,
            "back07.scr" ,
            "back08.scr" ,
            "back12.scr" ,
            "back13.scr" ,
            "back14.scr" ,
            "back15.scr" ,
            "back16.scr" ,
            "back17.scr" ,
            "backg.lbm" ,
            "basebits.pck" ,
            "basebits.tab" ,
            "geobord.scr" ,
            "graph.bdy" ,
            "graphs.spk" ,
            "inticon.pck" ,
            "inticon.tab" ,
            "texture.dat" ,
            "up001.bdy" ,
            "up002.bdy" ,
            "up003.bdy" ,
            "up004.bdy" ,
            "up005.bdy" ,
            "up006.bdy" ,
            "up007.bdy" ,
            "up008.bdy" ,
            "up009.bdy" ,
            "up010.bdy" ,
            "up011.bdy" ,
            "up012.bdy" ,
            "up013.bdy" ,
            "up014.bdy" ,
            "up015.bdy" ,
            "up016.bdy" ,
            "up017.bdy" ,
            "up018.bdy" ,
            "up019.bdy" ,
            "up020.bdy" ,
            "up021.bdy" ,
            "up022.bdy" ,
            "up023.bdy" ,
            "up024.bdy" ,
            "up025.bdy" ,
            "up026.bdy" ,
            "up027.bdy" ,
            "up028.bdy" ,
            "up029.bdy" ,
            "up030.bdy" ,
            "up031.bdy" ,
            "up032.bdy" ,
            "up033.bdy" ,
            "up034.bdy" ,
            "up035.bdy" ,
            "up036.bdy" ,
            "up037.bdy" ,
            "up038.bdy" ,
            "up039.bdy" ,
            "up040.bdy" ,
            "up041.bdy" ,
            "up042.bdy" ,
            "up043.bdy" ,
            "up044.bdy" ,
            "up045.bdy" ,
            "up046.bdy" ,
            "up047.bdy" ,
            "up048.bdy" ,
            "up049.bdy" ,
            "up050.bdy" ,
            "up051.bdy" ,
            "up052.bdy" ,
            "up053.bdy" ,
            "up054.bdy" ,
            "up055.bdy" ,
            "up056.bdy" ,
            "up057.bdy" ,
            "up058.bdy" ,
            "up059.bdy" ,
            "up060.bdy" ,
            "up061.bdy" ,
            "up062.bdy" ,
            "up063.bdy" ,
            "up064.bdy" ,
            "up065.bdy" ,
            "up066.bdy" ,
            "up067.bdy" ,
            "up068.bdy" ,
            "up069.bdy" ,
            "up070.bdy" ,
            "up071.bdy" ,
            "up072.bdy" ,
            "up073.bdy" ,
            "up074.bdy" ,
            "up075.bdy" ,
            "up076.bdy" ,
            "up077.bdy" ,
            "up078.bdy" ,
            "up079.bdy" ,
            "up080.bdy" ,
            "up081.bdy" ,
            "up082.bdy" ,
            "up083.bdy" ,
            "up084.bdy" ,
            "up085.bdy" ,
            "up086.bdy" ,
            "up087.bdy" ,
            "up088.bdy" ,
            "up089.bdy" ,
            "up090.bdy" ,
            "up091.bdy" ,
            "up092.bdy" ,
            "up093.bdy" ,
            "up094.bdy" ,
            "up095.bdy" ,
            "up096.bdy" ,
            "up097.bdy" ,
            "up098.bdy" ,
            "up099.bdy" ,
            "up100.bdy" ,
            "up101.bdy" ,
            "up102.bdy" ,
            "up103.bdy" ,
            "up104.bdy" ,
            "up105.bdy" ,
            "up106.bdy" ,
            "up107.bdy" ,
            "up108.bdy" ,
            "up109.bdy" ,
            "up110.bdy" ,
            "up111.bdy" ,
            "up112.bdy" ,
            "up_bord2.scr" ,

            // maps:
            "alart00.map" ,
            "alart01.map" ,
            "alart02.map" ,
            "alart03.map" ,
            "alart04.map" ,
            "alart05.map" ,
            "alart06.map" ,
            "alart07.map" ,
            "alart08.map" ,
            "alart09.map" ,
            "alart10.map" ,
            "alart11.map" ,
            "alship00.map" ,
            "alship01.map" ,
            "alship02.map" ,
            "alship03.map" ,
            "alship04.map" ,
            "alship05.map" ,
            "alship06.map" ,
            "alship07.map" ,
            "alship08.map" ,
            "alship09.map" ,
            "alship10.map" ,
            "alship11.map" ,
            "alship12.map" ,
            "alship13.map" ,
            "alship14.map" ,
            "alship15.map" ,
            "alship16.map" ,
            "alship17.map" ,
            "atlan00.map" ,
            "atlan01.map" ,
            "atlan02.map" ,
            "atlan03.map" ,
            "atlan04.map" ,
            "atlan05.map" ,
            "atlan06.map" ,
            "atlan07.map" ,
            "atlan08.map" ,
            "atlan09.map" ,
            "atlan10.map" ,
            "atlan11.map" ,
            "atlan12.map" ,
            "a_base00.map" ,
            "a_base01.map" ,
            "a_base02.map" ,
            "a_base03.map" ,
            "a_base04.map" ,
            "a_base05.map" ,
            "a_base06.map" ,
            "a_base07.map" ,
            "a_base08.map" ,
            "a_base09.map" ,
            "a_base10.map" ,
            "a_base11.map" ,
            "a_base12.map" ,
            "a_base13.map" ,
            "a_base14.map" ,
            "a_base15.map" ,
            "cargo00.map" ,
            "cargo01.map" ,
            "cargo02.map" ,
            "coral00.map" ,
            "coral01.map" ,
            "coral02.map" ,
            "coral03.map" ,
            "coral04.map" ,
            "coral05.map" ,
            "coral06.map" ,
            "coral07.map" ,
            "coral08.map" ,
            "coral09.map" ,
            "coral10.map" ,
            "coral11.map" ,
            "coral12.map" ,
            "crypt01.map" ,
            "crypt02.map" ,
            "crypt03.map" ,
            "crypt04.map" ,
            "crypt05.map" ,
            "crypt06.map" ,
            "crypt07.map" ,
            "crypt08.map" ,
            "crypt09.map" ,
            "entry00.map" ,
            "entry01.map" ,
            "entry02.map" ,
            "entry03.map" ,
            "entry04.map" ,
            "entry05.map" ,
            "entry06.map" ,
            "entry07.map" ,
            "entry08.map" ,
            "gal01.map" ,
            "gal02.map" ,
            "gal03.map" ,
            "gal04.map" ,
            "gal05.map" ,
            "gal06.map" ,
            "gal07.map" ,
            "gal08.map" ,
            "gal09.map" ,
            "gal10.map" ,
            "gal11.map" ,
            "gal12.map" ,
            "gal13.map" ,
            "gal14.map" ,
            "gal15.map" ,
            "gal16.map" ,
            "grunge00.map" ,
            "grunge01.map" ,
            "grunge02.map" ,
            "grunge03.map" ,
            "grunge04.map" ,
            "grunge05.map" ,
            "grunge06.map" ,
            "grunge07.map" ,
            "grunge08.map" ,
            "grunge09.map" ,
            "grunge10.map" ,
            "grunge11.map" ,
            "grunge12.map" ,
            "grunge13.map" ,
            "grunge14.map" ,
            "grunge15.map" ,
            "grunge16.map" ,
            "hammer.map" ,
            "hammer1.map" ,
            "hammer2.map" ,
            "island00.map" ,
            "island01.map" ,
            "island02.map" ,
            "island03.map" ,
            "island04.map" ,
            "island05.map" ,
            "island06.map" ,
            "island07.map" ,
            "island08.map" ,
            "island09.map" ,
            "island10.map" ,
            "island11.map" ,
            "island12.map" ,
            "island13.map" ,
            "island14.map" ,
            "level01.map" ,
            "level02.map" ,
            "level03.map" ,
            "level04.map" ,
            "level05.map" ,
            "level06.map" ,
            "level07.map" ,
            "level08.map" ,
            "level09.map" ,
            "leviath.map" ,
            "linerb02.map" ,
            "linerb03.map" ,
            "linert00.map" ,
            "linert01.map" ,
            "linert02.map" ,
            "maps" ,
            "msunk00.map" ,
            "msunk01.map" ,
            "msunk02.map" ,
            "msunk03.map" ,
            "msunk04.map" ,
            "msunk05.map" ,
            "msunk06.map" ,
            "msunk07.map" ,
            "msunk08.map" ,
            "msunk09.map" ,
            "msunk10.map" ,
            "msunk11.map" ,
            "msunk12.map" ,
            "msunk13.map" ,
            "mu00.map" ,
            "mu01.map" ,
            "mu02.map" ,
            "mu03.map" ,
            "mu04.map" ,
            "mu05.map" ,
            "mu06.map" ,
            "mu07.map" ,
            "mu08.map" ,
            "mu09.map" ,
            "mu10.map" ,
            "mu11.map" ,
            "mu12.map" ,
            "mu13.map" ,
            "mu14.map" ,
            "pipes00.map" ,
            "pipes01.map" ,
            "pipes02.map" ,
            "pipes03.map" ,
            "pipes04.map" ,
            "pipes05.map" ,
            "pipes06.map" ,
            "pipes07.map" ,
            "pipes08.map" ,
            "pipes09.map" ,
            "pipes10.map" ,
            "pipes11.map" ,
            "plane.map" ,
            "plane00.map" ,
            "plane01.map" ,
            "plane02.map" ,
            "plane03.map" ,
            "plane04.map" ,
            "plane05.map" ,
            "plane06.map" ,
            "plane07.map" ,
            "plane08.map" ,
            "plane09.map" ,
            "plane10.map" ,
            "plane11.map" ,
            "plane12.map" ,
            "plane13.map" ,
            "plane14.map" ,
            "plane15.map" ,
            "plane16.map" ,
            "plane17.map" ,
            "plane18.map" ,
            "plane19.map" ,
            "plane20.map" ,
            "port00.map" ,
            "port01.map" ,
            "port02.map" ,
            "port03.map" ,
            "port04.map" ,
            "port05.map" ,
            "port06.map" ,
            "port07.map" ,
            "port08.map" ,
            "port09.map" ,
            "port10.map" ,
            "port11.map" ,
            "port12.map" ,
            "port13.map" ,
            "port14.map" ,
            "port15.map" ,
            "port16.map" ,
            "port17.map" ,
            "port18.map" ,
            "port19.map" ,
            "port20.map" ,
            "routes" ,
            "seabed00.map" ,
            "seabed01.map" ,
            "seabed02.map" ,
            "seabed03.map" ,
            "seabed04.map" ,
            "seabed05.map" ,
            "seabed06.map" ,
            "seabed07.map" ,
            "seabed08.map" ,
            "seabed09.map" ,
            "seabed10.map" ,
            "seabed11.map" ,
            "seabed12.map" ,
            "triton.map" ,
            "ufo01.map" ,
            "ufo02.map" ,
            "ufo03.map" ,
            "ufo04.map" ,
            "ufo05.map" ,
            "ufo06.map" ,
            "ufo07.map" ,
            "ufo08.map" ,
            "volc00.map" ,
            "volc01.map" ,
            "volc02.map" ,
            "volc03.map" ,
            "volc04.map" ,
            "volc05.map" ,
            "volc06.map" ,
            "volc07.map" ,
            "volc08.map" ,
            "volc09.map" ,
            "volc10.map" ,
            "volc11.map" ,
            "xbases00.map" ,
            "xbases01.map" ,
            "xbases02.map" ,
            "xbases03.map" ,
            "xbases04.map" ,
            "xbases05.map" ,
            "xbases06.map" ,
            "xbases07.map" ,
            "xbases08.map" ,
            "xbases09.map" ,
            "xbases10.map" ,
            "xbases11.map" ,
            "xbases12.map" ,
            "xbases13.map" ,
            "xbases14.map" ,
            "xbases15.map" ,
            "xbases16.map" ,
            "xbases17.map" ,
            "xbases18.map" ,
            "xbases19.map" ,
            "xbases20.map" ,

            // routes:
            "alart00.rmp" ,
            "alart01.rmp" ,
            "alart02.rmp" ,
            "alart03.rmp" ,
            "alart04.rmp" ,
            "alart05.rmp" ,
            "alart06.rmp" ,
            "alart07.rmp" ,
            "alart08.rmp" ,
            "alart09.rmp" ,
            "alart10.rmp" ,
            "alart11.rmp" ,
            "alship00.rmp" ,
            "alship01.rmp" ,
            "alship02.rmp" ,
            "alship03.rmp" ,
            "alship04.rmp" ,
            "alship05.rmp" ,
            "alship06.rmp" ,
            "alship07.rmp" ,
            "alship08.rmp" ,
            "alship09.rmp" ,
            "alship10.rmp" ,
            "alship11.rmp" ,
            "alship12.rmp" ,
            "alship13.rmp" ,
            "alship14.rmp" ,
            "alship15.rmp" ,
            "alship16.rmp" ,
            "alship17.rmp" ,
            "atlan00.rmp" ,
            "atlan01.rmp" ,
            "atlan02.rmp" ,
            "atlan03.rmp" ,
            "atlan04.rmp" ,
            "atlan05.rmp" ,
            "atlan06.rmp" ,
            "atlan07.rmp" ,
            "atlan08.rmp" ,
            "atlan09.rmp" ,
            "atlan10.rmp" ,
            "atlan11.rmp" ,
            "atlan12.rmp" ,
            "a_base00.rmp" ,
            "a_base01.rmp" ,
            "a_base02.rmp" ,
            "a_base03.rmp" ,
            "a_base04.rmp" ,
            "a_base05.rmp" ,
            "a_base06.rmp" ,
            "a_base07.rmp" ,
            "a_base08.rmp" ,
            "a_base09.rmp" ,
            "a_base10.rmp" ,
            "a_base11.rmp" ,
            "a_base12.rmp" ,
            "a_base13.rmp" ,
            "a_base14.rmp" ,
            "a_base15.rmp" ,
            "a_base18.rmp" ,
            "a_base20.rmp" ,
            "cargo00.rmp" ,
            "cargo01.rmp" ,
            "cargo02.rmp" ,
            "coral00.rmp" ,
            "coral01.rmp" ,
            "coral02.rmp" ,
            "coral03.rmp" ,
            "coral04.rmp" ,
            "coral05.rmp" ,
            "coral06.rmp" ,
            "coral07.rmp" ,
            "coral08.rmp" ,
            "coral09.rmp" ,
            "coral10.rmp" ,
            "coral11.rmp" ,
            "coral12.rmp" ,
            "crypt01.rmp" ,
            "crypt02.rmp" ,
            "crypt03.rmp" ,
            "crypt04.rmp" ,
            "crypt05.rmp" ,
            "crypt06.rmp" ,
            "crypt07.rmp" ,
            "crypt08.rmp" ,
            "crypt09.rmp" ,
            "entry00.rmp" ,
            "entry01.rmp" ,
            "entry02.rmp" ,
            "entry03.rmp" ,
            "entry04.rmp" ,
            "entry05.rmp" ,
            "entry06.rmp" ,
            "entry07.rmp" ,
            "entry08.rmp" ,
            "gal01.rmp" ,
            "gal02.rmp" ,
            "gal03.rmp" ,
            "gal04.rmp" ,
            "gal05.rmp" ,
            "gal06.rmp" ,
            "gal07.rmp" ,
            "gal08.rmp" ,
            "gal09.rmp" ,
            "gal10.rmp" ,
            "gal11.rmp" ,
            "gal12.rmp" ,
            "gal13.rmp" ,
            "gal14.rmp" ,
            "gal15.rmp" ,
            "gal16.rmp" ,
            "grunge00.rmp" ,
            "grunge01.rmp" ,
            "grunge02.rmp" ,
            "grunge03.rmp" ,
            "grunge04.rmp" ,
            "grunge05.rmp" ,
            "grunge06.rmp" ,
            "grunge07.rmp" ,
            "grunge08.rmp" ,
            "grunge09.rmp" ,
            "grunge10.rmp" ,
            "grunge11.rmp" ,
            "grunge12.rmp" ,
            "grunge13.rmp" ,
            "grunge14.rmp" ,
            "grunge15.rmp" ,
            "grunge16.rmp" ,
            "hammer.rmp" ,
            "hammer1.rmp" ,
            "hammer2.rmp" ,
            "island00.rmp" ,
            "island01.rmp" ,
            "island02.rmp" ,
            "island03.rmp" ,
            "island04.rmp" ,
            "island05.rmp" ,
            "island06.rmp" ,
            "island07.rmp" ,
            "island08.rmp" ,
            "island09.rmp" ,
            "island10.rmp" ,
            "island11.rmp" ,
            "island12.rmp" ,
            "island13.rmp" ,
            "island14.rmp" ,
            "level01.rmp" ,
            "level02.rmp" ,
            "level03.rmp" ,
            "level04.rmp" ,
            "level05.rmp" ,
            "level06.rmp" ,
            "level07.rmp" ,
            "level08.rmp" ,
            "level09.rmp" ,
            "leviath.rmp" ,
            "linerb02.rmp" ,
            "linerb03.rmp" ,
            "linert00.rmp" ,
            "linert01.rmp" ,
            "linert02.rmp" ,
            "msunk00.rmp" ,
            "msunk01.rmp" ,
            "msunk02.rmp" ,
            "msunk03.rmp" ,
            "msunk04.rmp" ,
            "msunk05.rmp" ,
            "msunk06.rmp" ,
            "msunk07.rmp" ,
            "msunk08.rmp" ,
            "msunk09.rmp" ,
            "msunk10.rmp" ,
            "msunk11.rmp" ,
            "msunk12.rmp" ,
            "msunk13.rmp" ,
            "mu00.rmp" ,
            "mu01.rmp" ,
            "mu02.rmp" ,
            "mu03.rmp" ,
            "mu04.rmp" ,
            "mu05.rmp" ,
            "mu06.rmp" ,
            "mu07.rmp" ,
            "mu08.rmp" ,
            "mu09.rmp" ,
            "mu10.rmp" ,
            "mu11.rmp" ,
            "mu12.rmp" ,
            "pipes00.rmp" ,
            "pipes01.rmp" ,
            "pipes02.rmp" ,
            "pipes03.rmp" ,
            "pipes04.rmp" ,
            "pipes05.rmp" ,
            "pipes06.rmp" ,
            "pipes07.rmp" ,
            "pipes08.rmp" ,
            "pipes09.rmp" ,
            "pipes10.rmp" ,
            "pipes11.rmp" ,
            "plane00.rmp" ,
            "plane01.rmp" ,
            "plane02.rmp" ,
            "plane03.rmp" ,
            "plane04.rmp" ,
            "plane05.rmp" ,
            "plane06.rmp" ,
            "plane07.rmp" ,
            "plane08.rmp" ,
            "plane09.rmp" ,
            "plane10.rmp" ,
            "plane11.rmp" ,
            "plane12.rmp" ,
            "plane13.rmp" ,
            "plane14.rmp" ,
            "plane15.rmp" ,
            "plane16.rmp" ,
            "plane17.rmp" ,
            "plane18.rmp" ,
            "plane19.rmp" ,
            "plane20.rmp" ,
            "port00.rmp" ,
            "port01.rmp" ,
            "port02.rmp" ,
            "port03.rmp" ,
            "port04.rmp" ,
            "port05.rmp" ,
            "port06.rmp" ,
            "port07.rmp" ,
            "port08.rmp" ,
            "port09.rmp" ,
            "port10.rmp" ,
            "port11.rmp" ,
            "port12.rmp" ,
            "port13.rmp" ,
            "port14.rmp" ,
            "port15.rmp" ,
            "port16.rmp" ,
            "port17.rmp" ,
            "port18.rmp" ,
            "port19.rmp" ,
            "port20.rmp" ,
            "seabed00.rmp" ,
            "seabed01.rmp" ,
            "seabed02.rmp" ,
            "seabed03.rmp" ,
            "seabed04.rmp" ,
            "seabed05.rmp" ,
            "seabed06.rmp" ,
            "seabed07.rmp" ,
            "seabed08.rmp" ,
            "seabed09.rmp" ,
            "seabed10.rmp" ,
            "seabed11.rmp" ,
            "seabed12.rmp" ,
            "triton.rmp" ,
            "ufo01.rmp" ,
            "ufo02.rmp" ,
            "ufo03.rmp" ,
            "ufo04.rmp" ,
            "ufo05.rmp" ,
            "ufo06.rmp" ,
            "ufo07.rmp" ,
            "ufo08.rmp" ,
            "volc00.rmp" ,
            "volc01.rmp" ,
            "volc02.rmp" ,
            "volc03.rmp" ,
            "volc04.rmp" ,
            "volc05.rmp" ,
            "volc06.rmp" ,
            "volc07.rmp" ,
            "volc08.rmp" ,
            "volc09.rmp" ,
            "volc10.rmp" ,
            "volc11.rmp" ,
            "xbases00.rmp" ,
            "xbases01.rmp" ,
            "xbases02.rmp" ,
            "xbases03.rmp" ,
            "xbases04.rmp" ,
            "xbases05.rmp" ,
            "xbases06.rmp" ,
            "xbases07.rmp" ,
            "xbases08.rmp" ,
            "xbases09.rmp" ,
            "xbases10.rmp" ,
            "xbases11.rmp" ,
            "xbases12.rmp" ,
            "xbases13.rmp" ,
            "xbases14.rmp" ,
            "xbases15.rmp" ,
            "xbases16.rmp" ,
            "xbases17.rmp" ,
            "xbases18.rmp" ,
            "xbases19.rmp" ,
            "xbases20.rmp" ,

            // sound:
            "sample.cat" ,

            // terrain:
            "asunk.mcd" ,
            "asunk.pck" ,
            "asunk.tab" ,
            "atlantis.mcd" ,
            "atlantis.pck" ,
            "atlantis.tab" ,
            "blanks.mcd" ,
            "blanks.pck" ,
            "blanks.tab" ,
            "cargo1.mcd" ,
            "cargo1.pck" ,
            "cargo1.tab" ,
            "cargo2.mcd" ,
            "cargo2.pck" ,
            "cargo2.tab" ,
            "cargo3.mcd" ,
            "cargo3.pck" ,
            "cargo3.tab" ,
            "cargo4.pck" ,
            "cargo4.tab" ,
            "cargo5.pck" ,
            "cargo5.tab" ,
            "coral.mcd" ,
            "coral.pck" ,
            "coral.tab" ,
            "crypt1.mcd" ,
            "crypt1.pck" ,
            "crypt1.tab" ,
            "crypt2.mcd" ,
            "crypt2.pck" ,
            "crypt2.tab" ,
            "crypt3.mcd" ,
            "crypt3.pck" ,
            "crypt3.tab" ,
            "crypt4.mcd" ,
            "crypt4.pck" ,
            "crypt4.tab" ,
            "debris.mcd" ,
            "debris.pck" ,
            "debris.tab" ,
            "deckc.mcd" ,
            "deckc.pck" ,
            "deckc.tab" ,
            "entry.mcd" ,
            "entry.pck" ,
            "entry.tab" ,
            "grunge1.mcd" ,
            "grunge1.pck" ,
            "grunge1.tab" ,
            "grunge2.mcd" ,
            "grunge2.pck" ,
            "grunge2.tab" ,
            "grunge3.mcd" ,
            "grunge3.pck" ,
            "grunge3.tab" ,
            "grunge4.mcd" ,
            "grunge4.pck" ,
            "grunge4.tab" ,
            "grunge5.mcd" ,
            "grunge5.pck" ,
            "grunge5.tab" ,
            "hammer.mcd" ,
            "hammer.pck" ,
            "hammer.tab" ,
            "island1.lbm" ,
            "island1.mcd" ,
            "island1.pck" ,
            "island1.tab" ,
            "island2.lbm" ,
            "island2.mcd" ,
            "island2.pck" ,
            "island2.tab" ,
            "island3.lbm" ,
            "island3.mcd" ,
            "island3.pck" ,
            "island3.tab" ,
            "island4.mcd" ,
            "leviath.mcd" ,
            "leviath.pck" ,
            "leviath.tab" ,
            "linera.mcd" ,
            "linera.pck" ,
            "linera.tab" ,
            "linerb.mcd" ,
            "linerb.pck" ,
            "linerb.tab" ,
            "linerc.mcd" ,
            "linerc.pck" ,
            "linerc.tab" ,
            "linerd.mcd" ,
            "linerd.pck" ,
            "linerd.tab" ,
            "loftemps.dat" ,
            "msunk1.mcd" ,
            "msunk1.pck" ,
            "msunk1.tab" ,
            "msunk2.mcd" ,
            "msunk2.pck" ,
            "msunk2.tab" ,
            "mu.mcd" ,
            "mu.pck" ,
            "mu.tab" ,
            "organic.pck" ,
            "organic.tab" ,
            "organic1.mcd" ,
            "organic1.pck" ,
            "organic1.tab" ,
            "organic2.mcd" ,
            "organic2.pck" ,
            "organic2.tab" ,
            "organic3.mcd" ,
            "organic3.pck" ,
            "organic3.tab" ,
            "pipes.mcd" ,
            "pipes.pck" ,
            "pipes.tab" ,
            "plane.mcd" ,
            "plane.pck" ,
            "plane.tab" ,
            "port01.mcd" ,
            "port01.pck" ,
            "port01.tab" ,
            "port02.mcd" ,
            "port02.pck" ,
            "port02.tab" ,
            "port1.mcd" ,
            "port1.pck" ,
            "port1.tab" ,
            "psynom.mcd" ,
            "psynom.pck" ,
            "psynom.tab" ,
            "pyramid.mcd" ,
            "pyramid.pck" ,
            "pyramid.tab" ,
            "rocks.mcd" ,
            "rocks.pck" ,
            "rocks.tab" ,
            "sand.mcd" ,
            "sand.pck" ,
            "sand.tab" ,
            "scang.dat" ,
            "sea.mcd" ,
            "sea.pck" ,
            "sea.tab" ,
            "triton.mcd" ,
            "triton.pck" ,
            "triton.tab" ,
            "uext1.mcd" ,
            "uext1.pck" ,
            "uext1.tab" ,
            "uext2.mcd" ,
            "uext2.pck" ,
            "uext2.tab" ,
            "uext3.mcd" ,
            "uext3.pck" ,
            "uext3.tab" ,
            "ufobits.mcd" ,
            "ufobits.pck" ,
            "ufobits.tab" ,
            "uint.pck" ,
            "uint.tab" ,
            "uint1.mcd" ,
            "uint1.pck" ,
            "uint1.tab" ,
            "uint2.mcd" ,
            "uint2.pck" ,
            "uint2.tab" ,
            "uint3.mcd" ,
            "uint3.pck" ,
            "uint3.tab" ,
            "urbits.mcd" ,
            "urbits.pck" ,
            "urbits.tab" ,
            "volc.mcd" ,
            "volc.pck" ,
            "volc.tab" ,
            "weeds.mcd" ,
            "weeds.pck" ,
            "weeds.tab" ,
            "xbase1.mcd" ,
            "xbase2.mcd" ,
            "xbases01.mcd" ,
            "xbases01.pck" ,
            "xbases01.tab" ,
            "xbases02.mcd" ,
            "xbases02.pck" ,
            "xbases02.tab" ,
            "xbases03.mcd" ,
            "xbases03.pck" ,
            "xbases03.tab" ,
            "xbases04.mcd" ,
            "xbases04.pck" ,
            "xbases04.tab" ,
            "xbases05.mcd" ,
            "xbases05.pck" ,
            "xbases05.tab" ,
            "xbits.mcd" ,
            "xbits.pck" ,
            "xbits.tab" ,

            // ufograph:
            "cursor.pck" ,
            "cursor.tab" ,
            "d0.lbm" ,
            "d1.lbm" ,
            "d2.lbm" ,
            "d3.lbm" ,
            "detblob.dat" ,
            "detbord.bdy" ,
            "detbord2.bdy" ,
            "hit.pck" ,
            "hit.tab" ,
            "icons.bdy" ,
            "man_0f0.bdy" ,
            "man_0f1.bdy" ,
            "man_0f2.bdy" ,
            "man_0f3.bdy" ,
            "man_0m0.bdy" ,
            "man_0m1.bdy" ,
            "man_0m2.bdy" ,
            "man_0m3.bdy" ,
            "man_1f0.bdy" ,
            "man_1f1.bdy" ,
            "man_1f2.bdy" ,
            "man_1f3.bdy" ,
            "man_1m0.bdy" ,
            "man_1m1.bdy" ,
            "man_1m2.bdy" ,
            "man_1m3.bdy" ,
            "man_2f0.bdy" ,
            "man_2f1.bdy" ,
            "man_2f2.bdy" ,
            "man_2f3.bdy" ,
            "man_2m0.bdy" ,
            "man_2m1.bdy" ,
            "man_2m2.bdy" ,
            "man_2m3.bdy" ,
            "man_3f0.bdy" ,
            "man_3f1.bdy" ,
            "man_3f2.bdy" ,
            "man_3f3.bdy" ,
            "man_3m0.bdy" ,
            "man_3m1.bdy" ,
            "man_3m2.bdy" ,
            "man_3m3.bdy" ,
            "medibits.dat" ,
            "medibord.bdy" ,
            "scanbord.bdy" ,
            "smoke.pck" ,
            "smoke.tab" ,
            "spicons.dat" ,
            "tac00.scr" ,
            "tac01.bdy" ,
            "unibord.pck" ,
            "x1.pck" ,
            "x1.tab" ,

            // units:
            "aqua.pck" ,
            "aqua.tab" ,
            "bigobs.pck" ,
            "bigobs.tab" ,
            "biodron.pck" ,
            "biodron.tab" ,
            "breath-1.pck" ,
            "breath-1.tab" ,
            "calcin.pck" ,
            "calcin.tab" ,
            "civil_1.pck" ,
            "civil_1.tab" ,
            "civil_2.pck" ,
            "civil_2.tab" ,
            "deepone.pck" ,
            "deepone.tab" ,
            "floorob.pck" ,
            "floorob.tab" ,
            "gillman.pck" ,
            "gillman.tab" ,
            "hallucin.pck" ,
            "hallucin.tab" ,
            "handob.pck" ,
            "handob.tab" ,
            "lobster.pck" ,
            "lobster.tab" ,
            "tank01.pck" ,
            "tank01.tab" ,
            "tasoths.pck" ,
            "tasoths.tab" ,
            "tdxcom_0.pck" ,
            "tdxcom_0.tab" ,
            "tdxcom_1.pck" ,
            "tdxcom_1.tab" ,
            "tdxcom_2.pck" ,
            "tdxcom_2.tab" ,
            "tentac.pck" ,
            "tentac.tab" ,
            "triscen.pck" ,
            "triscen.tab" ,
            "xarquid.pck" ,
            "xarquid.tab" ,
            "zombie.pck" ,
            "zombie.tab"
    };

    private final static String[] CinematicFiles = {
            "gameover.idx",
            "gameover.vid",
            "intro.idx",
            "intro.vid",
            "logo.idx",
            "logo.vid",
            "outro.idx",
            "outro.vid",
            "rise.idx",
            "rise.vid"
    };

    private final static String[] SlideshowFiles = {
            "gao01.lbm",
            "gao02.lbm",
            "gao03.lbm",
            "gao04.lbm",
            "gao05.lbm",
            "int00.lbm",
            "int01.lbm",
            "int02.lbm",
            "int03.lbm",
            "int04.lbm",
            "int05.lbm",
            "int06.lbm",
            "int07.lbm",
            "int08.lbm",
            "int09.lbm",
            "int10.lbm",
            "int11.lbm",
            "int12.lbm",
            "int13.lbm",
            "int14.lbm",
            "int15.lbm",
            "int16.lbm",
            "int17.lbm",
            "int18.lbm",
            "int19.lbm",
            "int20.lbm",
            "int21.lbm",
            "out01.lbm",
            "out02.lbm",
            "out03.lbm",
            "out04.lbm",
            "out05.lbm",
            "out06.lbm",
            "out07.lbm",
            "out08.lbm",
            "out09.lbm",
            "out10.lbm",
            "out11.lbm",
            "out12.lbm",
            "twe01.lbm",
            "twe02.lbm",
            "twe03.lbm",
            "twe04.lbm",
            "twe05.lbm",
            "twe06.lbm"
    };

    private final static String[] DosSounds = {
            "adlib.cat",
            "drivers.cat",
            "gm.cat",
            "mvol.dat",
            "roland.cat",
            "sample.cat",
            "sound.cfg"
    };

    private final static String[] WinSounds = {
            "gmattbas.mid",
            "gmbigmar.mid",
            "gmdebgoo.mid",
            "gmdebpor.mid",
            "gmdefbas.mid",
            "gmgeo1.mid",
            "gmgeo2.mid",
            "gmgeo3.mid",
            "gmgeo4.mid",
            "gmgeo5.mid",
            "gmgeo6.mid",
            "gminter2.mid",
            "gminter3.mid",
            "gmisposh.mid",
            "gminter1.mid",
            "gmnewint.mid",
            "gmsig.mid",
            "gmtacdry.mid",
            "gmtacwet.mid",
            "gmwaitlo.mid"
    };

    private final static String CinematicDir = "anims";
    private final static String SlideshowDir = "flop_int";

    private final Set<String> commonFiles;
    private final Set<String> floppyFiles;
    private final Set<String> cdromFiles;
    private final Set<String> dosFiles;
    private final Set<String> winFiles;

    private Set<String> commonDirs;

    public Xcom2DataChecker() {
        commonFiles = new HashSet<>(Arrays.asList(CommonFiles));
        floppyFiles = new HashSet<>(Arrays.asList(SlideshowFiles));
        cdromFiles = new HashSet<>(Arrays.asList(CinematicFiles));
        dosFiles = new HashSet<>(Arrays.asList(DosSounds));
        winFiles = new HashSet<>(Arrays.asList(WinSounds));

    }

    @Override
    public DataCheckResult checkWithPath(String path) {
        Set<String> contents = new HashSet<>();
        File containingDir = new File(path);
        if (!containingDir.exists()) {
            return new DataCheckResult(false, "(null)", "Invalid location");
        }
        // Here I assume that there won't be any subdirectories in the subdirectories.
        for (String subpath: CommonDirs) {
            File subDir = new File(path + "/" + subpath);
            if (!subDir.exists()) {
                if (subpath.equals(CinematicDir) || subpath.equals(SlideshowDir)) {
                    Log.w("DataChecker", "[Xcom2DataChecker] Couldn't find '" + subpath + "', some features will be unavailable");
                    continue;
                } else {
                    return new DataCheckResult(false, "(null)", "Incomplete installation");
                }
            }
            String[] subList = subDir.list();
            if (subList != null) { // WHY does this even happen?!
                ArrayList<String> subListLower = new ArrayList<>(subList.length);
                for (String subElem: subList) {
                    subListLower.add(subElem.toLowerCase());
                }
                contents.addAll(subListLower);
            }
        }

        String versionDescription = "";
        String contentDescription = "";
        if (contents.containsAll(commonFiles)) {
            if (contents.containsAll(dosFiles)) {
                versionDescription = "DOS";
            } else if (contents.containsAll(winFiles)) {
                versionDescription = "Windows";
            }
            if (contents.containsAll(floppyFiles)) {
                if (contents.containsAll(cdromFiles)) {
                    contentDescription = "slides and cutscenes";
                } else {
                    contentDescription = "slides only";
                }
            } else {
                if (contents.containsAll(cdromFiles)) {
                    contentDescription = "cutscenes only";
                } else {
                    contentDescription = "no slides or cutscenes";
                }
            }
        }
        return new DataCheckResult(true, versionDescription, contentDescription);
    }

    @Override
    public Set<String> getDirChecklist() {
        if (commonDirs == null) {
            commonDirs = new HashSet<>(Arrays.asList(CommonDirs));
        }
        return commonDirs;
    }

    @Override
    public String getInstallDir() {
        return SUBDIR_NAME;
    }
}
