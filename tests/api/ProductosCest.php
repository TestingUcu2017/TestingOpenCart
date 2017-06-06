<?php

namespace tests\api;

use ApiTester;
use Codeception\Example;
use Codeception\Util\HttpCode;
use function json_decode;

class ProductosCest {

    public function _before(ApiTester $I) {
        
    }

    public function _after(ApiTester $I) {
        
    }

    /**
     * @return array
     */
    protected function productosProvider() {
        $file = file_get_contents(__DIR__ . '/productos.json');
        return json_decode($file, true);
    }

    /**
     * @dataprovider productosProvider
     */
    public function buscarProducto(ApiTester $I, Example $producto) {
        $I->wantTo('Buscar: ' . $producto['termino']);
        $I->sendGET('', ['route' => 'product/search', 'search' => $producto['termino']]);
        $I->seeResponseCodeIs(HttpCode::OK);
        $I->seeResponseContains($producto['resultado']);
    }

}
