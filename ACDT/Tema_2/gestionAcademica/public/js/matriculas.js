document.getElementById("asignaturaForm").onSubmit(() =>{
    document.getElementById("asignaturaForm").setAttribute(
        "action", "/asignaturas" 
        + document.getElementById("asignatura").innerText
        + "/matriculas"
    )
})

window.document.addEventListener("change", ev => {
    let seleccion = document.getElementById("asignatura")
    let idAsignatura = seleccion.opions[seleccion.selectedIndex].value
    document.getElementById("asignaturaForm")
        .setAttribute(
            "action","/asignaturas" +
            idAsignatura +
            "/matriculas"
        )
    document.getElementById("asignaturaForm").submit()
})