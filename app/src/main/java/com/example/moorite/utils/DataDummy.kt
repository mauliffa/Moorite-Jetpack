package com.example.moorite.utils

import com.example.moorite.data.source.local.entity.MovieEntity
import com.example.moorite.data.source.local.entity.TVShowEntity
import com.example.moorite.data.source.remote.response.MovieResponse
import com.example.moorite.data.source.remote.response.TVResponse

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity("460465",
            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "Mortal Kombat",
            "2021-04-07",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            8.0)
        )
        movies.add(
            MovieEntity("399566",
            "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Godzilla vs. Kong",
            "2021-03-24",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            8.2)
        )
        movies.add(
            MovieEntity("615457",
            "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "Nobody",
            "2021-03-18",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            8.5)
        )
        movies.add(
            MovieEntity("791373",
            "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "Zack Snyder's Justice League",
            "2021-03-18",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            8.5)
        )
        movies.add(
            MovieEntity("615678",
            "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
            "Thunder Force",
            "2021-04-09",
            "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
            5.8)
        )
        movies.add(
            MovieEntity("634528",
            "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
            "The Marksman",
            "2021-01-15",
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
            7.1)
        )
        movies.add(
            MovieEntity("412656",
            "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
            "Chaos Walking",
            "2021-02-24",
            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
            7.4)
        )
        movies.add(
            MovieEntity("527774",
            "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "Raya and the Last Dragon",
            "2021-03-03",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            8.3)
        )
        movies.add(
            MovieEntity("632357",
            "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "The Unholy",
            "2021-03-31",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            5.8)
        )
        movies.add(
            MovieEntity("664767",
            "/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "Mortal Kombat Legends: Scorpion's Revenge",
            "2020-04-12",
            "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
            8.4)
        )
        movies.add(
            MovieEntity("458576",
            "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
            "Monster Hunter",
            "2020-12-03",
            "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
            7.1)
        )
        movies.add(
            MovieEntity("635302",
            "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "Mugen Train",
            "2020-10-16",
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
            8.1)
        )

        return movies
    }

    fun generateDummyTV(): List<TVShowEntity> {
        val tvshows = ArrayList<TVShowEntity>()

        tvshows.add(
            TVShowEntity("88396",
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "The Falcon and the Winter Soldier",
            "2021-03-19",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            7.9)
        )
        tvshows.add(
            TVShowEntity("71712",
            "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
            "The Good Doctor",
            "2017-09-25",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
            8.6)
        )
        tvshows.add(
            TVShowEntity("79008",
            "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
            "Luis Miguel: The Series",
            "2018-04-22",
            "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades." ,
            8.1)
        )
        tvshows.add(
            TVShowEntity("60735",
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "The Flash",
            "2014-10-07",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash." ,
            7.7)
        )
        tvshows.add(
            TVShowEntity("1416",
            "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "Grey's Anatomy",
            "2005-03-27",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            8.2)
        )
        tvshows.add(
            TVShowEntity(" 65820",
            "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
            "Van Helsing",
            "2016-09-23",
            "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
            6.9)
        )
        tvshows.add(
            TVShowEntity("95557",
            "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
            "Invincible",
            "2021-03-26",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
            8.9)
        )
        tvshows.add(
            TVShowEntity("69050",
            "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
            "Riverdale",
            "2017-01-26",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            8.6)
        )
        tvshows.add(
            TVShowEntity("63174",
            "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "Lucifer",
            "2016-01-25",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            8.5)
        )
        tvshows.add(
            TVShowEntity("85271",
            "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
            "WandaVision",
            "2021-01-15",
            "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
            8.4)
        )
        tvshows.add(
            TVShowEntity("1402",
            "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            "The Walking Dead",
            "2010-10-31",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            8.1)
        )
        tvshows.add(
            TVShowEntity("120168",
            "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "Who Killed Sara?",
            "2021-03-24",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            7.8)
        )

        return tvshows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse("460465",
            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "Mortal Kombat",
            "2021-04-07",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            8.0)
        )
        movies.add(MovieResponse("399566",
            "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Godzilla vs. Kong",
            "2021-03-24",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            8.2)
        )
        movies.add(MovieResponse("615457",
            "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "Nobody",
            "2021-03-18",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            8.5))
        movies.add(MovieResponse("791373",
            "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "Zack Snyder's Justice League",
            "2021-03-18",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            8.5))
        movies.add(MovieResponse("615678",
            "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
            "Thunder Force",
            "2021-04-09",
            "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
            5.8))
        movies.add(MovieResponse("634528",
            "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
            "The Marksman",
            "2021-01-15",
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
            7.1))
        movies.add(MovieResponse("412656",
            "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
            "Chaos Walking",
            "2021-02-24",
            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
            7.4))
        movies.add(MovieResponse("527774",
            "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "Raya and the Last Dragon",
            "2021-03-03",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            8.3))
        movies.add(MovieResponse("632357",
            "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "The Unholy",
            "2021-03-31",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            5.8))
        movies.add(MovieResponse("664767",
            "/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "Mortal Kombat Legends: Scorpion's Revenge",
            "2020-04-12",
            "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
            8.4))
        movies.add(MovieResponse("458576",
            "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
            "Monster Hunter",
            "2020-12-03",
            "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
            7.1))
        movies.add(MovieResponse("635302",
            "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            "Mugen Train",
            "2020-10-16",
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
            8.1))

        return movies
    }

    fun generateRemoteDummyTV(): List<TVResponse> {
        val tvshows = ArrayList<TVResponse>()

        tvshows.add(TVResponse("88396",
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "The Falcon and the Winter Soldier",
            "2021-03-19",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            7.9))
        tvshows.add(TVResponse("71712",
            "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
            "The Good Doctor",
            "2017-09-25",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
            8.6))
        tvshows.add(TVResponse("79008",
            "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
            "Luis Miguel: The Series",
            "2018-04-22",
            "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades." ,
            8.1))
        tvshows.add(TVResponse("60735",
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "The Flash",
            "2014-10-07",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash." ,
            7.7))
        tvshows.add(TVResponse("1416",
            "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "Grey's Anatomy",
            "2005-03-27",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            8.2))
        tvshows.add(TVResponse(" 65820",
            "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
            "Van Helsing",
            "2016-09-23",
            "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
            6.9))
        tvshows.add(TVResponse("95557",
            "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
            "Invincible",
            "2021-03-26",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
            8.9))
        tvshows.add(TVResponse("69050",
            "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
            "Riverdale",
            "2017-01-26",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            8.6))
        tvshows.add(TVResponse("63174",
            "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "Lucifer",
            "2016-01-25",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            8.5))
        tvshows.add(TVResponse("85271",
            "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
            "WandaVision",
            "2021-01-15",
            "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
            8.4))
        tvshows.add(TVResponse("1402",
            "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            "The Walking Dead",
            "2010-10-31",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            8.1))
        tvshows.add(TVResponse("120168",
            "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "Who Killed Sara?",
            "2021-03-24",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            7.8))

        return tvshows
    }

}