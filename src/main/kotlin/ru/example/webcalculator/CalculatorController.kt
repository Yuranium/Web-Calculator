package ru.example.webcalculator

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("/calculator")
class CalculatorController
{
    /**
     * Метод для возвращения html страницы с формой для заполнения
     * @return HTML-шаблон, который отображает дефолтную форму.
     *
     */
    @GetMapping
    fun form(): String
    {
        return "calculate"
    }

    /**
     * Метод для обработки конкретной арифметической операции.
     *
     * @param a Первое число для сложения.
     * @param b Второе число для сложения.
     * @param operation Модель для передачи данных в представление.
     * @param redirectAttributes Объект Spring Framework для выполнения редиректа
     * @return Строка с редиректом на конкретный URL для выполнения определённой операции.
     */
    @GetMapping("/calculate")
    fun calculate(
            @RequestParam(value = "a", required = false) a: Double,
            @RequestParam(value = "b", required = false) b: Double,
            @RequestParam(value = "operation") operation: String,
            redirectAttributes: RedirectAttributes
    ): String
    {
        redirectAttributes.addAttribute("a", a)
        redirectAttributes.addAttribute("b", b)
        return when (operation)
        {
            "addition" -> "redirect:/calculator/addition"
            "subtraction" -> "redirect:/calculator/subtraction"
            "multiplication" -> "redirect:/calculator/multiplication"
            "division" -> "redirect:/calculator/division"
            else -> "redirect:/calculator"
        }
    }

    /**
     * Метод для обработки операции сложения.
     *
     * @param a Первое число для сложения.
     * @param b Второе число для сложения.
     * @param model Модель для передачи данных в представление.
     * @return Имя HTML-шаблона, который отображает результат.
     *
     * Пример запроса:
     * GET /calculator/addition?a=5&b=3
     *
     * Пример ответа: Страница с текстом "Результат операции: 8.0"
     */
    @GetMapping("/addition")
    fun addition(@RequestParam(value = "a", required = false) a: Double,
                 @RequestParam(value = "b", required = false) b: Double, model: Model): String
    {
        model.addAttribute("result", "Результат операции: ${a + b}")
        return "result"
    }

    /**
     * Метод для обработки операции вычитания.
     *
     * @param a Уменьшаемое.
     * @param b Вычитаемое.
     * @param model Модель для передачи данных в представление.
     * @return Имя HTML-шаблона, который отображает результат.
     *
     * Пример запроса:
     * GET /calculator/subtraction?a=10&b=4
     *
     * Пример ответа: Страница с текстом "Результат операции: 6.0"
     */
    @GetMapping("/subtraction")
    fun subtraction(@RequestParam(value = "a", required = false) a: Double,
                 @RequestParam(value = "b", required = false) b: Double, model: Model): String
    {
        model.addAttribute("result", "Результат операции: ${a - b}")
        return "result"
    }

    /**
     * Метод для обработки операции умножения.
     *
     * @param a Первый множитель.
     * @param b Второй множитель.
     * @param model Модель для передачи данных в представление.
     * @return Имя HTML-шаблона, который отображает результат.
     *
     * Пример запроса:
     * GET /calculator/multiplication?a=7&b=3
     *
     * Пример ответа: Страница с текстом "Результат операции: 21.0"
     */
    @GetMapping("/multiplication")
    fun multiplication(@RequestParam(value = "a", required = false) a: Double,
                 @RequestParam(value = "b", required = false) b: Double, model: Model): String
    {
        model.addAttribute("result", "Результат операции: ${a * b}")
        return "result"
    }

    /**
     * Метод для обработки операции деления.
     *
     * @param a Делимое.
     * @param b Делитель.
     * @param model Модель для передачи данных в представление.
     * @return Имя HTML-шаблона, который отображает результат.
     *
     * Пример запроса:
     * GET /calculator/division?a=12&b=4
     *
     * Пример ответа: Страница с текстом "Результат операции: 3.0"
     *
     * Особая обработка деления на ноль. В случае попытки деления на ноль,
     * возвращается сообщение об ошибке.
     */
    @GetMapping("/division")
    fun division(@RequestParam(value = "a", required = false) a: Double,
                 @RequestParam(value = "b", required = false) b: Double, model: Model): String
    {
        model.addAttribute("result", "Результат операции: ${a / b}")
        return "result"
    }
}