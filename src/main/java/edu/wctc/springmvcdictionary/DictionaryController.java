package edu.wctc.springmvcdictionary;

import edu.wctc.springmvcdictionary.entity.Word;
import edu.wctc.springmvcdictionary.services.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private WordListService wordListService;

    @Autowired
    public DictionaryController(WordListService wls) {
        this.wordListService = wls;
    }

    //home page displays all words as links - links lead to definition page
    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("words", wordListService.getWords());
        return "index";
    }

    //shows the search page
    @RequestMapping("/search")
    public String showSearchPage(Model model) {
        model.addAttribute("words", wordListService.getWords());

        Word defaultWord = new Word();
        defaultWord.setTerm("tmesis");
        defaultWord.setDefinition("a definition");
        model.addAttribute("word", defaultWord);
        return "search";
    }

    //displays definition of word from page 1
    @GetMapping("/{term}")
    public String showDefinition(@PathVariable("term") String term, Model model) {
        model.addAttribute("word", term);
        model.addAttribute("definition", wordListService.getWord(term));
        return "definition";
    }

    //displays definition of word from page 2
    @PostMapping("/definition")
    public String showSearchDefinition(@RequestParam(name = "wordSearch") String word, Model model) {
        model.addAttribute("word", word);
        model.addAttribute("definition", wordListService.getWord(word));
        return "definition";
    }


}
