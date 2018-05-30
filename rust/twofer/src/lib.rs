pub fn twofer(name: &str)-> String {
    let name = if name.is_empty() { "you" } else { name } ;
    "One for ".to_string() + name + ", one for me."
}
