const registerForm = document.getElementById('register-form')
const registerUsername = document.getElementById('register-lessonName')
const registerPassword = document.getElementById('register-description')

const headers = {
    'Content-Type':'application/json'
}
const baseUrl = 'http://localhost:8080/danceLessons'

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        lessonName: registerLessonName.value,
        description: registerDescription.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        header: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if(response.status === 200){
        window.location.replace(responseArr[0])
    }
}
registerForm.addEventListener("submit, handleSubmit")





