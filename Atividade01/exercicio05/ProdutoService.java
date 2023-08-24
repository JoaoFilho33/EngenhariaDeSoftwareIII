// https://github.com/JoaoFilho33/Projeto_Rosa/blob/main/newProjetoRosa/rosa/src/main/java/com/projeto/rosa/services/ProductService.java


public Product toggleProductStatus(Long id) {
    Product product = getProductById(id);

    if (product != null) {
        product.setStatus(
            product.getStatus() == StatusEnum.DISPONIVEL ?
            StatusEnum.INDISPONIVEL : StatusEnum.DISPONIVEL
        );
        return productRepository.save(product);
    }

    return null;
}


// Formato antigo do código
//  public Product changeProductStatus(Long id) {
//         Product product = getProductById(id);

//         if (product != null) {
//             if (product.getStatus() == StatusEnum.DISPONIVEL) {
//                 product.setStatus(StatusEnum.INDISPONIVEL);
//             } else {
//                 product.setStatus(StatusEnum.DISPONIVEL);
//             }

//             return productRepository.save(product);
//         }

//         return null;
//     }
